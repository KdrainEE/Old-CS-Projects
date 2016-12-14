package heaps;

//max heap
public class ArrayHeap <T extends Comparable> {
	public static final int DEFAULT_SIZE = 100;
	private T[] heap;
	private int size;
	
	public ArrayHeap()
	{
		heap = (T[]) new Comparable[DEFAULT_SIZE];
		size = 0;
	}
	public ArrayHeap(int size)
	{
		if(size<0)
			return;
		heap = (T[]) new Comparable[size];
		this.size =0;
	}
	//copy constructor
	public ArrayHeap(ArrayHeap aHeap)
	{
		
	}
	public void insert(T value)
	{
		if(size>= heap.length)
			return;//heap is full		
		heap[size] = value;
		//bubble up
		bubbleUp();
		size++;
	}
	private void bubbleUp()
	{
		int index = this.size;
		while(index>0 && heap[(index-1)/2].compareTo(heap[index])<0)
		{
			//swap
			T temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}
	}
	public T remove(){
		T retVal = heap[0];
		heap[0] = heap[size-1];
		size--;
		//bubble down
		bubbleDown();
		return retVal;
	}
	private void bubbleDown()
	{
		int index = 0;
		while(index*2+1<size)
		{
			//pick the larger child
			int bigIndex = index*2+1;//left child
			if (index*2+2<size && heap[index*2+1].compareTo(heap[index*2+2])<0)
			{
				bigIndex = index*2+2;
			}
			if(heap[index].compareTo(heap[bigIndex])<0)
			{
				//swap
				T temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
			{
				break;//done
			}
			index = bigIndex;
		}
	}
	public void heapSort()
	{
		//this does not preserve the heap
		for(int i=size; i>size; i--)
		{
			System.out.println(this.remove()+" ");
		}
	}
	
}














