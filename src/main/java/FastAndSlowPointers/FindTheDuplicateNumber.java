package FastAndSlowPointers;

public class FindTheDuplicateNumber {

	public int findDuplicate(int[] nums) {

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
