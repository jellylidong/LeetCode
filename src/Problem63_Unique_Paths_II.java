
public class Problem63_Unique_Paths_II {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col = obstacleGrid[0].length;
        int row = obstacleGrid.length;
        if(row == 1){
            for(int i = 0; i < col; i++)
                if(obstacleGrid[0][i] == 1)
                    return 0;
            return 1;
        }
        
        if(col == 1){
            for(int i = 0; i < row; i++)
                if(obstacleGrid[i][0] == 1)
                    return 0;
            return 1;
        }
        int[][] res = new int[row+1][col+1];
        res[1][1] = 1;
        //int obX = Integer.MAX_VALUE, obY = Integer.MAX_VALUE;
        for(int i = 1; i < row+1; i++){
            for(int j = 1; j < col+1; j++){
                
                if(i == 1 || j == 1){
                    //obX = i;
                    //obY = j;
                    res[i][j] = 1;
                }
                if(obstacleGrid[i-1][j-1] == 1)
                    res[i][j] = 0;
                else if(i != 1 || j != 1)
                    res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[row][col];
    }
}
