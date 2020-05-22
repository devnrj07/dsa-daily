/*
Array with Duplicates       : [1, 1, 2, 2, 3, 4, 5]
After removing duplicates   : [1, 0, 2, 0, 3, 4, 5]

Array with Duplicates       : [1, 1, 1, 1, 1, 1, 1]
After removing duplicates   : [1, 0, 0, 0, 0, 0, 0]

Array with Duplicates       : [1, 2, 3, 4, 5, 6, 7]
After removing duplicates   : [1, 2, 3, 4, 5, 6, 7]

Array with Duplicates       : [1, 2, 1, 1, 1, 1, 1]
After removing duplicates   : [1, 0, 0, 0, 0, 0, 2]


*/
import java.util.HashMap;
import java.util.Map;

public class Solution{
    public static void main(String[] args) {
       int[] temp1 = {1, 1, 2, 2, 3, 4, 5};
       int[] temp2 = {1, 1, 1, 1, 1, 1, 1};
       int[] temp3 = {1, 2, 1, 1, 1, 1, 1};
       int[] temp4 = {1, 2, 3, 4, 5, 6, 7};
       replaceDuplicates(temp1);
       replaceDuplicates(temp2);
       replaceDuplicates(temp3);
       replaceDuplicates(temp4);
        for(int i: temp1)
            System.out.println(i);
        for(int i : temp2)
            System.out.println(i);
        for(int i : temp3)
            System.out.println(i);
        for(int i : temp4)
            System.out.println(i);
 
    }

    static int[] replaceDuplicates(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int length = arr.length;
        for(int i = 0; i < length; i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i],1);
            else    
                arr[i] = 0;    
        }
        return arr;
    }
}