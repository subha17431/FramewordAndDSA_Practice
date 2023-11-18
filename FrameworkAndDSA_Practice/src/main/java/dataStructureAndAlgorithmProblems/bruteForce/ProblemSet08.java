package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;
import org.junit.Assert;

public class ProblemSet08 {

	/* PROBLEM 1 CW
	 * Valid String Palindrome - https://leetcode.com/problems/valid-palindrome/description/
	 */


	@Test
	public void test1() {
		boolean paliandromeResult = stringPaliandrome("A man, a plan, a canal: Panama");
		System.out.println(paliandromeResult);
		Assert.assertEquals(true, paliandromeResult);
	}


	public boolean stringPaliandrome(String str) {
		boolean result = true;
		str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int n = str.length();
		int j = n - 1;
		for(int i = 0; i<n/2; i++) {
			if (str.charAt(i) != str.charAt(j)) {
				result = false;
				break;
			} else j--;
		}
		return result;
	}


	public boolean stringPaliandrome2(String str) {
		str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		String original = str;
		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		return original.equals(reverse);
	}


	/*
	 * PROBLEM 2 CW
	 * Shuffle String - https://leetcode.com/problems/shuffle-string/description/
	 */


	@Test
	public void test2() {
		String unsuffled = shuffleString("codeleet", new int[] {4,5,6,7,0,2,1,3});
		System.out.println(unsuffled);
	}


	public String shuffleString(String str, int[] arr) {
		String newStr = "";
		char[] charArray = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			charArray[arr[i]] = str.charAt(i); 
		}
		newStr = String.valueOf(charArray);
		return newStr;
	}


	/* 
	 * PROBLEM 3 CW
	 * Determine if String Halves Are Alike - https://leetcode.com/problems/determine-if-string-halves-are-alike/description/
	 */


	@Test
	public void test3() {
		boolean compareResult = equalHalves("sdftaeiouAEIOUSDFT");
		System.out.println(compareResult);
		Assert.assertEquals(true, compareResult);
	}


	public boolean equalHalves(String str) {

		String firstHalf = str.substring(0, str.length()/2);
		String secondHalf = str.substring(str.length()/2, str.length()-1);
		String firststr = firstHalf.replaceAll("[^a,e,i,o,u,A,E,I,O,U]", "");
		String secondstr = secondHalf.replaceAll("[^a,e,i,o,u,A,E,I,O,U]", "");

		return firststr.length() == secondstr.length();
	}


	/*
	 * PROBLEM 1 HW
	 * Find First Palindromic String in the Array - https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/
	 */


	@Test
	public void test4() {
		String firstPalindrome = firstPaliandrome(new String[] {"abc","car","ada","racecar","cool"});
		System.out.println(firstPalindrome);
		Assert.assertEquals("ada", firstPalindrome);
	}


	public String firstPaliandrome(String[] strArray) {
		String result = "";
		for (int i = 0; i < strArray.length; i++) {
			if (stringPaliandrome2(strArray[i])) {
				result = strArray[i];
				break;
			}
		}
		return result;
	}


	/*
	 * PROBLEM 2 HW
	 * Merge Strings Alternately - https://leetcode.com/problems/merge-strings-alternately/description/
	 */


	@Test
	public void test5() {
		String altMerged = mergeString("ab", "pqrs");
		System.out.println(altMerged);
		Assert.assertEquals("apbqrs", altMerged);
	}


	public String mergeString(String word1, String word2) {
		int p = word1.length();
		int q = word2.length();
		int i = 0;
		String merged = "";
		while (i<p || i<q) {
			if (i<p) {
				merged = merged + word1.charAt(i);
			}
			if (i<q) {
				merged = merged + word2.charAt(i);
			}
			i++;
		}
		return merged;
	}
}
