package Strings;

public class ValidPalindromeII {

	boolean isValidPalindrome(String s, int left, int right, boolean isCharacterDeleted) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				if (isCharacterDeleted)
					return false;
				return isValidPalindrome(s, left + 1, right, true) || isValidPalindrome(s, left, right - 1, true);
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
