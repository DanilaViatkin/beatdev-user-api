package com.beatdev.core.service.validator;

import com.beatdev.core.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidator implements Validator<User>{
    private static final int MAX_NAME_LENGTH = 50;
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_EMAIL_LENGTH = 50;
    private static final int MIN_EMAIL_LENGTH = 8;

    @Override
    public boolean isValid(User entity) {
        if(!isNameValid(entity.getName()) ||
                !isEmailValid(entity.getEmail())){
            return false;
        }
        return true;
    }

    public boolean isNameValid(String name){
        if (name.length() > MAX_NAME_LENGTH ||
                name.length() < MIN_NAME_LENGTH){
            return false;
        }
        return true;
    }

    public boolean isEmailValid(String email){
        if (email.length() > MAX_EMAIL_LENGTH ||
                email.length() < MIN_EMAIL_LENGTH){
            return false;
        }
        return true;
    }
}
