package SlidingWindow_Variable;

import java.util.HashMap;

/**
 * 
 * @author saiteja 
 * Problem Link   :https://leetcode.com/problems/subarray-sum-equals-k/description/
 *         Tc: O(n) SC : O(1)
 */

public class Subarray_Sum_Equals_K {

	public int subarraySum(int[] nums, int k) {
		int sum = 0;
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		// map(sum,occurrence)
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			// k-sum gives negative value so it doesn't work
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
	}
}
