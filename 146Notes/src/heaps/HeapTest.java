package heaps;

import java.util.*;

public class HeapTest {

	public static void main(String[] args) {
		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(10);
		Random rand = new Random();
		
		for (int i = 0; i<10;i++){
			heap.insert(rand.nextInt(100));
		}
		heap.heapSort();
	}

}
