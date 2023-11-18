package dataStructureAndAlgorithmProblems.bruteForce;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ProblemSet07 {


	/* PROBLEM 1 HW
	 * Squares of a Sorted Array - https://leetcode.com/problems/squares-of-a-sorted-array/description/
	 */


	@Test
	public void test1( ) {
		int[] sortedSquareArray = sortedSquare(new int[] {-4,-1,0,3,10});
		System.out.println(Arrays.toString(sortedSquareArray));
		Assert.assertArrayEquals(new int[] {0,1,9,16,100}, sortedSquareArray);
	}


	public int[] sortedSquare(int[] arr) {
		int[] result = new int[arr.length];
		int i = 0, j = arr.length - 1;
		for (int p = arr.length - 1; p >= 0; p--) {
			if (Math.abs(arr[i]) > Math.abs(arr[j])) {
				result[p] = arr[i] * arr[i];
				i++;
			} else {
				result[p] = arr[j] * arr[j];
				j--;
			}
		}
		return result;
	}


	/* PROBLEM 2 HW
	 * Power of Three - https://leetcode.com/problems/power-of-three/description/
	 */


	@Test
	public void test2() {
		boolean result = powerThree(90);
		System.out.println(result);
		Assert.assertEquals(false, result);
	}


	public boolean powerThree(int num) {
		double power;
		boolean result = false;
		if (num<=0) {
			return false;
		}
		power = Math.log(num)/Math.log(3);
		if (power - Math.round(power) == 0) {
			result = true;
		} else result = false;
		return result;
	}
}
