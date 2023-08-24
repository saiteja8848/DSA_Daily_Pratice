package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
	// Function to return Breadth First Traversal of given graph.

	void doBreadthFirstTraversal(Queue<Integer> queue, boolean[] visited, ArrayList<ArrayList<Integer>> adj,
			ArrayList<Integer> bft) {
		if (queue.isEmpty())
			return;

		int node = queue.poll();// FIFO
		bft.add(node);
		for (int adjacent : adj.get(node)) {
			if (!visited[adjacent]) {
				queue.add(adjacent);
				visited[adjacent] = true;
			}
		}

		doBreadthFirstTraversal(queue, visited, adj, bft);
	}

	// public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>>
	// adj) {
	// boolean[] visited = new boolean[V];
	// ArrayList<Integer> bft = new ArrayList<>();
	// Queue<Integer> queue = new LinkedList<>();
	// for(int i=0;i<V;i++){
	// if(!visited[i]){
	// visited[i]=true;
	// queue.add(i);
	// doBreadthFirstTraversal(queue,visited,adj,bft);
	// }
	// }
	// return bft;
	// }

	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here

		ArrayList<Integer> bfs = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[V];

		queue.add(0);
		visited[0] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			bfs.add(node);
			for (Integer adjacent : adj.get(node)) {
				if (!visited[adjacent]) {
					visited[adjacent] = true;
					queue.add(adjacent);
				}
			}
		}
		return bfs;

	}
}