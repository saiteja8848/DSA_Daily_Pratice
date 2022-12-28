package Trees;

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
 * Problem Link :https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

 * */

public class ZigZag_BFS {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
       if(root==null){
           return result;
       }
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       boolean odd=true;
       while(!queue.isEmpty()) {
          int size = queue.size();
          LinkedList<Integer> res = new LinkedList<>();
          for(int i=1;i<=size;i++){
              TreeNode node = queue.poll();
              if(odd){
                  res.add(node.val);   
              } else {
                  res.add(0,node.val);
              }
              if(node.left!=null) {
                      queue.add(node.left);
              }
           if(node.right!=null){
                       queue.add(node.right);
                  }
              
          }
           result.add(res);
           odd=!odd;
       }
       return result;
   }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
