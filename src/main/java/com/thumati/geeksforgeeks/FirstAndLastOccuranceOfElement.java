package com.thumati.geeksforgeeks;

/**
 * Find first and last positions of an element in a sorted array.
 * Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.
 * Examples:
 * Input : arr[] = {1, 3, 5, 5, 5, 5 ,67, 123, 125}    
        x = 5
   Output : First Occurrence = 2
            Last Occurrence = 5

   Input : arr[] = {1, 3, 5, 5, 5, 5 ,7, 123 ,125 }    
        x = 7
   Output : First Occurrence = 6
            Last Occurrence = 6
 */

public class FirstAndLastOccuranceOfElement {

	public static void firstAndLastOccuranceOfAnElementOfSortedArray(int[] arr, int x) {
		
		int first=-1, last=-1;
		int n = arr.length;
		
		for(int i=0; i<n;++i) {
			if(x!=arr[i]) 
				continue;
			if(first==-1)
				first=i;
			last=i;
		}
		
		if(first!=-1) {
			System.out.println("First Occurance of "+x+" : "+first);
			System.out.println("Last Occurance of "+x+" : "+last);
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 2, 2, 3, 4, 7 ,8 ,8 };
		firstAndLastOccuranceOfAnElementOfSortedArray(arr, 8);
		firstAndLastOccuranceOfAnElementOfSortedArray(arr, 2);
		firstAndLastOccuranceOfAnElementOfSortedArray(arr, 3);
	}

}
