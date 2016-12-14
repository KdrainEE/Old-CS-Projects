package Stacks;

public class LinkedListStack<T> implements StackInterface {
	private class ListNode{
		private T data;
		private ListNode link;
		public ListNode(T aData, ListNode aLink){
			data = aData;
			link = aLink;
		}
	}
	
	private ListNode head;	
	public LinkedListStack(){
		head = null;
	}
	//Useful to add size method to check how many elements are in the stack
	public void push(Object aData){
		ListNode newNode = new ListNode((T)aData, head);
		head = newNode;
	}
	public T pop(){
		if(head==null)
			return null;
		T retData = head.data;
		head = head.link;
		return retData;
	}
	public T peek(){
		if(head==null)
			return null;
		return head.data;
	}
	public void print(){
		ListNode temp = head;
		while(temp != null){
			System.out.println(temp.data.toString());
			temp = temp.link;
		}
	}
}

























