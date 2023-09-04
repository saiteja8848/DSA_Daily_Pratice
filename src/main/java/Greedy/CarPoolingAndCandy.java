package Greedy;

public class CarPoolingAndCandy {
  
    
    public int candy(int[] ratings) {
    int n = ratings.length;
    if (n == 0) return 0;
    
    int[] candies = new int[n];
    Arrays.fill(candies, 1);
    
    // Scan from left to right
    for (int i = 1; i < n; i++) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1;
        }
    }
    
    int totalCandies = candies[n - 1];
    
    // Scan from right to left and adjust candies
    for (int i = n - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
        totalCandies += candies[i];
    }
    
    return totalCandies;
}


    // public boolean carPooling(int[][] trips, int capacity) {
// 	 Arrays.sort(trips, (a,b) -> a[1]-b[1]);  // sort array from start time in ascending order
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);  // sort PriorityQueue from end time in ascending order.
        
//         for(int[] trip : trips) {
//             while(!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
//                 capacity += pq.poll()[0];
//             }
//             pq.offer(trip);
//             capacity -= trip[0];
//             if(capacity < 0)
//                 return false;
//         }
        
//         return true;
// }


public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];
        
        for(int[] trip : trips){
            stops[trip[1]] += trip[0];
            stops[trip[2]] -= trip[0];
        }
        
        int passengerCount = 0;
        for(int val: stops){
            passengerCount += val;
            if(passengerCount > capacity){
                return false;
            }
        }
        
        return true;
    }
}
