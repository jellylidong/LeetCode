import java.util.*;
public class Problem212_Word_Search_II {
	TrieNode root = new TrieNode();
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board.length == 0)
            return res;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(String s: words){
            addWord(s);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++)
                if(root.children[board[i][j] - 'a'] != null)
                    explore(board, i, j, "", root, visited, res);
        }
        return res;
    }
    
    public class TrieNode{
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];
        TrieNode(){}
    }
    
    private void addWord(String s){
        TrieNode node = root;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }
    public void explore(char[][] board, int i, int j, String word, TrieNode node, boolean[][] visited, List<String> res){
        if(i < 0 || j < 0 || i == board.length || j == board[i].length || visited[i][j])   return;
        if(node.children[board[i][j] - 'a'] == null)    return;
        visited[i][j] = true;
        node = node.children[board[i][j] - 'a'];
        if(node.isWord && !res.contains(word + board[i][j])) 
            res.add(word + board[i][j]);
        explore(board, i+1, j, word+board[i][j], node, visited, res);
        explore(board, i-1, j, word+board[i][j], node, visited, res);
        explore(board, i, j+1, word+board[i][j], node, visited, res);
        explore(board, i, j-1, word+board[i][j], node, visited, res);
        
        visited[i][j] = false;;
         
    }
}
