package lint;

import junit.framework.TestCase;

public class Sudoku extends TestCase {

	/**
	 * @param board
	 *            : the board
	 * @return: wether the Sudoku is valid
	 */
	public boolean isValidSudoku(char[][] board) {
		int[][] rules = new int[27][4];
		for (int x1 = 0; x1 < 9; x1++) {
			rules[x1] = new int[] { x1, 0, x1, 8 };
		}
		for (int y1 = 0; y1 < 9; y1++) {
			rules[y1 + 9] = new int[] { 0, y1, 8, y1 };
		}
		int row = 18;
		for (int x1 = 0; x1 < 9; x1 += 3) {
			for (int y1 = 0; y1 < 9; y1 += 3) {
				rules[row++] = new int[] { x1, y1, x1 + 2, y1 + 2 };
			}
		}

		for (int[] rule : rules) {
			if (!nodup(board, rule[0], rule[1], rule[2], rule[3])) {
				return false;
			}
		}
		return true;
	}

	boolean nodup(char[][] board, int x1, int y1, int x2, int y2) {
		int[] values = new int[9];
		for (; x1 <= x2; x1++) {
			for (int y3=y1; y3 <= y2; y3++) {
				if (board[x1][y3] != '.') {
					if (values[board[x1][y3] - '1'] == 1) {
						return false;
					} else {
						values[board[x1][y3] - '1'] = 1;
					}
				}
			}
		}
		return true;
	}
	
	public void testSample() {
		char[][]board = new char[9][9];
		String[]strs = new String[]{"..4...63.",".........","5......9.","...56....","4.3.....1","...7.....","...5.....",".........","........."};
		for(int i=0; i<strs.length; i++) {
			for(int j=0; j<strs[i].length(); j++) {
				board[i][j]=strs[i].charAt(j);
			}
		}
		assertFalse(this.isValidSudoku(board));
		
	}

}
