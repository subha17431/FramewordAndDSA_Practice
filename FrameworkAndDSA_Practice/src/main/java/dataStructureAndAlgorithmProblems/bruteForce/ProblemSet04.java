package dataStructureAndAlgorithmProblems.bruteForce;

import java.util.Arrays;

import org.junit.Test;

import org.junit.Assert;

public class ProblemSet04 {

	
	/* 
	 * Distribute Candies - https://leetcode.com/problems/distribute-candies/description/
	 */
	
	
	@Test
	public void test1() {
		int result = candies(new int[] {1,2,1,4,2,5,2,4}).length;
		System.out.println(result);
		System.out.println(Arrays.toString(candies(new int[] {1,2,1,4,2,5,2,4})));
		Assert.assertEquals(4, result);
	}
	
	public int[] candies(int[] arr) {
		Arrays.sort(arr);
		int[] half = new int[arr.length/2];
		half[0] = arr[0];
		int j=0;
		for (int i = 1; i < arr.length; i++) {
			if (j+1>=arr.length/2) {
				break;
			}	else {
			if (arr[i] != half[j]) {
				half[j+1] = arr[i];
				j++;
			}
		}
	}
		return half;
}

	
	/* 
	 * Given an integer array arr, count how many elements x there are, 
   such that x + 1 is also in arr. 
   If there are duplicates in arr, count them separately.
   
   example 1: input = [1, 2, 3]
			  output = 2
	 */

	@Test
	public void Test2() {
		int result = duplicate(new int[] {1, 2, 3});
		System.out.println(result);
		Assert.assertEquals(2, result);
	}
	
	
	public int duplicate(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] +1 == array[j]) {
					count++;
				}
			}
		}
		return count;
	}
}