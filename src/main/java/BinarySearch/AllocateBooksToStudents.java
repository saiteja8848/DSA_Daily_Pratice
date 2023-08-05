package BinarySearch;

import java.util.ArrayList;

public class AllocateBooksToStudents {

	public static int countSubarraysWithGivenSum(ArrayList<Integer> boards, int sum) {
		int count = 1;
		int totalSum = 0;
		for (int num : boards) {
			if (num + totalSum > sum) {
				totalSum = 0;
				count++;
			}
			totalSum += num;
		}
		return count;
	}

	public static int findPages(ArrayList<Integer> boards, int n, int k) {

		if (k > n)
			return -1;
		int low = 0, high = 0;
		for (int i = 0; i < boards.size(); i++) {
			if (boards.get(i) > low)
				low = boards.get(i);
			high += boards.get(i);
		}

		int ans = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int countOfSubarraysWithGivenSum = countSubarraysWithGivenSum(boards, mid);
			if (countOfSubarraysWithGivenSum > k) {
				low = mid + 1;
			} else {
				// it means we have k subarrays with given sum, so we can say this MAY BE our
				// answer
				ans = mid;
				// Try find even better
				high = mid - 1;
			}
		}

		return ans;
	}
}
