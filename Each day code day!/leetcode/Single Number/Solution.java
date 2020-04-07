/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

public class Solution {
    public static  int singleNumber(int[] nums) {
        int oddNum=nums[0];
        
        for(int i=1;i<nums.length;i++ ){
            oddNum ^=nums[i];
        }
        return oddNum;
    }


	public static void main(string args[]){

	singleNumber([2,3,4,1,4,3,2]);
	}
}