package printer;

import game.Kartenhand;

public class Printer {

    public void printResult(Kartenhand spielerHand, Kartenhand geberHand) {
        printBreakMessage("Endergebnis");
        final int spielerPoints = spielerHand.getPunkte();
        final int geberPoints = geberHand.getPunkte();

        if((spielerPoints > geberPoints || geberPoints > 21 ) && spielerPoints < 22){
            sop(String.format("Gewonnen. Du hast %d Punkte, der Geber hat %d Punkte.", spielerPoints, geberPoints));
        } else if(spielerPoints == geberPoints || (spielerPoints > 21 && geberPoints > 21)){
            sop(String.format("Unentschieden. Du hast %d Punkte, der Geber hat %d Punkte.", spielerPoints, geberPoints));
        } else{
            sop(String.format("Verloren. Du hast %d Punkte, der Geber hat %d Punkte.", spielerPoints, geberPoints));
        }
    }

    public void printAgainQuestion() {
        System.out.println("Noch ein Spiel? (y/n)");
    }

    public void printBreakMessage(final String message){
        sop(String.format("----- %s -----", message));
    }

    public void printToMuchPoints(final int points) {
        sop(String.format("Du hast mit %d Punkte mehr als 21 Punkte und bist damit raus - bust!", points));
    }

    public void printPoints(final int points){
        sop(String.format("Du hast %d von maximal 21 Punkten", points));
    }

    public void printError() {
        sop("Das hat nicht geklappt. Bitte versuche es erneut.");
    }

    public void printQuestion() {
        sop("Möchtest eine weitere Karte ziehen? (stay = 1, hit = 2)");
    }

    public void printSpielerHand(Kartenhand spielerHand){
        sop(String.format("Du hast folgende Karten: %s", spielerHand.getKartenNames()));
        sop(String.format("Deine Punkte: %d", spielerHand.getPunkte()));
    }

    public void printGeberHand(Kartenhand geberHand){
        sop(String.format("Der Geber hat folgende Karten: %s", geberHand.getKartenNames()));
        sop(String.format("Seine Punkte: %d", geberHand.getPunkte()));
    }

    public void printEnd(){
        sop("Vielen Dank für deinen Besuch! Bis zum nächsten Mal :)");
    }

    private void sop(String printMessage){
        System.out.println(printMessage);
    }
}
