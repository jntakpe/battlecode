package fr.github.jntakpe.battlecode.demineur;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author jntakpe
 */
public class DemineurMain {

    public static final String[] ENONCES = {
            "4 1,6 1,2 2,5 3,7 3,2 6,4 6,6 6",
            "5 5,2 3,1 1,3 3,2 5",
            "8 7,10 3,10 2,3 5,4 8,9 5,3 2,4 10,9 7,1 8,4 3,5 2,2 10,5 7,4 9,6 2,2 1,6 3,3 10,6 10"
    };

    public static final int[] PLATEAUX = {7, 5, 10};


    public static void main(String[] args) throws IOException {
        for (int i = 0; i < ENONCES.length; i++) {
            List<Case> plateau = initPlateau(PLATEAUX[i], PLATEAUX[i]);
            putMines(plateau, ENONCES[i]);
            putNumbers(plateau);
            printPlateau(plateau, PLATEAUX[i]);
        }
        Path enonceFile = Paths.get("/Users/jOSS/dev/battlecode/src/main/java/fr/github/jntakpe/battlecode/demineur/Minesweeper_q3.txt");
        if (Files.exists(enonceFile)) {
            List<String> lines = Files.readAllLines(enonceFile, StandardCharsets.UTF_8);
            StringBuilder enonce = new StringBuilder(lines.size());
            lines.stream().forEach(enonce::append);
            List<Case> plateau = initPlateau(100, 100);
            putMines(plateau, enonce.toString());
            putNumbers(plateau);
            printPlateau(plateau, 100);
        }
    }

    private static void printPlateau(List<Case> plateau, int lines) {
        for (int i = 0; i <= lines; i++) {
            int line = i;
            plateau.stream()
                    .filter(c -> c.getY() == line)
                    .forEach(c -> System.out.print(c.isMine() ? "x" : c.getNumero()));
            System.out.println("");
        }
    }

    public static List<Case> initPlateau(int nbX, int nbY) {
        List<Case> plateau = new ArrayList<>();
        for (int i = 1; i <= nbX; i++) {
            for (int j = 1; j <= nbY; j++) {
                plateau.add(new Case(i, j));
            }
        }
        return plateau;
    }

    public static void putMines(List<Case> cases, String mines) {
        for (String mine : mines.split(",")) {
            int x = Integer.parseInt(StringUtils.substringBefore(mine, " "));
            int y = Integer.parseInt(StringUtils.substringAfter(mine, " "));
            cases.stream()
                    .filter(c -> c.equals(new Case(x, y)))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("La case x:" + x + " et y:" + y + " est introuvable"))
                    .setMine(true);
        }
    }

    public static void putNumbers(List<Case> plateau) {
        plateau.stream()
                .filter(c -> !c.isMine())
                .forEach(c -> c.setNumero((int) calcNumber(c, plateau)));
    }

    public static long calcNumber(Case currentCase, List<Case> plateau) {
        return getCasesArround(currentCase, plateau).stream()
                .filter(Case::isMine)
                .count();
    }

    public static List<Case> getCasesArround(Case currentCase, List<Case> plateau) {
        return plateau.stream()
                .filter(c -> !c.equals(currentCase))
                .filter(isCaseArround(currentCase))
                .collect(Collectors.toList());

    }

    private static Predicate<Case> isCaseArround(Case currentCase) {
        return c -> Math.abs(c.getX() - currentCase.getX()) <= 1 && Math.abs(c.getY() - currentCase.getY()) <= 1;
    }
}
