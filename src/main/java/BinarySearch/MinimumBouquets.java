package BinarySearch;

import java.util.Arrays;

class Solution8 {
	public static int getNumberOfBouques(int[] arr, int day, int k) {
		int cnt = 0;
		int noOfB = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= day) {
				cnt++;
			} else {
				noOfB += (cnt / k);
				cnt = 0;
			}
		}
		noOfB += (cnt / k);
		return noOfB;
	}

	public int minDays(int[] arr, int m, int k) {
		// if no of flowers required is more than no of flowers given, return -1;
		long val = (long) m * k;
		if (val > arr.length)
			return -1;

		int low = Arrays.stream(arr).min().getAsInt();
		int high = Arrays.stream(arr).max().getAsInt();
		while (low <= high) {
			int mid = (low + high) / 2;
			if (getNumberOfBouques(arr, mid, k) < m) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}
}

public class MinimumBouquets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
