package mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
	 public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> out = new ArrayList<>();
        int i = 0;
        
        /*
        Step 1.
        Add all intervals before newInterval (that don't overlap with newInterval so just 1 in this case
            1.    2.     3.     4.      5  
          ----- ------- ---- -------- ------
                    -------------        
         */
        while( i<intervals.length && intervals[i][1] < newInterval[0] ){
            out.add(intervals[i++]);
        }
        
        // 
        /*
        Step 2.
        Now i is at an interval that we merge with OR that we don't merge with (case B)
        Case A.
            1.    2.     3.     4.      5  
          ----- ------- ---- -------- ------
                    -------------   

        Case B.
            1.                          2.  
          -----                       ------
                    -------------   
                    
        "intervals[i][0] <= newInterval[1]" below means if the current interval's start is before or 
		at the newIntervals end, it should be part of the merge interval. Look at the diagram,
		in case A it is easy to see 4. is the last interval we take. In case B. there are no intervals so the while never loops
         */
        while( i<intervals.length && intervals[i][0] <= newInterval[1] ){
            newInterval[0] = Math.min( newInterval[0], intervals[i][0] ); 
            newInterval[1] = Math.max( newInterval[1], intervals[i][1] ); 
            i++;
        }
        
		// Add the insert interval
        out.add(newInterval);
        
        // Step 3. Add all of the intervals that come after the inserted interval if any
        while( i<intervals.length ){
            out.add(intervals[i++]);
        }
        
        return out.toArray(new int[out.size()][2]);
    }
}
