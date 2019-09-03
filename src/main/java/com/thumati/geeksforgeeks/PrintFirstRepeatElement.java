package com.thumati.geeksforgeeks;

import java.util.HashSet;

/**
 * Find the first repeating element in an array of integers.
 * Given an array of integers, find the first repeating element in it. We need to find the element that occurs more than once and whose 
 * index of first occurrence is smallest.
 * 
 * Examples:
 * Input:  arr[] = {10, 5, 3, 4, 3, 5, 6}
 * Output: 5 [5 is the first element that repeats]
 * 
 * Input:  arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10}
 * Output: 6 [6 is the first element that repeats]
 */
public class PrintFirstRepeatElement {
	
	public static void repeatedElementWhoseIndexisSmallest(int[] arr) {
		int min = -1;
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int i = arr.length-1; i>=0; --i) {
			if(set.contains(arr[i])) {
				min=i;
			}else {
				set.add(arr[i]);
			}
		}
		System.out.println("Repeated Element : "+arr[min]);
	}
	
	public static void main(String[] args) {
		repeatedElementWhoseIndexisSmallest(new int[]{10, 5, 3, 4, 3, 5, 6});
		repeatedElementWhoseIndexisSmallest(new int[]{6, 10, 5, 4, 9, 120, 4, 6, 10});
	}

}
