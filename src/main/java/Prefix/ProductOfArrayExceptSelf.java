package Prefix;


/**
 * 
 * 
 * 
 * @author saiteja
 * 
 * LeetCode Problem Link :  https://leetcode.com/problems/product-of-array-except-self/description/
 * 
 * Input : [1,2,3,4]
 * Output : [24,12,8,6]
 * 
 * 
 * 
 * 
 *
 */


public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		if (nums.length == 0)
			return null;

		int[] res = new int[nums.length];
		
		//Calculate Prefix Left Product
		res[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
			res[i] = res[i - 1] * nums[i];
		
		//Since we have left product, traverse from right end
		int right = 1; // for last element assuming right product is 1
		for (int i = nums.length - 1; i > 0; --i) {
			res[i] = res[i - 1] * right; // leftProduct * rightProduct, leaving currentElement
			right *= nums[i]; // Now right product is updated with current Element to carry forward
		}
		res[0] = right;
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
