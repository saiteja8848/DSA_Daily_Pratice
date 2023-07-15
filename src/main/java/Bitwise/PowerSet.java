package Bitwise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {

	public List<String> AllPossibleStrings(String s) {
		long pow_set_size = (long) Math.pow(2, s.length());
		int counter, j;
		List<String> ans = new ArrayList<>();
		for (counter = 0; counter < pow_set_size; counter++) {
			String str = "";
			for (j = 0; j < s.length(); j++) {
				if ((counter & (1 << j)) > 0)
					str = str + s.charAt(j);
			}
			if (str != "")
				ans.add(str);
		}
		Collections.sort(ans);
		return ans;
	}

}
