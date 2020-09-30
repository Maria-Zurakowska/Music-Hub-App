package com.musichub.musichubapp.validator;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PasswordValidatorTestSuite {

    @Test
    public void testValidate() {
        assertTrue(PasswordValidator.validate("Testowe123!"));
    }
}
