package TwoPointers;

import java.util.Arrays;

/**
 * 
 * @author saiteja
 *  https://leetcode.com/problems/valid-triangle-number/
 */

public class ValidTriangle {

	public int triangleNumber(int[] nums) {
		// a+b>c , b+c>a , a+c>b when these 3 conditions are satisfied we can say
		// a,b,c is a triangle, so it means a>b>c
		/*
		 *  a<b<c
		 *    if we observe c is already greater here, so when we combine c with either a,b it always greater
		 *   
		 *     // a+b>c These condition we need to check
		 *   
		 *    //By default
		 *   b+c>a (true)
		 *   a+c>b (true)
		 * 
		 * 
		 */
		
		// By property we can say
		Arrays.sort(nums);
		int n = nums.length;
		int ans = 0;

		for (int c = n - 1; c >= 2; c--) { 
			// here we are fixing c, now apart from c, we need to pick a and b
			int a = 0; // smaller end
			int b = c - 1; // larger end
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
