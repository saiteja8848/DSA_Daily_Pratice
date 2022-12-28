package com.teja.leetcode.segementTrees;


/**

In case of brute force:

return preSum[end], when start is 0, since it is an edge case
prefixSum[end] - prefixSum[start-1] == gives range Sum => O(1)
where as update operation update index n, with x value => O(n);

So to optimize this go for segment tree ==> Building segmentTree => PreOrderTraversal => O(n)

Node description : sum = left + right sum==> simplying suming up by diving the array, so that we can have mid ranges sum
which is easy while searching range sums ==> So the time complexity will be O(logN)

Rangle sum also  O(logn)

Problem Link : https://leetcode.com/problems/range-sum-query-mutable/

Video Solution : https://youtu.be/dUkRI0R3sg8

Mutable means we can able to change the array values
Immutable we are not allowed to modifiy

*/


class NumArray {
    
    class SegmentTreeNode{
        private int start,end;
        private SegmentTreeNode left,right;
        private int sum;
        
        public SegmentTreeNode(int start,int end){
            this.start=start;
            this.end=end;
            this.left = null;
            this.right =null;
            this.sum=0;
        }
    }
    
    SegmentTreeNode root = null;
    
    public NumArray(int[] nums) {
        root = buildTree(nums,0,nums.length-1);
    }
    
    //o(n)-
    private SegmentTreeNode buildTree(int[] nums, int start, int end){
        if(start > end) // leftNodes calling left and right return null
            return null;
        else{
            SegmentTreeNode newNode = new SegmentTreeNode(start,end);
            if(start==end) // base condition - for leafNode
                 newNode.sum=nums[start];
            else{
                int mid = start + (end-start)/2;
                newNode.left = buildTree(nums,start,mid);
                newNode.right = buildTree(nums,mid+1,end);
                newNode.sum = newNode.left.sum + newNode.right.sum;
            }
            return newNode;
       }    
    }
    
    
    
    public void update(int index, int val) {
        updateHelper(root,index,val);
    }
    
    void updateHelper(SegmentTreeNode root, int index, int newValue){
        if(root.start==root.end)
            root.sum=newValue;
        else{
            int mid = root.start + (root.end-root.start)/2;
            if(index<=mid)
                updateHelper(root.left,index,newValue);
            else
                updateHelper(root.right,index,newValue);
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(root,left,right);
    }
    
    int sumRangeHelper(SegmentTreeNode root, int start, int end){
        if(root.start==start && root.end == end)
            return root.sum;
        else{
            int mid = root.start + (root.end - root.start) /2;
            if(end <=mid)
                return sumRangeHelper(root.left,start,end);
            else if(start >=mid+1)
                return sumRangeHelper(root.right,start,end);
            else 
                return sumRangeHelper(root.left,start,mid) + sumRangeHelper(root.right,mid+1,end);
        }
    }
    
}



public class RangeSumQuery_Mutable_1D_307 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
