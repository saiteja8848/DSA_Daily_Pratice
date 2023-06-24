package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	List<List<String>> lists;

	public List<List<String>> solveNQueens(int n) {
		lists = new ArrayList<>();

		char[][] matrix = new char[n][n];
		for (char[] array : matrix)
			Arrays.fill(array, '.');

		recursion(0, n, matrix);
		return lists;
	}

	void recursion(int row, int n, char[][] matrix) {
		// Add to the solution - it means we found one solution successfully
		if (row == n) {
			List<String> list = new ArrayList<>();
			for (char[] array : matrix)
				list.add(String.valueOf(array));
			lists.add(list);
			return;
		}
		for (int col = 0; col < n; col++) {
			if (isValid(row, col, n, matrix)) {
				matrix[row][col] = 'Q';
				// proceed further
				recursion(row + 1, n, matrix);
				// backtrack
				matrix[row][col] = '.';
			}
		}
	}

	boolean isValid(int row, int col, int n, char[][] matrix) {
		// checking row wise - column is constant
		for (int i = 0; i < row; i++) {
			if (matrix[i][col] == 'Q')
				return false;
		}

		// checking column wise - row is constant
		for (int i = 0; i < col; i++) {
			if (matrix[row][i] == 'Q')
				return false;
		}

		// checking diagonally
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (matrix[i][j] == 'Q')
				return false;
		}

		for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
			if (matrix[i][j] == 'Q')
				return false;
		}

		return true;
	}
}

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
