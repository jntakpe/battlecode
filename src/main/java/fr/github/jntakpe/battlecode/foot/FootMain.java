package fr.github.jntakpe.battlecode.foot;

/**
 * @author jntakpe
 */
public class FootMain {

    public static void main(String[] args) {
        int[] xTab = {35, 15, 1};
        int[] yTab = {65, 30, 120};
        int[] zTab = {35, 10, 2};
        for (int i = 0; i < 3; i++) {
            printScore(ourGoals(xTab[i]), theirsGoals(yTab[i], zTab[i]));
        }
    }

    private static int ourGoals(int minutes) {
        return nbRepetition(minutes);
    }

    private static int theirsGoals(int autoMinutes, int theirMinutes) {
        return nbRepetition(autoMinutes) + nbRepetition(theirMinutes);
    }

    private static int nbRepetition(int occursTime) {
        return (int) Math.ceil(90 / occursTime);
    }

    private static void printScore(int ourGoals, int theirGoals) {
        System.out.println(ourGoals + "-" + theirGoals);
    }




}
