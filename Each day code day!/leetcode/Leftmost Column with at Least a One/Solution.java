




/*
A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

    BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
    BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.

Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.


*/



/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */
// simple upgradation from brute force, instead of visiting every element from left to right,
//traverse from right and look for first `0` instead then after row ends instead of starting from the end of a row, how about starting from the index from the previous row where 1 occurred. 
//This works since in the question we're given that ow is sorted in ascending order
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
       List<Integer> list = binaryMatrix.dimensions();
        int row = list.get(0);
        int col = list.get(1);
        int index = -1;
       //start from right column and note the index where you see '1', otherwise move to next row
        for(int r=0,c=col-1;r<row && c>=0;){
            if(binaryMatrix.get(r,c) == 1){
                    index = c;
                    c--;
                }else{
                     r++;
                }
            }
  return index;
    }
}

// Binary Search solution
//same logic find first zero from right
/* 
1. start by setting leftptr = 0 for each row
2. set right pointer either to max row length or to the index where you saw 1 for the previous row.
3. start searching using binary searching
4. Now look for mid == 1, when found move rightptr(store that index) else move leftptr (the idea is to narrow the search range until left & right point to the same 1)
5. set the new index accordingly and continue. 

*/
class BinarySearch{
    public int leftMostColumnWithOne(int[] binaryMatrix) {

            int m = binaryMatrix.length;
            int n = binaryMatrix[0].length; 
            int row  = 0, col =0; //indexes
            int left = 0, right= n; //ptrs
            //iterate row
            while(row < m){
                
                    while(left < right){
                        int mid = left + (right - left)/2;
                        if(binaryMatrix[mid] == 1){
                            right = mid;
                        }else{
                            left = mid +1;
                        }
                    }
                    col = left; //index where 1 occured
                    row++;
            }
            return col == n ? -1 : col;
}
}