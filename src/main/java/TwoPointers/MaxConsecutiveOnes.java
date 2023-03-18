package TwoPointers;

/**
 * 
 * 
 * @author saiteja
 *         https://leetcode.com/problems/max-consecutive-ones/description/
 */

public class MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {
		int count = 0, i = 0;

		int maxCount = Integer.MIN_VALUE;

		while (i < nums.length) {
			if (nums[i] == 1)
				count++;
			else
				count = 0;

			maxCount = Math.max(maxCount, count);

			i++;
		}
		return maxCount;
	}

	public static void main(String[] args) {

	}

}
