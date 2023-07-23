package Strings;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s.isEmpty()) {
			return true;
		}

		int leftPtr = 0;
		int rightPtr = s.length() - 1;

		while (leftPtr < rightPtr) {
			char a = s.charAt(leftPtr);
			char b = s.charAt(rightPtr);

			// if it is not a character, move forward
			if (!Character.isLetterOrDigit(a))
				leftPtr++;
			else if (!Character.isLetterOrDigit(b))
				rightPtr--;
			else {
				if (Character.toLowerCase(a) != Character.toLowerCase(b))
					return false;
				leftPtr++;
				rightPtr--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
