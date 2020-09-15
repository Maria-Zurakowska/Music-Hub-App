package com.musichub.musichubapp.service;

import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.entities.ArtistGrade;
import com.musichub.musichubapp.entities.SearchHistory;
import com.musichub.musichubapp.entities.User;
import com.musichub.musichubapp.repository.ArtistGradeRepository;
import com.musichub.musichubapp.repository.ArtistRepository;
import com.musichub.musichubapp.repository.SearchHistoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DbArtistServiceTestSuite {

    @Test
    public void testGetAllArtists() {

        //Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        artistList.add(artist1);

        SearchHistory searchHistory1 = new SearchHistory();
        searchHistoryList.add(searchHistory1);

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);
        when(searchHistoryRepositoryMock.findAll()).thenReturn(searchHistoryList);

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);
        when(artistRepositoryMock.findAll()).thenReturn(artistList);

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);
        List<ArtistGrade> artistGradesList = new ArrayList<>();
        artistGradesList.add(new ArtistGrade(1, "Madonna", 5));
        when(artistGradeRepositoryMock.findAll()).thenReturn(artistGradesList);


        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        //When

        List<Artist> result = dbArtistService.getAllArtists();

        //Then

        Assert.assertEquals(1, result.size());

    }

    @Test
    public void testGetArtist() {

        // Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        artistList.add(artist1);

        SearchHistory searchHistory1 = new SearchHistory(1, "Madonna", user1, LocalDate.now());
        searchHistoryList.add(searchHistory1);

        ArtistGrade artistGrade1 = new ArtistGrade(1, "Madonna", 5);

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);
        when(searchHistoryRepositoryMock.findById(1)).thenReturn(Optional.of(searchHistory1));

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);
        when(artistRepositoryMock.findById(1)).thenReturn(Optional.of(artist1));

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);
        List<ArtistGrade> artistGradesList = new ArrayList<>();
        artistGradesList.add(new ArtistGrade(1, "Madonna", 5));
        when(artistGradeRepositoryMock.findById(1)).thenReturn(Optional.of(artistGrade1));

        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        //When

        Optional<Artist> artist = dbArtistService.getArtist(1);

        //Then

        Assert.assertEquals(true, artist.isPresent());

    }

    @Test
    public void testSaveArtist() {

        //Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        artistList.add(artist1);

        SearchHistory searchHistory1 = new SearchHistory(1, "Madonna", user1, LocalDate.now());
        searchHistoryList.add(searchHistory1);

        ArtistGrade artistGrade1 = new ArtistGrade(1, "Madonna", 5);

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);
        when(searchHistoryRepositoryMock.save(searchHistory1)).thenReturn(searchHistory1);

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);
        when(artistRepositoryMock.save(artist1)).thenReturn(artist1);

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);
        List<ArtistGrade> artistGradesList = new ArrayList<>();
        artistGradesList.add(new ArtistGrade(1, "Madonna", 5));
        when(artistGradeRepositoryMock.save(artistGrade1)).thenReturn(artistGrade1);


        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        //When

        Artist artist = dbArtistService.saveArtist(artist1);

        //Then

        Assert.assertEquals(artist1, artist);

    }

    @Test
    public void testDeleteArtist() {

        //Given

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);


        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        //When

        dbArtistService.deleteArtist(1);

        //Then

        Mockito.verify(artistRepositoryMock).deleteById(1);

    }

    @Test
    public void testGetAllArtistGrades() {

        //Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        artistList.add(artist1);

        SearchHistory searchHistory1 = new SearchHistory();
        searchHistoryList.add(searchHistory1);

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);
        when(searchHistoryRepositoryMock.findAll()).thenReturn(searchHistoryList);

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);
        when(artistRepositoryMock.findAll()).thenReturn(artistList);

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);
        List<ArtistGrade> artistGradesList = new ArrayList<>();
        artistGradesList.add(new ArtistGrade(1, "Madonna", 5));
        when(artistGradeRepositoryMock.findAll()).thenReturn(artistGradesList);


        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        //When

        List<ArtistGrade> result = dbArtistService.getAllArtistGrades();

        //Then

        Assert.assertEquals(1, result.size());

    }

    @Test
    public void testGetArtistGrade() {

        //Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        artistList.add(artist1);

        SearchHistory searchHistory1 = new SearchHistory(1, "Madonna", user1, LocalDate.now());
        searchHistoryList.add(searchHistory1);

        ArtistGrade artistGrade1 = new ArtistGrade(1, "Madonna", 5);

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);
        when(searchHistoryRepositoryMock.findById(1)).thenReturn(Optional.of(searchHistory1));

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);
        when(artistRepositoryMock.findById(1)).thenReturn(Optional.of(artist1));

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);
        List<ArtistGrade> artistGradesList = new ArrayList<>();
        artistGradesList.add(new ArtistGrade(1, "Madonna", 5));
        when(artistGradeRepositoryMock.findById(1)).thenReturn(Optional.of(artistGrade1));


        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        //When

        Optional<ArtistGrade> artistGrade = dbArtistService.getArtistGrade(1);

        //Then

        Assert.assertEquals(true, artistGrade.isPresent());

    }

    @Test
    public void testSaveArtistGrade() {

        //Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        artistList.add(artist1);

        SearchHistory searchHistory1 = new SearchHistory(1, "Madonna", user1, LocalDate.now());
        searchHistoryList.add(searchHistory1);

        ArtistGrade artistGrade1 = new ArtistGrade(1, "Madonna", 5);

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);
        when(searchHistoryRepositoryMock.save(searchHistory1)).thenReturn(searchHistory1);

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);
        when(artistRepositoryMock.save(artist1)).thenReturn(artist1);

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);
        List<ArtistGrade> artistGradesList = new ArrayList<>();
        artistGradesList.add(new ArtistGrade(1, "Madonna", 5));
        when(artistGradeRepositoryMock.save(artistGrade1)).thenReturn(artistGrade1);


        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        //When

        ArtistGrade result = dbArtistService.saveArtistGrade(artistGrade1);

        //Then

        Assert.assertEquals(artistGrade1, result);

    }

    @Test
    public void testDeleteArtistGrade() {

        //Given

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);

        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        //When

        dbArtistService.deleteArtistGrade(1);

        //Then

        Mockito.verify(artistGradeRepositoryMock).deleteById(1);
    }

    @Test
    public void testGetLast10Artists() {

        //Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        artistList.add(artist1);

        SearchHistory searchHistory1 = new SearchHistory(1, "Madonna", user1, LocalDate.now());
        searchHistoryList.add(searchHistory1);

        ArtistGrade artistGrade1 = new ArtistGrade(1, "Madonna", 5);

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);
        when(searchHistoryRepositoryMock.findFirstById(1)).thenReturn(searchHistoryList);

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);
        when(artistRepositoryMock.findFirstById(1)).thenReturn(artistList);

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);
        List<ArtistGrade> artistGradesList = new ArrayList<>();
        artistGradesList.add(new ArtistGrade(1, "Madonna", 5));
        when(artistGradeRepositoryMock.findFirstById(1)).thenReturn(artistGradesList);


        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        //When

        List<Artist> last10Artists = dbArtistService.getLast10Artists(1);

        //Then

        Assert.assertEquals(artistList, last10Artists);
    }

    @Test
    public void testGetLastArtistsByWhenSearched() {

        //Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        artistList.add(artist1);

        SearchHistory searchHistory1 = new SearchHistory(1, "Madonna", user1, LocalDate.now());
        searchHistoryList.add(searchHistory1);

        ArtistGrade artistGrade1 = new ArtistGrade(1, "Madonna", 5);

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);
        when(searchHistoryRepositoryMock.findAllByWhenSearched(LocalDate.now())).thenReturn(searchHistoryList);

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);
        List<ArtistGrade> artistGradesList = new ArrayList<>();
        artistGradesList.add(new ArtistGrade(1, "Madonna", 5));


        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        //When

        List<SearchHistory> lastArtistsByWhenSearchedList = dbArtistService.getLastArtistsByWhenSearched(LocalDate.now());


        //Then

        Assert.assertEquals(searchHistoryList, lastArtistsByWhenSearchedList);

    }

    @Test
    public void testGetLastArtistsByText() {

        //Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        artistList.add(artist1);

        SearchHistory searchHistory1 = new SearchHistory(1, "Madonna", user1, LocalDate.now());
        searchHistoryList.add(searchHistory1);

        ArtistGrade artistGrade1 = new ArtistGrade(1, "Madonna", 5);

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);
        when(searchHistoryRepositoryMock.findAllBySearchedWord("Madonna")).thenReturn(searchHistoryList);

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);
        List<ArtistGrade> artistGradesList = new ArrayList<>();
        artistGradesList.add(new ArtistGrade(1, "Madonna", 5));


        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        //When

        List<SearchHistory> lastArtistsByTextList = dbArtistService.getLastArtistsByText("Madonna");

        //Then

        Assert.assertEquals(searchHistoryList, lastArtistsByTextList);
    }
}