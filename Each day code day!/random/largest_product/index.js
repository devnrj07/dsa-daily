/* 

You are given an array of integers. Return the largest product that can be made by multiplying any 3 integers in the array.

Example:

[-4, -4, 2, 8] should return 128 as the largest product can be made by multiplying -4 * -4 * 8 = 128.

*/



//O(nlogn) O(1)
const findLargestProduct = (nums) =>{

    nums.sort((a,b) => b - a);
    let product1 = 1; //product of top three
    let product2 = 1;//for handling -ve case
    let count = 0;
    nums.forEach(x =>{
        if(count < 3 && x !=0){
            product1*=x;
            count++;
            console.log("product :", product1, "count :", count);
        }
    })

    product2*=nums[0] * nums[nums.length-2] * nums[nums.length-1];
    console.log(product2);
    
    
    return Math.max(product1,product2);
}


//O(n) O(1) instead of sort find max, 2ndmax, 3rdmax, min, 2ndmin and do the same thing as above p1(max,2max,3max) p2(max,min,2min) max(p1,p2)


const findLargestProductInOn = (nums) =>{
    let firstMax = -1000, secondMax = -1000, thirdMax = -1000, firstMin = 1000, secondMin = 1000;
    let productOne = 1, productTwo = 1;
    for(let i = 0; i < nums.length ; i++){
        
        // Update Maximum, second maximum and third 
        // maximum element 
        if (nums[i] > firstMax) { 
            thirdMax = secondMax; 
            secondMax = firstMax; 
            firstMax = nums[i]; 
            // Update second maximum and third maximum element
        } else if( nums[i] > secondMax){
            thirdMax = secondMax;
            secondMax = nums[i];
            // Update third maximum element 
        }else if(nums[i > thirdMax]){
            thirdMax = nums[i];
        }

        if(nums[i] < firstMin){
            secondMin = firstMin;
            firstMin = nums[i];
        }else if(nums[i] < secondMin){
            secondMin = nums[i];
        }


        
    }

    console.log("firstMax :", firstMax, "secondMax :", secondMax, "thirdMax :", thirdMax, "firstMin", firstMin, "secondMin :", secondMin);
    
    productOne *= firstMax*secondMax*thirdMax;
    productTwo *= firstMax*firstMin*secondMin;
    console.log("1 :", productOne, " 2:", productTwo)
    return Math.max(productOne, productTwo);
}

findLargestProductInOn([-10, -3, 5, 6, -20]);
//findLargestProduct([-4, -4, 2, 8]);
//findLargestProduct([-10, -3, 5, 6, -20]);