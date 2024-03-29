package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
		if (remain < 0)
			return; /** no solution */
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < cand.length; i++) {
				tempList.add(cand[i]);
				backtrack(list, tempList, cand, remain - cand[i], i);
				tempList.remove(tempList.size() - 1);
			}
		}

	}

}

class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {

		if (remain < 0)
			return; /** no solution */
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < cand.length; i++) {
				if (i > start && cand[i] == cand[i - 1])
					continue; /** skip duplicates */
				tempList.add(cand[i]);
				backtrack(list, tempList, cand, remain - cand[i], i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}

class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<Integer>(), k, n, 1);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int remain, int start) {
		if (tempList.size() > k)
			return; /** no solution */
		else if (tempList.size() == k && remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i <= 9; i++) {
				tempList.add(i);
				backtrack(list, tempList, k, remain - i, i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}

class CombinationSumIV {
	HashMap<Integer, Integer> cache = new HashMap<>();

	public int combinationSum4(int[] candidates, int target) {

		return dfs(candidates, target);
	}

	public int dfs(int[] candidates, int currentValue) {

		if (cache.containsKey(currentValue)) {
			return cache.get(currentValue);
		}

		int count = 0;
		if (currentValue == 0) {
			return ++count;
		}

		for (int candidate : candidates) {
			if (currentValue - candidate >= 0) {
				count += dfs(candidates, currentValue - candidate);
			}
		}
		cache.put(currentValue, count);

		return count;
	}
}
