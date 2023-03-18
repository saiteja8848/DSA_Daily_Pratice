package TwoPointers;

/**
 * 
 * @author saiteja https://leetcode.com/problems/rotate-array/
 */

public class RotateArray {

	public void swap(int[] nums, int low, int high) {

		while (low < high) {
			int temp = nums[low];
			nums[low] = nums[high];
			nums[high] = temp;
			low++;
			high--;
		}

	}

	public void rotate(int[] nums, int k) {
		// if suppose array size is 4, k=5, k =5%4=1, we only need to rotate right
		int n = nums.length;
		k = k % n;

		swap(nums, 0, n - k - 1);
		swap(nums, n - k, n - 1);
		swap(nums, 0, n - 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
