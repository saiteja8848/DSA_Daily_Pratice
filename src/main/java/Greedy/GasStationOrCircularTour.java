package Greedy;

public class GasStationOrCircularTour {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalGas = 0;
		int totalCost = 0;
		for (int i = 0; i < gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
		}

		if (totalGas < totalCost)
			return -1;

		// where to start
		int remainingGas = 0;
		int start = 0;

		for (int i = 0; i < gas.length; i++) {
			remainingGas += gas[i] - cost[i];
			if (remainingGas < 0) {
				start = i + 1;
				remainingGas = 0;
			}
		}

		return start;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
