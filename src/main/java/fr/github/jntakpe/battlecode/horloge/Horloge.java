package fr.github.jntakpe.battlecode.horloge;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jntakpe
 */
public class Horloge {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH'h'mm");

    public static void main(String[] args) {
        LocalTime start = parse("00h00");
        LocalTime end = parse("01h00");
        System.out.println(total(start, end));
    }

    private static int sum(LocalTime localTime) {
        return localTime.getHour() + localTime.getMinute();
    }

    private static LocalTime parse(String string) {
        return LocalTime.parse(string, formatter);
    }

    private static int total(LocalTime start, LocalTime end) {
        int total = 0;
        while (start.isBefore(end)) {
            total += sum(start);
            start = start.plusMinutes(1L);
        }
        return total;
    }
}
