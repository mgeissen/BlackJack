public class Casino {

    private final Kartenstapel kartenstapel;
    private final Kartenhand spielerHand;
    private final Kartenhand geberHand;

    public Casino() {
        kartenstapel = new Kartenstapel();
        spielerHand = new Kartenhand();
        geberHand = new Kartenhand();
    }

    public void starteSpiel() {
        initializeGame();
        startInteraction();
    }

    private void startInteraction() {
        while (spielerHand.getPunkte() < 22){

        }
    }

    private void printSpielerHand(){
        System.out.println(String.format("Du hast folgende Karten: %s", spielerHand.getKartenNames()));
        System.out.println(String.format("Deine Puntke: %d", spielerHand.getPunkte()));
    }

    private void initializeGame() {
        spielerHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
        spielerHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
        geberHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
    }

}
