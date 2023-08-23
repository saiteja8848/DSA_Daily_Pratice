package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak_II {
	Map<String, List<String>> mem = new HashMap<>();

	public List<String> wordBreak(String s, List<String> wordDict) {

		if (mem.get(s) != null)
			return mem.get(s);

		List<String> result = new ArrayList<>();

		if (wordDict.contains(s))
			result.add(s);

		for (int i = 1; i < s.length(); i++) {
			String word = s.substring(0, i);
			if (wordDict.contains(word)) {
				List<String> tmp = wordBreak(s.substring(i), wordDict);
				for (String str : tmp) {
					result.add(word + " " + str);
				}
			}
		}
		mem.put(s, result);
		return result;

	}
}
