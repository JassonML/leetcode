package com.leetcode.array;

import java.util.ArrayList;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> answer = new ArrayList<>();
	    for(int i = 0;i < nums.length - 1;i++){
	    	for(int j = i + 1;j < nums.length;j++){
	    		if(nums[i] + nums[j] == target){
	    			answer.add(i);
	    			answer.add(j);
	    		}
	    	}
	    }
	    int[] solution = new int[answer.size()];
	    for(int i = 0;i < answer.size();i++){
	        solution[i] = answer.get(i);
	    }
	    return solution;
    }
}
