package com.hong.algorithm.sorting.heap;

import com.hong.algorithm.sorting.capi.Sort;

/**
 * 
 * @author HYao
 *
 */
public class Heap implements Sort {
	
	public static void main(String [] args) {
		Heap heap = new Heap();
		heap.createHeap(input);
		heap.createHeap(heap.add(19, input));
	}
	
	@Override
	public void init() {
	}

	@Override
	public void sort() {
				
	}
	
	public void createHeap(int [] arr) {
		System.out.println("heap sort input : ");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		int len = arr.length - 1;
		// from bottom to top
		for(int i = len; i >= 0; i--) {
			int rootIndex;
			if( i%2 == 0) {
				// right leaf
				rootIndex = (i/2) - 1; 	
			}
			else {
				rootIndex = ((i+1)/2) - 1; 				
			}
			if(rootIndex >= 0 && arr[i] > arr[rootIndex]) {
				arr = swap(i, rootIndex, arr);
			}
		}
		System.out.println("heap : ");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	protected int [] swap(int i, int j, int[] arr) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		return arr;
	}
	
	protected int [] add(int newValue, int [] arr) {
		int newLen = arr.length + 1;
		int [] heap = new int [newLen];
		for(int i = 0; i < newLen; i++) {
			if(i == arr.length) {
				heap[i] = newValue;
			}
			else {
				heap[i] = arr[i];
			}
		}
		System.out.println("heap add : " + newValue);
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		return heap;
		
	}
	

}
