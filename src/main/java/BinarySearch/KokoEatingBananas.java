package BinarySearch;

import java.util.Arrays;

class Solution99 {

	  // Approach 1: Brute Force - TLE

	// Time complexity: O(m * n), where n is length of piles, m is max(piles)
	// Space complexity: O(1)

	// public int minEatingSpeed(int[] piles, int h) {
//	 	int speed = 1;
//	 	while (true) {
//	 		if (getHoursToEat(piles,speed) <= h)
//	 			break;
//	 		speed++;
//	 	}
//	 	return speed;
	// }



	    public int minEatingSpeed(int[] piles, int h) {
	        int low =1;
	        int high = Arrays.stream(piles).max().getAsInt();

	        while (low <= high) {
	            int mid = (low + high) / 2;
	            int totalH = getHoursToEat(piles, mid);
	            if (totalH > h) {
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }
	        return low;
	    }

	    private int getHoursToEat(int[] piles, int speed) {
	        int hours=0;
	        for (int pile : piles) {
	          hours += Math.ceil((double)(pile) / (double)(speed));
			}
	        return hours;
	    }
	}

public class KokoEatingBananas {

}
