/* 
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

*/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        // dp strategy, look for bottom right element of square as min(top left, top right, bottom left) + 1
        if(matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row+1][col+1]; // same as original matrix
        
        int maxEdge = 0;
        //start from '1'
        for(int i = 1; i <=row; i++){
            for(int j = 1; j <= col; j++){
                //bottom right is one
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    maxEdge = Math.max(maxEdge,dp[i][j]);
                }
            }
        }
        return maxEdge * maxEdge;
    }
}