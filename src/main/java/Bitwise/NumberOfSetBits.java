package Bitwise;

public class NumberOfSetBits {

	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;

		// int c=0;
		// for(int i=0;i<32;i++){
		// if(((n>>i) & 1)!=0)
		// c++;
		// }
		// return c;
	}
	// TC : O(1) or O(no of set bits)

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
