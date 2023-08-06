package BinarySearch;

import java.util.Arrays;

class Solution111 {
	public int shipWithinDays(int[] weights, int days) {
		int low = Arrays.stream(weights).max().getAsInt();
		int high = Arrays.stream(weights).sum();
		while (low <= high) {
			int mid = low + (high - low) / 2;
			// Note : Incase we are getting more no of days, it means our capcity is low,
			// so we have to increase our capacity - so move to increasing side, low = mid
			// +1, so that we will get least no of days
			if (getNumOfDays(weights, days, mid) > days)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return low;
	}

	public int getNumOfDays(int[] weights, int days, int midAsCapacityPerDay) {
		int sum = 0;
		int count = 1;
		for (int weight : weights) {
			if (count > days)
				break;
			if (sum + weight > midAsCapacityPerDay) {
				count += 1;
				sum = 0;
			}
			sum += weight;
		}
		return count;
	}
}

public class CapacityToShip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
