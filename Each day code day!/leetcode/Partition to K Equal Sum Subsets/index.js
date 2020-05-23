var canPartitionKSubsets = function(nums, k) {
    
    const total = nums.reduce((sum,num) => sum +num,0)
    
    if(total % k != 0)
            return false;
    
    const targetSum = total /k;
    const visited = new Array(nums.length).fill(false);
    const canPartion = (startIndex, currentSum, subsets) =>{
        if(subsets === 1)
            return true;
        if(currentSum > targetSum)
            return false;
        
        if(currentSum === targetSum)
            return canPartion(0,0,subsets-1)
        
        for(let i = 0; i < nums.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                
                if(canPartion(i+1, currentSum+nums[i], subsets))
                    return true
                
              visited[i] = false;  
            }
        }
        return false;
    }
    
    return canPartion(0,0,k)
};  