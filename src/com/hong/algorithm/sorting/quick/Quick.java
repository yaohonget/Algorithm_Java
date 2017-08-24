package com.hong.algorithm.sorting.quick;

import com.hong.algorithm.sorting.capi.Sort;

public class Quick implements Sort {
	
	public static void main(String[] args) {
		Quick quickSort = new Quick();
		//quickSort.sort();
		quickSort.sort2();
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
	
	public void sort2() {
		System.out.println("Quick sort input : ");
		for(int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
		long startTime = System.nanoTime();
		quickSort2(0, input.length - 1);
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
		int pivot = input[endPos];
		int searchEnd = endPos - 1;
		for(int i = startPos; i <= searchEnd; i++) {			
			if(input[i] < pivot) {
				switchPos(i, storePos);
				storePos++;				
			}
		}		
		switchPos(endPos, storePos);		
		quickSort(startPos, storePos - 1);
		quickSort(storePos + 1, endPos);		
	}
	
	protected void quickSort2(int pStartPos, int pEndPos) {
		int startPos = pStartPos;
		int endPos = pEndPos;
		// for only one element
		if(endPos <= startPos) {
			return;
		}
		// for only two elements
		else if((startPos + 1) == endPos) {
			if( input[startPos] > input[endPos]) {
				switchPos(startPos, endPos);
			}			
			return;
		}
		else {
			// fix position of pivot, start and end
			int pivotPos = startPos;	
			int pivot = input[pivotPos];
			startPos++;
			do {
				int foundEndPos = findEndPos(pivotPos, startPos, endPos);
				int foundStartPos = findStartPos(pivotPos, startPos, foundEndPos);
				if(foundStartPos < foundEndPos) {
					switchPos(foundStartPos, foundEndPos);
				}
				else {
					if(pivot > input[foundEndPos]) {
						switchPos(pivotPos, foundEndPos);
						pivotPos = foundEndPos;
					}
					break;
				}
			}
			while(true);
			quickSort2(pStartPos, pivotPos - 1);
			quickSort2(pivotPos + 1, pEndPos);
			return;
		}
	}
	
	protected int findEndPos(int pivotPos, int startPos, int endPos) {
		int foundEndPos = endPos;
		while(true) {
			if(endPos <= startPos) {
				foundEndPos = startPos; 
				break;
			}
			if(input[endPos] > input[pivotPos]) {
				endPos--;				
			}
			else {
				foundEndPos = endPos;
				break;
			}
		}
		return foundEndPos;
	}
	
	protected int findStartPos(int pivotPos, int startPos, int endPos) {
		int foundStartPos = startPos;
		while(true) {
			if(foundStartPos >= endPos) {
				foundStartPos = endPos;
				break;
			}
			if(input[startPos] <= input[pivotPos]) {
				startPos++;				
			}
			else {
				foundStartPos =startPos;				
				break;
			}
		}
		return foundStartPos;
	}
	
	protected void switchPos(int posA, int posB) {
		int tmp = input[posA];
		input[posA] = input[posB];
		input[posB] = tmp;
	}
}
