package linkedLists;

public class GenLinkedList <T> {
	private class ListNode{
		private T data;
		private ListNode link;
		public ListNode(){
			data = null;
			link = null;
		}
		public ListNode(T aData, ListNode aNode){
			data = aData;
			link = aNode;
		}
	}
	
	private ListNode head; //points to first item
	private ListNode current;
	private ListNode previous;
	
	public GenLinkedList(){
		head = current = previous = null;
	}
	public T GetDataAtCurrent(){//Accessor
		if (current != null)
			return current.data;
		else
			return null;
	}
	public void SetDataAtCurrent(T aData){//Mutator
		if (current != null)
			current.data = aData;
	}
	public void Insert(T newData){//Inserts at the end of the list
		//Construct the node
		ListNode newNode = new ListNode();
		newNode.data = newData;
		if (head == null){ //checks if list is empty
			head = newNode;
			current = head;
			return;
		}
		ListNode temp = head;
		while (temp.link != null){
			temp = temp.link;
		}
		temp.link = newNode;
	}
	public void InsertAfterCurrent(T newData){
		ListNode newNode = new ListNode();
		newNode.data = newData;
		if(current != null){
			newNode.link = current.link;
			current.link = newNode;
		}
	}
	//Iteration methods to move around the current
	public void ResetIteration(){
		current = head;
		previous = null;
	}
	public boolean MoreToIterate(){
		return current != null;
	}
	public void GoToNext(){
		if(current != null){
			previous = current;
			current = current.link;
		}
	}
	public void DeleteCurrent(){
		if(current!=null && previous!=null){//middle of the list
			previous.link = current.link;
			current = current.link;
		}
		else if(current!=null && previous==null){//pointing to head
			head =current.link;
			current = head;
		}
		else{
			System.out.println("Deleting nothing. Nothing from nothing is nothing");
		}
	}
	public void ShowList(){
		ListNode temp = head;
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
}