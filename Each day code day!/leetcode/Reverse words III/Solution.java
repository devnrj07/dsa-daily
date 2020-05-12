/* 
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
*/

public class Solution{
    public static void main(String[] args) {
        
    }

    static String reverseWords(String s){
        String words[] = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word: words){
            word = new StringBuilder(word).reverse().toString();
            result.append(word+" ");
        }
        return result.toString().trim();
    }

    //without using helper methods
    /* 
    1. convert string to char[]
    2. if we encounter a space (call reverse function)
    3. repeat till the end
    
    */
    static String reverseword(String s){
        char[] letters = s.toCharArray();
        int i = 0;
        for(int j=0; j<=letters.length;j++){
            if(j == letters.length||letters[j]== ' '){
                reverse(letters, i, j-1);
                i = j+1;
            }
        }
        reverse(letters,i, letters.length);
        return new String(letters);
    }

    static void reverse(char[] chars, int begin, int end){
        while(begin++ < end--){
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;

        }
    }
}