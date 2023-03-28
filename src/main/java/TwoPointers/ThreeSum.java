package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * 
 * https://leetcode.com/problems/3sum/description/
 */

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length == 0)
			return ans;
		Arrays.sort(nums);

		// A+B+C =0 ==> +A-(B+C)=0 or -A+(B+C)=0 , so if we have one negative or
		// positive with us, will check for other
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int a = -nums[i];
				int low = i + 1;
				int high = nums.length - 1;
				while (low < high) {
					int currSum = nums[low] + nums[high];
					if (currSum > a)
						high--;
					else if (currSum < a)
						low++;
					else {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[low++]);
						temp.add(nums[high--]);
						ans.add(temp);

						while (low < high && nums[low] == nums[low - 1])
							low++;
						while (high > low && nums[high] == nums[high + 1])
							high--;
					}
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
	}

}
