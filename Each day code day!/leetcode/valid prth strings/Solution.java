//iterate from both end left-to-right, then 📲 //  we just need to record the number of '(', ')' and wildcard to see if wildcard can be '(' or ')'

public class Solution{

    public static void main(String[] args) {
        checkValidString("(((()))))***");
    }

    public static boolean checkFromLeft(String s) {
        int star = 0, open = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                close++;
            } else {
                star++;
            }
            if (close > open + star) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkFromRight(String s) {
        int star = 0, open = 0, close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                open++;
            } else if (c == '(') {
                close++;
            } else {
                star++;
            }
            if (close > open + star) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;
        return checkFromLeft(s) && checkFromRight(s);
    }
}