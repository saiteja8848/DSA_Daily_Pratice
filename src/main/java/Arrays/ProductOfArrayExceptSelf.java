package Arrays;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {

		if (nums.length == 0)
			return null;

		int[] res = new int[nums.length];
		res[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
			res[i] = res[i - 1] * nums[i];

		int right = 1;
		for (int i = nums.length - 1; i > 0; --i) {
			res[i] = res[i - 1] * right;
			right *= nums[i];
		}
		res[0] = right;

		return res;
	}
}
