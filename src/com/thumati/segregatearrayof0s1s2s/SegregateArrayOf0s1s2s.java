package com.thumati.segregatearrayof0s1s2s;

import java.util.Scanner;

//Program to segregate the array of 0s, 1s and 2s
public class SegregateArrayOf0s1s2s {

	public static void main(String[] args) {
		// Using Scanner class to take input 
		Scanner sc = new Scanner(System.in);
		
		//No Of testcase input
		int t = sc.nextInt();
		
		//Iterating through all the testcases 
		while(t-- > 0) {
			
			//Input n, i.e. size of array 
			int n = sc.nextInt();
			
			int[] a = new int[n];
			
			// Taking input of array elements 
			for(int i=0; i<n; ++i) {
				a[i] = sc.nextInt();
			}
			
			// Calling function to segregate input array 
			segregate(a, n);
			
			// printing the modified array 
			for(int i : a) {
				System.out.print(i+", ");
			}
			System.out.println();
		}
		sc.close();
	}
	
	// Function to segragate 0s, 1s and 2s 
	public static void segregate(int[] a, int n) {
		 /* 
        low : to keep left index 
        high : to keep right index 
        mid : to get middle element 
        */
		int low =0, high = n-1, mid = 0;
		
		// Iterating through the array and segregating elements 
		while(mid <= high) {
			// If element at mid is 0 move it to left 
			if(a[mid]==0) {
				int temp = a[mid];
				a[mid] = a[low];
				a[low] = temp;
				low++;
				mid++;
			}else if(a[mid]==1) {// If element at mid is 1 nothing to do 
				mid++;
			}else {// If element at mid is 2 move it to last 
				int temp = a[mid];
				a[mid] = a[high];
				a[high] = temp;
				high--;
			}
		}
	}
}
