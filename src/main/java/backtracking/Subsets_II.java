package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums); // To handle duplicate
		List<List<Integer>> res = new ArrayList<>();
		subset2(res, new ArrayList<>(), nums, 0);
		return res;
	}

	public void subset2(List<List<Integer>> res, List<Integer> ls, int[] nums, int idx) {
		res.add(new ArrayList<>(ls));
		for (int i = idx; i < nums.length; i++) {
			if (i > idx && nums[i] == nums[i - 1])
				continue; // skip the duplicates, except for the first time
			ls.add(nums[i]); // add the element to list
			subset2(res, ls, nums, i + 1);
			ls.remove(ls.size() - 1); // backtrack, remove the element from list
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
