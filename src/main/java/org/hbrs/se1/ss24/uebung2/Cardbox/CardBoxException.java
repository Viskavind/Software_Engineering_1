package org.hbrs.se1.ss24.uebung2.Cardbox;

public class CardBoxException extends Exception{

    public CardBoxException(String message){
        super(message);
    }

    public CardBoxException(String message, Throwable cause){
        super(message, cause);
    }

    public CardBoxException(Throwable cause){
        super(cause);
    }

    public CardBoxException(){
        super();
    }
}
