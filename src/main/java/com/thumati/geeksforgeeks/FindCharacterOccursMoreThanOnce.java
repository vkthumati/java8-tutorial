package com.thumati.geeksforgeeks;

import java.util.HashSet;

/**
 * Given a string, find the first repeated character in it. We need to find the character that occurs more than once and whose 
 * index of second occurrence is smallest.
 * 
 * Examples : 
 * Input:  ch = "geeksforgeeks"
 * Output: e
 * e is the first element that repeats
 * Input:  str = "hello geeks"
 * Output: l
 * l is the first element that repeats
 */
public class FindCharacterOccursMoreThanOnce {

	public static char findCharacterOccursMoreThanOnceWhoseIndexOfSecondOccuranceIsSmallest(char[] arr) {
		
		HashSet<Character> h = new HashSet<>();
		
		for(int i=0; i<=arr.length-1; ++i) {
			
			char c = arr[i];
			
			if(h.contains(c))
				return c;
			
			h.add(c);
		}
		
		return '\0';
	}
	
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		
		char[] charArr = str.toCharArray();
		System.out.println(findCharacterOccursMoreThanOnceWhoseIndexOfSecondOccuranceIsSmallest(charArr));

		charArr = "hello geeks".toCharArray();
		System.out.println(findCharacterOccursMoreThanOnceWhoseIndexOfSecondOccuranceIsSmallest(charArr));
	}

}
