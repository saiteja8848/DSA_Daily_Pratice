package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestFromArray {

	public String largestNumber(int[] nums) {

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < nums.length; i++) {
			list.add(String.valueOf(nums[i]));
		}

		// S, we are sorting things based on the this core logic
		// [1,2] -> AB=12, BA=21, is BA>AB(21>12) then make a swap b/w A and B

		Collections.sort(list, new Comparator<String>() {
			public int compare(String A, String B) {
				String AB = A + B;
				String BA = B + A;
				return AB.compareTo(BA) > 0 ? -1 : 1;
			}
		});

		// Now we have a sorted array, Then merge all the number into One String
		String res = "";
		for (String s : list) {
			res += s;
		}

		// [0,0], we will get as 00, so just return 0 for this case
		if (res.charAt(0) == '0')
			return "0";

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
