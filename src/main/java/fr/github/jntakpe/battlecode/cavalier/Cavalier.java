package fr.github.jntakpe.battlecode.cavalier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jntakpe
 */
public class Cavalier {

    private Case currentCase = new Case(0, 0);

    private final List<Case> moves = new ArrayList<>();

    private final List<Case> plateau;

    private int[] posX = {2, 1, -1, -2, -2, -1, 1, 2};

    private int[] posY = {1, 2, 2, 1, -1, -2, -2, -1};

    public Cavalier(List<Case> plateau) {
        this.plateau = plateau;
        tryMovingTo(0, 0);
    }

    public void run() {
        while (true) {
            goNextCase();
        }
    }

    public int calcRunningTime() {
        return moves.size() * 15;
    }

    private boolean tryMovingTo(int x, int y) {
        Case goTo = new Case(currentCase.getX() + x, currentCase.getY() + y);
        if (plateau.contains(goTo)) {
            plateau.remove(goTo);
            setCurrentCase(goTo);
            moves.add(goTo);
            return true;
        }
        return false;
    }

    private void goNextCase() {
        int i = 0;
        while (!tryMovingTo(posX[i], posY[i])) {
            i++;
        }
    }

    public Case getCurrentCase() {
        return currentCase;
    }

    public void setCurrentCase(Case currentCase) {
        this.currentCase = currentCase;
    }


}
