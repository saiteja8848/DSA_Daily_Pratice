package mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	  public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        
        if(nums==null || nums.length==0)
            return result;
        
        int start=0, end=0, n=nums.length;
        for(int i=0;i<n;i++){
            if(i+1<n && nums[i+1]-nums[i]==1)
                end++;
            else {
                 result.add(start==end ?nums[end]+"": nums[start]+"->"+nums[end]);
                end++;
                start=end;
            }
           
        }
        return result;
    }
}
