/* '''
Witness of The Tall People
Hi, here's your problem today. This problem was recently asked by Google:
There are n people lined up, and each have a height represented as an integer. A murder has happened right in front of them, and only people who are taller than everyone in front of them are able to see what has happened. How many witnesses are there?
Example:
Input: [3, 6, 3, 4, 1]  
Output: 3
Explanation: Only [6, 4, 1] were able to see in front of them.
 #
 #
 # #
####
####
#####
36341                                 x (murder scene) */

const findWitnesses = (height) =>{
    
//last one always sees it.    
let witnessCount = 1;
let witnesses = [];

for(let i = 0 ; i < height.length -1;i++){
    if(height[i+1]-height[i] >=1){
        witnesses.push(height[i+1]);
        witnessCount++;
    }

}

console.log(witnessCount);
return height.length > 0 ? witnessCount: 0;
}

module.exports = findWitnesses;


//use jest to run test cases `jest test.js`
//findWitnesses([3, 6, 3, 4, 1]) //3
//findWitnesses([3, 4, 4, 4, 1]) // 2
//findWitnesses([-1, -3, -7, -2]) //2