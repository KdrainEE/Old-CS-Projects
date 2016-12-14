package Queues;

public class ArrayQueue <T> implements QueueInterface {
	private T[] queue;
	private int tailIndex; //first empty item
	public static final int DEFAULT_SIZE = 50;
	
	public ArrayQueue() {
		initialize(DEFAULT_SIZE);
	}
	public ArrayQueue(int size) {
		initialize(size);
	}
	private void initialize(int size) {
		if (size<=0)
			return;
		queue = (T[])(new Object[size]);
		tailIndex = 0;
	}
	public void enqueue(Object data) {
		if(this.queue.length<=this.tailIndex)//it's full
			return;
		this.queue[tailIndex] = (T)data;
		tailIndex++;
	}
	public T dequeue() {
		T returnItem = this.queue[0];
		for(int i = 0; i<this.tailIndex;i++){
			this.queue[i] = this.queue[i+1];
		}
		this.tailIndex--;
		return returnItem;
	}
	public T peek(){
		return this.queue[0];
	}
	public void print() {
		for(int i=0;i<this.tailIndex;i++){
			System.out.println(this.queue[i].toString());
		}
	}
}
























