package backtracking;

//T.C :-O(9^(n^2)), for each cell in the n^2 board, we have 9 possible numbers
class Solution1 {

	public void solveSudoku(char[][] board) {
		helper(board);
	}

	boolean helper(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == '.') {
					for (int val = 1; val <= 9; val++) {
						if (isSafe(row, col, (char) (val + '0'), board)) {
							char c = (char) (val + '0');
							board[row][col] = c;
							if (helper(board))
								return true;
							else {
								board[row][col] = '.';
							}
						}
					}
					// if we reached here means we tried all value from 1 to 9 at that cell but no
					// one satisfying the all the three conditions it means current
					// state of board is wrong we have to backtrack to change it's previous state so
					// return false
					// that mean temp will store false and it goes to backtracking step
					return false;
				}
			}
		}
		// if we reached here means our board if filled return true
		return true;
	}

	boolean isSafe(int row, int col, char val, char[][] board) {
		for (int i = 0; i < board.length; i++) {
			// check row
			if (board[row][i] == val)
				return false;

			// check column
			if (board[i][col] == val)
				return false;

			// check 3*3 matrix
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val)
				return false;
		}
		return true;
	}
}

public class SudukoSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
