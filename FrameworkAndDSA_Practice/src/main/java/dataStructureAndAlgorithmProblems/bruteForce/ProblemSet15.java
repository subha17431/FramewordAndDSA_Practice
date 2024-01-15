package dataStructureAndAlgorithmProblems.bruteForce;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Assert;


public class ProblemSet15 {


	/*
	 * PROBLEM 1 CW
	 * Valid Anagram - https://leetcode.com/problems/valid-anagram/description/
	 */
	
	
	@Test
	public void test1() {
		boolean result = isAnagram("anagram", "nagaram");
		System.out.println(result);
		Assert.assertEquals(true, result);
	}


	@Test
	public void test2() {
		boolean result = isAnagram("rat", "car");
		System.out.println(result);
		Assert.assertEquals(false, result);
	}


	@Test
	public void test3() {
		boolean result = isAnagram("aacc", "ccac");
		System.out.println(result);
		Assert.assertEquals(false, result);
	}


	public boolean isAnagram(String s, String t) {
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		Arrays.sort(sArray);
		Arrays.sort(tArray);
		s = String.valueOf(sArray);
		t = String.valueOf(tArray);
		if (s.equals(t)) {
			return true;
		}else {
			return false;
		}
	}

	
	/*
	 * Excel Sheet Column Number - https://leetcode.com/problems/excel-sheet-column-number/
	 */
	
	
	@Test
	public void test4() {
		int columnNumber = columnNumber("J");
		System.out.println(columnNumber);
		Assert.assertEquals(10, columnNumber);
	}


	@Test
	public void test5() {
		int columnNumber = columnNumber("ABA");
		System.out.println(columnNumber);
		Assert.assertEquals(729, columnNumber);
	}

	@Test
	public void test6() {
		int columnNumber = columnNumber("ZY");
		System.out.println(columnNumber);
		Assert.assertEquals(701, columnNumber);
	}


	public int columnNumber(String columnTitle) {
		int column = 0;
		for(int i=0; i<columnTitle.length(); i++) {
			int last = columnTitle.charAt(i) - 'A' + 1;
			column = column*26 + last;
		}
		return column;
	}
}
