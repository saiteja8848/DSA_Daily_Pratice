package Bitwise;

public class PowerOf2OrNot {

	static boolean isPowerofTwo(int n) {
		int cnt = 0;
		while (n > 0) {
			if ((n & 1) == 1) {
				cnt++; // if n&1 == 1 keep incrementing cnt
				// variable
			}
			n = n >> 1; // keep dividing n by 2 using right
						// shift operator
		}
		if (cnt == 1) {
			// if cnt = 1 only then it is power of 2
			return true;
		}
		return false;
	}

	public static boolean isPowerofTwo(long n) {

		// Your code here
		if (n <= 0) {
			return false;
		}
		return (n & (n - 1)) == 0;

	}

}
