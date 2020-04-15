const findContiguousArray = (nums)=>{

    let globalMax = 0
    let localMax = 0
    let sumIndex = {0: -1}; //because we care about zero sum
    for(let i = 0 ;  i < nums.length ; i++){
        localMax+= nums[i] === 0 ? -1 : 1;

        if(sumIndex[localMax]!=null){
            globalMax = Math.max(globalMax, i - sumIndex[localMax])
        }else{
            sumIndex[localMax] = i ;
        }
    }
    return globalMax;
}