package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixMedian {

	int median(int matrix[][], int R, int C) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				list.add(matrix[i][j]);
			}
		}

		Collections.sort(list);
		int mid = list.size() / 2;
		int median;
		if (list.size() % 2 == 0) {
			median = (list.get(mid - 1) + list.get(mid)) / 2;
		} else {
			median = list.get(mid);
		}

		return median;

	}

	int median_binarySearch(int matrix[][], int R, int C) {
		// code here
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < R; i++) {
			if (matrix[i][0] < min)
				min = matrix[i][0];

			if (matrix[i][C - 1] > max)
				max = matrix[i][C - 1];
		}

		int desired = (R * C + 1) / 2;
		while (min <= max) {
			int mid = min + (max - min) / 2;
			int place = 0;

			for (int i = 0; i < R; ++i) {
				int l = 0, col = C - 1;
				while (l < col) {
					int m = (l + col) / 2;
					if (matrix[i][m] <= mid) {
						l = m + 1;
					} else {
						col = m;
					}
				}
				if (matrix[i][l] <= mid) {
					place++;
				}
				place += l;

			}

			if (place < desired)
				min = mid + 1;
			else
				max = mid - 1;
		}
		return min;
	}

	public static void main(String[] args) {
	}

}

class Solution1 {

	int lesserThanMid(int[] arr, int x) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] <= x)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return low;
	}

	public int getCountOfNumbersLessThanMid(int[][] matrix, int mid, int row, int col) {
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = col - 1; j >= 0; j--) {
				if (matrix[i][j] <= mid) {
					count = count + (j + 1);
					break;
				}
			}
		}
		return count;
	}

	int median(int matrix[][], int R, int C) {
		int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
		for (int i = 0; i < R; i++) {
			low = Math.min(low, matrix[i][0]);
			high = Math.max(high, matrix[i][C - 1]);
		}

		int pos = ((R * C) - 1) / 2;
		System.out.println("expected median position=" + pos);
		while (low <= high) {
			int mid = low + (high - low) / 2;

			// int count=0;
			// for(int i=0;i<R;i++)
			// count+=lesserThanMid(matrix[i],mid);
			System.out.println(
					"mid=" + mid + " couny=" + getCountOfNumbersLessThanMid(matrix, mid, R, C) + " low=" + low);
			if (getCountOfNumbersLessThanMid(matrix, mid, R, C) <= pos)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return low;
	}
}
