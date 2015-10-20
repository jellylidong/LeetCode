import java.util.*;
public class Problem130_Surrounded_Regions {
	
	//This method works fine, but will cause stack over flow when input has too many 0s
	/*
	int[] di = {0, 0, -1, 1};
    int[] dj = {1, -1, 0, 0};
    public void solve(char[][] board) {
        if(board.length == 0)
            return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length; i++){
            for(int j =0; j < board[0].length; j++){
                if(board[i][j] == 'O' && !visited[i][j])
                    explore(board, visited, i, j, 2);
            }
        }
    }
    
    public boolean explore(char[][] board, boolean[][] visited, int i, int j, int dir){
        // if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
        //     return false;
        if(board[i][j] == 'X')
            return true;
        visited[i][j] = true;
        boolean res = true;
        for(int k = 0; k < 4; k++){
           {
                if(!(i+di[k] < 0 || i+di[k] >= board.length || j+dj[k] < 0 || j+dj[k] >= board[0].length)){
                    if(!visited[i+di[k]][j+dj[k]]){
                        res = res && explore(board, visited, i+di[k], j+dj[k], k);
                    }
                }
                else
                    res = false;
            }
            if(!res)
                break;
        }
        if(res){
            board[i][j] = 'X';
            //System.out.println(board[i][j]);
        }
        return res;
    }*/
	
	public void solve(char[][] board) {
        if(board == null || board.length == 0)
            return;
        for(int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O')
                mark(board, 0, i);
            if(board[board.length-1][i] == 'O')
                mark(board, board.length-1, i);
        }
        
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O')
                mark(board, i, 0);
            if(board[i][board[0].length-1] == 'O')
                mark(board, i, board[0].length-1);
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'U')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
    
    public void mark(char[][] board, int i, int j){
        int[] di = {0, 0, -1, 1};
        int[] dj = {-1, 1, 0, 0};
        Stack<point> s = new Stack<>();
        s.push(new point(i, j));
        while(!s.empty()){
            point tmp = s.pop();
            int ii = tmp.i;
            int jj = tmp.j;
            board[ii][jj] = 'U';
            for(int k = 0; k < 4; k++){
                if( ii+di[k] >= 0 && ii+di[k] < board.length && 
                    jj+dj[k] >= 0 && jj+dj[k] < board[0].length &&
                    board[ii+di[k]][jj+dj[k]] == 'O'
                    ){
                        s.push(new point(ii+di[k], jj+dj[k]));
                    }
            }
        }
    }
    
    public class point{
        int i;
        int j;
        point(int ii, int jj){
            i = ii;
            j = jj;
        }
    }
}
