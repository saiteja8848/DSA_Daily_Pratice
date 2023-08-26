package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
	/**
	 * 
	 * Problem Statement:
	 * 
	 * majority element is the one which appears > (n/2)
	 * 
	 * 
	 * moore's voting algorithm : canceling out majority | minority element
	 * 
	 * 
	 * Arrays.sort(nums); return nums[nums.length/2];
	 * 
	 * hashMap counts - grouping concept - canceling out the same frequent elements
	 * and left we one extra element
	 * 
	 */

	public int majorityElement(int[] nums) {
		int count = 0;
		int candidate = 0;
		for (int num : nums) {

			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}
		return candidate;
	}

	public List<Integer> majorityElementII(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
			else if (count1 == 0) {
				number1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				number2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
		}
		if (count1 > len / 3)
			result.add(number1);
		if (count2 > len / 3)
			result.add(number2);
		return result;
	}
}
