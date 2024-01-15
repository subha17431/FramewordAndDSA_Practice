package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;
import org.junit.Assert;

public class ProblemSet18 {

	
	/*
	 * https://leetcode.com/problems/alternating-digit-sum/description/ - Alternating Digit Sum
	 */
	@Test
	public void test1() {
		int sum = alternateDigitSum(521);
		System.out.println("Sum of all digits with their corresponding sign is "+sum);
		Assert.assertEquals(4, sum);
	}


	@Test
	public void test2() {
		int sum = alternateDigitSum(111);
		System.out.println("Sum of all digits with their corresponding sign is "+sum);
		Assert.assertEquals(1, sum);
	}


	@Test
	public void test3() {
		int sum = alternateDigitSum(886996);
		System.out.println("Sum of all digits with their corresponding sign is "+sum);
		Assert.assertEquals(0, sum);
	}


	public int alternateDigitSum(int n) {
		int sum = 0;
		String num = String.valueOf(n);
		for (int i = 0; i < num.length(); i++) {
			if (i%2 == 0) {
				sum = sum + Integer.valueOf(num.charAt(i) - '0');
			} else
				sum = sum + (-1*Integer.valueOf(num.charAt(i) - '0'));
		}
		return sum;
	}
}
