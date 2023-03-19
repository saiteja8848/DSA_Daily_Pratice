package SlidingWindow_Variable;


/**
 * 
 * @author saiteja 
 * ProblemLink :https://leetcode.com/problems/max-consecutive-ones-iii
 * Tc: O(n) SC : O(1)
 */


public class MaxConsecutiveOnes_III {

	public int longestOnes(int[] nums, int k) {
		int flips = 0;
		int startWindow = 0;
		int endWindow = 0;
		int n = nums.length;
		int maxCount = Integer.MIN_VALUE;
		while (endWindow < n) {
			if (nums[endWindow] == 0) {
				flips++;
			}
			while (flips > k && nums[startWindow++] == 0) {
				flips--;
			}
			maxCount = Math.max(maxCount, endWindow - startWindow + 1);
			endWindow++;
		}
		return maxCount;
	}

	public static void main(String[] args) {
	}
}
