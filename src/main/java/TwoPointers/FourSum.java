package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/4sum/description/
 * @author saite
 *
 */

public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> ans = new ArrayList<>();

		Arrays.sort(nums);

		int n = nums.length;

		for (int i = 0; i < n - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			for (int j = i + 1; j < n - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;

				int targetSum = target - (nums[i] + nums[j]);
				int low = j + 1;
				int high = n - 1;
				while (low < high) {
					if (nums[low] + nums[high] == targetSum) {
						List<Integer> temp = new ArrayList();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[low]);
						temp.add(nums[high]);
						ans.add(temp);
						while (low < high && nums[low] == nums[low + 1])
							low++;
						while (low < high && nums[high] == nums[high - 1])
							high--;

						low++;
						high--;
					} else if (nums[low] + nums[high] < targetSum)
						low++;
					else
						high--;

				}

			}

		}
		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
