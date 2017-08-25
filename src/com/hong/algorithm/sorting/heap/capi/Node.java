package com.hong.algorithm.sorting.heap.capi;

public interface Node {
	public boolean isRoot();
	public boolean hasLeaf();
	public boolean hasParent();
	public Node getParentNode();
	public void setNodeValue(int pValue);
	public int getNodeValue();
	
	public boolean hasLeftLeaf();
	public Node getLeftLeaf();
	public void setLeftLeaf(Node pNode);
	public boolean hasRightLeaf();
	public Node getRightLeaf();
	public void setRightLeaf(Node pNode);
}
