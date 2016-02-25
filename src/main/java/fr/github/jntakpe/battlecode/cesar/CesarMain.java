package fr.github.jntakpe.battlecode.cesar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jntakpe
 */
public class CesarMain {

    public static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static final String[] ENCODED_MSG = {
            "DBFTBS DJQIFS",
            "QEFP FP X KBDXQFSB HBV",
            "TUZF: GEQ YAPGXA FIQZFK EUJ FA PQOAPQ FTUE AZQ !"
    };

    public static final int[] CESAR_NB = {1, -3, 402};

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(decodeMsg(ENCODED_MSG[i], resolveCaesar(CESAR_NB[i])));
        }
    }

    public static String decodeMsg(String msg, int cesarNb) {
        StringBuilder builder = new StringBuilder();
        for (char letter : msg.toCharArray()) {
            builder.append(decodeChar(letter, cesarNb));
        }
        return builder.toString();
    }

    public static char decodeChar(char letter, int cesarNb) {
        int letterIdx = toListAlphabet().indexOf(letter);
        if (letterIdx != -1) {
            return ALPHABET[resolveIdx(letterIdx, cesarNb)];
        }
        return letter;
    }

    public static int resolveIdx(int letterIdx, int cesarNb) {
        int diff = letterIdx - cesarNb;
        if (diff < 0) {
            return ALPHABET.length + diff;
        } else if (diff >= ALPHABET.length) {
            return diff - ALPHABET.length;
        }
        return diff;
    }

    public static int resolveCaesar(int caesar) {
        int modulo = Math.abs(caesar) % ALPHABET.length;
        return caesar < 0 ? -modulo : modulo;
    }

    public static List<Character> toListAlphabet() {
        List<Character> alphabetList = new ArrayList<>();
        for (char letter : ALPHABET) {
            alphabetList.add(letter);
        }
        return alphabetList;
    }

}
