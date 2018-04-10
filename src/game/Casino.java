package game;

import printer.Printer;

import java.util.Scanner;

public class Casino {

    private final Kartenstapel kartenstapel;
    private Kartenhand spielerHand;
    private Kartenhand geberHand;
    private final Scanner scanner;
    private final Printer printer;

    public Casino() {
        kartenstapel = new Kartenstapel();
        spielerHand = new Kartenhand();
        geberHand = new Kartenhand();
        scanner = new Scanner(System.in);
        printer = new Printer();
    }

    public void startGame() {
        initializeGame();
        startSpielerInteraction();
        startGeberInteraction();
        printer.printResult(spielerHand, geberHand);
        if(playerWillAgain()){
            startGame();
        }
        printer.printEnd();
    }

    private boolean playerWillAgain() {
        printer.printAgainQuestion();
        final String input = scanner.next();
        return input.equals("y");
    }

    private void startSpielerInteraction() {
        printer.printBreakMessage("Spieler");
        while (spielerHand.getPunkte() < 22){
            printer.printSpielerHand(spielerHand);
            printer.printQuestion();
            final int input = scanner.nextInt();
            if(input == 1){
                break;
            } else if(input == 2){
                spielerHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
            } else{
                printer.printError();
            }
        }
        printer.printSpielerHand(spielerHand);
        if(spielerHand.getPunkte() >= 22){
            printer.printToMuchPoints(spielerHand.getPunkte());
        } else{
            printer.printPoints(spielerHand.getPunkte());
        }
    }

    private void startGeberInteraction(){
        printer.printBreakMessage("Geber");
        while (geberHand.getPunkte() <= 16){
            printer.printGeberHand(geberHand);
            geberHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
        }
        printer.printGeberHand(geberHand);
    }

    private void initializeGame() {
        spielerHand = new Kartenhand();
        geberHand = new Kartenhand();
        spielerHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
        spielerHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
        geberHand.addSpielkarte(kartenstapel.getFirstSpielkarte());
    }

}
