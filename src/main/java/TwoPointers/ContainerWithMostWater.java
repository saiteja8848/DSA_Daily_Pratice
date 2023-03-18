package TwoPointers;


/**
 * 
 * @author saiteja
 *  https://leetcode.com/problems/container-with-most-water
 */


public class ContainerWithMostWater {

//  public int maxArea(int[] height) {
//  //O(n^2) solution, where we take one left, check with every right and ask which is giving the max combination of area

//  int result = 0;
//  int len = height.length-1;
//  for(int i=0;i<len;i++){
//      for(int j=i+1;j<len;j++){
//          int area = (j-i) * Math.min(height[i],height[j]);
//          result = Math.max(area, result);

//      }
//  }
//  return result;
//}

	public int maxArea(int[] height) {
		// O(n) solution,

		int result = 0;
		int i = 0;
		int j = height.length - 1;

		while (i < j) {
			int area = (j - i) * Math.min(height[i], height[j]);
			result = Math.max(area, result);

			if (height[i] < height[j])
				i++;
			else
				j--;

		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
