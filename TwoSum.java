package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args){
		int[] a = {2, 4, 5, 7, 11, 15, 24};
		int[] b = twoSum0(a, 9);
		for(int x: b){
			System.out.print(x + " ");
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {
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
	
	public static int[] twoSum0(int[] nums, int target) {
	    for (int i = 0; i < nums.length; i++) {
	        for (int j = i + 1; j < nums.length; j++) {
	            if (nums[j] == target - nums[i]) {
	                return new int[] { i, j };
	            }
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	public static int[] twoSum1(int[] nums, int target) {
	    for (int i = 0; i < nums.length; i++) {
	        for (int j = i + 1; j < nums.length; j++) {
	            if (nums[j] == target - nums[i]) {
	                return new int[] { i, j };
	            }
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	public int[] twoSum2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
}
