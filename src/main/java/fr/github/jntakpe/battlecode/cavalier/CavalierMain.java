package fr.github.jntakpe.battlecode.cavalier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jntakpe
 */
public class CavalierMain {

    private Case currentCase = new Case(0, 0);



    public static void main(String[] args) {
        Cavalier cavalier = new Cavalier(initPlateau(1000, 1500));
        try {
            cavalier.run();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(cavalier.calcRunningTime());
        }
    }

    public static List<Case> initPlateau(int nbX, int nbY) {
        List<Case> plateau = new ArrayList<>();
        for (int i = 0; i < nbX; i++) {
            for (int j = 0; j < nbY; j++) {
                plateau.add(new Case(i, j));
            }
        }
        return plateau;
    }


}
