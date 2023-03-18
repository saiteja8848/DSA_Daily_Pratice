package FastAndSlowPointers;



//Problem Link : https://leetcode.com/problems/happy-number
//Logic: Object moves twice as fast as other
//by the time the faster object moves x distance, slower will move x/2 distance
//Time complexity: , 
//Space complexity: O(1)

public class HappyNumber {

	public boolean isHappy1(int n) { 
		int s = n, f = n; // slow , fast

		do {
			s = compute(s); // slow computes only once
			f = compute(compute(f)); // fast computes 2 times

			if (s == 1)
				return true; // if we found 1 then happy indeed !!!
		} while (s != f); // else at some point they will meet in the cycle

		return false; // it's a cycle , not happy at all !!!
	}

	public int compute(int n) {
		int s = 0;
		while (n != 0) {
			s += (n % 10) * (n % 10);
			n = n / 10;
		}
		return s;
	}

	public boolean isHappy(int n) {
		if (n < 1)
			return false;
		while (true) {
			n = helper(n);
			if (n == 1 || n == 7)
				return true;
			if (n < 10)
				return false;
		}
	}

	public int helper(int n) {
		int sum = 0;
		while (n != 0) {
			int rem = n % 10;
			sum += rem * rem;
			n /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
