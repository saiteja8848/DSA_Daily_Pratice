package LinkedList;

public class FlattenBinaryTree {

	 public void flatten(TreeNode root) {
	        // if(root==null)
	        //    return;

	        // TreeNode tempLeft = root.left;
	        // TreeNode tempRight =root.right;

	        // root.left=null;
	       
	        // //Go Left first and do this
	        // flatten(tempLeft);
	        // flatten(tempRight);

	        // root.right = tempLeft;
	        // TreeNode current =root;
	        // while(current.right!=null)
	        //    current=current.right;

	        // current.right=tempRight;

	        //Morris tree traversal
	        if(root==null)
	          return ;
	        while(root!=null){
	            if(root.left!=null){
	                TreeNode left = root.left;
	                TreeNode current = left;
	                while(current.right!=null)
	                  current=current.right;
	                current.right=root.right;
	                root.left=null;
	                root.right=left;
	            }
	            root=root.right;
	        }
	  

	    }

}
