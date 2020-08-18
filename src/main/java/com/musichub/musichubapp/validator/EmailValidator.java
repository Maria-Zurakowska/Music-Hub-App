package com.musichub.musichubapp.validator;

import java.util.Objects;

public class  EmailValidator {

    public static boolean validate(String email){
        boolean validationResult = true;

        if(!checkFieldFormat(email)){
            System.out.println("Email format is not correct");
            validationResult = false;
        }
        return validationResult;
    }

    // my sample regex: " ([A-Za-z0-9_])+@([A-Za-z])+\\.[A-Za-z]{2,3}"

    //Email must have:
    // A-Z characters
    //a-z characters
    //0-9 numbers
    // may contain . _ /
    // can't start with @
    // com. - dot after domain is not allowed
    private static boolean checkFieldFormat(String email){
        return Objects.nonNull(email) && email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");

    }
}
