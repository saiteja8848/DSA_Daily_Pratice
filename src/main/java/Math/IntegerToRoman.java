package Math;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * 
 * Leetcode Link : https://leetcode.com/problems/integer-to-roman/description/
 * 
 * */


public class IntegerToRoman {

	public String intToRoman(int num) {
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("M", 1000); // After 1000
		map.put("CM", 900); // newly added(1)
		map.put("D", 500); // after 500
		map.put("CD", 400); // newly added(2)
		map.put("C", 100); // after 100
		map.put("XC", 90); // newly added(3)
		map.put("L", 50); // after 50
		map.put("XL", 40); // newly added(4)
		map.put("X", 10); // after 10
		map.put("IX", 9); // newly added(5)
		map.put("V", 5); // after 5
		map.put("IV", 4); // newly added(6)
		map.put("I", 1);
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			/*
			 * it is nothing but the division where num is a divident and entry.getValue is
			 * a divisor and remainder will be new Num
			 */
			while (num >= entry.getValue()) {
				num -= entry.getValue();
				sb.append(entry.getKey());
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
