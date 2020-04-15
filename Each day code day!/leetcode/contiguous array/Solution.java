
/* 

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:

Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:

Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000. 


*/




//idea is simple to leverage the fact that array is binary so diff = 1 - 0 = 0
// to make it more obivious subtract 1 from count and add 1 to the count for 0 & 1 respectively.
// to keep the track of indexes use a map with (count, index) and look for the same key or the same count
//this is where count has become same and hence is the length(i - storedIndex) we need.
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] values = {0,1,0};
        System.out.println(findContiguousArray(values));
    }

    static int findContiguousArray(int[] values){
            int maxLength = 0;
            int sum = 0;
            //sum, index
            Map<Integer, Integer> tracker = new HashMap<>();
            tracker.put(0, -1); // ?? Because zero does not contribute to the sum, we add -1 instead to count zeros within the sum.

            for(int i = 0 ; i < values.length ; i++){
                //maintain the balance by -1 for zero & +1 for ones
                sum+= values[i] == 0 ? -1 : 1;
                
                if(tracker.containsKey(sum)){
                    //update the sum with new index, and global max with diff b/w curr-index and storedindex with the same sum
                    maxLength = Math.max(maxLength, i - tracker.get(sum));
                }else{
                    //add it to the Map
                    tracker.put(sum,i);
                }
            }
        return maxLength;
    }
}