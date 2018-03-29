public class Spielkarte {

    private Farbe farbe;
    private Wert wert;

    public Spielkarte(final Farbe farbe, final Wert wert) {
        this.farbe = farbe;
        this.wert = wert;
    }

    public Farbe getFarbe() {
        return farbe;
    }

    public Wert getWert() {
        return wert;
    }

    public int getPunkte(final boolean withHighPoints){
        if(!withHighPoints && wert == Wert.ASS){
            return 1;
        }
        return wert.getWert();
    }

    public enum Farbe {
        KREUZ, PIEK, KARO, HERZ
    }

    public enum Wert{
        ZWEI(2),
        DREI(3),
        VIER(4),
        FÜNF(5),
        SECHS(6),
        SIEBEN(7),
        ACHT(8),
        NEUN(9),
        ZEHN(10),
        BUBE(10),
        DAME(10),
        KÖNIG(10),
        ASS(11); // WICHTIG: Wert 11 oder 1 | Default 11

        private int wert;

        Wert(final int wert) {
            this.wert = wert;
        }

        public int getWert() {
            return wert;
        }
    }

}
