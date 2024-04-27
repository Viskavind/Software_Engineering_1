package org.hbrs.se1.ss24.uebung2.Cardbox;
import org.hbrs.se1.ss24.uebung2.businesslogic.PersonCard;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


//Class that can store Objects of the type PersonCard
public class CardBox {

    //Das Singleton Pattern wird angewendet um nur ein erstellbares CardBox Objekt zu erzeugen,
    // von diesem wird dann die Instanz über getInstance abgerufen.
    private final ArrayList<PersonCard> cardBox = new ArrayList<>();
    private static final CardBox cardBoxInstance = new CardBox();

    private CardBox(){};

    public static CardBox getInstance(){
        return cardBoxInstance;
    }

    public void addPersonCard(PersonCard card) throws CardBoxException {
        for (PersonCard existingCard : cardBox) {
            if (existingCard.getId() == card.getId()) {
                throw new CardBoxException("Das CardBox-Objekt mit der ID " + card.getId() + " ist bereits vorhanden");
            }
        }
        cardBox.add(card);
    }

    public String deletePersonCard(int id){
        for (PersonCard card : cardBox) {
            if (card.getId() == id) {
                cardBox.remove(card);
                return "Das CardBox-Objekt mit der ID " + id + " wurde erfolgreich gelöscht";
            }
        }
        //Das Problem hierbei ist, dass falls dieses Objekt existiert aber wegen eines Fehlers im Code übersprungen wird,
        // wird dieser Fehler ignoriert und es gibt keine Fehlermeldung
        return "Das CardBox-Objekt mit der ID " + id + " konnte nicht gefunden werden";
    }

    public void showContent(){
        for (PersonCard card : cardBox) {
            System.out.println(card.toString());
        }
    }

    public int size(){
        return cardBox.size();
    }

    public PersonCard getPersonCard(int pos){
            return cardBox.get(pos);
    }

    public void save() {

    }

    public void load() {

    }
}
