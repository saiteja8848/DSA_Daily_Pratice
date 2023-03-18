package CyclicSort;



/**
 * 
 * @author saiteja
 * PraticeLink : https://leetcode.com/problems/find-the-duplicate-number/
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 *
 * Duplicate Number I
 * we can use cyclic sort or fast-slow pointer
 * 
 *
 */


public class FindTheDuplicateNumber {
	
	//Cyclic sort solution
	public int findDuplicate1(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (nums[i] != i + 1) {
				int correct = nums[i] - 1;
				if (nums[i] != nums[correct]) {
					int temp = nums[i];
					nums[i] = nums[correct];
					nums[correct] = temp;
				} else
					return nums[i];
			} else
				i++;
		}
		return -1;
	}
	
	// Slow and fast pointer - imagine linkedList cycle
	public static int findDuplicate(int[] nums) {

		int slow = nums[0];
		int fast = nums[0];

		// first create a cycle
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		// compare the slow and fast with in the cycle
		fast = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
