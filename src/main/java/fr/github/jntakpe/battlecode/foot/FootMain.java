package fr.github.jntakpe.battlecode.foot;

/**
 * @author jntakpe
 */
public class FootMain {

    public static final int[] ENONCE_X = {35, 15, 1};

    public static final int[] ENONCE_Y = {65, 30, 120};

    public static final int[] ENONCE_Z = {35, 10, 2};

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            printScore(ourGoals(ENONCE_X[i]), theirsGoals(ENONCE_Y[i], ENONCE_Z[i]));
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
