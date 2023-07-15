package Bitwise;

public class AddBinary {

	public String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();
		int carry = 0;
		int i = a.length() - 1, j = b.length() - 1;

		// we have start from lsb to msb (right to left)
		while (i >= 0 || j >= 0) {

			carry += i >= 0 ? a.charAt(i--) - '0' : 0;
			carry += j >= 0 ? b.charAt(j--) - '0' : 0;
			// 1+1=2, 1+1=10(here carry is 1, result is 0) 2%2=0(sum), 2/2=1(carry)
			result.insert(0, carry % 2);
			carry = carry / 2;
		}

		// need to care of leftover carry as well, if it 0, then fine else we need to
		// add to solu
		if (carry == 1)
			result.insert(0, carry);

		return result.toString();
	}
}
