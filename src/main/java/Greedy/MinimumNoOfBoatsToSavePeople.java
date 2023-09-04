package Greedy;

import java.util.Arrays;

public class MinimumNoOfBoatsToSavePeople {

  public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while(left <= right){
             left = (people[left] + people[right])<=limit? left+1: left;
             boatCount++;
             right--;
        }
        return boatCount;
    }

}
