package Bitwise;

public class DecimalToBinaryConversion {

	public void decToBinary(int n) {
		// Size of an integer is assumed to be 32 bits
		for (int i = 31; i >= 0; i--) {
			int k = n >> i;
			if ((k & 1) > 0)
				System.out.print("1");
			else
				System.out.print("0");
		}
	}

	static void toBinary(int N) {
		String s = "";
		int rem;
		while (N != 0) {
			rem = N % 2;
			s = rem + s + "";
			N = N / 2;
		}
		System.out.print(s);
	}

	static void decToBinary11(int n) {
		// array to store binary number
		int[] binaryNum = new int[32];

		// counter for binary array
		int i = 0;
		while (n > 0) {
			// storing remainder in binary array
			binaryNum[i] = n % 2;
			n = n / 2;
			i++;
		}

		// printing binary array in reverse order
		for (int j = i - 1; j >= 0; j--)
			System.out.print(binaryNum[j]);
	}

	public void decToBinary12(int n) {
		// Size of an integer is assumed to be 32 bits
		for (int i = 31; i >= 0; i--) {
			int k = n >> i;
			if ((k & 1) > 0)
				System.out.print("1");
			else
				System.out.print("0");
		}
	}

	public static void main(String[] args) {
	}

}
