package org.hbrs.se1.ss24.uebung3.Cardbox;
import org.hbrs.se1.ss24.uebung3.businesslogic.PersonCard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


//Klasse die Objekte von PersonCard speichert und verwaltet
public enum CardBox {

    //Das Singleton Pattern wird angewendet um nur ein erstellbares CardBox Objekt zu erzeugen,
    // von diesem wird dann die Instanz über getInstance abgerufen.
    INSTANCE;
    private final ArrayList<PersonCard> cardBox = new ArrayList<>();

    public static CardBox getInstance(){
        return INSTANCE;
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

    public List<PersonCard> getCurrentList(){
        return cardBox;
    }

    public int size(){
        return cardBox.size();
    }

    public PersonCard getPersonCard(int pos){
        return cardBox.get(pos);
    }


    public void save() throws CardboxStorageException {
        try {
            File outputfile = new File("Objects.txt");
            FileOutputStream fos = new FileOutputStream(outputfile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (PersonCard card : cardBox) {
                oos.writeObject(card);
            }

            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new CardboxStorageException("Fehler beim Speichern der CardBox", e);
        }
    }

    public void load() throws CardboxStorageException {
        cardBox.clear();

        try {
            FileInputStream fis = new FileInputStream("Objects.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (fis.available() > 0) {
                PersonCard card = (PersonCard) ois.readObject();
                cardBox.add(card);
            }

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new CardboxStorageException("Fehler beim Laden der CardBox", e);
        }
    }
}
