package TwoPointers;

/**
 * 
 * @author saiteja
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 */

public class RemoveDuplicatesFromSortedArrayIAndII {

	public int removeDuplicatesII(int[] nums) {
		int i = 2;
		int j = 2;

		if (nums.length < 3)
			return nums.length;

		while (j < nums.length) {
			if (nums[i - 2] != nums[j])
				nums[i++] = nums[j];
			j++;
		}

		return i;
	}

	public int removeDuplicatesI(int[] nums) {
		// Core logic, whenever we find the duplicate elem, search for the next elem
		// which is not equal and update it
		int i = 0;
		int j = 1;

		while (j < nums.length) {
			if (nums[i] != nums[j])
				nums[++i] = nums[j++];
			else
				j++;
		}

		return (i + 1);
	}

	public static void main(String[] args) {

	}

}
