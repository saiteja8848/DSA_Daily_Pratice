package Arrays;

public class FactorialTrailingZeros {
	public int trailingZeroes(int n) {
		int count = 0;
		while (n != 0) {
			int tmp = n / 5;
			count += tmp;
			n = tmp;
		}
		return count;
	}
}
