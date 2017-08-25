package com.hong.graph.dijkstra;

import com.hong.graph.capi.Graph;

public class Dijkstra implements Graph {
	
	public static void main(String [] args) {
		Dijkstra dijkstra = new Dijkstra();
		dijkstra.findShortestPath(0);
	}

	@Override
	public void init() {		
	}
	
	public void findShortestPath(int pStart) {
		
		for (int i = 0; i < dijkstraMatrix.length; i++) {
			for (int j = 0; j < dijkstraMatrix[0].length; j++) {
				System.out.printf("%5s", dijkstraMatrix[i][j] + "|");
			}
			System.out.println();
		}
		
		System.out.printf("Start to find shortest path from %d ...\n", pStart);
		int[] toBeFound = dijkstra(dijkstraMatrix, 0);

		System.out.printf("Finially path starting from %d : ", pStart);
		for(int i = 0; i < toBeFound.length; i++ ) {
			System.out.printf(" %5d|", toBeFound[i]);
		}
	}
	
	protected int [] dijkstra(int[][] pToBeFound, int pStart) {
		int[][] toBeFound = pToBeFound;
		
		int start = pStart;
			
		int [] dis = toBeFound[start];
		int [] foundDis = new int[dis.length];
		for(int i = 0; i < dis.length; i++ ) {
			if(i == pStart) {
				foundDis[i] = 0;
			}
			else {
				foundDis[i] = -1;
			}
		}
		
		System.out.printf("Initial path starting from %d : ", pStart);
		for(int i = 0; i < dis.length; i++ ) {
			System.out.printf(" %5d|", dis[i]);
		}
		System.out.println();
		for(int level = 0; level < dis.length; level++ ) {
			if(level == pStart) {
				continue;
			}
			int currentShortest = getNextNearestNode(start, dis, foundDis);
			int [] nextArr = pToBeFound[currentShortest];
			for(int i = 0; i < nextArr.length; i++) {
				if(i == currentShortest || nextArr[i] < 0) {
					continue;
				}
				else if(dis[i] < 0 || (dis[i] > (dis[currentShortest] + nextArr[i]))){
					dis[i] = dis[currentShortest] + nextArr[i];
				}
			}
			foundDis[currentShortest] = dis[currentShortest];
		}		
		
		return foundDis;
	}
	
	protected int getNextNearestNode(int pStartNode, int [] pDis, int [] pFoundDis) {
		int foundPos = pStartNode;
		if(foundPos < pDis.length) {
			int shortest = -1;
			for(int i = 0; i < pDis.length; i++) {
				if(i == pStartNode || pDis[i] < 0 || pFoundDis[i] > 0) {
					continue;
				}
				if(shortest < 0) {
					foundPos = i;
					shortest = pDis[i];
				}
				else {
					if(shortest > pDis[i]) {
						foundPos = i;
						shortest = pDis[i];
					}
				}
			}
		}
		return foundPos;
	}

}
