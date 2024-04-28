package org.hbrs.se1.ss24.uebung2.Cardbox;


import java.io.IOException;

public class CardboxStorageException extends Exception {

    public CardboxStorageException(String message){
        super(message);
    }

    public CardboxStorageException(String message, Throwable cause){
        super(message, cause);
    }

    public CardboxStorageException(Throwable cause){
        super(cause);
    }

    public CardboxStorageException(){
        super();
    }

}
