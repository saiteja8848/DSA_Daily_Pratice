package BinarySearch;

class Solution {
	// Approach 1: sorting - TC: O(NlogN) and space complexity : O(n)
	// public int kthSmallest(int[][] matrix, int k) {
	// int n = matrix.length;
	// int [] arr = new int[n*n];
	// int idx = 0;
	// for(int i = 0;i<n;i++){
	// for(int j = 0;j<n;j++){
	// arr[idx++] = matrix[i][j];
	// }
	// }
	// Arrays.sort(arr);
	// return arr[k - 1];
	// }

	// Approach 2: PriorityQueue - maxHeap maitains the largest number on top
	// TC : O(n^2logk) and SC: O(k)
	// public int kthSmallest(int[][] matrix, int k) {
	// int n = matrix.length+matrix[0].length;
	// PriorityQueue<Integer> pq = new
	// PriorityQueue<Integer>(Collections.reverseOrder());
	// for(int i=0;i<matrix.length;i++)
	// for(int j=0;j<matrix[0].length;j++)
	// {

	// pq.add(matrix[i][j]);
	// if(pq.size()>k)
	// pq.poll();

	// }
	// return pq.poll();
	// }

	public int kthSmallest(int[][] matrix, int k) {
		// Step 1: sorted, so take the search space
		int row = matrix.length, col = matrix[0].length;
		int low = matrix[0][0];
		int high = matrix[row - 1][col - 1];
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (getCountOfNumbersLessThanMid(matrix, mid, row, col) < k) {
				low = mid + 1;
				// System.out.println("mid="+mid+"
				// count="+getCountOfNumbersLessThanMid(matrix,mid,row,col));
			} else
				high = mid - 1;
		}
		return low;
	}

	public int getCountOfNumbersLessThanMid(int[][] matrix, int mid, int row, int col) {
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = col - 1; j >= 0; j--) {
				if (matrix[i][j] <= mid) {
					count = count + (j + 1);
					break;
				}
			}
		}
		return count;
	}
}

public class KthSmallestElementInASortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
