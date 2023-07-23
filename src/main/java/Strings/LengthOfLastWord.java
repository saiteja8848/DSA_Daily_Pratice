package Strings;

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		int start;
		int end = s.length() - 1;
		for (start = end; start >= 0; start--) {
			if (s.charAt(start) == ' ' && s.charAt(end) == ' ') {
				end--;
				continue;
			}
			if (s.charAt(start) == ' ')
				break;
		}
		return end - start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
