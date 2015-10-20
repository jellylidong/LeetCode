import java.util.*;
public class Problem36_Valid_Sudoku {
	 public static boolean isValidSudoku(char[][] board) {
	        List<HashSet<Character>> row = new ArrayList<HashSet<Character>>();
	        List<HashSet<Character>> col = new ArrayList<HashSet<Character>>();
	        List<HashSet<Character>> sub = new ArrayList<HashSet<Character>>();
	        int width = board[0].length;
	        //int height = board.length;
	        for(int i = 0; i < board.length; i++){
	        	for(int j = 0; j < board[i].length; j++){
	        		if(i == row.size())
	        			row.add(new HashSet<Character>());
	        		if(j == col.size())
	        			col.add(new HashSet<Character>());
	        		if(width/3 * (i/3) + j/3 == sub.size())
	        			sub.add(new HashSet<Character>());
	        		char c = board[i][j];
	        		if(c != '.'){
	        			if(!row.get(i).contains(c))
	        				row.get(i).add(c);
	        			else{ 
	        				System.out.println("row "+i+" "+j);
	        				return false;
	        			}
	        			if(!col.get(j).contains(c))
	        				col.get(j).add(c);
	        			else{ 
	        				System.out.println("col "+i+" "+j);
	        				return false;
	        			}
	        			if(!sub.get(width/3 * (i/3) + j/3).contains(c))
	        				sub.get(width/3 * (i/3) + j/3).add(c);
	        			else{ 
	        				System.out.println("sub "+i+" "+j);
	        				return false;
	        			}
	        		}		
	        	}
	        }
	        return true;
	    }
	 
	 public static void main(String[] args){
		 String[] test = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		 char[][] board = tools.transStrToChar(test);
		 System.out.print(isValidSudoku(board));
 	 }
}
