package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;
import org.junit.Assert;

public class ProblemSet21 {
	
	
	/*
	 * Three Divisors - https://leetcode.com/problems/three-divisors/
	 */
	
	
	@Test
	public void test1( ) {
		Assert.assertEquals(false, isTHree(2));
	}
	
	@Test
	public void test2( ) {
		Assert.assertEquals(true, isTHree(9));
	}
	
	@Test
	public void test3( ) {
		Assert.assertEquals(false, isTHree(250));
	}
	
	
	public boolean isTHree(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n%i==0) {
				count++;
			}
			if (count>3) {
				return false;
			}
		}
		if (count == 3) {
			return true;
		}else
			return false;
	}
}
