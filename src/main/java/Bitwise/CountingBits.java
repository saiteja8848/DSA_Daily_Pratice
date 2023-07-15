package Bitwise;

public class CountingBits {

	public int[] countBits(int n) {
		int[] solution = new int[n + 1];
		solution[0] = 0;
		for (int i = 1; i <= n; i++)
			solution[i] = solution[i / 2] + i % 2;
		return solution;
	}

}
