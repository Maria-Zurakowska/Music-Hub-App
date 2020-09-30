package com.musichub.musichubapp.validator;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EmailValidatorTestSuite {

    @Test
    public void testValidate() {

        assertTrue(EmailValidator.validate("testowe@o2.pl"));
    }
}
