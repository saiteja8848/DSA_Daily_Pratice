package Bitwise;

public class SingleNumber_I {

	public int singleNumber(int[] nums) {
		int xor = 0;
		for (int i : nums) {
			xor ^= i; // xor =xor^i
		}
		return xor;
	}

	public int singleNumberII(int[] nums) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) == 1) {
					sum++;
					sum %= 3;
				}
			}
			if (sum != 0) {
				ans = ans | sum << i;
			}
		}
		return ans;
	}

}
