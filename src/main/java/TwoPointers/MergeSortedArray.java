package TwoPointers;

/**
 * 
 * 
 * @author saiteja 
 * https://leetcode.com/problems/merge-sorted-array/description/
 */

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int i1 = m - 1; // pointer for last element in nums1
		int i2 = n - 1; // pointer for last element in nums2

		// Loop through the arrays, from last element to first
		while (i1 >= 0 && i2 >= 0) {
			if (nums1[i1] >= nums2[i2]) {
				nums1[i1 + i2 + 1] = nums1[i1--];
			} else {
				nums1[i1 + i2 + 1] = nums2[i2--];
			}
		}

		// Copy in the remaining elements
		while (i2 >= 0) {
			nums1[i2] = nums2[i2--];
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
