package me.liumingbo.strings;

import java.util.Arrays;

public class LongestPreStr {
    public String longestPreStr(String[] strs) {
        int len = strs.length;
        StringBuffer result = new StringBuffer();
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        int minStrLen = strs[0].length();
        int maxStrLen = strs[len - 1].length();
        int cmpLen = Math.min(minStrLen, maxStrLen);
        for (int i = 0; i < cmpLen; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                result.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }
}
