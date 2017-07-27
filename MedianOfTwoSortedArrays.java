package com.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums1 = {1,5,3};
		int[] nums2 = {2,6,4,7,8};
		double solution = findMedianSortedArrays1(nums1, nums2);
		System.out.println(solution);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
		double solution;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			list.add(nums1[i]);
		}
		for (int j = 0; j < nums2.length; j++) {
			list.add(nums2[j]);
		}
		Collections.sort(list);	
		int index = list.size()/2;
		
		if(list.size() % 2 != 0){
			solution = (double)list.get(index);
		}else{
			solution = (double)(list.get(index - 1) + list.get(index))/2;
		}	
		return solution;
    }
	
	/*
	 * Concise JAVA solution based on Binary Search:
	 * 
	 * the key point of this problem is to ignore half part of A and B each step recursively 
	 * by comparing the median of remaining A and B:
	 * 
	 * if (aMid < bMid) Keep [aRight + bLeft] 
	 * else Keep [bRight + aLeft]
	 */
	   		
	public static double findMedianSortedArrays1(int[] A, int[] B) {
	    int m = A.length, n = B.length;
	    int l = (m + n + 1) / 2;
	    int r = (m + n + 2) / 2;
	    return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

	public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
		if (aStart > A.length - 1) return B[bStart + k - 1];            
		if (bStart > B.length - 1) return A[aStart + k - 1];                
		if (k == 1) return Math.min(A[aStart], B[bStart]);
	
		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
		if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
		if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        
	
		if (aMid < bMid) 
			return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft 
		else 
			return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
	}

}
