package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;

import java.util.Arrays;
import org.junit.Assert;

public class ProblemSet01 {
	
	
	/*
	 * Contains Duplicate - https://leetcode.com/problems/contains-duplicate/description/
	 */
	
	@Test
	public void test() {
		boolean result = duplicate(new int[] {1,2,3,1});
		System.out.println(result);
		Assert.assertEquals(true, result);
	}
	
	
	public boolean duplicate(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count == 2) {
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * With single loop
	 */
	
	
	@Test
	public void test0() {
		boolean result = duplicate2(new int[] {1,2,3,4});
		System.out.println(result);
		Assert.assertEquals(false, result);
	}
	
	
	public boolean duplicate2(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] == arr[i+1]) {
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * Given a sorted array arr[] and a target num x; find the no of occurances of the number x in the array arr[].
	 */
	
	
	@Test
	public void test1() {
		int result = occurance(new int[] {5,6,8,8,2,5,8,2,4,8,2,6,8,8,8}, 8);
		System.out.println("No of Occurances of target element = " +result);
		Assert.assertEquals(7, result);
	}
	
	
	public int occurance(int[] arr, int x) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				count++;
			}
		}
		return count;
	}
	
	
	/*
	 * Arranging Coins - https://leetcode.com/problems/arranging-coins/description/
	 */
	
	
	@Test
	public void test2() {
		int completeRows = arrangingCoins(8);
		System.out.println("Total no of complete rows = "+completeRows);
		Assert.assertEquals(3, completeRows);
	}
	
	
	public int arrangingCoins(int n) {
		int rows=1;
		if (n==0) {
			return rows = 0;
		} else {
		while (n>rows) {
			n = n - rows;
			rows++;
		}
		return rows-1;
	}
	}
	
	
	/*
	 * 
	 * Next Big Character - Given a sorted character array and a target character, 
find the next biggest character in the array. 

Example:
char[] char = {‘b’, ‘d’ , ‘h’}; char k = ‘e’ 
Output -> h
	 */
	
	
	@Test
	public void test3() {
		char result = nextBigChar(new char[] {'a','b','f','k','r'}, 'p');
		System.out.println(result);
		Assert.assertEquals('r', result);
	}
	
	
	public char nextBigChar(char[] charArray, char target) {
		char result = ' ';
		for (int i = 0; i < charArray.length; i++) {
			if(charArray[i]>target) {
				result = charArray[i];
			}
		}
		return result;		
	}
	
	
	/*
	 * 
	 * Best Time to Buy and Sell Stock - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
	 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
	 */
	
	
	@Test
	public void test4() {
		int maxprofit = maxGain(new int[]{7,5,4,3,6});
		System.out.println(maxprofit);
		Assert.assertEquals(3,maxprofit);
		
	}
	
	
	public int maxGain(int[] stockprice) {
		int maxprofit = 0;
		int profit = 0;
		for(int i=0; i<stockprice.length-1; i++) {
			for(int j=i+1; j<stockprice.length; j++) {
				profit = stockprice[j]-stockprice[i];
				if (profit>maxprofit) {
					maxprofit = profit;
				}
			}
		}
		return maxprofit;	
	}
	
	
	/*
	 * Majority Element - https://leetcode.com/problems/majority-element/description/
	 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
	 */
	
	
	@Test
	public void test5() {
		int majorityElement = majorityElement(new int[] {1,2,2,4,2,3,2,7,2,2,7,4,2});
		System.out.println(majorityElement);
		Assert.assertEquals(2, majorityElement);
	}
	
	
	public int majorityElement(int[] nums) {
		int result = 0;
		int count = 0;
		for (int i = 0; i < nums.length/2; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i]==nums[j]) {
					count++;
				}
			}
			if (count>nums.length/2) {
				result = nums[i];
			}
			count = 0;
		}
		return result;
	}
	
	
	/*
	 * PROBLEM 4
	 * Prime Number - Check if the given number is prime or not 
	(Hint: A number is prime if it divisible only by 1 and itself)
	Example1: input = 5
			output = true
	Example2: input = 6
			output = false
	 */
	
	
	@Test
	public void test6() {
		int factorcount = isPrime(11);
		if (factorcount==2) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		Assert.assertEquals(2,factorcount);	
	}
	
	
	public int isPrime(int num) {
		int count = 0;
		for(int i=1; i<=num; i++) {
			if (num%i==0) {
				count++;
			}
		}
		return count;
		
	}

}
