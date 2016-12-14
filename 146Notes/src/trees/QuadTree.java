package trees;

import java.util.*;
//this will be a STATIC quad tree
public class QuadTree {
	private class Node
	{
		private ArrayList<Collider> colliders;
		private double x,y;//top left point of the box
		private double sideLength;//Size of the square box
		private Node TL, TR, BL, BR;
		
		public Node(double aX, double aY, double aSideLength)
		{
			this.x = aX;
			this.y = aY;
			this.sideLength = aSideLength;
		}
	}
	private Node root;
	private int depth;
	
	public QuadTree(double aSideLength, int aDepth)
	{
		if (aDepth < 1 && aSideLength <= 0)
			return;
		//need to subdivide
		root = subdivideNode(0.0,0.0,aSideLength,aDepth);
	}
	private Node subdivideNode(double aX, double aY, double sideLength, int aDepth)
	{
		Node aNode = new Node(aX,aY,sideLength);
		if (aDepth > 0)
		{
			double halfSide = sideLength/2.0;
			aNode.TL = subdivideNode(aX,aY,halfSide,aDepth-1);
			aNode.TR = subdivideNode(aX+halfSide,aY,halfSide,aDepth-1);
			aNode.BL = subdivideNode(aX,aY+halfSide,halfSide,aDepth-1);
			aNode.BR = subdivideNode(aX+halfSide,aY+halfSide,halfSide,aDepth-1);
		}
		return aNode;
	}
	public void addCollider(Collider aCollider)
	{
		addCollider(root,aCollider);
	}
	private void addCollider(Node aNode, Collider aCollider)
	{
		//check if it is contained in TL TR BL BR
		if(isContained(aNode.BL,aCollider))
			addCollider(aNode.BL, aCollider);
		else if (isContained(aNode.BR, aCollider))
			addCollider(aNode.BR, aCollider);
		else if (isContained(aNode.TL,aCollider))
			addCollider(aNode.TL,aCollider);
		else if (isContained(aNode.TR,aCollider))
			addCollider(aNode.TR,aCollider);
		else
			aNode.colliders.add(aCollider);
	}
	private boolean isContained(Node aNode, Collider aCollider)
	{
		return aNode.x < aCollider.getX() && aCollider.getX() < aNode.x + aNode.sideLength
				&& aNode.y < aCollider.getY() && aCollider.getY() < aNode.y + aNode.sideLength;
	}
}



















