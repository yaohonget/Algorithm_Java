package com.hong.algorithm.sorting.quick;

import com.hong.algorithm.sorting.capi.Sort;

public class Quick implements Sort {
	
	
	
	
	
	public static void main(String[] args) {
		Quick quickSort = new Quick();
		quickSort.sort();

	}

	public void init() {	
		
	}

	public void sort() {
		System.out.println("Quick sort input : ");
		for(int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
		long startTime = System.nanoTime();
		quickSort(0, input.length - 1);
		long endTime = System.nanoTime();
		long executionTime = endTime - startTime;
		System.out.println("Quick sort result : ");
		for(int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("execution time : " + executionTime);
	}
	
	protected void quickSort(int startPos, int endPos) {	
		
		if(endPos < startPos) {
			return;
		}
		
		int storePos = startPos;
		int privot = input[endPos];
		int searchEnd = endPos - 1;
		for(int i = startPos; i <= searchEnd; i++) {			
			if(input[i] < privot) {
				switchPos(i, storePos);
				storePos++;				
			}
		}
		
		switchPos(endPos, storePos);
		
		quickSort(startPos, storePos - 1);
		quickSort(storePos + 1, endPos);
		
	}
	
	protected void switchPos(int posA, int posB) {
		int tmp = input[posA];
		input[posA] = input[posB];
		input[posB] = tmp;
	}

}
