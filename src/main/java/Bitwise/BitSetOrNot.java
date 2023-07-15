package Bitwise;

public class BitSetOrNot {
	
	/**
	 * TC:SC:O(1)
	 * @param n
	 * @param k
	 * @return
	 */

	public Boolean checkKthBit(int n, int k) {

		// return (n&(1<<k))==1<<k;
		// return (n & (1 << k)) != 0;

		return ((n >> k) & 1) != 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
