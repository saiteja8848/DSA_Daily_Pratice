package BinarySearch;

public class SearchInA2DMatrix_I {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix[0][0] == target)
			return true;

		int n = matrix.length;
		int m = matrix[0].length;

		int crow = 0;
		int ccol = m - 1;
		while (crow <= n - 1 && ccol >= 0) {
			int temp = matrix[crow][ccol];
			if (temp == target)
				return true;
			if (temp > target)
				ccol--;
			else
				crow++;
		}
		return false;
	}

	public boolean searchMatrix2(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		int left = 0;
		int right = m * n - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int row = mid / n;
			int col = mid % n;
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
