package TwoPointers;

/**
 * 
 * 
 * 
 * @author saiteja 
 * https://leetcode.com/problems/move-zeroes/
 *
 */
public class MoveZeros {

	public void moveZeroes(int[] nums) {
		int right = 0;
		int left = 0;
		while (left < nums.length) {
			if (nums[left] != 0) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				right++;
			}
			left++;
		}
	}

	public static void main(String[] args) {

	}

}
