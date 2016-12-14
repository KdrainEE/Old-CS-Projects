package recursion;

import java.util.Scanner;

public class RecursionSimpleStuff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int factorial(int number){
		if(number==0)
			return 1;
		else
			return number*factorial(number-1);
	}
	public static int gcd(int a, int b){
		if(b==1)//Stopping condition
			return a;
		else
			return gcd(b,a%b);//recursive call
	}
	public static int fib(int number){
		if(number==1||number==2)//stopping condition
			return 1;
		else
			return fib(number-1)+fib(number-2);
	}

}
























