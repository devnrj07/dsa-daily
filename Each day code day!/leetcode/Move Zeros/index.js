/* 
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.



*/

var moveZeroes = function(nums) {
    let i = 0; //keep the track of position from where we need to insert zeros
     
 for(let j = 0; j < nums.length ; j++){
     
     //if its zero we don't care, if its not replace it with the position `i` and increment i++
     if(nums[j]!==0) nums[i++] = nums[j];
 }
 
 //stat adding zeros at the end from updated position `i`
 for( let j = i ; j < nums.length ; j++){
     nums[j] = 0;
 }
 
 
};