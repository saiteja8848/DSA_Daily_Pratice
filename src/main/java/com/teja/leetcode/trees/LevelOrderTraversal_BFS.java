package com.teja.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 
 * TimeComplexity :  O(n)
 * SpaceComplexity : O(n)
 * 
 * where n is the no of nodes in the given tree
 * 
 * Problem Link : https://leetcode.com/problems/binary-tree-level-order-traversal/
 *  same as above : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * GFG Article : https://www.geeksforgeeks.org/level-order-tree-traversal/
 * */



public class LevelOrderTraversal_BFS {
    
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> sol = new ArrayList<>();
		if (root == null)
			return sol;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {

				TreeNode node = queue.poll();
				if (node != null) {
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
					temp.add(node.val);
				}
			}
			sol.add(temp);

		}
		return sol;

	}
	
	
	public static void main(String[] args) {
	}

}
