public class Solution{
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(nums, 4));
    }
    //backtracking
    static boolean canPartitionKSubsets(int[] nums, int k) {
       int total = 0;

       for(int num:nums)
           total+=num;

       if(total % k !=0) 
            return false;
       int target = total/k;
       boolean[] visited = new boolean[nums.length];
       
       return canPartion(nums, 0, 0,target, k, visited);
    }   

    static boolean canPartion(int[] nums, int start, int currentSum, int targetSum, int k, boolean[] visited){

        // base case : means we found k-1 sets, last one doesn't needs to be counted
        if(k == 1)
            return true;

        //performance boost : avoid counting these cases.    
        if(currentSum > targetSum) 
                return false;

        // when a subset is found, we launch another search to find the  remaining subsets from the unvisited elements. 
        if(currentSum == targetSum)
            return canPartion(nums, 0, 0, targetSum, k-1, visited);    
        
        for(int i = start; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
            // launch a search to find other elements that will sum up to the target with the current element.
            if(canPartion(nums, i+1 , currentSum+nums[i], targetSum, k, visited))  
                return true;
        // reset to enable backtracking       
        visited[i] = false;
    }
}     
    return false;   
    }
}