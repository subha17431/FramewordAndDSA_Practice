package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;

import java.util.Arrays;

import org.junit.Assert;;

public class ProblemSet03 {

	
	@Test
	public void test1() {
		boolean result = paliandrome(121);
		if (result) {
			System.out.println("The given no is a paliandrome");
		} else {
			System.out.println("The given no is not a paliandrome");
		}
		Assert.assertEquals(true, result);
	}
	

	public boolean paliandrome(int n) {
		int revNum=0;
		int num = n;
		while(n!=0) {
			int rem = n%10;
			revNum = revNum*10 + rem;
			n = n/10;
		}
		if (revNum == num) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/* 
	 * Single Number - https://leetcode.com/problems/single-number/description/
	 */
	
	
	@Test
	public void test2() {
		System.out.println(singleNumber(new int[] {1,2,3,4,5,1,2,3,4}));
		Assert.assertEquals(5, singleNumber(new int[] {1,2,3,4,5,1,2,3,4}));
	}
	
	
	public int singleNumber(int [] arr) {
		int result = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count == 1) {
				return arr[i];
			}
			count = 0;
		}
		return result;
	}
	
	
	/* 
	 * Single Number - 2nd Meathod
	 */
	
	
	@Test
	public void test3() {
		System.out.println(singleNumber2(new int[] {1,2,3,4,5,1,2,3,4}));
		Assert.assertEquals(5, singleNumber2(new int[] {1,2,3,4,5,1,2,3,4}));
	}
	
	
	public int singleNumber2(int[] arr)
	{
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length-1; i=i+2) 
		{
		  if(arr[i]!=arr[i+1])
			{
				return arr[i];
			
			}
		}
		return arr[arr.length-1];
	}
}
