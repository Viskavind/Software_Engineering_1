package org.hbrs.se1.ss24.uebung4.storage;


public class UserStoryStorageException extends Exception{
    public UserStoryStorageException(String message, Throwable cause){
        super(message, cause);
    }

    public UserStoryStorageException(String message){
        super(message);
    }
}
