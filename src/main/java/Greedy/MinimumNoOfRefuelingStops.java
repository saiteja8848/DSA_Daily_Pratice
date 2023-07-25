package Greedy;

import java.util.PriorityQueue;

public class MinimumNoOfRefuelingStops {

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int currentFeul = startFuel;
		int numOfStationsRefueled = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
		// As a greed approach always wanted to reach farthest and fill out with max gas
		// check each and every station - whether we are gng to make it or not if not
		// refuel it
		for (int[] station : stations) {
			int nextStation = station[0];
			int fuelCapacity = station[1];
			while (currentFeul < nextStation) {
				if (queue.isEmpty())
					return -1;
				currentFeul += queue.poll();
				numOfStationsRefueled++;
			}
			queue.add(fuelCapacity);
		}

		while (currentFeul < target) {
			if (queue.isEmpty())
				return -1;
			currentFeul += queue.poll();
			numOfStationsRefueled++;
		}
		return numOfStationsRefueled;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
