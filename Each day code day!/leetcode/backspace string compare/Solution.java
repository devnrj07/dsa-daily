public class Solution{
    public static void main(String[] args) {
        
    }

    static boolean compareTwoStrings(String one, String two){

        int s = S.length() - 1, t = T.length() - 1;

        // start to compare string from the end
        while (s >= 0 && t >= 0) {
            s = nextNonSkipChar(S, s);
            t = nextNonSkipChar(T, t);

            // in case any of two string is already exhausted
            if (s < 0 || t < 0) break;
            // compare two characters
            if (S.charAt(s--) != T.charAt(t--)) return false;
        }

        // if any of two string is not exhausted yet,
        // check to see if it can be exhausted
        if (s >= 0) s = nextNonSkipChar(S, s);
        if (t >= 0) t = nextNonSkipChar(T, t);

        // check two see if both string has been exhausted
        return s < 0 && t < 0;
    }

    /*
    helper method to find the next unskippable character in the string and return
    its index. Return -1 if the string is exhausted.
     */
    private int nextNonSkipChar(String str, int s) {
        int skip = 0;
        while (s >= 0) {
            // if current char is #, we need to skip next character
            if (str.charAt(s) == '#') {
                skip++;
                s--;
            }
            // if current character is not #, but we still have some characters
            // need to be skipped
            else if (skip > 0) {
                skip--;
                s--;
            }
            // in case this is the character we cannot skip
            else break;
        }
        return s;
    }
}

// another cool solution using stringbuilder same as stack solution
/* 

 public boolean backspaceCompare(String S, String T) {
        String s = getString(S);
        String t = getString(T);
        return s.equals(t);
    }
    
    private String getString(String s) {
        StringBuilder str = new StringBuilder();
        char[] c = s.toCharArray();
        for (char ch : c) {
            if (ch == '#') {
                if ( str.length() != 0) {
                    str.deleteCharAt(str.length() - 1);
                }
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }




*/