package SlidingWindow_Fixed;
//http://lixinchengdu.github.io/algorithmbook/leetcode/prime-arrangements.html
public class DietPlanPerformance {
	
	  int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
	        int calorie = 0;
	        int score = 0;
	        for (int i = 0; i < k - 1; ++i) {
	            calorie += calories[i];
	        }

	        for (int i = k - 1; i < calories.length; ++i) {
	            calorie += calories[i];
	            if (calorie < lower) {
	                score -= 1;
	            } else if (calorie > upper) {
	                score += 1;
	            } 
	            calorie -= calories[i - k + 1];
	        }

	        return score;
	    }

	public static void main(String[] args) {
	}

}
