package TwoPointers;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 * https://www.geeksforgeeks.org/trapping-rain-water/
 *
 * TimeComplexity :
 * Space Complexity:
 *
 *
 * Core Logic : for every Index, check the leftMax height and rightMaxHeight , take minimum height
 *  Min(maxLeft,maxRight) - currentHeight
 *  
 *  so we have to maintain - prefixLeftSum and prefixRightSum --> which takes extra time complexity
 *  
 *
 *
 */

public class TrappingRainWater {
	
	  public int trap(int[] height) {
		    int water = 0;
		    int l = 0;
		    int r = height.length-1;
		    int lmax = Integer.MIN_VALUE;
		    int rmax = Integer.MIN_VALUE;
		    
		         //minimum height window only moves then only we can save water, 
		        while(l < r){
		            lmax = Math.max(height[l], lmax);
		            rmax = Math.max(height[r], rmax);
		            
		            //here logic is if we standing in ith position, we need to think about Min(leftMax,rightMax)-h[i]
		            water+=  (lmax < rmax) ? lmax-height[l++] : rmax-height[r--] ;
		            //which one is minimum that one moves further
		        }
			  return water;
		    }

	public static void main(String[] args) {
	}

}
