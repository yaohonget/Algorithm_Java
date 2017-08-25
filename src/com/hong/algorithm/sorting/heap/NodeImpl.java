package com.hong.algorithm.sorting.heap;

import com.hong.algorithm.sorting.capi.Sort;
import com.hong.algorithm.sorting.heap.capi.Node;

public class NodeImpl implements Node {

	@Override
	public boolean isRoot() {
		return !hasParent();
	}

	@Override
	public boolean hasLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasParent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node getParentNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNodeValue(int pValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNodeValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasLeftLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node getLeftLeaf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLeftLeaf(Node pNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasRightLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node getRightLeaf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRightLeaf(Node pNode) {
		// TODO Auto-generated method stub
		
	}

}
