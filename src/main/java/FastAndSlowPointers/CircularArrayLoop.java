package FastAndSlowPointers;

//Problem Link : https://leetcode.com/problems/circular-array-loop/
//Logic: Object moves twice as fast as other
//by the time the faster object moves x distance, slower will move x/2 distance
//Time complexity: O(n), 
//Space complexity: O(1)
public class CircularArrayLoop {

	public boolean circularArrayLoop(int[] arr) {
		if (arr.length <= 1) {
			return false;
		}

		for (int i = 0; i < arr.length; i++) {

			int slow, fast;
			slow = fast = i;
			boolean ifForward = arr[i] > 0;

			while (true) {
				slow = getNextPosition(arr, slow, ifForward);
				if (slow == -1) {
					break;
				}

				fast = getNextPosition(arr, fast, ifForward);
				if (fast == -1) {
					break;
				}

				fast = getNextPosition(arr, fast, ifForward);
				if (fast == -1) {
					break;
				}

				if (slow == fast) {
					return true;
				}
			}
		}

		return false;
	}

	private static int getNextPosition(int[] arr, int index, boolean ifForward) {
		boolean direction = arr[index] >= 0;

		if (direction != ifForward) {
			return -1;
		}

		int nextIndex = (index + arr[index]) % arr.length;

		//In case if starting element is -2, (0thIndex-2)%5=-2, but its wrong it should move right so we need to add arraylength to move backward
		if (nextIndex < 0) {
			nextIndex = nextIndex + arr.length;
		}

		 // this is for negative case if there is only 1 element and that is 1, (0+1)%1=1 going back to same node - nocycle
		if (nextIndex == index) {
			return -1;
		}

		return nextIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
