package mergeIntervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


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
	public static int minRooms(int[][] intervals) {
		 if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort the intervals by their start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Create a min heap to keep track of the end times of ongoing meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the end time of the first meeting to the heap
        minHeap.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int earliestEnd = minHeap.peek();

            // If the current meeting can reuse a room (its start time is after the earliest end time),
            // remove the earliest end time from the heap.
            if (currentStart >= earliestEnd) {
                minHeap.poll();
            }

            // Add the end time of the current meeting to the heap
            minHeap.offer(intervals[i][1]);
        }

        // The size of the heap represents the minimum number of meeting rooms required
        return minHeap.size();
	}

	  
}
