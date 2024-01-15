package dataStructureAndAlgorithmProblems.bruteForce;

import java.util.Arrays;

import org.junit.Test;

public class ProblemSet11 {
	
	/*
	 * PROBLEM 1 HW
	 * Second Largest Digit in a String - https://leetcode.com/problems/second-largest-digit-in-a-string/description/
	 */
	
	
	@Test
	public void test1() {
		String result = secondLargest("abc1111");
		System.out.println(result);
	}
	
	
	@Test
	public void test2() {
		String result = secondLargest("dfa12321afd");
		System.out.println(result);
	}
	
	
	public String secondLargest(String str) {
		str = str.replaceAll("[^0-9]", "");
		// System.out.println(str);
		char c = 0;
		for (int i = 0; i < 2; i++) {
			c = largest(str);
			str = str.replace(String.valueOf(c), "");
		}
		if (c == 0) {
			return "-1";
		} else
			return String.valueOf(c);
	}

	
	public char largest(String s) {
		int j = 0;
		char result = 0;
		while(j<s.length()-1) {
			if (s.charAt(j) > result && s.charAt(j) > s.charAt(j+1)) {
				result = s.charAt(j);
			} 
			j++;
		}
		return result;
	}
	
	
	/*
	 * PROBLEM 2 HW
	 * Plus One - https://leetcode.com/problems/plus-one/description/
	 */
	
	
	@Test
	public void test3() {
		int[] arr = plusOne(new int[] {9,9,9,9});
		System.out.println(Arrays.toString(arr));
	}
	
	
	@Test
	public void test4() {
		int[] arr = plusOne(new int[] {4,3,2,1});
		System.out.println(Arrays.toString(arr));
	}
	
	
	public int[] plusOne(int[] arr) {
		int num = Integer.valueOf(Arrays.toString(arr).replaceAll("[^0-9]", "")) + 1;
		int[] newArray = new int[String.valueOf(num).length()];
		for (int i = newArray.length - 1; i >=0 ; i--) {
			newArray[i] = num % 10;
			num = num/10;
		}
		return newArray;
	}
}
