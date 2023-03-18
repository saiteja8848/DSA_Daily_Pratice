package CyclicSort;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author saiteja
 * PraticeLink :https://leetcode.com/problems/set-mismatch/
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * 
 * SAME AS MISSING NUMBER --> fist missing number == first repeated number ==> cyclic sort
 *
 * 
 * 
 *
 */
public class SetMismatch {
	
	// first repeating element === first missing number
	public int[] findErrorNums(int[] nums) {

		int i = 0;
		while (i < nums.length) {
			int correct = nums[i] - 1;
			if (nums[i] != nums[correct]) {
				int temp = nums[i];
				nums[i] = nums[correct];
				nums[correct] = temp;
			} else
				i++;
		}
		// first missig number - index+1, in that place we have repeating no arr[index]
		for (int z = 0; z < nums.length; z++) {
			if (nums[z] != z + 1) {
				return new int[] { nums[z], z + 1 };
			}
		}

		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
	}
}
