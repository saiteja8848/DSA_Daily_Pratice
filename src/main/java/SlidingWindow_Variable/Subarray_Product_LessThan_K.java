package SlidingWindow_Variable;

/**
 * 
 * @author saiteja
 * Problem Link :https://leetcode.com/problems/subarray-product-less-than-k/description/
 * Tc: O(n)
 * SC : O(1)
 */

public class Subarray_Product_LessThan_K {

	  public int numSubarrayProductLessThanK(int[] nums, int k) {
	        if (k <= 1) return 0;
	        int product = 1, ans = 0, start = 0;
	        for (int end=0;end<nums.length;end++) {
	            //condition to increase window
	            product*=nums[end];
	            
	            //Condition to shrink the window from starting
	            while (product >= k) 
	              product /= nums[start++];
	            
	            //suming up the count whose subarray product is less than K
	            ans += end - start + 1;
	        }
	        return ans;  
	    }
	public static void main(String[] args) {
	}
}
