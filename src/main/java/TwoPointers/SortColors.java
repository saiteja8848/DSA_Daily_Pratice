package TwoPointers;

/**
 * 
 * 
 * @author saiteja https://leetcode.com/problems/sort-colors/
 */

public class SortColors {

	public void sortColors(int[] nums) {
		int movingPtr = 0; // it always keep traks of 1,
		int leftPtr = 0; // if moving ptrs encounters 1, assing it to left and both move ahead
		int rightPtr = nums.length - 1; // if moving ptrs encounters 2, only decrease right, kept move

		while (movingPtr <= rightPtr) {

			if (nums[movingPtr] == 1)
				movingPtr++;
			else if (nums[movingPtr] == 0) {
				int temp = nums[movingPtr];
				nums[movingPtr++] = nums[leftPtr];
				nums[leftPtr++] = temp;
			} else if (nums[movingPtr] == 2) {
				int temp = nums[movingPtr];
				nums[movingPtr] = nums[rightPtr];
				nums[rightPtr--] = temp;
			}
		}

	}

	public static void main(String[] args) {

	}

}
