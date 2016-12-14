

public class LinkedListQueue<T> implements QueueInterface {
	private class ListNode {
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink){
			this.data = aData;
			this.link = aLink;
		}
	}
	ListNode head;//points to first item
	ListNode tail;//points to last item
	public LinkedListQueue() {
		head = null;
		tail = head;
	}
	public void enqueue(Object data){
		ListNode newNode = new ListNode((T)data,null);
		if(head==null){
			head = newNode;
			tail = head;
			return;
		}
		this.tail.link = newNode;
		this.tail = newNode;
	}
	public T dequeue(){
		if(head==null)
			return null;
		ListNode retNode = head;
		head = head.link;
		return retNode.data;
	}
	public T peek(){
		return head.data;
	}
	public void print(){
		ListNode temp = head;
		while(temp!=null){
			System.out.println(temp.data.toString());
			temp = temp.link;
		}
	}
	public int length(){
		int length=0;
		ListNode temp = head;
		while(temp!=null){
			length++;
			temp=temp.link;
		}
		return length;
	}
}



























