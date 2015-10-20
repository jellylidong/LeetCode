
public class Problem37_Sudoku_Solver {
	char[][] b;
    public void solveSudoku(char[][] board) {
        
        b = board;
        if(b == null || b.length == 0)
            return;
        solve(0);
    }
    
    public boolean solve(int n){
        if(n == 81)
            return true;
        int i = n/9;
        int j = n%9;
        if(b[i][j] != '.') return solve(n+1);
        else{
            for(char c = '1'; c <= '9'; c++){
                
                if(valid(i, j, c)){
                    b[i][j] = c;
                    if(solve(n+1))
                        return true;
                    else
                        b[i][j] = '.';
                }
            }
            return false;
        }
    }
    
    public boolean valid(int i, int j, char c){
        for(int k = 0; k < 9; k++){
            if(b[i][k] == c)
                return false;
            if(b[k][j] == c)
                return false;
            int r = i/3*3 + j/3;
            if(b[r/3*3+k/3][r%3*3+k%3] == c)
                return false;
        }
        return true;
    }
}
