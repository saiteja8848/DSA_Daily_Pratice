package SlidingWindow_Variable;

import java.util.Collections;
import java.util.PriorityQueue;


// https://leetcode.com/problems/sliding-window-median/description/

class Solution {
    
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new double[0];
        int len=nums.length;
        double[] result = new double[len-k+1];
        for(int i=0;i<len;i++){
            addToHeap(nums[i]);
            if(i-k+1>=0){
                result[i-k+1]=findMedian();
                removeFromHeap(nums[i-k+1]);
            }
        }
        return result;   
    }
    
    private void addToHeap(int num){
        if (maxHeap.size() == 0 || maxHeap.peek() >= num) 
            maxHeap.add(num);
        else 
            minHeap.add(num);
        rebalanceHeaps();
    }

	// This method removes the first element in the sliding window from the appropriate heap and rebalances the heaps
    private void removeFromHeap(int num){
        if (num > maxHeap.peek())
            minHeap.remove(num);
        else 
            maxHeap.remove(num);
        rebalanceHeaps();
    }    
    
	// This method keeps the height of the 2 heaps same
    private void rebalanceHeaps(){
        if (maxHeap.size() == minHeap.size())
            return;
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());        
    }
    
     private double findMedian(){
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
    }
    
    
}


public class Sliding_Window_Median {

	public static void main(String[] args) {
	}

}
