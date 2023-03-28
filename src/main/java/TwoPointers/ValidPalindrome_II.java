package TwoPointers;

/*8
 * 
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 */

public class ValidPalindrome_II {

	public boolean validPalindrome(String s) {
		return isValidPalindrome(s, 0, s.length() - 1, false);
	}

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
