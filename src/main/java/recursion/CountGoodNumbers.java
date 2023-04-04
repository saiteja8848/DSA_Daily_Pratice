package recursion;

public class CountGoodNumbers {

	// This is the mod value given in question.
	public long mod = 1000000007;

	public int countGoodNumbers(long n) {

		// Indexing is 0 based according to the question.
		long odd = n / 2; // It gives the number of odd indices starting from 1 to n.
		long even = (n + 1) / 2; // It gives number of even indices. It is basically n/2 + n%2;
		return (int) (pow(5, even) * pow(4, odd) % mod); // As there are 4 prime numbers and 5 even numbers
															// from 0 to 9.

	}

	// To understand this pow function properly you can solve leetcode problem 50
	// where you will have to contruct it. I will attach the link above.
	public long pow(long x, long n) {
		if (n == 0)
			return 1;
		long temp = pow(x, n / 2);
		if (n % 2 == 0) {
			return (temp * temp) % mod;
		} else {
			return (x * temp * temp) % mod;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
