package Graphs;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor)
			return image;
		changeColor(image, sr, sc, image[sr][sc], newColor);
		return image;
	}

	public void changeColor(int[][] image, int sr, int sc, int color, int newColor) {

		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color)
			return;
		image[sr][sc] = newColor;
		changeColor(image, sr - 1, sc, color, newColor);
		changeColor(image, sr + 1, sc, color, newColor);
		changeColor(image, sr, sc - 1, color, newColor);
		changeColor(image, sr, sc + 1, color, newColor);
	}
}
