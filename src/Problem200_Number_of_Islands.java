
public class Problem200_Number_of_Islands {
	int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++)
                if(grid[i][j] == '1'){
                    res++;
                    explore(grid, j, i);
                }
        }
        return res;
    }
    
    public void explore(char[][] grid, int x, int y){
        grid[y][x] = 'x';
        for(int i = 0; i < dx.length; i++){
            if(x+dx[i] >= 0 && x+dx[i] < grid[y].length &&
               y+dy[i] >= 0 && y+dy[i] < grid.length &&
               grid[y+dy[i]][x+dx[i]] == '1')
               explore(grid, x+dx[i], y+dy[i]);
        }
    }
}
