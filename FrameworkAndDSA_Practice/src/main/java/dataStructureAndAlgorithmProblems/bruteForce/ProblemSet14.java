package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;

import java.util.Arrays;
import org.junit.Assert;

public class ProblemSet14 {
	
	
	/*
	 * PROBLEM 1 HW
	 * Count Primes - https://leetcode.com/problems/count-primes/description/
	 */
	

	@Test
	public void test1() {
		int primeCount = noOFPrimes(10);
		System.out.println("No of prime no's before given number = "+primeCount);
		Assert.assertEquals(4, primeCount);
	}


	@Test
	public void test2() {
		int primeCount = noOFPrimes(1);
		System.out.println("No of prime no's before given number = "+primeCount);
		Assert.assertEquals(0, primeCount);
	}


	public int noOFPrimes(int num) {
		int n = 0, i = 1;
		while(i<num) {
			if (prime(i)) {
				n++;
			}
			i++;
		}
		return n;
	}

	public boolean prime(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n%i==0) {
				count++;
			}
		}
		if (count == 2) {
			return true;
		}
		return false;
	}
	
	
	/*
	 * PROBLEM 2 HW
	 * Intersection of Two Arrays - https://leetcode.com/problems/intersection-of-two-arrays/description/
	 */
	
	
	@Test
	public void test3() {
		char[] ch = intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4});
		System.out.println(Arrays.toString(ch));
		Assert.assertArrayEquals(new char[] {'4','9'} , ch);
	}
	
	
	public char[] intersection(int[] array1, int[] array2) {
		String str = "";
		Arrays.sort(array1);		
		if (ifPresent(array1[0], array2)) {
			str = str + array1[0];
		}
		for (int i = 1; i < array1.length; i++) {
			if (array1[i] != array1[i-1]) {
				if (ifPresent(array1[i], array2)) {
					str = str + array1[i];
				}
			}
		}
		return str.toCharArray();
	}
	
	public boolean ifPresent(int num, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return true;
			}
		}
		return false;
	}
}
