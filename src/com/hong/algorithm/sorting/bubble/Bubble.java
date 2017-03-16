package com.hong.algorithm.sorting.bubble;

import com.hong.algorithm.sorting.capi.Sort;

public class Bubble implements Sort {
	
	public static void main(String[] args) {
		Bubble bubbleSort = new Bubble();
		bubbleSort.sort();
	}
	
	public void init() {
		
	}

	public void sort() {
		System.out.println("Bubble sort input : ");
		for(int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
		long startTime = System.nanoTime();
		bubbleSort();
		long endTime = System.nanoTime();
		long executionTime = endTime - startTime;
		System.out.println("Bubble sort result : ");
		for(int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("execution time : " + executionTime);
	}
	
	protected void bubbleSort() {
		int inputLength = input.length;
		for(int i = 0; i < inputLength; i++) {
			for(int j = i; j < inputLength; j++) {
				if(input[i] > input[j]) {
					switchPos(i, j);
				}
			}
		}
		
	}
	
	protected void switchPos(int posA, int posB) {
		int tmp = input[posA];
		input[posA] = input[posB];
		input[posB] = tmp;
	}
	
}
