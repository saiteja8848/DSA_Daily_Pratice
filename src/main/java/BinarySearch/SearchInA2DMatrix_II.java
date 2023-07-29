package BinarySearch;

public class SearchInA2DMatrix_II {

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int row = 0, col = matrix[0].length - 1;
		while (row != matrix.length && col != matrix[0].length && row >= 0 && col >= 0) {
			if (matrix[row][col] == target)
				return true;
			else if (matrix[row][col] > target)
				col--;
			else
				row++;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
