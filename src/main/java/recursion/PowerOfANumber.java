package recursion;

public class PowerOfANumber {

	public boolean isPowerOfThree(int n) {
		return checkIsPowerOf3(n);
	}

	boolean checkIsPowerOf3(int n) {
		if (n == 3 || n == 1)
			return true;

		if (n < 1)
			return false;

		if (n % 3 == 0)
			return checkIsPowerOf3(n / 3);

		return false;
	}

	public boolean isPowerOfTwo(int n) {
		return checkPowerOfTwo(n);
	}

	public boolean checkPowerOfTwo(int n) {
		if (n == 1 || n == 2)
			return true;

		if (n < 1)
			return false;

		if (n % 2 == 0)
			return checkPowerOfTwo(n / 2);

		return false;
	}

	public boolean isPowerOfFour(int n) {
		return checkPowerOfFour(n);
	}

	boolean checkPowerOfFour(int n) {
		if (n == 1 || n == 4)
			return true;

		if (n < 1)
			return false;

		if (n % 4 == 0)
			return checkPowerOfFour(n / 4);

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
