package Greedy;

public class CarPoolingAndCandy {
  
    public int candy(int[] ratings) {
          int n =  ratings.length;
        if(n==0)
            return 0;
        int left[] = new int[n];
        Arrays.fill(left,1);
        for(int i=1;i<n;i++)
        {
            if(ratings[i] > ratings[i-1])
                left[i] = left[i-1]+1;
        }
        int right=1;
        int ans = left[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i] > ratings[i+1]){
                right++;
                  left[i] = Math.max(right,left[i]);
            }
              
            else
              right=1;
            
            ans += left[i];
        }
 
        return ans;
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
