/* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

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

use recursion for small integers
DP to store result and reuse, hence performance boost

Solution : the idea is to calculate the sum for next positions i.e top and right and add the min (top, right) to the position itself
*/

var minPathSum = function(grid) {
	
    const n = grid.length;
    const m = grid[0].length;
    
	// Calculate the distance travelled within the first column
	for(let i=1; i<n; i++) {
        grid[i][0] += grid[i-1][0];
    }
    
	// The same goes for the first row. There is nothing above the 
	// first row. So we just calculate the distance by what is to the left
	// of it
    for(let j=1; j<m; j++) {
        grid[0][j] += grid[0][j-1];
    }
    
	// Start one row and one column in because we've precomputed
	// those above
    for(let i=1; i<n; i++) {
        for(let j=1; j<m; j++) {
			// The distance to the grid at i,j is equal to itself plus the minimum
			// of the two grid spaces (one above, one to the left)
            grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        }
    }
    
	// Return the distance bottom right corner
    return grid[n-1][m-1];
}