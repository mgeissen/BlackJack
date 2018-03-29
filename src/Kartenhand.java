import java.util.ArrayList;
import java.util.List;

public class Kartenhand {

    private final List<Spielkarte> hand = new ArrayList<>();

    public void addSpielkarte(final Spielkarte spielkarte){
        if(hand.size() <= 21){
            hand.add(spielkarte);
        }
    }

    public int getPunkte(){
        int points = collectPoints(true);
        if(points > 21){
            points = collectPoints(false);
        }
        return points;
    }

    private int collectPoints(final boolean highestPoints){
        return hand.stream()
                .mapToInt(spielkarte -> spielkarte.getPunkte(highestPoints))
                .sum();
    }

    public String getKartenNames(){
        final StringBuilder nameBuilder = new StringBuilder();
        hand.forEach(spielkarte -> {
            nameBuilder.append(String.format("%s %s,", spielkarte.getFarbe().name(), spielkarte.getWert().name()));
        });
        return nameBuilder.toString();
    }

}
