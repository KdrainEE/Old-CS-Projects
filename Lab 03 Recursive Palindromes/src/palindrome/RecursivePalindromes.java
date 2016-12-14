package palindrome;

import java.util.Scanner;
/*@Author Kyle Drain
 * 9/9/16
 */


public class RecursivePalindromes {
	//takes in a string that is all the same case and 
	//and returns true if the string is a palindrome
	public static boolean palindrome(String testPal){	//input string that is all the same case and has no whitespace
		//System.out.println(testPal);
		if (testPal.charAt(0)!=testPal.charAt(testPal.length()-1))
			return false;
		if(testPal.length()==1)
			return true;
		return palindrome(testPal.substring(1,testPal.length()-1));
	}
	public static boolean iterativePalindrome(String testPal){
		char[] reverse = new char[testPal.length()];
		int j=0;
		for(int i=testPal.length()-1;i>=0;i--){
			reverse[i]=testPal.charAt(j);
			j++;
		}
		for(int i=0;i<testPal.length();i++){
			if (reverse[i]!=testPal.charAt(i))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		System.out.println("Enter a word or phrase to determine if it is a palindrome");
		
		String wSpace = user.nextLine();
		String withoutSpace = wSpace.replace(" ","");// removes all spaces from the phrase entered
		boolean palindrome;
		if (withoutSpace.length()<2||withoutSpace==null) // declares the string a palindrome if it is null or has length
			palindrome = true;							// less than 2
		else
			palindrome = iterativePalindrome(withoutSpace.toLowerCase());// checks whether the phrase is a palindrome
		
		if (palindrome)
			System.out.println(wSpace+" is a palindrome"); //prints results to console
		else if(!palindrome)
			System.out.println(wSpace+" is not a palindrome");
		
	}

}




















