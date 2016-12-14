
public class GenLLQueue<T> {
	private class ListNode {
		T data;
		ListNode link;
		public ListNode(T data, ListNode link) {
			this.data = data;
			this.link = link;
		}
	}
	ListNode head;//first item
	ListNode tail;//last item
	public GenLLQueue(){
		head=tail=null;
	}
	public void enqueue(Object data){
		ListNode newNode = new ListNode((T)data,null);
		if(head==null){
			head = newNode;
			tail = head;
			return;
		}
		this.tail.link=newNode;
		this.tail=newNode;
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
	public void showQueue(){
		ListNode temp = head;
		while(temp!=null){
			System.out.println(temp.data.toString());
			temp=temp.link;
		}
	}
}





















