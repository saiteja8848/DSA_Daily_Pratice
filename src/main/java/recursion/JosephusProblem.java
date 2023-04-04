package recursion;


/**
 * 
 * https://youtu.be/KJsuIMWvN20
 * @author saiteja
 *
 */

public class JosephusProblem {
	
	static int josephus(int n, int k) {
		if(n==1)
			return 0;
		return (josephus(n-1,k)+k)%n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
