package mergeIntervals;

public class Non_overlappingInterval {


   Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
        
        
        int prevEnd = intervals[0][1];
        int count=0;
        for(int i=1;i<intervals.length;i++){
        
            //if not overlapping ex: [1,3] [4,5];
            if(intervals[i][0]>=prevEnd){
                prevEnd = intervals[i][1];
            }else{
                count=count+1;
                prevEnd = Math.min(prevEnd,intervals[i][1]);
            }
            
        }
        return count;

}
