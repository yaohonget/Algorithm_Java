package com.hong.graph.capi;

public interface Graph {
	
	public final int [][] floydMatrix = {{0, 2, 6, 4},{-1, 0, 3, -1},{7, -1, 0, 1},{5, -1, 12, 0}};
	
	public final int [][] dijkstraMatrix = {{0, 1, 12, -1, -1, -1}, {-1, 0, 9, 3, -1, -1}, {-1, -1, 0, -1, 5, -1}, {-1, -1, 4, 0, 13, 15}, {-1, -1, -1, -1, 0, 4}, {-1, -1, -1, -1, -1, 0}};
	
	public void init();
	
}
