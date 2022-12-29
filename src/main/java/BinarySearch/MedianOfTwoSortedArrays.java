package BinarySearch;



/**
 * 
 * 
 * Problem Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Video Solution: https://youtu.be/NTop3VTjmxk
 * 
 * */

public class MedianOfTwoSortedArrays {
	
	
	//Approach 1 : O(m+n)TC, O(m+n)Space
	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
	       int total = nums1.length+nums2.length;
	     int i=0,j=0,k=0;
	     int[] result = new int[total]; 
	      
	        while(k<total)
	        {
	            if(j==nums2.length ||(i<nums1.length&&nums1[i]<=nums2[j])){
	                result[k++]=nums1[i++];
	            }
	            else 
	             if(i==nums1.length ||(j<nums2.length&&nums2[j]<nums1[i])){
	                result[k++]=nums2[j++];
	            }
	        }    
	        return (total%2==0) ?((result[total/2]+result[total/2-1])/2.0):result[total/2]; 
	    }
	
	
	//Optimized Solution OLog(m+n)TC, Space :O(1)
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        return median(nums1,nums2,nums1.length,nums2.length);
	    }
	    
	    double median(int arr1[],int arr2[],int m,int n) {
	    if(m>n)
	        return median(arr2,arr1,n,m);//ensuring that binary search happens on minimum size array
	        
	    int low=0,high=m,medianPos=((m+n)+1)/2;
	    while(low<=high) {
	        int cut1 = (low+high)>>1;
	        int cut2 = medianPos - cut1;
	        
	        int l1 = (cut1 == 0)? Integer.MIN_VALUE:arr1[cut1-1];
	        int l2 = (cut2 == 0)? Integer.MIN_VALUE:arr2[cut2-1];
	        int r1 = (cut1 == m)? Integer.MAX_VALUE:arr1[cut1];
	        int r2 = (cut2 == n)? Integer.MAX_VALUE:arr2[cut2];
	        
	        if(l1<=r2 && l2<=r1) {
	            if((m+n)%2 != 0)
	                return Math.max(l1,l2);
	            else 
	                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
	        }
	        else if(l1>r2) high = cut1-1;
	        else low = cut1+1;
	    }
	    return 0.0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
