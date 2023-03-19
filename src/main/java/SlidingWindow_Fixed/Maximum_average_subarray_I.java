package SlidingWindow_Fixed;

//https://leetcode.com/problems/maximum-average-subarray-i/description/
public class Maximum_average_subarray_I {

	public double findMaxAverage(int[] nums, int k) {
		double sum = 0;
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}
		double res = sum;
		for (int i = k; i < nums.length; i++) {
			sum += nums[i] - nums[i - k];
			res = Math.max(res, sum);
		}

		return res / k;

	}

	public static void main(String[] args) {
	}

}
