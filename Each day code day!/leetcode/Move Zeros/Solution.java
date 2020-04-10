class Solution {
    public void moveZeroes(int[] nums) {
        
        int i = 0;
        
        for(int j = 0 ; j< nums.length; j++){
            if(nums[j]!=0) nums[i++] =nums[j];
        }
        
        for(int j=i;j<nums.length;j++){
            nums[j] = 0;
        }
    }


public void moveZeroes2(int[] nums) {
    if (nums.length <= 1)
        return;
    int j = 1;
    int i = 0;
    while (j < nums.length) {
        if (nums[i] == 0) {
            if (nums[j] == 0) {
                j++;
            } else {
                nums[i] = nums[j];
                nums[j] = 0;
                j++;
                i++;

            }
        } else {
            i++;
            j++;
        }
    }
}

}