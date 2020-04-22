/* 

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.

Note:

Your solution should be in logarithmic complexity.



*/

class Solution {
    //iterative
    public int findPeakElement(int[] nums) {
              
        //return search(nums, 0, nums.length - 1);
    
        
        //index out of bound       
        int l = 0, r = nums.length -1;
        
        while(l < r){
            int mid = l + (r - l)/2;
            //using the concept of slopes, mid > mid+1, down slope i.e peak element must be on the left of the mid
            if(nums[mid] > nums[mid+1]){
                r = mid;
            }else{
                //if the mid < mid+1, up slow(ascending) peak is to the right of the mid
                l = mid+1;
            }
        }
        return l;
  }


// recursive
public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
}