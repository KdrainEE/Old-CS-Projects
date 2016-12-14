package Stacks;

public class ArrayStack<T> implements StackInterface {
	private T[] stack;
	public static int MAX_STACK_SIZE = 100;
	private int head;//first null element
	
	public ArrayStack(){
		stack = (T[]) (new Object[MAX_STACK_SIZE]);
		head = 0;
	}
	public ArrayStack(int size){
		if(size<=0)
			return;
		stack = (T[]) new Object[size];
		head = 0;
	}
	public void push(Object aData){
		if(head>=stack.length){
			System.out.println("The stack is full");
			return;
		}
		T tData = (T)aData;
		stack[head] = tData;
		head++;
	}
	public T pop(){
		if(head==0){
			System.out.println("The stack is empty");
			return null;
		}
		T retVal = stack[head-1];
		head--;
		return retVal;
	}
	public T peek(){
		if(head>0)
			return stack[head-1];
		else
			return null;
	}
	public void print(){
		for(int i = head-1; i>=0;i--){
			System.out.println(stack[i].toString());
		}
	}
}



























