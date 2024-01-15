package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;
import org.junit.Assert;

public class ProblemSet17 {
	
	
	/*
	 * Determine Color of a Chessboard Square - https://leetcode.com/problems/determine-color-of-a-chessboard-square/
	 */
	
	
	@Test
	public void test() {
		boolean squareColor = chessboard("a1");
		if (squareColor) {
			System.out.println("True");
		} else
			System.out.println("False");
		Assert.assertEquals(false, squareColor);
	}
	
	
	@Test
	public void test2() {
		boolean squareColor = chessboard("c7");
		if (squareColor) {
			System.out.println("True");
		} else
			System.out.println("False");
		Assert.assertEquals(false, squareColor);
	}
	
	
	@Test
	public void test3() {
		boolean squareColor = chessboard("f5");
		if (squareColor) {
			System.out.println("True");
		} else
			System.out.println("False");
		Assert.assertEquals(true, squareColor);
	}
	
	
	public boolean chessboard(String str) {
		if (Integer.valueOf(str.charAt(0) - str.charAt(1))%2 == 0) {
			return false;
		} else
			return true;
	}
}
