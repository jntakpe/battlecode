package fr.github.jntakpe.battlecode.horloge;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jntakpe
 */
public class Horloge {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH'h'mm");

    public static final String[] ENONCES_DEBUT = {"00h00", "09h59", "15h00"};

    public static final String[] ENONCES_FIN = {"01h00", "23h30", "14h58"};

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            LocalTime start = parse(ENONCES_DEBUT[i]);
            LocalTime end = parse(ENONCES_FIN[i]);
            System.out.println(total(start, end));
        }
    }

    private static int sum(LocalTime localTime) {
        return localTime.getHour() + localTime.getMinute();
    }

    private static LocalTime parse(String string) {
        return LocalTime.parse(string, formatter);
    }

    private static int total(LocalTime start, LocalTime end) {
        int total = 0;
        while (!start.equals(end)) {
            total += sum(start);
            start = start.plusMinutes(1L);
        }
        return total;
    }

}
