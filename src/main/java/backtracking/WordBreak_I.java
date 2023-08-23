package backtracking;

import java.util.HashMap;
import java.util.List;

public class WordBreak_I {
	public boolean wordBreak(String s, List<String> wordDict) {
		// For Memoization
		HashMap<String, Boolean> map = new HashMap<>();
		return helper(s, wordDict, map);
	}

	public boolean helper(String target, List<String> wordDict, HashMap<String, Boolean> map) {

		if (map.containsKey(target))
			return map.get(target);

		// If the target lenght is empty, it means we have parsed the string and it is
		// avaliable in the dictionary right
		if (target.isEmpty())
			return true;

		for (String word : wordDict) {

			System.out.println(target);
			if (target.startsWith(word)) {

				if (helper(target.substring(word.length()), wordDict, map)) {
					// System.out.println(target);
					map.put(target, true);
					return true;
				}

			}
		}

		map.put(target, false);
		return false;
	}
}
