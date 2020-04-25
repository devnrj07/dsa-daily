import java.util.Map;
import java.util.HashMap;

/* Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2

Note:

    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

Explaination : just like two sum problem use map to store SUM[0...J], and SUM[0,i-1] now, K = SUM[0...J] - SUM[0...i]

Our HashMap tells us SUM[0...i]. Our current sum gives us SUM[0...j]. 
So subtraction gives us SUM[0...j] - SUM[0...i] = SUM[i...j]. Each SUM[i...j] == k gives us 1 solution.

    */

public class Solution{
    public static void main(String[] args) {
        
    }

    public static int subarraySum(int[] nums, int k) {
        //Define a map: key is the prefix sum and value is number of times of the key.
        Map<Integer,Integer> presum = new HashMap<Integer, Integer>();
        int currSum = 0;
        int result = 0;
        // for sum == 0
        presum.put(0,1);

        for(int n : nums){
            currSum += n;
            //look for the key == currSum - targetSum(k)
            /*For every sum encountered, we need determine the number of times the sum sum-k 
            has occured already, since it will determine the number of times a subarray with sum k has occured upto the current index.
            */
            result += presum.getOrDefault(currSum-k,0);
            presum.put(currSum, presum.getOrDefault(currSum,0)+1);
        }
        return result;
    }


}