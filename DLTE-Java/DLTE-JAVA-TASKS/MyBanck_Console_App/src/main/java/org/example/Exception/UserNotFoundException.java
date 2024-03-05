package org.example.Exception;

import java.util.ResourceBundle;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super(ResourceBundle.getBundle("information").getString("user.name"));
    }
}
