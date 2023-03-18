package TwoPointers;

/**
 * 
 * 
 * @author saiteja https://leetcode.com/problems/remove-element/description/
 */
public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {

			// both are same from both ends,we cann't move left ptrs,
			if (nums[left] == val && nums[right] == val)
				right--;
			else if (nums[left] == val && nums[right] != val)
				nums[left++] = nums[right--];
			else
				left++;
		}

		return left;

	}

	public static void main(String[] args) {

	}

}
