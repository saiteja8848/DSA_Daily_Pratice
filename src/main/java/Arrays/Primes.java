package Arrays;

public class Primes {
     public boolean isUgly(int n) {
        // A non-positive integer cannot be ugly
        if (n <= 0) {
            return false;
        }

        // Factorize by dividing with permitted factors
        for (int factor : new int[] { 2, 3, 5 }) {
            n = keepDividingWhenDivisible(n, factor);
        }

        // Check if the integer is reduced to 1 or not.
        return n == 1;
    }

    // Keep dividing dividend by divisor when division is possible.
    private int keepDividingWhenDivisible(int dividend, int divisor) {
        while (dividend % divisor == 0) {
            dividend /= divisor;
        }
        return dividend;
    }


   // Counting primies
       public int countPrimes(int n) {
          if(n==0 || n == 1) return 0;
        
        boolean[] prime = new boolean[n];
        //initialising notPrime with a value 1(counting "1" as not prime)
        int notPrime = 1;
        
        for(int i=2;i*i<n;i++){
            if(prime[i] == false){
                for(int j=i;j*i<n;j++){
                    if(prime[j*i] == false){
                        notPrime++;
                        prime[j*i] = true;
                    }
                }
            }
        }
        return n - notPrime - 1;
    }
     
}
