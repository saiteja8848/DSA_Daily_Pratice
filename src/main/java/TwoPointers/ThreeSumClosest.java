package TwoPointers;

import java.util.Arrays;


/*
 * 
 * https://leetcode.com/problems/3sum-closest/description/
 */

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		long closest = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length - 2; i++) {

			int p1 = i + 1;
			int p2 = nums.length - 1;

			while (p1 < p2) {

				int sum = nums[i] + nums[p1] + nums[p2];

				if (Math.abs(sum - target) < Math.abs(closest - target))
					closest = sum;

				if (sum < target)
					p1++;
				else
					p2--;

			}

		}

		return (int) closest;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
