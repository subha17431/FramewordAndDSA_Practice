package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;
import org.junit.Assert;

public class ProblemSet20 {

	/*
	 * Average Value of Even Numbers That Are Divisible by Three - 
	 */

	@Test
	public void test1() {
		int avg = averageValue(new int[] {1,3,6,10,12,15});
		System.out.println(avg);
		Assert.assertEquals(9, avg);
	}

	@Test
	public void test2() {
		int avg = averageValue(new int[] {1,2,4,7,10});
		System.out.println(avg);
		Assert.assertEquals(0, avg);
	}


	public int averageValue(int[] nums) {
		int sum = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]%2==0 && nums[i]%3==0) {
				sum = sum + nums[i];
				count++;
			}
		}
		if (sum == 0) {
			return 0;
		}else
			return sum/count;
	}

}
