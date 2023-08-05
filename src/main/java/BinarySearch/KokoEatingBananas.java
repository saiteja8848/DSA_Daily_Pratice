package BinarySearch;

import java.util.Arrays;

class Solution99 {
	public int minEatingSpeed(int[] piles, int h) {
		int min = 1;
		int max = Arrays.stream(piles).max().getAsInt();

		while (min < max) {
			int mid = (min + max) / 2;
			if (getHoursToEat(piles, mid) > h) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}

		return min;
	}

	private int getHoursToEat(int[] piles, int k) {
		int h = 0;
		for (int a : piles) {
			h += Math.ceil((double) a / k);
		}
		return h;
	}
}

public class KokoEatingBananas {

}
