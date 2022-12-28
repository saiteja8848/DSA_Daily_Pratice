package com.teja.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;


/*
 * 
 * TimeComplexity :  O(n)
 * SpaceComplexity : O(n)
 * 
 * where n is the no of nodes in the given tree
 * 
 * Problem Link : https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * */

public class MaximumDepthOfATree_BFS {
	
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			if (queue.size() == 0) {
				return level;
			}

			level++;
		}
		return level;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
