package TwoPointers;

import java.util.HashMap;

import java.util.Map;

/**
 * 
 * 
 * @author saiteja
 * https://leetcode.com/problems/two-sum/description/
 *
 */


public class TwoSum_I {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		int i = 0;
		for (int n : nums) {
			// Initially check whether difference is existing in map or not
			// if not put the element with its index in key, because it may // act as key to
			// further elements
			if (map.containsKey(target - n)) {
				result[1] = i;
				result[0] = map.get(target - n);
			}
			map.put(n, i++);
		}
		return result;
	}

	public static void main(String[] args) {
	}
}
