class Solution {
    public boolean canJump(int[] nums) {
        //sounds dumb but we actually don't have to find the indexes just the possibility
        // and possibility becomes zero when curr_index > max_jump
        
        //the loop will fail once it can't reach max
        int max_jump = 0;
        for(int i = 0; i < nums.length;i++){
            if(i > max_jump)return false;
            
            if(nums[i]+i> max_jump){
                 max_jump = nums[i]+i;   
            }
        }
        return true;
    }
}