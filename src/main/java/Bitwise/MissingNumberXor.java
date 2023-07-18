package Bitwise;

public class MissingNumberXor {

	public int missingNumber(int[] nums) {
		int xor = 0;
		int i = 0;
		for (; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}
		return xor ^ i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
