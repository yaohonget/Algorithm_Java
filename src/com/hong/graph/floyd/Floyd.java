package com.hong.graph.floyd;

import com.hong.graph.capi.Graph;

public class Floyd implements Graph {

	public static void main(String[] args) {
		Floyd floyd = new Floyd();
		floyd.findShortestPath();
	}

	@Override
	public void init() {

	}

	public void findShortestPath() {
		
		for (int i = 0; i < floydMatrix.length; i++) {
			for (int j = 0; j < floydMatrix[0].length; j++) {
				System.out.printf("%5s", floydMatrix[i][j] + "|");
			}
			System.out.println();
		}
		
		System.out.println("Start to search...");
		int[][] toBeFound = floyd(floydMatrix);

		for (int i = 0; i < toBeFound.length; i++) {
			for (int j = 0; j < toBeFound[0].length; j++) {
				System.out.printf("%5s", toBeFound[i][j] + "|");
			}
			System.out.println();
		}

	}

	protected int[][] floyd(int[][] pToBeFound) {
		int[][] toBeFound = pToBeFound;
		int len = 0;
		int width = 0;
		if (toBeFound.length > 0) {
			len = toBeFound.length;
			if (toBeFound[0].length > 0) {
				width = toBeFound[0].length;
			}
		}

		if (len > 0 && width > 0) {
			for (int level = 0; level < len; level++) {
				// start to search from each note to all other notes
				for (int i = 0; i < len; i++) {
					for (int j = 0; j < width; j++) {
						if (i == j || i == level || j == level) {
							continue;
						}
						int start = toBeFound[i][level];
						int end = toBeFound[level][j];
						if (start < 0) {
							start = 0;
						}
						if (end < 0) {
							end = 0;
						}
						if (toBeFound[i][j] < 0) {
							toBeFound[i][j] = start + end;
						} else if (toBeFound[i][j] > (start + end)) {
							toBeFound[i][j] = start + end;
						}
					}
				}
			}

		}

		return toBeFound;
	}

}
