package BinarySearch;

public class LowerAndUpperBound {

	public static int lowerBound(int[] arr, int n, int x) {
		int low = 0, high = n - 1;
		int ans = n;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] >= x) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1; // look on the right
			}
		}
		return ans;
	}

	public static int upperBound(int[] arr, int x, int n) {
		int low = 0, high = n - 1;
		int ans = n;

		while (low <= high) {
			int mid = (low + high) / 2;
			// maybe an answer
			if (arr[mid] > x) {
				ans = mid;
				// look for smaller index on the left
				high = mid - 1;
			} else {
				low = mid + 1; // look on the right
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
