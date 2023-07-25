package Greedy;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

	public int distributeCandies(int[] candyType) {
		Set<Integer> candyTypes = new HashSet<>();
		for (int candy : candyType) {
			candyTypes.add(candy);
		}

		return (candyTypes.size() >= candyType.length / 2) ? candyType.length / 2 : candyTypes.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
