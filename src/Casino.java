import java.util.Scanner;

public class Casino {

    private final Kartenstapel kartenstapel;
    private Kartenhand spielerHand;
    private Kartenhand geberHand;
    private final Scanner scanner;

    public Casino() {
        kartenstapel = new Kartenstapel();
        spielerHand = new Kartenhand();
        geberHand = new Kartenhand();
        scanner = new Scanner(System.in);
    }

    public void starteSpiel() {
        initializeGame();
        startSpielerInteraction();
        startGeberInteraction();
        printResult();
        if(playerWillAgain()){
            starteSpiel();
        }
    }

    private boolean playerWillAgain() {
        System.out.println("Noch ein Spiel? (y/n)");
        final String input = scanner.next();
        return input.equals("y");
    }

    private void printResult() {
        printBreakMessage("Endergebnis");
        final int spielerPoints = spielerHand.getPunkte();
        final int geberPoints = geberHand.getPunkte();

        if((spielerPoints > geberPoints || geberPoints > 21 ) && spielerPoints < 22){
            System.out.println(String.format("Gewonnen. Du hast %d Punkte, der Geber hat %d Punkte.", spielerPoints, geberPoints));
        } else if(spielerPoints == geberPoints || (spielerPoints > 21 && geberPoints > 21)){
            System.out.println(String.format("Unentschieden. Du hast %d Punkte, der Geber hat %d Punkte.", spielerPoints, geberPoints));
        } else{
            System.out.println(String.format("Verloren. Du hast %d Punkte, der Geber hat %d Punkte.", spielerPoints, geberPoints));
        }
    }

    private void startSpielerInteraction() {
        printBreakMessage("Spieler");
        while (spielerHand.getPunkte() < 22){
            printSpielerHand();
            printQuestion();
            final int input = scanner.nextInt();
            if(input == 1){
                break;
            } else if(input == 2){
                spielerHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
            } else{
                printError();
            }
        }
        printSpielerHand();
        if(spielerHand.getPunkte() >= 22){
            printToMuchPoints(spielerHand.getPunkte());
        } else{
            printPoints(spielerHand.getPunkte());
        }
    }

    private void startGeberInteraction(){
        printBreakMessage("Geber");
        while (geberHand.getPunkte() <= 16){
            printGeberHand();
            geberHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
        }
        printGeberHand();
    }

    private void printToMuchPoints(final int points) {
        System.out.println(String.format("Du hast mit %d Punkte mehr als 21 Punkte und bist damit raus - bust!", points));
    }

    private void printPoints(final int points){
        System.out.println(String.format("Du hast %d von maximal 21 Punkten", points));
    }

    private void printError() {
        System.out.println("Das hat nicht geklappt. Bitte versuche es erneut.");
    }

    private void printQuestion() {
        System.out.println("Möchtest eine weitere Karte ziehen? (stay = 1, hit = 2)");
    }

    private void printSpielerHand(){
        System.out.println(String.format("Du hast folgende Karten: %s", spielerHand.getKartenNames()));
        System.out.println(String.format("Deine Punkte: %d", spielerHand.getPunkte()));
    }

    private void printGeberHand(){
        System.out.println(String.format("Der Geber hat folgende Karten: %s", geberHand.getKartenNames()));
        System.out.println(String.format("Seine Punkte: %d", geberHand.getPunkte()));
    }

    private void initializeGame() {
        spielerHand = new Kartenhand();
        geberHand = new Kartenhand();
        spielerHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
        spielerHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
        geberHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
    }

    private void printBreakMessage(final String message){
        System.out.println(String.format("----- %s -----", message));
    }

}
