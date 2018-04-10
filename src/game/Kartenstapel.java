package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kartenstapel {

    List<Spielkarte> deck = new ArrayList<>();

    public Kartenstapel() {
        createKartendeck();
        shuffleKartendeck();
    }

    private void shuffleKartendeck() {
        Collections.shuffle(deck);
    }

    private void createKartendeck() {
        Arrays.asList(Spielkarte.Farbe.values())
                .forEach(farbe -> {
                    Arrays.asList(Spielkarte.Wert.values())
                            .forEach(wert -> deck.add(new Spielkarte(farbe, wert)));
                });
    }

    private int getKartenAnzahl(){
        return deck.size();
    }

    public Spielkarte getFirstSpielkarte(){
        return deck.remove(deck.size() - 1);
    }


}
