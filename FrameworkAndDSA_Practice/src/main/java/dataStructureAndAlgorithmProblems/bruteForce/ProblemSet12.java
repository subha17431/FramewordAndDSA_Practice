package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;
import org.junit.Assert;

public class ProblemSet12 {

	/*
	 * PROBLEM 1 HW
	 * Find Pivot Index - https://leetcode.com/problems/find-pivot-index/description/
	 */


	@Test
	public void test1() {
		int pivotIndex = pivot(new int[] {1,7,3,6,5,6});
		System.out.println(pivotIndex);
		Assert.assertEquals(3, pivotIndex);
	}


	@Test
	public void test2() {
		int pivotIndex = pivot(new int[] {2,1,3});
		System.out.println(pivotIndex);
		Assert.assertEquals(-1, pivotIndex);
	}


	@Test
	public void test3() {
		int pivotIndex = pivot(new int[] {2,1,-1});
		System.out.println(pivotIndex);
		Assert.assertEquals(0, pivotIndex);
	}


	public int pivot(int[] arr) {
		int leftSum = 0, rightSum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int l = 0; l < i; l++) {
				leftSum = leftSum + arr[l];
			}
			for (int r = arr.length-1; r > i; r--) {
				rightSum = rightSum + arr[r];
			}
			if (leftSum == rightSum) {
				return i;
			}
			leftSum = 0; rightSum = 0;
		}
		return -1;
	}

	/*
	 * PROBLEM 2 HW
	 * Replace All Digits with Characters - https://leetcode.com/problems/replace-all-digits-with-characters/description/
	 */


	@Test
	public void test4() {
		String replaced = replaceChar("a1c1e1");
		System.out.println(replaced);
		Assert.assertEquals("abcdef", replaced);
	}


	@Test
	public void test5() {
		String replaced = replaceChar("a1b2c3d4e");
		System.out.println(replaced);
		Assert.assertEquals("abbdcfdhe", replaced);
	}


	public String replaceChar(String str) {
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			int a = str.charAt(i) - '0';
			if (i % 2 == 0) {
				newStr = newStr + str.charAt(i);
			} else
				newStr = newStr + shift(str.charAt(i-1), a);
		}
		return newStr;
	}


	public char shift(char c, int x) {
		return (char) (c + x);
	}
}
