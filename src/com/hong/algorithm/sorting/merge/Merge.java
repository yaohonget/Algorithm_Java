package com.hong.algorithm.sorting.merge;

import com.hong.algorithm.sorting.capi.Sort;

public class Merge implements Sort {

	public static void main(String[] args) {
		Merge mergeSort = new Merge();
		System.out.println("Merge sort input : ");
		for(int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
		mergeSort.merge(0, input.length);
		System.out.println("Merge sort result : ");
		for(int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sort() {
		

	}
	
	public void merge(int start, int end) {
		int mid = (start + end) / 2;
		if(mid > start) {			
			merge(start, mid);
			merge(mid + 1, end);
		}
		
		for(int i = start; i < end; i++) {
			for(int j = i; j < end; j++) {
				if(input[i] > input[j]) {
					int temp = input[j];
					input[j] = input[i];
					input[i] = temp;
				}
			}
		}
	}

}
