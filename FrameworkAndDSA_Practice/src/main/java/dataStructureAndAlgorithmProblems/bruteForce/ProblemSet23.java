package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;

public class ProblemSet23 {
	
	
	/*
	 * Check If It Is a Straight Line - https://leetcode.com/problems/check-if-it-is-a-straight-line/
	 */
	
	@Test
	public void test1() {
		boolean result = checkStraightLine(new int[][] {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}});
		System.out.println(result);
		org.junit.Assert.assertEquals(true, result);
	}
	
	@Test
	public void test2() {
		boolean result = checkStraightLine(new int[][] {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}});
		System.out.println(result);
		org.junit.Assert.assertEquals(false, result);
	}
	
	@Test
	public void test3() {
		boolean result = checkStraightLine(new int[][] {{1,2},{56,89}});
		System.out.println(result);
		org.junit.Assert.assertEquals(true, result);
	}
	
	public boolean checkStraightLine(int[][] coordinates) {
		float x0 = coordinates[0][0];
		float y0 = coordinates[0][1];
		float x1 = coordinates[1][0];
		float y1 = coordinates[1][1];
		
		if (coordinates.length == 2) {
			return true;
		}
		for (int i = 2; i < coordinates.length; i++) {
			float x = coordinates[i][0];
			float y = coordinates[i][1];
			float m1 = (y-y0)/(x-x0);
			float m2 = (y1-y0)/(x1-x0);
			if (m1 !=m2) {
				return false;
			}
		}
		return true;
	}

}
