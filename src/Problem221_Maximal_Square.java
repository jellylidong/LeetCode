

public class Problem221_Maximal_Square {
	public int maximalSquare(char[][] m) {
        if(m.length == 0 || m[0].length == 0)
            return 0;
        int y = m.length;
        int x = m[0].length;
        int max = 0;
        
        int[][] res = new int[y][x];
        for(int i = 0; i < y; i++){
            res[i][0] = m[i][0] - 48;
            max = Math.max(max, res[i][0]);
        }
        for(int i = 0; i < x; i++){
            res[0][i] = m[0][i] - 48;
            max = Math.max(max, res[0][i]);
        }
        
        
        
        for(int i = 1; i < y; i++){
            for(int j = 1; j < x; j++){
                if(m[i][j] == '1'){
                    res[i][j] = Math.min(res[i-1][j], Math.min(res[i-1][j-1], res[i][j-1])) + 1;
                    max = Math.max(max, res[i][j]);
                }
            }
        }
        return max*max;
    }
}
