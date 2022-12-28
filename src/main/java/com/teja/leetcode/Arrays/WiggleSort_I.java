package com.teja.leetcode.Arrays;


/**
 * 
 * 
 * 
 * Odd index values > previous Even Index values
 * Even Index values < next Odd Index values
 * 
 * if this condition doesn't met, swap the values in the array
 * 
 * TC:o(N)
 * 
 * BRUTE FORCE: Sort and swap alternating elements
 * 
 * ProblmeLink : https://www.lintcode.com/problem/508/description
 * @author saite
 *
 */


public class WiggleSort_I {
	
	public void wiggleSort(int[] nums) {

		for (int i = 1; i < nums.length; i++) {

			if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
				int temp = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = temp;
			}
		}

		return;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
