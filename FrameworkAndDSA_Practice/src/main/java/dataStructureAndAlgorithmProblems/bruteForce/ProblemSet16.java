package dataStructureAndAlgorithmProblems.bruteForce;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ProblemSet16 {
	
	
	/*
	 * PROBLEM 1 HW
	 * Self Dividing Numbers - https://leetcode.com/problems/self-dividing-numbers/
	 */
	
	
	@Test
	public void test() {
		ArrayList<Integer> numbersList = selfDividingNumbers(1, 22);
		System.out.println(numbersList);
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,11,12,15));
		Assert.assertEquals(expected, numbersList);
		
	}
	
	public ArrayList<Integer> selfDividingNumbers(int left, int right) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = left; i < right; i++) {
			if (selfDividing(i)) {
				list.add(i);
			}
		}
		return list;
	}
	
	public boolean selfDividing(int num) {
		int n = num, rem;
		while(n!=0) {
			rem = n%10;
			if (rem == 0 || num%rem != 0) {
				return false;
			}
			n = n/10;
		}
		return true;
	}
}
