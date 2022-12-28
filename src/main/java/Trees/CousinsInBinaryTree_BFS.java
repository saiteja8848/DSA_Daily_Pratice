package Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * TimeComplexity :  O(n)
 * SpaceComplexity : O(n)
 * 
 * where n is the no of nodes in the given tree
 * 
 * Problem Link : https://leetcode.com/problems/cousins-in-binary-tree/
 * 
 * */



public class CousinsInBinaryTree_BFS {
	
	 public boolean isCousins(TreeNode root, int x, int y) {
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        while(!queue.isEmpty()) {
	            TreeNode parentX = null, parentY = null;
	            int size = queue.size();
	            for(int i = 0; i < size; i++) {
	                root = queue.poll();
	                if(root.left != null) {
	                    if(root.left.val == x) 
	                        parentX = root;
	                    else if(root.left.val == y) 
	                        parentY = root;
	                    queue.offer(root.left);
	                }
	                if(root.right != null) {
	                    if(root.right.val == x) 
	                        parentX = root;
	                    else if(root.right.val == y) 
	                        parentY = root;
	                    queue.offer(root.right);
	                }
	            }
	            if(parentX != null && parentY != null) 
	                return parentX != parentY;
	            if(parentX != null || parentY != null) 
	                return false;
	        }
	        return false;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
