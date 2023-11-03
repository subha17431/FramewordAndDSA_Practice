package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;

import java.util.Arrays;

import org.junit.Assert;

public class ProblemSet05 {

	/* 
	 * Add Digits - https://leetcode.com/problems/add-digits/description/
	 */


	@Test
	public void test1() {
		int sumOfDigits = digitSumRecursion(5555);
		System.out.println(sumOfDigits);
		Assert.assertEquals(2, sumOfDigits);
	}


	/*
	 * With Loop & Recursion
	 */

	//Loop
	public int digitSumLoop(int num) {
		int sum = 0;
		int rem;
		while(num/10 != 0) {
			sum = 0;
			while (num!=0) {
				rem = num%10;
				sum = sum + rem;
				num = num/10;
			}
			num = sum;
		}
		return sum;
	}

	//Recursion
	public int digitSumRecursion(int num) {
		int sum = 0;
		int rem;
		while (num!=0) {
			rem = num%10;
			sum = sum + rem;
			num = num/10;
		}

		if(sum/10 == 0)
			return sum;
		else sum = digitSumRecursion(sum);
		return sum;
	}


	@Test
	public void test2() {
		int sumOfDigits = digitSum(546);
		System.out.println(sumOfDigits);
		Assert.assertEquals(6, sumOfDigits);
	}

	//Without Loop or Recursion
	public int digitSum(int num) {
		int sum = 0;
		if(num == 0)
			sum = 0;
		if(num%9 == 0)
			sum = 9;
		else
			sum = num%9;
		return sum;
	}


	/* 
	 * Remove the target element in the array
							
	example 1: input = [2, 3, 3, 4, 5], target=3
			   output = [2, 4, 5]
			   explanation: when 3 is removed from input array, 
							output is [2, 4, 5]
	
	example 2: input = [2, 2], target=2
			   output = []
			   explanation: when 2 is removed, output would be empty
	 */
	
	
	@Test
	public void test3() {
		int[] newArray = removeElement(new int[] {1,5,5,4,5,6,7,5,9,5,2}, 5);
		System.out.println(Arrays.toString(newArray));
		Assert.assertArrayEquals(new int[] {1,4,6,7,9,2}, newArray);
	}

	
	public int[] removeElement(int [] arr, int target) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				count++;
			}
		}
		int [] newArray = new int[arr.length - count];
		int k = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] != target) {
				newArray[k] = arr[j];
				k++;
			}
		}
		return newArray;
	}
}

