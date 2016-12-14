package searchAlgorithms;

public class Searching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static boolean linearSearch(int[]a, int value){
		for(int i =0;i<a.length;i++){
			if(a[i]==value)
				return true;
		}
		return false;
	}
	public static boolean linearSearchRecur(int[] a, int value, int index){
		if(a[index]==value)
			return true;
		else{
			index++;
			if(index>=a.length)
				return false;
			else
				return linearSearchRecur(a,value,index);
		}
	}
	public static boolean binSearch(int[] a, int value){// assumes data is sorted in ascending order
		int minIndex = 0;
		int maxIndex = a.length-1;
		while(minIndex<=maxIndex){
			int midIndex = (maxIndex+minIndex)/2;
			if(a[midIndex] == value)
				return true;
			else if(value>a[midIndex])
				minIndex=midIndex+1;
			else if(value<a[midIndex])
				maxIndex = midIndex-1;
		}
		return false;
	}
	public static boolean binSearchRecur(int[] a, int value,int minIndex,int maxIndex){
		int midIndex = (maxIndex+minIndex)/2;
		if(minIndex> maxIndex)
			return false;
		if(a[midIndex]==value)
			return true;
		else if(value>a[midIndex])
			return binSearchRecur(a,value,midIndex+1,maxIndex);
		else
			return binSearchRecur(a,value,minIndex,midIndex-1);
	}
	
}
























