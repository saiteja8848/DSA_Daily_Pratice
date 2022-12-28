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
 * Problem Link : https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * 
 * */


public class AverageOfLevelsInBT_BFS {
	
	 public List < Double > averageOfLevels(TreeNode root) {
	        List < Double > res = new ArrayList < > ();
	        Queue < TreeNode > queue = new LinkedList < > ();
	        queue.add(root);
	        while (!queue.isEmpty()) {
	            long sum = 0, count = 0;
	            Queue < TreeNode > temp = new LinkedList < > ();
	            while (!queue.isEmpty()) {
	                TreeNode n = queue.remove();
	                sum += n.val;
	                count++;
	                if (n.left != null)
	                    temp.add(n.left);
	                if (n.right != null)
	                    temp.add(n.right);
	            }
	            queue = temp;
	            res.add(sum * 1.0 / count);
	        }
	        return res;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
