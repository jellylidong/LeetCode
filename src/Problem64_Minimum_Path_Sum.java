
public class Problem64_Minimum_Path_Sum {
	public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int vol = grid[0].length;
        int[][] minPath = new int[row+1][vol+1];
        //minPath[1][1] = grid[0][0];
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= vol; j++){
                if(i-1 == 0 && j-1 != 0){
                	minPath[i-1][j] = Integer.MAX_VALUE;
                	//minPath[i][j-1] = Integer.MAX_VALUE;
                }
                if(i-1 != 0 && j-1 == 0){
                	//minPath[i-1][j] = Integer.MAX_VALUE;
                	minPath[i][j-1] = Integer.MAX_VALUE;
                }
                
                minPath[i][j] = grid[i-1][j-1] + Math.min(minPath[i-1][j], minPath[i][j-1]);
                System.out.println(i + " "+ j + ": " + minPath[i][j]);
            }
        }
        return minPath[row][vol];
    }
	
	public static void main(String[] args){
		int[][] grid = {{1,2},{1,1}};
		//int[][] grid;
		System.out.print(minPathSum(grid));
	}
}
