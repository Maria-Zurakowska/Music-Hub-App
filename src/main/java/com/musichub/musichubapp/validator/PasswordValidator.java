package com.musichub.musichubapp.validator;

import java.util.Objects;

public class  PasswordValidator {
    public static boolean validate(String password){
        boolean validationResult = true;

        if(!checkFieldFormat(password)){
            System.out.println("Password format is not correct");
            validationResult = false;
        }
        return validationResult;
    } 

    //Password must contain at least:
    // 8 characters, maximum 20
    // 1 number
    // 1 upper case letter
    // 1 lower case letter
    // 1 special character
    // not any spaces
    private static boolean checkFieldFormat(String password){
        return Objects.nonNull(password) && password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*](?=\\S+$).{8,20}$");

    }
}
