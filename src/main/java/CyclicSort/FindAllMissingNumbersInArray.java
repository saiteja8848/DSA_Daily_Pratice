package CyclicSort;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author saiteja
 * PraticeLink : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * Duplicate Number II
 *
 * 
 * 
 *
 */


public class FindAllMissingNumbersInArray {
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> nonOccuredNumbers = new ArrayList<>();
		int i = 0;
		while (i < nums.length) {
			int correct = nums[i] - 1;
			if (nums[i] != nums[correct]) {
				int temp = nums[i];
				nums[i] = nums[correct];
				nums[correct] = temp;
			} else
				i++;
		}
		// Checking for the missing item in the soted array "nums"
		for (int z = 0; z < nums.length; z++) {
			if (nums[z] != z + 1) {
				nonOccuredNumbers.add(z + 1);
			}
		}
		return nonOccuredNumbers;
	}
	
	public static void main(String[] args) {
	}
}
