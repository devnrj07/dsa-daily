const numberOfIslands = function(grid){
    const n = grid.length;
    const m = grid[n].length;
    const count = 0;
    for(let i = 0 ; i<n;i++){
        for(let j=0; j< m; j++){
            if(grid[i][j] === '1'){
                explore(i,j,grid)
                count++;
            }

        }
    }
    return count;
}

const explore = (row, column, grid) =>{
    //break condition
    if (grid[x][y] === '1') {
        grid[x][y] = '0';
    } else {
        return;
    }

    //condition to move up
    if(row < grid.length - 1){
        explore(row+1, column, grid);
    }

    if(column < grid[row].length){
        explore(row, column+1, grid)
    }

    if (row > 0 && row < grid.length) {
        explore(row-1, column,grid);
    }
    
    if (column > 0 && column < grid[row].length) {
        explore(row, column-1, grid);
    }

}