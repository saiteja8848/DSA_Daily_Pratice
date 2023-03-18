package TwoPointers;

import java.util.Arrays;

/**
 * 
 * @author saiteja https://leetcode.com/problems/valid-triangle-number/
 */

public class ValidTriangle {

	public int triangleNumber(int[] nums) {
		// a+b>c , b+c>a , a+c>b when these 3 conditions are satified we can say
		// a,b,c is a triangle, so it means a>b>c
		// By property we can say
		Arrays.sort(nums);

		int n = nums.length;
		int ans = 0;

		for (int c = n - 1; c >= 2; c--) {
			int a = 0;
			int b = c - 1;

			while (a < b) {
				if (nums[a] + nums[b] > nums[c]) {
					ans += b - a;
					b--;
				} else
					a++;
			}
		}

		return ans;

	}

	public static void main(String[] args) {
	}

}
