package Bitwise;

import java.util.ArrayList;
import java.util.List;

public class Swap2Numbers {

	static List<Integer> get(int a, int b) {
		// code here
		a = a + b;
		b = a - b;
		a = a - b;
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(a);
		ans.add(b);
		return ans;
	}

	static List<Integer> get11(int a, int b) {
		// code here
		List<Integer> li = new ArrayList<>();
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		li.add(a);
		li.add(b);
		return li;
	}

}
