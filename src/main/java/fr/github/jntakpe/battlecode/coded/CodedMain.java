package fr.github.jntakpe.battlecode.coded;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jntakpe
 */
public class CodedMain {

    public static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static final String[] ENCODED_MSG = {
            "SHXPQ JDIAJK!",
            "HMEJ GL SH!",
            "YNI BJKWI WLF VWPI...!!!",
            "YXWLAPETOJEZU ... NVWIU IXMBQFZT... JZABCDEFGHIJKDWPIB..."
    };

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            System.out.println(decodeMsg(ENCODED_MSG[i]));
        }
    }

    private static String decodeMsg(String msg) {
        int previousIdx = 0;
        StringBuilder msgBuilder = new StringBuilder();
        for (char letter : msg.toCharArray()) {
            int letterIndex = letterIndex(letter);
            if (letterIndex != -1) {
                letter = decodeLetter(previousIdx, letterIndex);
                previousIdx = ++letterIndex;
            }
            msgBuilder.append(letter);
        }
        return msgBuilder.toString();
    }

    private static char decodeLetter(int previousIdx, int currentIdx) {
        int idx;
        currentIdx++;
        if (currentIdx < previousIdx) {
            idx = ALPHABET.length + currentIdx - previousIdx;
        } else {
            idx = currentIdx - previousIdx;
        }
        return ALPHABET[--idx];
    }

    private static int letterIndex(char letter) {
        return toListAlphabet().indexOf(letter);
    }

    private static List<Character> toListAlphabet() {
        List<Character> alphabetList = new ArrayList<>();
        for (char letter : ALPHABET) {
            alphabetList.add(letter);
        }
        return alphabetList;
    }

}
