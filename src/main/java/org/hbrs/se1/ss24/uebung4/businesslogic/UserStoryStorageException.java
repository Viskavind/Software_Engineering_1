package org.hbrs.se1.ss24.uebung4.businesslogic;

import java.io.IOException;

public class UserStoryStorageException extends Exception{
    public UserStoryStorageException(String message, Throwable cause){
        super(message, cause);
    }
}
