package BinarySearch;

public class HIndex_II {

	// public int hIndex(int[] citations) {
	// int n = citations.length;
	// int[] count = new int[n+1];
	// for(int i=0;i<n;i++){
	// if(citations[i]>=n)
	// count[n]++;
	// else
	// count[citations[i]]++;
	// }
	// int pages=0;
	// for(int i=n;i>=0;i--){
	// pages+=count[i];
	// if(pages>=i)
	// return i;
	// }
	// return 0;
	// }

	public int hIndex(int[] citations) {
		int left = 0;
		int right = citations.length - 1;
		int n = citations.length;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int expectedCount = n - mid;
			if (citations[mid] == expectedCount)
				return n - mid;
			else if (citations[mid] < expectedCount)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return n - left;

	}

}
