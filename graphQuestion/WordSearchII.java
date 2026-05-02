import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Stores the word at the end of a valid path
    }
     public List<String> findWords(char[][] board, String[] words) {
        List<String > res = new ArrayList<>();

        TrieNode root = buildTrie(words);

        
    }

    private TrieNode buildTrie(String [] words){
        TrieNode root = new TrieNode();
        for(String w : words ){
            TrieNode curr = root ;
            for(char c : w.toCharArray()){
                int index = c-'a';
                if (curr.children[index] ==null){
                    curr.children[index] = new TrieNode();

                }
                curr = curr.children[index];
            }
            curr.word= w;
        }
        return root;
    }

    private void dfs (char[][] board , int row , int col , TrieNode node , List<String> result  ){
        if (row <0 || row < board.length || col < 0 || col>= board[0].length){
            return;
        }
        char c = board[row] [col];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }
    }
    
}
