package dataStructureAndAlgorithmProblems.bruteForce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ProblemSet02 {
	
	
/*
 * Two Sum - https://leetcode.com/problems/two-sum/description/
 */
	
	
	@Test
	public void test() {
		int[] result = twoSumWithMap(new int[] {1,2,3,4,5,6}, 7);
		System.out.println(Arrays.toString(result));
		Assert.assertArrayEquals(new int[] {0,5}, result);
	}
	
	
public int[] twoSum(int[] nums, int target) {
	
	for(int i=0; i<nums.length-1; i++) {
		for (int j = i+1; j < nums.length; j++) {
			if(nums[i]+nums[j] == target) {
				int[] result = new int[]{i,j};
				return result;
			}
		}
	}
	return new int[] {};
}

public int[] twoSumWithMap(int[] nums, int target) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	for (int i = 0; i < nums.length; i++) {
		map.put(nums[i], i);
	}
	for (int i = 0; i < nums.length; i++) {
		if(map.containsKey(target - nums[i])) {
			if(i != map.get(target-nums[i])) {
				return new int[] {i, map.get(target-nums[i])};
			}
		}
	}
	return new int[] {};
}


/*
 * Power of Two - https://leetcode.com/problems/power-of-two/description/
 */


@Test
public void test2() {
	boolean result = powerOfTwo(65);
	System.out.println(result);
	Assert.assertEquals(false, result);	
}


public boolean powerOfTwo(int num) {
	int newNum = 1;
	if(num == 1) {
		return true;
	}
	while (newNum<num) {
		newNum = newNum*2;
		if (newNum == num) {
			return true;
		}	
	}
	return false;
}


/*
 * Count of Matches in Tournament - https://leetcode.com/problems/count-of-matches-in-tournament/description/
 */

@Test
public void test3() {
	int totalMatches = MatchCount(3);
	System.out.println(totalMatches);
}


public int MatchCount(int teams) {
	int matchCount = 0;
	while(teams>1) {
		if(teams%2==0) {
			matchCount = matchCount + teams/2;
			teams=teams/2;
		}
		else {
			matchCount = matchCount + teams/2;
			teams=teams/2 + 1;
		}
	}
	return matchCount;
}


}
