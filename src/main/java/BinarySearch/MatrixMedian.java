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
		// TODO Auto-generated method stub

	}

}
