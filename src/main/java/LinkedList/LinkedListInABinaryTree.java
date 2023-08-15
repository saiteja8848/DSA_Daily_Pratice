package LinkedList;


public class LinkedListInABinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) 
            return false;
        
     
        if(head.val == root.val){
            if(searchPath(head, root)) 
                return true;
        }

        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    
    private boolean searchPath(ListNode listNode, TreeNode treeNode){
        //base cases
        //if tree node reched to end,
        //check list node reached to end or node
        if(treeNode == null) 
            return listNode == null;
        
        //list node reached to end, it meand found 
        if(listNode == null) 
            return true;
        
        //if treeNode val is not match with list val,
        //return, no need to search further
        if(treeNode.val != listNode.val) 
            return false;
        
        return searchPath(listNode.next, treeNode.left) || searchPath(listNode.next, treeNode.right);
    }
    
}