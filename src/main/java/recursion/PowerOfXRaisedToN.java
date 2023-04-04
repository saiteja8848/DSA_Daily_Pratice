package recursion;

public class PowerOfXRaisedToN {

	public double myPow(double base, int exponent) {
		long power = Math.abs((long) exponent);
		double ans = 1;
		while (power > 0) {
			// check whether power is odd or not
			if ((power & 1) == 1)
				ans = ans * base;
			base = base * base;

			// divide by power by 2
			power >>= 1;
		}

		return exponent < 0 ? 1 / ans : ans;
	}

//	     public double myPow(double base, int exponent) {
//	         return myPow(base, 1L*exponent);
//	     }

//	     double myPow(double base, long exponent){
//	           //reduce the exponent by half, and increase the base by self 1
//	         if(exponent==0)
//	             return 1;

//	         if(exponent<0)
//	             return myPow(1/base,-exponent);

//	         return exponent%2==0 ? myPow(base*base,exponent/2) : base * myPow(base*base, exponent/2);
//	     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
