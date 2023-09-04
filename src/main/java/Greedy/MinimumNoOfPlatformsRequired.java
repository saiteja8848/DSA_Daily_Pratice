package Greedy;

import java.util.Arrays;

public class MinimumNoOfPlatformsRequired {
	static int findPlatform(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);

		int plat_needed = 1; // Initialize the count of platforms needed to 1
		int result = 1; // Initialize the result to 1
		int i = 1, j = 0;

		// Use a single loop to traverse both arrival and departure arrays
		while (i < n && j < n) {
			// If the next event is an arrival, increment the number of platforms needed
			if (arr[i] <= dep[j]) {
				plat_needed++;
				i++;
			} else { // If the next event is a departure, decrement the number of platforms needed
				plat_needed--;
				j++;
			}

			// Update the result with the maximum number of platforms needed at any time
			result = Math.max(result, plat_needed);
		}

		return result;
	}
}
