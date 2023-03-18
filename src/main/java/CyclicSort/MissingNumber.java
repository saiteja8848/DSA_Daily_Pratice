package CyclicSort;


/**
 * 
 * @author saiteja
 * PraticeLink : https://leetcode.com/problems/missing-number/
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 *
 * Approach 1 : we can use statusArray - to mark element is present or not - but space - O(n)
 * Approach 2 : Sort the array - O(nlogn) and compare element with its index
 * Approach 3 : Sum of n natural numbers - totalSumOfGivenArray
 * 
 *
 */


public class MissingNumber {

	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int totalSum = (n * (n + 1)) / 2;
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return (totalSum - sum);
	}	
	
	/*
    cyclic sort - range is fixed O- n ==> O to n-1 [0-3 means 0,1,2]
    we expect nos to be like 0,1,2 and indexes also 0,1,2
    
    so now we have 2 conditions to swap to set it back as above
    
     0,1,2
    [3,0,1]
    
    0th index we expect 0, but it is 3, which is out of boundary, so continue to next
    1st index we expect 1, but it is 0, so swap now, take 0 out and 
      - inplace of 0, update  
 
 */
 
	public int missingNumber2(int[] nums) {
		int i = 0;

		// Cyclic Sort in action - trying to place the elements in their respective
		// index
		while (i < nums.length) {
			int correct = nums[i];
			if (nums[i] < nums.length && nums[i] != nums[correct]) {
				int temp = nums[i];
				nums[i] = nums[correct];
				nums[correct] = temp;
			} else
				i++;
		}

		// Checking for the missing item in the soted array "nums"
		for (int z = 0; z < nums.length; z++) {
			if (nums[z] != z) {
				return z;
			}
		}

		return nums.length;
	}
	
	 // XOR SOLUTION - WILL DISCUSS LATER - SAME NUMBERS CANCEL OUT HERE, ONLY UNIQUE NUMBER STAYS
	 public int missingNumber3(int[] nums) {
	        int xor = 0;
	        int i = 0;
	        for(; i < nums.length; i++) {
	            xor = xor ^ i ^ nums[i];
	        }
	        return xor ^ i;
	    }
	
	public static void main(String[] args) {
	
	}
}
