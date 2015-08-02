package lint;

import java.util.HashSet;

import junit.framework.TestCase;

public class WordSerch extends TestCase{
	/**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    HashSet<String> used = new HashSet<String>();
                    if (match(board,used, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    boolean match(char[][] board, HashSet<String> used, int i, int j, String word, int idx) {
        if (idx==word.length()){
            return true;
        }
        if (board[i][j]==word.charAt(idx) && idx==word.length()-1) {
            return true;
        }
        if (board[i][j]!=word.charAt(idx)) {
            return false;
        }
        boolean result = false;
        used.add(int2key(i,j));
        idx++;
        if (i>0 && !used.contains(int2key(i-1, j))) {
            result = match(board, used, i-1, j, word, idx);
        }
        if (!result && i<board.length-1 && !used.contains(int2key(i+1, j))){
            result = match(board, used, i+1, j, word, idx);
        }
        if (!result && j>0 && !used.contains(int2key(i,j-1))){
            result = match(board, used, i, j-1, word, idx);
        }
        if (!result && j<board[0].length-1 && !used.contains(int2key(i,j+1))){
            result = match(board, used, i, j+1, word, idx);
        }
        used.remove(int2key(i, j));
        return result;
    }
    
    String int2key(int i, int j) {
        return i+" "+j;
    }

    
    public void testSample() {
    	char[][]board = new char[][]{{'a','b','c'}, {'a','e', 'd'}, {'a','f','g'}};
    	assertTrue(this.exist(board, "abcdefg"));
    }
}
