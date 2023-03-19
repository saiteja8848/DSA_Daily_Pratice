package SlidingWindow_Variable;



/**
 * 
 * @author saiteja 
 * Problem Link   :https://leetcode.com/problems/minimum-size-subarray-sum
 *         Tc: O(n) SC : O(n)
 */

/*Note:  This code works only in case of positive numbers, in questions there are clearly mentioned, i/p is positive*/
public class MinimumSize_SubarraySum_GreaterThanEquals_K {

	public int minSubArrayLen(int target, int[] nums) {
		int start = 0, end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while (end < nums.length) {
			sum += nums[end++];
			while (sum >= target) {
				min = Math.min(min, end - start);
				sum = sum - nums[start++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void main(String[] args) {
	}

}
