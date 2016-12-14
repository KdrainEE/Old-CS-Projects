package midtermReview;

public class Review {
	
	
	/*Midterm Review

		Java Review:
		1. Give the output of this method. If it errors out, explain why.
		private void methodOne() {
			int a = 10
			for ( int i = 0; i < a; i++ ) {
				for ( int j = 2; j != 0; j-- ) {
					System.out.println("*");
					i++;
				}
			}
		}
		
		2. Give the output of this method. If it errors out, explain why.
		private void methodTwo() {
			int[] a = { 1,3,5,7,9,11,13,15 };
			for( int i = a.length; i >= 0; i-- ) {
				System.out.println( a[ i ] );
			}
		}
		
		3. Give the output of the following code.
		public static void main (String[] args) {
			Node aNode = new Node( 1 );
			changeValue1( aNode );
			System.out.println("Data: " + aNode.data);
			changeValue2( aNode );
			System.out.println("Data: " + aNode.data);
		}
		
		public static void changeValue1(Node x) {
			x = new Node( 2 );
		}
		
		public static void changeValue2(Node x) {
			x.data = 3;
		}
		
		static class Node {
			public int data;
			public Node pointer;
			
			public Node(final int data) {
				this.data = data;
				pointer = null;
			}
		}
		
		4. Write a private method called "factorial" that takes in a final integer n and returns the factorial of n.
		
		*/ 
			private int factorial(final int n){
				int result = 1;
				for(int i=result; i<=n;i++)
					result*=i;
				
				return result;
			}
		/*
		
		5. Write a public method called "sumEvens" that takes in an integer n and returns the sum of ALL EVEN NUMBERS in the range [0,n].
		
		6. Write a public static method called "isDivisibleBy" that takes in two integers n and m and returns if n is divisible by m. You may not use the modulus operator.
		*/
			public static boolean isDivisibleBy(int n, int m){
				int result = n;
				boolean isDivisible = false;
				while(result >=0){
					if(result==0)
						isDivisible = true;
					result -=m;
				}
				return isDivisible;
			}
		/*
		Linked Lists:
		7. What is the greatest advantage of using a linked list over an array?
		8. How are linked lists stored in memory compared to how arrays are stored in memory? Draw a diagram to explain this.
		
		Now let's perform some common linked list operations, draw diagrams where appropriate and also indicate where the following are: head, tail, current, previous.
		9. Insert the following list into a linked list in the order given: { 7,2,5,1,10,43,3,5 }
		10. Delete a node with data 5 and a node with data 43 from this list
		11. Write a method called "goToNext()" that moves current to the next node
		
			public void goToNext(){
				if(current!=null){
					previous = current;
					current = current.link;
				}	
			}
		
		12. Call "goToNext()" 3 times and delete the node AFTER the current
		13. Finally, write a method that inserts a new node after the current
		
		Queues:
		14. What is the primary principle that Queues follow?
		
		Now let's write the queue operations. Assume the queue is a queue of positive integers. Write either the linked version or array version, just stay consistent. (or do both!)
		15. Write the "enqueue" method for a queue
		16. Write the "dequeue" method
		17. Write the "peek" method
		
		Now let's perform some basic operations on queues, draw diagrams and indicate where the head and tail are.
		18. Insert the following list into a queue in the order given: { 12, 8, 3, 44, 2, 4, 2 }
		19. Dequeue three times
		20. Enqueue 3 and 7
		21. Give the output of peek
		22. Dequeue two times
		23. Give the output of peek
		24. Enqueue 1
		
		Stacks:
		25. What is the primary principle that Stacks follow?
		
		Now let's write the stack operations. Assume the stack is a stack of positive integers. Write either the linked version or array version, just stay consistent. (or do both!)
		26. Write the "push" method for a stack
		27. Write the "pop" method
		28. Write the "peek" method
		
		Now let's perform some basic operations on stacks, draw diagrams and inidcate where the head is.
		29. Insert the following list into a stack in the order given: { 3, 7, 22, 9, 30, 66, 1 }
		30. Give the output of peek
		31. Push 10 and 8
		32. Give the output of peek
		33. Pop 5 times
		34. Push 19 and 20
		35. Give the output of peek
		
		Recursion:
		For numbers 36-38 consider the following method:
		
		*/public static String methodThree(final String aString) {
			if( aString.length() == 1 )
				return aString;
			
			int mid = aString.length()/2;
		
			String firstHalf = methodThree( aString.substring(0,mid) );
			String secondHalf = methodThree( aString.substring(mid) );
		
			return secondHalf + firstHalf;
		}/*
		hello
		he llo
		h e l lo
		h e l l 0
		eh l ol
		eh oll
		olleh
		
		
		36. What will this method return if "hello" is passed in?
		37. What will this method return if "abcdefg" is passed in?
		38. What does this method do?
		
		For numbers 39-41 consider the following method:
		
		public String methodFour(final String aString) {
			if( aString.length() == 1 )
				return aString;
		
			int mid = aString.length()/2;
		
			String firstHalf = methodFour( aString.substring(0,mid) );
			String secondHalf = methodFour( aString.substring(mid) );
		
			String result = "";
		
			if( ! firstHalf.equals( "a" ))
				result += firstHalf;
			if( ! secondHalf.equals( "a"))
				result += secondHalf;
		
			return result;
		}
		
		39. What will this method return if "abc" is passed in?
		40. What will this method return if "abba" is passed in?
		41. What does this method do?
		
		For the following, use recursion. Multiple methods may be necessary.
		42. Write a method called "search" that takes an array of integers "anArray" and an integer "n" and returns a boolean indicating if the value "n" is in "anArray"
		43. Write a method call "fib" that takes an integer "n" and returns the nth term in the fibonacci sequence
		44. Write a method called "factorial" that takes an integer "n" and returns n!
		
		Searching/Sorting/Asymptotics
		45. Order the following by increasing big O complexity: 
			a) indexing into an array 			O(1)
			b) merge sort						O(nlgn)
			c) binary search					O(lgn)
			d) quick sort						O(n^2)
			e) inserting into a linked list		O(1)
			f) inserting into an array			O(n)
			g) selection sort					O(n^2)
			h) bubble sort						O(n^2)
			i) indexing into a linked list		O(n)
			a & e, c, f & i, b, g & h & d 
		
		For each of the following arrays, simulate both selection sort and merge sort:
		46. { 1, 2, 3, 4, 5, 6 }
		47. { 8, 1, 9, 20, 3, 44 }
		48. { 50, 22, 5, 90, 11, 32, 74}
		
		49. Give the big O of the following method
		public int[ ] methodFive(int [ ] array) {
			int[ ] result = new int[array.length];
			for( int i = 1; i >= 5; i++ ) {
				for ( int h = 0 ; h != array.length; h++) {
					result[ i ] = array[ h ] * i;
				}
			}
		}
		
		49. Give the big O of the following method
		public String methodSix(final String aString) {
			final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			String newString = "";
			for( int i = 0; i != aString.length(); i++ ) {
				final char letter = aString.charAt( i );
				int number = 0;
				for( int h = 0; h != alphabet.length; h++ ) {
					if( letter == alphabet[ h ] ) {
						number = h + 1;
						if( number >= alphabet.length )
							number = 0;
						break;
					}
				}
				newString += alphabet[number];
			}
			return newString;
		}
		
		50. Give the big O of the following method
		public boolean methodSeven(String input) {
			int i = 0;
			int j = input.length() - 1;
			while( i < j ) {
				if( input.charAt( i ) != input.charAt( j ))
					return false;
				i++;
				j--;
			}
			return true;
		}
		*/
		public static void main(String[] agrs){
			System.out.print(methodThree("abcdef"));
		}

}
