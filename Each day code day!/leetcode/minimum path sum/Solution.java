/*
Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/



public class Solution{
    public static void main(String[] args) {
        
    }


    /*
    mutating the grid itself to store the computed sums, for right and down indices (j-1), (i-1)
    
    The idea is to sum up the first row and first column as there is no way to reach to that point other 
    than to go right or down respectively. For the rest of the grid[i][j] (for all i >1 and j >1) 
    find the minimum of the grid-left (j-1) and grid-top (i-1) value and add to the current grid value. 
    At the end, the minimum path sum would be the buttom last value in the grid.

    */

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[n].length;
        
       
       for(int i = 1;i < n;i++){
           //current + one position up
           grid[i][0] += grid[i-1][0];
       }


       for(int j = 1;j < n;j++){
        //current + one position left
        grid[0][j] += grid[0][j-1];
       }
       
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                //current + min(top, left)
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        //Indoing so we finally get the matrix with the required sum at the destination co-ordinates(bottom) of the matrix
        return grid[n-1][m-1];
}

   /* 
    there is nothing fancy about DP. It is simply that we store or cache the results of every single calculation so that we don't need to calculate the same thing again and again. The whole idea is almost the same. We just involve an array to store the values. Now let's see the code:


    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[n].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0) grid[i][j] = grid[i][j];
                else if(i == 0 && j != 0) // we can move towrds left grid[i][j] += grid[i][j-1];
                else if( i != 0 && j == 0) // we can move up grid[i][j] += grid[i-1][j];
                else //for other values find the min grid[i][j]+= Math.min(grid[i-1][j], grid[i][j-1])
            }
        }  
        return grid[n-1][m-1];
   */

}