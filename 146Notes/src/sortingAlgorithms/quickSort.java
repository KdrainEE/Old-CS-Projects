package sortingAlgorithms;
import java.util.*;
public class quickSort {
	public static void quickSort(int[] a, int left, int right)
	{
		//TODO partition the current array
		int index = partition(a,left,right);
		//recursive calls until dealing with an array of size 1
		if(left<index-1)
			quickSort(a,left,index-1);//partition left of the pivot
		if(right>index)
			quickSort(a,index+1,right);
	}
	private static int partition(int[] a, int left, int right)
	{
		int i = left;
		int j = right;
		int pivot  = (left+right)/2;
		
		while(i<=j)//attempt to swap elements until the indices run into each other
		{
			while(a[i]<pivot)
				i++;
			while(a[j]>pivot)
				j--;
			if(i<=j)//swap because the indices haven't met yet
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		return i;
	}
	
	
	public static void main(String[] args)
	{
		Random rand  = new Random();
		int[] a = new int[100];
		for(int i=0;i<100;i++)
		{
			a[i] = rand.nextInt(100);
		}
		System.out.println("hello world");
		quickSort(a,0,99);
		SortingAlgorithms.quickSort(a, 0, 99);
		for(int j=0;j<100; j++)
		{
			System.out.println(a[j]);
		}
	}
}
