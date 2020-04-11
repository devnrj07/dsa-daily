class Solution {
    public int findMin(int[] nums) {
        int left = 0 , right = nums.length -1;
        
        while(left<right){
            
            if(nums[left] < nums[right]) return nums[left];
            
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid]< nums[right]){
                right = mid;
            }else{ // when arr[mid] == arr[right], skip it
                right--;
            }
        }
        return nums[left];
    }


	public int findMax(int[] nums){

	int left = 0 , right = nums.length - 1;
	
while(left < right){

	//base condition for a binary search
	if(nums[left] < nums[right]) return nums[right];
	
	int mid = left + (right - left)/2;

	if(nums[mid] > nums[right])  right = mid;
	else if(nums[mid] < nums[right]) left++;
	else right--;

}
return nums[right];
}

}