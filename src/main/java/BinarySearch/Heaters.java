package BinarySearch;

import java.util.Arrays;

public class Heaters {

	class Solution {
//	    public int findRadius(int[] houses, int[] heaters) {
//	         int res = Integer.MIN_VALUE;
//	         for(int house:houses){
//	             int dis = Integer.MAX_VALUE;
//	             for(int i=0;i<heaters.length;i++){
//	                 dis = Math.min(dis,Math.abs(heaters[i]-house));
//	             }
//	             res = Math.max(res,dis);
//	         }
//	         return res;
//	     }

		public int findRadius(int[] houses, int[] heaters) {
			int i = 0, j = (int) 1e9;
			Arrays.sort(houses);
			Arrays.sort(heaters);
			while (i <= j) {
				int mid = (i + j) / 2;

				if (isPossible(houses, heaters, mid)) {
					j = mid - 1;
				} else {
					i = mid + 1;
				}
			}
			return i;
		}

		private boolean isPossible(int[] houses, int[] heaters, int r) {
			int i = 0, j = 0;
			while (i < houses.length) {
				if (houses[i] < heaters[j] - r) {
					return false;
				}
				if (houses[i] > heaters[j] + r) {
					if (++j == heaters.length) {
						return false;
					}
					i--;
				}
				i++;
			}
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
