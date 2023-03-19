package SlidingWindow_Fixed;

//https://leetcode.com/problems/find-the-k-beauty-of-a-number/
public class FindTheKBeautyOFANumber {

	public int divisorSubstrings(int num, int k) {
		String s = String.valueOf(num);
		int count = 0;
		for (int i = 0; i <= s.length() - k; i++) {
			int number = Integer.parseInt(s.substring(i, i + k));
			if (number > 0 && num % number == 0) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
