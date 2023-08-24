package Graphs;

public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int maxArea = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1)
					maxArea = Math.max(maxArea, dfs(i, j, grid));
			}
		}
		return maxArea;
	}

	int dfs(int row, int col, int[][] grid) {

		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] <= 0) {
			return 0;
		}
		grid[row][col] = -1;

		int totalArea = dfs(row + 1, col, grid) + dfs(row - 1, col, grid) + dfs(row, col + 1, grid)
				+ dfs(row, col - 1, grid);
		return totalArea + 1;
	}
}
