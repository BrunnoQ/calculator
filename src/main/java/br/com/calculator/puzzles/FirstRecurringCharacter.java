package br.com.calculator.puzzles;

import java.util.HashMap;

public class FirstRecurringCharacter {

    public static void main(String[] args) {
        System.out.println(firstRecurringCharacter("ABCA"));
        System.out.println(firstRecurringCharacter2("ABC"));
    }

    // O(n^2)
    public static char firstRecurringCharacter(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    return charArray[i];
                }
            }
        }
        return '\0';
    }

    // O(n)
    public static char firstRecurringCharacter2(String str) {
        char[] charArray = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {

            if (map.containsKey(charArray[i])) {
                return charArray[i];
            } else {
                map.put(charArray[i], 1);
            }

        }
        return '\0';
    }

}
