package backtracking;

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> sol = new ArrayList<>();
		generateCombination(candidates, target, ans, sol, 0);
		return ans;
	}

	public void generateCombination(int[] nums, int target, List<List<Integer>> ans, List<Integer> temp, int index) {

		// base condition
		if (index == nums.length) {
			if (target == 0) {
				ans.add(new ArrayList<>(temp));
			}
			return;
		}

		if (index < nums.length && nums[index] <= target) {
			temp.add(nums[index]);
			generateCombination(nums, target - nums[index], ans, temp, index);
			temp.remove(temp.size() - 1);
		}

		generateCombination(nums, target, ans, temp, index + 1);
	}

}


