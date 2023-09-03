package mergeIntervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Interval {
	int start;
	int end;
	
}
public class MeetingRooms {
	  public boolean canAttendMeetings(List<Interval> intervals) {
	        Collections.sort(intervals, new Comparator<Interval>() {
	            public int compare(Interval i1, Interval i2) {
	                return i1.start - i2.start;
	            }
	        });

	        for (int i = 0; i < intervals.size() - 1; i++) {
	        if (intervals.get(i).end > intervals.get(i+1).start)
	            return false;
	        }
	        return true;
	    }
	  
	  
	  /**
	     * @param intervals: an array of meeting time intervals
	     * @return: the minimum number of conference rooms required
	     */
	    public int minMeetingRooms(List<Interval> intervals) {
	        // Write your code here
	        int len = intervals.size();
	        int[] start = new int[len];
	        int[] end = new int[len];
	        for(int i=0;i<len;i++){
	            start[i]=intervals.get(i).start;
	            end[i]=intervals.get(i).end;
	        }

	        Arrays.sort(start);
	        Arrays.sort(end);

	        int i=0,j=0,res=0,count=0;
	        while(i<len){
	           if(start[i]<end[j]){
	               i++;
	               count++;
	           }else{
	               j++;
	               count--;
	           }
	           res = Math.max(res,count); 
	        }

	      return res;
	    }  
	  
}
