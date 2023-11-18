package dataStructureAndAlgorithmProblems.bruteForce;

import org.junit.Test;

import java.util.Arrays;

import org.junit.Assert;

public class ProblemSet10 {
	
	
	/* PROBLEM 1 HW
	 * Jewels and Stones - https://leetcode.com/problems/jewels-and-stones/description/
	 * 
	 */
	
	
	@Test
	public void test1() {
		int countOfJewels = jewels("aA", "aAAbbbb");
		System.out.println(countOfJewels);
		Assert.assertEquals(3, countOfJewels);
	}
	
	
	public int jewels(String jewels, String stones) {
		int count = 0;
		int i = 0;
		while(i<jewels.length()) {
			for (int j = 0; j < stones.length(); j++) {
				if (jewels.charAt(i) == stones.charAt(j)) {
					count++;
				}
			}
			i++;
		}
		return count;
	}
	
	
	@Test
	public void test2() {
		int missingNum = missingNum(new int[] {9,6,4,2,3,5,7,0,1});
		System.out.println(missingNum);
		Assert.assertEquals(8, missingNum);
	}
	
	
	public int missingNum(int[] num) {
		int i = 0;
		int n = num.length;
		Arrays.sort(num);
		while (i < num.length) {
			if (i!=num[i]) {
				n = i;
			}
			i++;
		}
		return n;
	}

}
