public class Solution{

    public static void main(String[] args) {
       

        int[][] ={1,1,1,1,0,
            1,1,0,1,0,
            1,1,0,0,0,
            0,0,0,0,0};
        findIslands(grid);
    }


    //the idea is simple : loop each column of each row and look for '1', then mark it as visited and look for more `1` in two direction.
    /*
    
    1. Start at the top left of the 2d array, and visit the first row, and all its columns, trying to find the start of the first island
    2. Once we find a 1, we can increment the number of islands, but we want to know where the island ends. So let’s look and follow any of the horizontal or vertical spots near the current position we are on.
    3. First, let’s mark the current start/visited parts of the islands as visited by turning them into a 0,
    4. Second, explore all the adjacent possibilities,
    5. If one of them is a 1, recursively turn it into a 0 and check its children
    6. Once we are done, we should have gotten rid of the island that we discovered and can move on to the next island, if it exists in the 2d array

    */
    
    
    
    public int numIslands(char[][] grid) {
        int count = 0;
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               if (grid[i][j] != '0') {
                   count++;
                   shrink(grid, i, j);
               }
           }
       }
       return count;
   }
   
   void shrink(char[][] grid, int i, int j) {
       if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
           return;
       grid[i][j] = '0';
       shrink(grid, i, j+1);
       shrink(grid, i, j-1);
       shrink(grid, i+1, j);
       shrink(grid, i-1, j);
   }
}