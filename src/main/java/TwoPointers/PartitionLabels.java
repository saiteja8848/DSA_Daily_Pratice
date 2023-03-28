package TwoPointers;

import java.util.ArrayList;
import java.util.List;



/**
 * 
 * 
 * @author saiteja 
 * https://leetcode.com/problems/partition-labels
 *
 */


public class PartitionLabels {

	public List<Integer> partitionLabels(String s) {

		int[] lastIndex = new int[26];
		for (int i = 0; i < s.length(); i++)
			lastIndex[s.charAt(i) - 'a'] = i;

		List<Integer> ans = new ArrayList<>();
		int leftPtr = 0;

		int previousCutPoint = 0;

		for (int rightPtr = 0; rightPtr < s.length(); ++rightPtr) {

			leftPtr = Math.max(leftPtr, lastIndex[s.charAt(rightPtr) - 'a']);

			if (rightPtr == leftPtr) {
				ans.add(rightPtr - previousCutPoint + 1);
				previousCutPoint = rightPtr + 1;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
	}
}
