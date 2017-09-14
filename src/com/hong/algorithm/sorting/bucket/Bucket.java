package com.hong.algorithm.sorting.bucket;

import com.hong.algorithm.sorting.capi.Sort;

public class Bucket implements Sort {

	private static int BUCKET_SIZE = 1;
	
	@Override
	public void init() {
		

	}

	@Override
	public void sort() {		
		System.out.println("Bucket sort input : ");
		for(int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int inputMaxVal = 9;
		int bucketNum = inputMaxVal / BUCKET_SIZE;
		
		int [] result = new int [bucketNum];
		for(int i : input) {
			int index = (i % (bucketNum + 1)) - 1;
			result[index] = i;
		}
		
		int index = 0;
		for(int i : result) {
			if(i != 0) {
				input[index] = i;
				index++;
			}
		}
		
		System.out.println("Bucket sort result : ");
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();		
	}

	public static void main(String[] args) {
		Bucket bucket = new Bucket();
		bucket.sort();
	}

}
