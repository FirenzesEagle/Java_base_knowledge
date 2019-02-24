package me.liumingbo.strings;

import java.util.HashSet;
import java.util.Set;

public class PalindromeNum {
    public Integer longestPalindrome(String str) {
        if (str.length() == 0 || str == null) {
            return 0;
        }
        char[] strChars = str.toCharArray();
        int count = 0;
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < strChars.length; i++) {
            if (!characterSet.contains(strChars[i])) {
                characterSet.add(strChars[i]);
            } else {
                characterSet.remove(strChars[i]);
                count++;
            }
        }
        return characterSet.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
