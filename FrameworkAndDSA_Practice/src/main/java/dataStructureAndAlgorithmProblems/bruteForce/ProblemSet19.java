package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;
import org.junit.Assert;

public class ProblemSet19 {
	
	/*
	 * Sign of the Product of an Array - https://leetcode.com/problems/sign-of-the-product-of-an-array/
	 */
	
	@Test
	public void test1() {
		int result = arraySign(new int[] {-1,-2,-3,-4,3,2,1});
		System.out.println(result);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void test2() {
		int result = arraySign(new int[] {1,5,0,2,-3});
		System.out.println(result);
		Assert.assertEquals(0, result);
	}
	
	@Test
	public void test3() {
		int result = arraySign(new int[] {-1,1,-1,1,-1});
		System.out.println(result);
		Assert.assertEquals(-1, result);
	}
	
	
	public int arraySign(int[] nums) {
		long product = 1;
		for (int i = 0; i < nums.length; i++) {
			product = product * nums[i];
		}
		return signFunc(product);
	}
	
	
	public int signFunc(long num) {
		if (num>0) {
			return 1;
		}else if (num < 0) {
			return -1;
		}else
			return 0;
	}
}
