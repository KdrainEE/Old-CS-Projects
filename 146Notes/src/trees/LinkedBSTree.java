package trees;

public class LinkedBSTree<T extends Comparable<T>> {
	private class Node{
		private T data;
		//private Node parent;
		private Node leftChild;
		private Node rightChild;
		public Node(T aData){
			data=aData;
			leftChild=null;
			rightChild=null;
		}
	}
	private Node root;
	public LinkedBSTree(){
		root=null;
	}
	
	public void insert(T data){
		if(root==null)//tree is empty
			root = new Node(data);
		else
			insert(root,data);
	}
	private Node insert(Node aNode,T data){
		if(aNode==null)//found a leaf. Create a new node
			aNode=new Node(data);
		else if(data.compareTo(aNode.data)<0){//Go left
			aNode.leftChild=insert(aNode.leftChild,data);
		}
		else if(data.compareTo(aNode.data)>=0){//Go right
			aNode.rightChild=insert(aNode.rightChild,data);
		}
		return aNode;
	}
	
	public void delete(T data){
		delete(root, data);		
	}
	private Node delete(Node aNode,T data){
		//find the value 
		if(aNode==null)//data not found
			return null;
		if(data.compareTo(aNode.data)<0)//go left
			aNode.leftChild = delete(aNode.leftChild,data);
		else if(data.compareTo(aNode.data)>0)//go right
			aNode.rightChild = delete(aNode.rightChild,data);
		else{//FOUND IT KILL IT
			if(aNode.rightChild == null)//either no children or just left
				return aNode.leftChild;
			if(aNode.leftChild == null)//right child only
				return aNode.rightChild;
			//we hare two children if it reaches here 
			Node temp = aNode;
			//find the minimum in the tree
			aNode = findMinInTree(aNode.rightChild);
			//delete the duplicate min in right subtree
			aNode.rightChild = deleteMinFromTree(aNode.rightChild);
			aNode.leftChild = temp.leftChild;
		}		
		return aNode;
		
	}
	private Node findMinInTree(Node aNode){
		if(aNode==null)
			return null;
		if(aNode.leftChild==null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
	private Node deleteMinFromTree(Node aNode){
		if(aNode == null)
			return null;
		if(aNode.leftChild==null)
			return aNode;
		aNode.leftChild = deleteMinFromTree(aNode.leftChild);
		return aNode;
	}
	
	public void printPreOrder() 
	{
		printPreOrder(root);
	}
	private void printPreOrder(Node aNode)
	{
		if(aNode == null)
			return;
		//Process
		System.out.println(aNode.data);
		if(aNode.leftChild != null)
			printPreOrder(aNode.leftChild);
		if(aNode.rightChild != null)
			printPreOrder(aNode.rightChild);
		return;
	}
	
	public void printInOrder()
	{
		printInOrder(root);
	}
	private void printInOrder(Node aNode)
	{
		if(aNode == null)
			return;
		if(aNode.leftChild != null)
			printInOrder(aNode.leftChild);
		
		System.out.println(aNode.data);//process the node
		
		if(aNode.rightChild != null)
			printInOrder(aNode.rightChild);
		return;
	}
	
	public void printPostOrder(){
		printPostOrder(root);
	}
	private void printPostOrder(Node aNode){
		if(aNode == null)
			return;
		if(aNode.leftChild != null)
			printPostOrder(aNode.leftChild);
		if(aNode.rightChild != null)
			printPostOrder(aNode.rightChild);
		//process
		System.out.println(aNode.data.toString());
			
	}
}























