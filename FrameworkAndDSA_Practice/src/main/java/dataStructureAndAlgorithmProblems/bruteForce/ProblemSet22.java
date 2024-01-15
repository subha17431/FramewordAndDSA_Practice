package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;

public class ProblemSet22 {
	
	
	/*
	 * Day of the Year - https://leetcode.com/problems/day-of-the-year/
	 * "2019-01-09"
	 */
	
	
	@Test
	public void test1() {
		int dayNumber = dayOfYear("2020-09-10");
		System.out.println(dayNumber);
		org.junit.Assert.assertEquals(254, dayNumber);
	}
	
	@Test
	public void test2() {
		int dayNumber = dayOfYear("2020-02-10");
		System.out.println(dayNumber);
		org.junit.Assert.assertEquals(41, dayNumber);
	}
	
	@Test
	public void test3() {
		int dayNumber = dayOfYear("2020-03-10");
		System.out.println(dayNumber);
		org.junit.Assert.assertEquals(70, dayNumber);
	}
	
	@Test
	public void test4() {
		int dayNumber = dayOfYear("2019-02-10");
		System.out.println(dayNumber);
		org.junit.Assert.assertEquals(41, dayNumber);
	}
	
	@Test
	public void test5() {
		int dayNumber = dayOfYear("2019-09-10");
		System.out.println(dayNumber);
		org.junit.Assert.assertEquals(253, dayNumber);
	}
	
	public int dayOfYear(String date) {
		int year, month, day, result = 0;
		year = Integer.valueOf(date.substring(0, 4));
		month = Integer.valueOf(date.substring(5, 7));
		day = Integer.valueOf(date.substring(8, 10));
		switch (month) {
		case 1:
			result = day;
			break;
		case 2:
			result = 31 + day;
			break;
		case 3:
			result = 31 + 28 + day;
			break;
		case 4:
			result = 31*2 + 28 + day;
			break;
		case 5:
			result = 31*2 + 28 + 30*1 + day;
			break;
		case 6:
			result = 31*3 + 28 + 30*1 + day;
			break;
		case 7:
			result = 31*3 + 28 + 30*2 + day;
			break;
		case 8:
			result = 31*4 + 28 + 30*2 + day;
			break;
		case 9:
			result = 31*5 + 28 + 30*2 + day;
			break;
		case 10:
			result = 31*5 + 28 + 30*3 + day;
			break;
		case 11:
			result = 31*6 + 28 + 30*3 + day;
			break;
		case 12:
			result = 31*6 + 28 + 30*4 + day;
			break;
		}
		if (((year%4==0 && year%100!=0) || year%400==0) && month>2) {
			result+=1;
		}
		return result;
	}

}
