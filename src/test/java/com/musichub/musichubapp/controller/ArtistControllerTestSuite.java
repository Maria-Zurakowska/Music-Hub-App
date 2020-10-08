package com.musichub.musichubapp.controller;


import com.musichub.musichubapp.domain.ArtistDto;
import com.musichub.musichubapp.domain.ArtistGradeDto;
import com.musichub.musichubapp.domain.Dto.*;
import com.musichub.musichubapp.domain.SearchHistoryDto;
import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.entities.ArtistGrade;
import com.musichub.musichubapp.entities.SearchHistory;
import com.musichub.musichubapp.entities.User;
import com.musichub.musichubapp.facade.ArtistFacade;
import com.musichub.musichubapp.mapper.ArtistGradeMapper;
import com.musichub.musichubapp.mapper.ArtistMapper;
import com.musichub.musichubapp.mapper.SearchHistoryMapper;
import com.musichub.musichubapp.repository.ArtistGradeRepository;
import com.musichub.musichubapp.repository.ArtistRepository;
import com.musichub.musichubapp.repository.SearchHistoryRepository;
import com.musichub.musichubapp.service.ArtistService;
import com.musichub.musichubapp.service.DbArtistService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ArtistControllerTestSuite {

    @Before
    public void setUp() {
        initMocks(this);
    }

// Controller as POJO object (not MockMVC) to not set up Spring context due to time of execution.

    @InjectMocks
    private ArtistController artistController;

    @Mock
    private ArtistService artistServiceMock;
    @Mock
    private ArtistFacade artistFacadeMock;
    @Mock
    private DbArtistService dbArtistServiceMock;
    @Mock
    private ArtistMapper artistMapperMock;
    @Mock
    private ArtistGradeMapper artistGradeMapperMock;
    @Mock
    private SearchHistoryMapper searchHistoryMapperMock;

    @Test
    public void testGetArtistDetails() {

        // Given

        List<TmImageDto> images = new ArrayList<>();
        TmSaleDto sales = new TmSaleDto(new TmSalePublicDto("2019-10-07T09:00:00Z", false, false, "2021-01-29T19:30:00Z"));
        TmDateDto dates = new TmDateDto();
        List<TmPriceRangeDto> tmPriceRangeDtoList = new ArrayList<>();

        TmSeatMapDto tmSeatMapDto = new TmSeatMapDto();
        TmTicketLimitDto ticketLimit = new TmTicketLimitDto();
        TmEventEmbeddedDto _embedded = new TmEventEmbeddedDto();

        List<TmEventDto> events1 = new ArrayList<>();
        List<TmEventDto> events2 = new ArrayList<>();
        TmEmbeddedDto emb1 = new TmEmbeddedDto(events1);
        TmEmbeddedDto emb2 = new TmEmbeddedDto(events2);
        TmEventDto tmEventDto1 = new TmEventDto("Karma Police- Radiohead Tribute Rescheduled", "event", "1AwZAqdGkeB9ITe", false, "https://www.ticketweb.ie/event/karma-police-radiohead-tribute-the-grand-social-tickets/9963725?REFERRAL_ID=tmfeed",
                "en-us", images, sales, dates, tmPriceRangeDtoList, tmSeatMapDto,ticketLimit, _embedded);
        TmEventDto tmEventDto2 = new TmEventDto("Radiohead - the tour", "event", "1AwZB473keB9ITe", false, "https://www.ticketweb.ie/event/radiohead-theTour-the-grand-social-tickets/9963725?REFERRAL_ID=tmfeed",
                "en-us", images, sales, dates, tmPriceRangeDtoList, tmSeatMapDto,ticketLimit, _embedded);

        events1.add((tmEventDto1));
        events2.add(tmEventDto2);


        TmEmbeddedDto emb3 = new TmEmbeddedDto();
        TmEmbeddedDto emb4 = new TmEmbeddedDto();

        TicketMasterResponseDto tmMusicianInfo = new TicketMasterResponseDto(emb3,emb4);

        SpotifyResponseDto spotifyMusicianInfo = new SpotifyResponseDto();
        WikipediaResponseDto wikiMusicianInfo = new WikipediaResponseDto();

        List<YTItemDto> ytItemDtoList = new ArrayList<>();
        YouTubeResponseDto ytMusicianInfo = new YouTubeResponseDto("youtube#searchListResponse", "XYlTkSBmrDfOceG7IiLvbkUK2dg", "CAUQAA","PL", new YTPageInfoDto(1000000, 5), ytItemDtoList);

        ResponseDto responseDto = new ResponseDto(tmMusicianInfo, spotifyMusicianInfo, wikiMusicianInfo, ytMusicianInfo);

        when(artistServiceMock.getDetails("Radiohead")).thenReturn(responseDto);

        // When

        ResponseDto result = artistController.getArtistDetails("Radiohead");

        // Then

        Assert.assertEquals("XYlTkSBmrDfOceG7IiLvbkUK2dg", result.getYtMusicianInfo().getEtag());
    }

    @Test
    public void testGetArtists() {

        // Given

        List<User> usersList = new ArrayList<>();

        Artist artist1 = new Artist(0, "Radiohead", "alternative rock", usersList);
        Artist artist2 = new Artist(2, "The Rolling Stones", "rock", usersList);
        List<Artist> artistList = new ArrayList<>();
        artistList.add(artist1);
        artistList.add(artist2);
        List<ArtistDto> artistDtoList = new ArrayList<>();
        ArtistDto artistDto1 = new ArtistDto(0, "Madonna", "pop", usersList);
        ArtistDto artistDto2 = new ArtistDto(1, "Rammstein", "metal", usersList);
        artistDtoList.add(artistDto1);
        artistDtoList.add(artistDto2);
        when(artistFacadeMock.getArtists()).thenReturn(artistDtoList);

        // When

        List<ArtistDto> result = artistController.getArtists();

        // Then

        Assert.assertEquals(artistDtoList.size(), result.size());
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(2, artistDtoList.size());
        Assert.assertEquals(artistList.size(), artistDtoList.size());
        Assert.assertEquals(artistList.get(0).getId(), artistDtoList.get(0).getId());

    }

    @Test
    public void testGetArtist() throws Exception {

        // Given

        List<User> usersList = new ArrayList<>();
        ArtistDto artistDto = new ArtistDto(0, "Radiohead", "alternative rock", usersList);
        Artist artist1 = new Artist(0, "Radiohead", "alternative rock", usersList);
        Artist artist2 = new Artist(2, "The Rolling Stones", "rock", usersList);

        when(artistMapperMock.mapToArtistDto(artist1)).thenReturn(artistDto);

        List<Artist> artistList = new ArrayList<>();
        when(dbArtistServiceMock.getArtist(0)).thenReturn(Optional.of(artist1));

        // When

        ArtistDto result = artistController.getArtist(0);

        // Then

        Assert.assertEquals("Radiohead", result.getName());
    }

    @Test
    public void testDeleteArtist() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();
        List<User> usersList = new ArrayList<>();

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        Artist artist2 = new Artist(2, "The Rolling Stones", "rock", usersList);



        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);


        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        // When

        artistController.deleteArtist(1);

        // Then

        verify(dbArtistServiceMock).deleteArtist(1);

    }

    @Test
    public void testUpdateArtist() {

        // Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        Artist artist2 = new Artist(2, "The Rolling Stones", "rock", usersList);
        artistList.add(artist1);
        artistList.add(artist2);

        ArtistDto artistDto = new ArtistDto(0, "Radiohead", "alternative rock", usersList);
        ArtistDto artistDto1 = new ArtistDto(1, "Madonna", "pop", usersList);

        when(artistMapperMock.mapToArtistDto(artist1)).thenReturn(artistDto1);
        when(dbArtistServiceMock.saveArtist(artist1)).thenReturn(artist1);
        when(artistMapperMock.mapToArtist(artistDto)).thenReturn(artist1);

        // When

        ArtistDto result = artistController.updateArtist(artistDto);

        // Then

        Assert.assertEquals(artistDto1, result);


    }

    @Test
    public void testCreateArtist() {

        // Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        Artist artist2 = new Artist(2, "The Rolling Stones", "rock", usersList);
        artistList.add(artist1);
        artistList.add(artist2);

        ArtistDto artistDto = new ArtistDto(0, "Radiohead", "alternative rock", usersList);

        SearchHistory searchHistory1 = new SearchHistory(1, "Madonna", user1, LocalDate.now());
        searchHistoryList.add(searchHistory1);

        ArtistGrade artistGrade1 = new ArtistGrade(1, "Madonna", 5);
        when(dbArtistServiceMock.saveArtist(artist1)).thenReturn(artist1);
        when(artistMapperMock.mapToArtist(artistDto)).thenReturn(artist2);

        // When

        artistController.createArtist(artistDto);

        // Then

        verify(dbArtistServiceMock).saveArtist(artist2);

    }

    @Test
    public void testGetAllArtistGrades() {


        // Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        artistList.add(artist1);

        SearchHistory searchHistory1 = new SearchHistory();
        searchHistoryList.add(searchHistory1);

        List<ArtistGrade> artistGradesList = new ArrayList<>();
        artistGradesList.add(new ArtistGrade(1, "Madonna", 5));

        when(dbArtistServiceMock.getAllArtistGrades()).thenReturn(artistGradesList);

        List<ArtistGradeDto> artistGradeDtoList = new ArrayList<>();

        ArtistGradeDto artistGradeDto1 = new ArtistGradeDto(0, "Madonna", 5);
        ArtistGradeDto artistGradeDto2 = new ArtistGradeDto(1, "Rammstein", 5);

        artistGradeDtoList.add(artistGradeDto1);
        artistGradeDtoList.add(artistGradeDto2);

        when(dbArtistServiceMock.getAllArtistGrades()).thenReturn(artistGradesList);

        // When

        List<ArtistGradeDto> result = artistController.getGrades();

        // Then

       Assert.assertNotEquals(artistGradesList.size(), result.size());

    }

    @Test
    public void testGetArtistGrade() throws Exception {

        // Given

        Optional<ArtistGrade> artistGradeList = Optional.of(new ArtistGrade(0, "Radiohead", 5));
        when(dbArtistServiceMock.getArtistGrade(0)).thenReturn(artistGradeList);

        // When

        ArtistGradeDto result = artistController.getArtistGrade(0);

        // Then

        Assert.assertEquals(true, artistGradeList.isPresent());
    }

    @Test
    public void testDeleteArtistGrade() {

        // Given

        ArtistGrade artistGrade1 = new ArtistGrade(0, "Madonna", 5);

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);

        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        // When

        artistController.deleteArtistGrade(0);

        // Then

        verify(dbArtistServiceMock).deleteArtistGrade(0);


    }

    @Test
    public void testUpdateArtistGrade() {

        // Given

        ArtistGradeDto artistGradeDto = new ArtistGradeDto(0, "Radiohead", 5);
        ArtistGrade artistGrade1 = new ArtistGrade(1, "Madonna", 5);

        when(artistGradeMapperMock.mapToArtistGradeDto(artistGrade1)).thenReturn(artistGradeDto);
        when(dbArtistServiceMock.saveArtistGrade(artistGrade1)).thenReturn(artistGrade1);
        when(artistGradeMapperMock.mapToArtistGrade(artistGradeDto)).thenReturn(artistGrade1);

        // When

        ArtistGradeDto result = artistController.updateArtistGrade(artistGradeDto);

        // Then

        Assert.assertEquals(artistGradeDto, result);
        Mockito.verify(artistGradeMapperMock).mapToArtistGradeDto(artistGrade1);

    }

    @Test
    public void testCreateArtistGrade() {

        // Given

        ArtistGradeDto artistGradeDto = new ArtistGradeDto(0, "Radiohead", 5);

        ArtistGrade artistGrade1 = new ArtistGrade(1, "Madonna", 5);
        when(dbArtistServiceMock.saveArtistGrade(artistGrade1)).thenReturn(artistGrade1);
        when(artistGradeMapperMock.mapToArtistGrade(artistGradeDto)).thenReturn(artistGrade1);

        // When

        artistController.createArtistGrade(artistGradeDto);

        // Then

        Assert.assertNotEquals(artistGrade1, artistGradeDto);
        Assert.assertNotNull(artistGradeDto);

    }

    @Test
    public void testGetLast10Artists() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        User user2 = new User(1, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);

        SearchHistory searchHistory1 = new SearchHistory(1, "Madonna", user1, LocalDate.now());
        searchHistoryList.add(searchHistory1);

        List<User> usersList = new ArrayList<>();
        usersList.add(user1);
        usersList.add(user2);

        artistList.add(new Artist(0, "Radiohead", "alternative rock", usersList));
        artistList.add(new Artist(1, "Nirvana", "grunge", usersList));

        ArtistDto artistDto1 = new ArtistDto(0, "Madonna", "pop", usersList);
        ArtistDto artistDto2 = new ArtistDto(1, "Rammstein", "metal", usersList);

        List<ArtistDto> artistDtoList = new ArrayList<>();
        artistDtoList.add(artistDto1);
        artistDtoList.add(artistDto2);

        when(artistMapperMock.mapToArtistDtoList(artistList)).thenReturn(artistDtoList);
        when(dbArtistServiceMock.getLast10Artists(0)).thenReturn(artistList);

        // When

        List<ArtistDto> result = artistController.getLast10Artists(0);

        // Then
        Assert.assertEquals(artistList.size(), result.size());

    }

    @Test
    public void testGetLastArtistsByDay() {

        // Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        Artist artist = new Artist(0, "Radiohead", "alternative rock", usersList);
        artistList.add(artist);

        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        User user2 = new User(1, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);

        searchHistoryList.add(new SearchHistory(0, "Radiohead", user1, LocalDate.of(2020, 9, 10)));
        searchHistoryList.add(new SearchHistory(1, "Nirvana", user2, LocalDate.of(2020,9,17)));

        SearchHistoryDto searchHistoryDto1 = new SearchHistoryDto(0, "Radiohead", user1, LocalDate.of(2020,9,10));
        SearchHistoryDto searchHistoryDto2 = new SearchHistoryDto(1, "Mad", user2, LocalDate.of(2020,9,5));

        List<SearchHistoryDto> searchHistoryDtoList = new ArrayList<>();
        searchHistoryDtoList.add(searchHistoryDto1);
        searchHistoryDtoList.add(searchHistoryDto2);

        when(searchHistoryMapperMock.mapToSearchHistoryDtoList(searchHistoryList)).thenReturn(searchHistoryDtoList);
        when(dbArtistServiceMock.getLastArtistsByWhenSearched(LocalDate.of(2020,9,5))).thenReturn(searchHistoryList);

        // When

        List<SearchHistoryDto> result = artistController.getLastArtistsByDay(LocalDate.of(2017, 1, 1));

        // Then

        Assert.assertEquals(0 , result.size());
        Assert.assertEquals(2, searchHistoryDtoList.size());
        Assert.assertEquals(searchHistoryList.size(), searchHistoryDtoList.size());
        Assert.assertEquals(searchHistoryList.get(0).getId(), searchHistoryDtoList.get(0).getId());
        Assert.assertEquals(searchHistoryList.get(0).getWhenSearched(), searchHistoryDtoList.get(0).getWhenSearched());
    }

    @Test
    public void testGetLastArtistsByText() {

        // Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        Artist artist = new Artist(0, "Radiohead", "alternative rock", usersList);
        artistList.add(artist);

        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        User user2 = new User(1, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);

        searchHistoryList.add(new SearchHistory(0, "Radiohead", user1, LocalDate.of(2020, 9, 10)));
        searchHistoryList.add(new SearchHistory(1, "Nirvana", user2, LocalDate.of(2020,9,17)));

        SearchHistoryDto searchHistoryDto1 = new SearchHistoryDto(0, "Radiohead", user1, LocalDate.of(2020,9,10));
        SearchHistoryDto searchHistoryDto2 = new SearchHistoryDto(1, "Mad", user2, LocalDate.of(2020,9,5));

        List<SearchHistoryDto> searchHistoryDtoList = new ArrayList<>();
        searchHistoryDtoList.add(searchHistoryDto1);
        searchHistoryDtoList.add(searchHistoryDto2);

        when(searchHistoryMapperMock.mapToSearchHistoryDtoList(searchHistoryList)).thenReturn(searchHistoryDtoList);

        when(dbArtistServiceMock.getLastArtistsByText("Radiohead")).thenReturn(searchHistoryList);

        // When

        List<SearchHistoryDto> result = artistController.getLastArtistsByText("Radiohead");

        // Then

        Assert.assertEquals(2 , result.size());
        Assert.assertEquals(2, searchHistoryDtoList.size());
        Assert.assertEquals(searchHistoryList.size(), searchHistoryDtoList.size());
        Assert.assertEquals(searchHistoryList.get(0).getId(), searchHistoryDtoList.get(0).getId());
        Assert.assertEquals(searchHistoryList.get(0).getSearchedWord(), searchHistoryDtoList.get(0).getSearchedWord());
    }
}
