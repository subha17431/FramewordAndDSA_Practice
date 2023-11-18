package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Assert;
import org.junit.Test;

public class ProblemSet09 {

	
	/*
	 * PROBLEM 1 CW
	 * 
	 */
	
	
	@Test
	public void test() {
		int length = lastWord("Hello World");
		System.out.println("The length of the last word is "+length);
		Assert.assertEquals(5, length);
	}
	
	
	@Test
	public void test1() {
		int length = lastWord("get");
		System.out.println("The length of the last word is "+length);
		Assert.assertEquals(3, length);
	}
	
	
	public int lastWord(String str) {
		String space = " ";
		if (!str.contains(space)) {
			return str.length();
		}
		return str.substring(str.lastIndexOf(' ')).length() - 1;
	}

	
	/*
	 * PROBLRM 2 CW
	 * Check if All A's Appears Before All B's - https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/description/
	 */
	
	
	@Test
	public void test2() {
		boolean check = checkString("aaabbb");
		Assert.assertEquals(true, check);
	}
	
	
	@Test
	public void test3() {
		boolean check = checkString2("abab");
		Assert.assertEquals(false, check);
	}
	
	
	@Test
	public void test4() {
		boolean check = checkString2("bbb");
		Assert.assertEquals(true, check);
	}
	
	
	public boolean checkString(String str) {
		boolean result = false;
		if (str.lastIndexOf('a')<str.indexOf('b') || !str.contains("a")) {
			result = true;
		}
		return result;
	}
	
	
	public boolean checkString2(String str) {
		boolean result = false;
		if (!str.contains("ba")) {
			result = true;
		}
		return result;
	}
	
	
	/*
	 * PROBLEM 3 CW
	 * Number of Senior Citizens - https://leetcode.com/problems/number-of-senior-citizens/description/
	 */
	
	
	@Test
	public void test5() {
		int numberOfSeniors = countSeniors(new String[] {"7868190130M7522","5303914400F9211","9273338290F4010"});
		System.out.println("Total no of seniors = "+numberOfSeniors);
		Assert.assertEquals(2, numberOfSeniors);
	}
	
	
	@Test
	public void test6() {
		int numberOfSeniors = countSeniors(new String[] {"1313579440F2036","2921522980M5644"});
		System.out.println("Total no of seniors = "+numberOfSeniors);
		Assert.assertEquals(0, numberOfSeniors);
	}
	
	
	public int countSeniors(String[] details) {
		int seniors = 0;
		for (int i = 0; i < details.length; i++) {
			if (Integer.valueOf(details[i].substring(11, 13)) > 60) {
				seniors++;
			}
		}
		return seniors;
	}
	
	/*
	 * PPROBLEM 4 CW
	 * Find the Difference - https://leetcode.com/problems/find-the-difference/description/
	 * 
	 */
	
	
	@Test
	public void test7() {
		char c = difference("asdf", "asgdf");
		System.out.println(c);
	}
	
	
	@Test
	public void test8() {
		char c = difference("", "y");
		System.out.println(c);
	}
	
	
	public char difference(String str1, String str2) {
		int count1, count2;
		char extra = str2.charAt(str2.length()-1);
		for(int i =0; i<str1.length(); i++) {
			count1 = 0;
			count2 = 0;
			for(int j = 0; j<str1.length(); j++) {
				if (str2.charAt(i) == str1.charAt(j)) {
					count1++;
				}
				if (str2.charAt(i) == str2.charAt(j)) {
					count2++;
				}
			}
			if(count1 != count2)
			extra = str2.charAt(i);
		}
		return extra;
	}
	
}
