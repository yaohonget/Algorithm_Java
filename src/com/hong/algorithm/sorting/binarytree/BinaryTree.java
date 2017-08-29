package com.hong.algorithm.sorting.binarytree;

import com.hong.algorithm.sorting.capi.Sort;

/**
 * level i contains 2^(i-1) : level 2 has 2^(2-1) = 2 elements a tree has i
 * level contains max 2^i - 1
 * 
 * @author HYao
 *
 */
public class BinaryTree implements Sort {

	Integer[] tree;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.sort();
	}

	@Override
	public void init() {
	}

	@Override
	public void sort() {
		System.out.println("Binary tree input : ");
		for (int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
		long startTime = System.nanoTime();

		int len = input.length;
		int treeLen = 2 * (len - 1) + 1;
		tree = new Integer[treeLen];
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				tree[i] = input[i];
			} else {
				int searchedIndex = 0;
				while (true) {
					if (searchedIndex >= treeLen) {
						break;
					}
					if (tree[searchedIndex] == null) {
						tree[searchedIndex] = input[i];
						break;
					}
					if (input[i] < tree[searchedIndex]) {
						searchedIndex = (searchedIndex + 1) * 2 - 1;
					} else if (input[i] > tree[searchedIndex]) {
						searchedIndex = (searchedIndex + 1) * 2;
					} else {
						break;
					}
				}
			}
		}

		long endTime = System.nanoTime();
		long executionTime = endTime - startTime;
		System.out.println("Sort result : ");
		printTree(0);
		System.out.println();
		System.out.println("execution time : " + executionTime);
	}

	protected void printTree(int searchedIndex) {
		int leftLeafIndex = ((searchedIndex + 1) * 2) - 1;
		int rightLeafIndex = (searchedIndex + 1) * 2;
		if (leftLeafIndex < tree.length && tree[leftLeafIndex] != null) {
			printTree(((searchedIndex + 1) * 2) - 1);
		}
		System.out.print(tree[searchedIndex].intValue() + " ");
		if (rightLeafIndex < tree.length && tree[rightLeafIndex] != null) {
			printTree((searchedIndex + 1) * 2);
		}
	}

}
