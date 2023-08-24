package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution 1: Top down DFS dfs find out the time needed for each employees. The
 * time for a manager = max(manager's employees) + informTime[manager]
 * 
 * Time O(N), Space O(N)
 */

public class TimeNeededToInformAllEmployees {

	public int numOfMinutes(final int n, final int headID, final int[] manager, final int[] informTime) {
		final Map<Integer, List<Integer>> graph = new HashMap<>();
		int total = 0;
		for (int i = 0; i < manager.length; i++) {
			int j = manager[i];
			if (!graph.containsKey(j))
				graph.put(j, new ArrayList<>());
			graph.get(j).add(i);
		}
		return dfs(graph, informTime, headID);
	}

	private int dfs(final Map<Integer, List<Integer>> graph, final int[] informTime, final int cur) {
		int max = 0;
		if (!graph.containsKey(cur))
			return max;
		for (int i = 0; i < graph.get(cur).size(); i++)
			max = Math.max(max, dfs(graph, informTime, graph.get(cur).get(i)));
		return max + informTime[cur];
	}
}