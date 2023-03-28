package TwoPointers;

import java.util.Arrays;


/*
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 * 
 */

public class FindKDiffPairs {
	
	
//	 if(B<0)
//         B=-B;
//
//       int i=0, j=1;
//       int len = A.size();
//       while(j<len){
//           int diff = A.get(j)-A.get(i);
//          
//
//            if(i!=j&&diff==B){
//              return 1;
//            }
//            else if(diff>B)
//               i++;
//            else
//               j++;   
//
//       }
//       return 0;


	public int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		int left = 0;
		int right = 1;
		int count = 0;

		while (left < nums.length && right < nums.length) {

			// skip duplicate element
			if (left > 0 && nums[left - 1] == nums[left]) {
				left++;
				continue;
			}

			if (left == right) {
				right++;
				continue;
			}

			int diff = nums[right] - nums[left];
			if (diff == k) {
				count++;
				left++;
			} else if (diff < k) {
				right++;
			} else {
				left++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
