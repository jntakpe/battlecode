package fr.github.jntakpe.battlecode.mnms;

/**
 * @author jntakpe
 */
public class MnM {

    private final char color;

    private final int occurs;

    public MnM(char color, int occurs) {
        this.color = color;
        this.occurs = occurs;
    }

    public char getColor() {
        return color;
    }

    public int getOccurs() {
        return occurs;
    }

    @Override
    public String toString() {
        return "MnM{" +
                "color=" + color +
                ", occurs=" + occurs +
                '}';
    }
}
