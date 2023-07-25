package Greedy;

public class JumpGame {

	public boolean canJump(int[] nums) {
		int n = nums.length;

		// last index from where we can reach to end cell
		// As from last index (n - 1) itself reach to end cell,
		int lastIndex = n - 1;

		for (int i = n - 1; i >= 0; i--) {
			if (i + nums[i] >= lastIndex) {
				lastIndex = i;
			}
		}

		// check from 0 reach to end cell
		return lastIndex == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
