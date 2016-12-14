

public interface QueueInterface<T> {
	public T peek();
	public void print();
	public T dequeue();
	public void enqueue(T data);
	public int length();
	
	
}
