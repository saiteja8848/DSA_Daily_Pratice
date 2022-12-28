package com.teja.leetcode.graphs;

/*
 * 
 * 
 * https://leetcode.com/problems/number-of-islands/description/
 * */


public class NumberOfIslands {

	private int rows;
	private int cols;

	public int numIslands(char[][] grid) {

		if (grid == null)
			return 0;
		if (grid.length == 0)
			return 0;

		int result = 0;
		this.rows = grid.length;
		this.cols = grid[0].length;

		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				if (grid[x][y] == '1') {
					result++;
					depth_first_search(grid, x, y);
				}

			}
		}

		return result;

	}

	private void depth_first_search(char[][] grid, int x, int y) {

		// it checks whether rowwise, we are inbound or not
		if (x < 0 || x >= rows)
			return;

		// it checks colum wise, whether we are inbound or not
		if (y < 0 || y >= cols)
			return;

		// if already visited 'v' or there is no path '0' simply return we cann't
		// proceed further as there is no path
		if (grid[x][y] == '0' || grid[x][y] == 'v')
			return;

		// mark every visted node as 'v' if not met with above conditions
		grid[x][y] = 'v';

		depth_first_search(grid, x + 1, y);

		depth_first_search(grid, x - 1, y);

		depth_first_search(grid, x, y + 1);

		depth_first_search(grid, x, y - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
