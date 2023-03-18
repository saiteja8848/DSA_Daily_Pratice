package TwoPointers;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 * https://www.geeksforgeeks.org/trapping-rain-water/
 *
 */

public class TrappingRainWater {
	
	  public int trap(int[] height) {
		    int water = 0;
		    int l = 0;
		    int r = height.length-1;
		    int lmax = Integer.MIN_VALUE;
		    int rmax = Integer.MIN_VALUE;
		        while(l < r){
		            lmax = Math.max(height[l], lmax);
		            rmax = Math.max(height[r], rmax);
		            
		            //here logic is if we standing in ith position, we need to think about Min(leftMax,rightMax)-h[i]
		            water+=  (lmax < rmax) ? lmax-height[l++] : rmax-height[r--] ;
		        }
			  return water;
		    }

	public static void main(String[] args) {
	}

}
