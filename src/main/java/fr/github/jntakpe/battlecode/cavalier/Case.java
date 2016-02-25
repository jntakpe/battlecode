package fr.github.jntakpe.battlecode.cavalier;

import java.util.Objects;

/**
 * @author jntakpe
 */
public class Case {

    private final int x;

    private final int y;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Case)) {
            return false;
        }
        Case aCase = (Case) o;
        return x == aCase.x &&
                y == aCase.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Case{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
