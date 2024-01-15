package dataStructureAndAlgorithmProblems.bruteForce;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Assert;

public class ProblemSet13 {

	/*
	 * PROBLEM 1 HW
	 * Unique Number of Occurrences - https://leetcode.com/problems/unique-number-of-occurrences/description/
	 */
	
	
	@Test
	public void test1() {
		boolean result = uniqueOccurance(new int[] {1,2});
		System.out.println(result);
		Assert.assertEquals(false, result);
	}
	
	
	@Test
	public void test2() {
		boolean result = uniqueOccurance(new int[] {-3,0,1,-3,1,1,1,-3,10,0});
		System.out.println(result);
		Assert.assertEquals(true, result);
	}

	
	public boolean uniqueOccurance(int[] arr) {
		Arrays.sort(arr);
		int count = 1;
		String str = "";
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i-1]) {
				count++;
			}else {
				str = str + count;
				count = 1;
			}
		}
		str = str + count;
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		for (int i = 0; i < ch.length-1; i++) {
			if (ch[i] == ch[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	
	/*
	 * PROBLEM 2 HW
	 * Maximum 69 Number - https://leetcode.com/problems/maximum-69-number/description/
	 */
	
	
	@Test
	public void test3() {
		String s = maximum(96669);
		System.out.println(s);
		Assert.assertEquals("99669", s);
	}
	
	
	public String maximum(int num) {
		String str = String.valueOf(num);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '6') {
				str = str.substring(0, i) + '9' + str.substring(i+1);
				return str;
			}
		}
		return "It is better not to apply any change.";
	}
}
