package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_I {

	public static List<List<Integer>> subsets11(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		subset1(nums, 0, new ArrayList<>(), res);
		return res;
	}

	public static void subset1(int[] nums, int idx, List<Integer> list, List<List<Integer>> res) {
		res.add(new ArrayList<>(list));
		for (int i = idx; i < nums.length; i++) {
			list.add(nums[i]);
			subset1(nums, i + 1, list, res);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		subset12(nums, 0, new ArrayList<>(), res);
		return res;
	}

	static public void subset12(int[] nums, int idx, List<Integer> list, List<List<Integer>> res) {
		res.add(new ArrayList<>(list));
		for (int i = idx; i < nums.length; i++) {
			if (i > idx && nums[i] == nums[i - 1])
				continue;
			list.add(nums[i]);
			subset1(nums, i + 1, list, res);
			list.remove(list.size() - 1);
		}
	}

}
