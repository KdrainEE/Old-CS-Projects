package Stacks;

public class StackTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//StackInterface<Integer> stack = new ArrayStack<Integer>();  Works exactly the same
		StackInterface<Integer> stack = new LinkedListStack<Integer>();
		for(int i=0;i<10;i++){
			stack.push(i);
		}
		for(int i=0; i<10; i++){
			System.out.println(stack.pop());
		}	
	}

}
