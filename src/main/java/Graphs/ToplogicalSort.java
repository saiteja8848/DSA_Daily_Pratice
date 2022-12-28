package Graphs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * 
 * Video Explanation : https://youtu.be/eL-KzMXSXXI
 * 
 * Note : 
 * 1.Topological sort can be applied only on directed acyclic graph - since there is dependency factor
 * 2.we can have multiples topological sort orders
 *
 * We solve this dfs or bfs
 * 
 * GFG Pratice Link : https://practice.geeksforgeeks.org/problems/topological-sort/1
 * 
 * 
 * Time complexity : O(V + E) , since we won't repeat visiting on already visted edge, it will be vertices + edges
 * Space Complexity: O(V) - for visited/unvisited status checks
 * 
 * Application : when there is prerequiste, examples project build scenarios, A has to build first before B
 *
 */


public class ToplogicalSort {

	static void findTopologicalOrder(int node, ArrayList<ArrayList<Integer>> adjacencyList, Stack<Integer> stack,
			boolean[] visited) {
		visited[node] = true;
		for (int n : adjacencyList.get(node)) {
			if (!visited[n]) {
				findTopologicalOrder(n, adjacencyList, stack, visited);
			}
		}
		stack.push(node);
	}

	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

		int[] topSort = new int[V];
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (visited[i] == false)
				findTopologicalOrder(i, adj, stack, visited);
		}

		int index = 0;
		while (!stack.isEmpty()) {
			topSort[index] = stack.pop();
			index++;
		}

		return topSort;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
