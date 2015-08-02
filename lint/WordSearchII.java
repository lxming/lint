package lint;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class WordSearchII extends TestCase {
	public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        Node trie = buildTrie(board);
        ArrayList<String> result = new ArrayList<String>();
        for(String s: words) {
            if (search(trie, s)) {
                result.add(s);
            }
        }
        return result;
    }
    
    boolean search(Node root, String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            if (curr.next[word.charAt(i)]!=null) {
                curr = curr.next[word.charAt(i)];
            }
            else {
                return false;
            }
        }
        return true;
    }
    
    Node buildTrie(char[][] board) {
        Node root = new Node(' ');
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                buildTrie(board, i, j, root);
            }
        }
        return root;
    }
    
    void buildTrie(char[][]board, int i, int j, Node parent) {
        if (i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='*') {
            return;
        }
        char c = board[i][j];
        Node curr =parent.next[c];
        if (curr==null){
            curr = new Node(c);
            parent.next[c] = curr;
        }
        board[i][j]='*';
        buildTrie(board, i-1, j, curr);
        buildTrie(board, i+1, j, curr);
        buildTrie(board, i, j-1, curr);
        buildTrie(board, i, j+1, curr);
        board[i][j]=c;
        
    }
    
    public void testSample() {
    	char[][]board = new char[][] {
    			{'a','b'},
    			{'c','d'}
    	};
    	assertEquals(2, this.wordSearchII(board, new ArrayList<String>(Arrays.asList("abdc", "ab", "abcd"))));
    }
    
    
}

class Node{
    char c;
    Node[] next; 
    Node(char c) {this.c = c;  next= new Node[256]; }
}
