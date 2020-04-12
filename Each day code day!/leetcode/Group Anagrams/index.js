/* 
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]   

O(nlogn) - not optimal
*/

const groupAnagrams = (strs)=>{
    //to store sorted strings as key and actual string as value
    let map = {};

    for( let str of strs){
        //all anagram strings can form a same key if arranged in a certain way
        const key = [...str].sort();

        if(!map[key]) map[key] =[];
        //same key add the string
        else map[key].push(str);
    }

    return Object.values(map);
}