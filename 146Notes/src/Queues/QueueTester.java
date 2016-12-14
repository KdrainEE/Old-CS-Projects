package Queues;

public class QueueTester {
	public static void main(String[] args){
		QueueInterface<Integer> queue = new LinkedListQueue<Integer>();
		
		for(int i=0; i<10;i++){
			queue.enqueue(i);
		}
		queue.print();
	}

}
