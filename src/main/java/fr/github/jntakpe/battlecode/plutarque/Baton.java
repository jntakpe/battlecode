package fr.github.jntakpe.battlecode.plutarque;

/**
 * @author jntakpe
 */
public class Baton {

    private String message;

    private int letterPerRound;

    private Baton(float diametre, float hauteur, String message) {
        this.message = message;
        letterPerRound = (int) Math.round(diametre * Math.PI / (hauteur / 10));
    }

    public static Baton init(String enonce) {
        String[] splitedEnonce = enonce.split(",");
        return new Baton(Float.parseFloat(splitedEnonce[0]), Float.parseFloat(splitedEnonce[1]), splitedEnonce[2]);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLetterPerRound() {
        return letterPerRound;
    }

    public void setLetterPerRound(int letterPerRound) {
        this.letterPerRound = letterPerRound;
    }
}
