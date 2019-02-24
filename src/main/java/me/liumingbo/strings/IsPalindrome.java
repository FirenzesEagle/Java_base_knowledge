package me.liumingbo.strings;

public class IsPalindrome {
    public boolean isPalindrome (String str) {
        if (str.length() == 0) {
            return true;
        }
        int head = 0, tail = str.length() - 1;
        while (head < tail) {
            if (!Character.isLetterOrDigit(str.charAt(head))) {
                head ++;
            }
            if (!Character.isLetterOrDigit(str.charAt(tail))) {
                tail --;
            } else {
                if (Character.toLowerCase(str.charAt(head)) != Character.toLowerCase(str.charAt(tail))) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}
