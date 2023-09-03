package mergeIntervals;

import java.util.Arrays;

public class MinimumArrowsToBurstBallons {
	public int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0) {
			return 0; // No balloons to burst
		}

		// Sort the balloons by their end points
		Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

		int arrows = 1; // Initial arrow position
		int prevEnd = points[0][1]; // End point of the first balloon

		for (int i = 1; i < points.length; i++) {
			int currentStart = points[i][0];
			int currentEnd = points[i][1];

			// If the current balloon doesn't overlap with the previous one,
			// we need a new arrow and update the previous end point
			if (currentStart > prevEnd) {
				arrows++;
				prevEnd = currentEnd;
			}
			// If the current balloon overlaps with the previous one,
			// update the previous end point to the smaller of the two end points
			else {
				prevEnd = Math.min(prevEnd, currentEnd);
			}
		}

		return arrows;
	}
}
