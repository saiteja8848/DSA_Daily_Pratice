package SegmentTrees;


/*
PrefixSum Problem : O(1)
Calculate PrefixSum
Apply rangeSumFormular PrefixSum[end]-prefixSum[start-1], where end/start are inclusive
https://leetcode.com/problems/range-sum-query-immutable/

*/


class NumArrayA { 
  int[] preSum;
  public NumArrayA(int[] nums) {
      preSum = nums; 
      for (int i = 1; i < preSum.length; ++i)
          preSum[i] += preSum[i-1]; 
  }
  
  public int sumRange(int left, int right) {
      //edge case when sum(0,1) return sum[1], because 0-1=-1
      if (left == 0) 
          return preSum[right];
      return preSum[right] - preSum[left-1];
  }
}
/**
* Your NumArray object will be instantiated and called as such:
* NumArray obj = new NumArray(nums);
* int param_1 = obj.sumRange(left,right);
*/



public class RangeSumQuery_Immutable_1D_303 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
