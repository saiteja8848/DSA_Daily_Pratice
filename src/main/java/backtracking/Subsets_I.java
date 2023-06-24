package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_I {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		subset1(nums, 0, new ArrayList<>(), res);
		return res;
	}

	public void subset1(int[] nums, int idx, List<Integer> list, List<List<Integer>> res) {
		res.add(new ArrayList<>(list));
		for (int i = idx; i < nums.length; i++) {
			list.add(nums[i]); // add the element to list
			subset1(nums, i + 1, list, res);
			list.remove(list.size() - 1); // backtrack, remove the element from list
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
