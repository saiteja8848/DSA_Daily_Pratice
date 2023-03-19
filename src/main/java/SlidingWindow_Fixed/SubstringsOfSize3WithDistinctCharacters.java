package SlidingWindow_Fixed;

public class SubstringsOfSize3WithDistinctCharacters {

	public int countGoodSubstrings(String s) {
		int l = s.length();
		int i = 0, j = 0, k = 3, count = 0;
		while (j < l) {
			if (j - i + 1 < k)
				j++;
			else if (j - i + 1 == k) {
				if (s.charAt(i) != s.charAt(j) && s.charAt(j) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 1))
					count++;
				i++;
				j++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
	}

}
