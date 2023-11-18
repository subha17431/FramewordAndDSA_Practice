package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;

import java.util.Arrays;

import org.junit.Assert;

public class ProblemSet06 {
	
	
	/* 
	 * PROBLEM 1 HW
	 * Climbing Stairs - https://leetcode.com/problems/climbing-stairs/
	 */
	
	
	@Test
	public void test1() {
		int totalSetps = 7;
		int distinctWays = stairs(totalSetps);
		System.out.println("Total no of distinct ways in which "+totalSetps+" steps can be climbed is "+distinctWays);
		Assert.assertEquals(21, distinctWays);
	}
	
	
	public int stairs(int num) {
		int a = 0;
		int b = 1;
		int c = 0;
		int i = 1;
		if (num == 0) {
			return c;
		}
		else {
			while(i<=num) {
				c = a + b;
				a = b;
				b = c;
				i++;
			}
		}
		return c;
	}
	
	
	/* PROBLEM 2 HW
	 * Move Zeroes - https://leetcode.com/problems/move-zeroes/description/
	 */
	
	
	@Test
	public void test2() {
		int[] newArray = zerosToRight(new int[] {1,3,5,7,10,0,0,0});
		System.out.println(Arrays.toString(newArray));
		Assert.assertArrayEquals(new int[] {1,3,5,7,10,0,0,0}, newArray);
	}
	
	
	public int[] zerosToRight(int[] arr) {
		int s = 0;
		int e = 1;
		int temp;
		if (arr.length == 1) {
			return arr;
		}
		while (e<arr.length) {
			if (arr[s] == 0 && arr[e] != 0) {
				temp = arr[e];
				arr[e] = arr[s];
				arr[s] = temp;
				s++;
				e++;
			}
			else if (arr[s] != 0 && arr[e] == 0) {
				s++;
				e++;
			}
			else if (arr[s] == 0 && arr[e] == 0) {
				e++;
			}
			else if (arr[s] != 0 && arr[e] != 0) {
				s++;
				e++;
			}
		}
		return arr;
	}
}
