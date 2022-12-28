package com.teja.leetcode.segementTrees;



/*

Video Solution : https://youtu.be/aAA8ymRAZy8

 Brute Force : Iterate over given m rows  * n colums for every query
 i. e : (m*n) * q 
 
 PrefixSum 2D: Iterate over m rows and apply the rangePrefixSum Formula and add them up
 which is like O(m*n ) for prefixSum once and O(m * q) for query querys
 
 Next Appoarach : O(1) for getting prefixSum
 O(m*n ) for preprocessing 
 
 means, we try to think of every matrix corners, 
 currentCell + justBeforeRowCellSum + justAsideColSumCell - repeated starting cellSum

*/



class NumMatrix {
	private int[][] dp;

	public NumMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		dp = new int[matrix.length + 1][matrix[0].length + 1];

		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	}
}



public class RangeSumQuery_Immutable_2D_304 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
