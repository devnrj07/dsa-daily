import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
] */

//solution : the idea is to create a unique key for every anagram string abc-> 1a1b1c & bca->1a1b1c, then use it as Map<key, []>


public class Solution{
    public static void main(String[] args) {
        
    }

    static List<String> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs){
            String key = hash(s);

            if(!map.containsKey(key)) map.put(key,new  ArrayList<>());
            
            map.get(key).add(s); // get the value and add string to it
        }
        return new ArrayList<>(map.values());
    }

    static String hash(String str){

        int[] hashArray = new int[26];
        for(char s : str.toCharArray()){
            hashArray[s-'a']++; // -a becuase range should be 0 to 25
        }
        System.out.println(hashArray);

return Arrays.toString(hashArray);
    }
}

