package BinarySearch;

public class FindThePeakElementInA2DMatrix {

	public int[] findPeakGrid1(int[][] mat) {
		int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[0].length; c++) {
				boolean isGreater = true;
				for (int[] dir : directions) {
					int row = r + dir[0];
					int col = c + dir[1];
					if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length)
						continue;
					if (mat[r][c] <= mat[row][col])
						isGreater = false;
				}
				if (isGreater)
					return new int[] { r, c };
			}
		}
		return new int[] { -1, -1 };
	}

	public int[] findPeakGrid(int[][] mat) {
		int low = 0;
		int high = mat[0].length - 1;
		int rows = mat.length;
		while (low <= high) {
			int midColumnIndex = low + (high - low) / 2;
			// step1 find the maxRow which is the midColumn which is having maxElement
			int maxRowIndex = 0;
			for (int i = 0; i < rows; i++) {
				maxRowIndex = (mat[i][midColumnIndex] > mat[maxRowIndex][midColumnIndex]) ? i : maxRowIndex;
			}
			// Now we have mat[maxRowIndex][midColumnIndex] it means in a column+row, we
			// pick on number, so top and bottom sorted
			// Step2: think about left and right
			boolean isLeftHigh = (midColumnIndex - 1 >= 0)
					&& (mat[maxRowIndex][midColumnIndex] < mat[maxRowIndex][midColumnIndex - 1]);

			boolean isRightHigh = (midColumnIndex + 1 < mat[0].length)
					&& (mat[maxRowIndex][midColumnIndex] < mat[maxRowIndex][midColumnIndex + 1]);

			if (!isLeftHigh && !isRightHigh) {
				return new int[] { maxRowIndex, midColumnIndex };
			} else if (isLeftHigh) {
				high = midColumnIndex - 1;
			} else {
				low = midColumnIndex + 1;
			}

		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
