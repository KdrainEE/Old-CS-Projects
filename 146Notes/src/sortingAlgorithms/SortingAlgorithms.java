package sortingAlgorithms;

public class SortingAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,4,3,2,1};
		selectionSort(arr);

	}
	public static void/*int[]*/ selectionSort(int[] a){
		for(int i=0;i<a.length;i++){
			int smallestIndex = i;
			for(int j=i;j<a.length;j++){
				if(a[j] < a[smallestIndex])
					smallestIndex = j;
			}
			if(smallestIndex!= i){//SWAP
				int temp = a[i];
				a[i] = a[smallestIndex];
				a[smallestIndex]=temp;
			}
		}
		//return a;
	}
	public static void bubbleSort(int[] a){
		boolean hasSwapped = true;
		while(hasSwapped){
			hasSwapped = false;
			for(int i = 0; i<a.length-1;i++){
				if(a[i]>a[i+1]){//needs to swap
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1]=temp;
					hasSwapped = true;
				}
			}
		}
	}
	public static void inLineMergeSort(int[] a, int left, int right){
		int mid;
		if(right>left){
			mid =(right+left)/2;
			inLineMergeSort(a,left,mid);
			inLineMergeSort(a,mid+1,right);
			//merge
			merge(a,left,mid+1,right);
			
		}
		
	}
	public static void merge(int[] a, int left,int mid,int right){
		int[] temp = new int[a.length];
		int leftEnd = mid-1;
		int tempPos = left;
		int numElements = right-left+1;
		
		while(left<=leftEnd&&mid<=right){
			if(a[left]<=a[mid]){//adds the value at the left to the temp array
				temp[tempPos++]=a[left++];
			}
			else{//adds the value at the middle to the temp array
				temp[tempPos++]=a[mid++];
			}
		}
		while(left<=leftEnd){//left array may not be complete
			temp[tempPos++]=a[left++];
		}
		while(mid<=right){//right array may not be complete
			temp[tempPos++]=a[mid++];
		}
		for(int i=left;i<=right;i++){//fix up to sort array a
			a[i]=temp[i];
		}
	}
	public static void mergeSort(int[] a){
		int size = a.length;
		if (size<2)//recursive halting point
			return;
		int mid = size/2;
		int leftSize = mid;
		int rightSize = size-mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		
		for(int i=0;i<mid;i++){//starts at beginning and goes to middle
			left[i] = a[i];
		}
		for(int i=mid;i<size;i++){//starts at middle and go to end
			right[i-mid]=a[i];
		}
		mergeSort(left);
		mergeSort(right);
		//merge
		merge(left,right,a);
	}
	private static void merge(int[] left, int[] right, int[]a){
		int leftSize = left.length;
		int rightSize = right.length;
		int i=0;//index of the left array
		int j=0;//index of the right array
		int k=0;//index of the sorted array (a)
		
		while(i<leftSize&&j<rightSize){
			if(left[i]<=right[j]){//value in left array was smaller than value in right array
				a[k]=left[i];
				i++;
				k++;
			}
			else{//Value in the right was smaller than the value in the left array
				a[k]=right[j];
				j++;
				k++;
			}
			while(i<leftSize){//values still left in left side
				a[k]=left[i];
				i++;
				k++;
			}
			while(j<rightSize){//Values still left in right array
				a[k]=right[j];
				j++;
				k++;
			}
		}
	}
	public static void quickSort(int[] a,int left,int right){
		//partition
		int index=partition(a,left,right);
		if(left<index-1)
			quickSort(a,left,index-1);
		if(index<right)
			quickSort(a,index,right);
	}
	private static int partition(int[] a,int left,int right){
		int i=left;
		int j=right;
		int pivot=a[(left+right)/2];
		
		while(i<=j){
			while(a[i]<pivot)
				i++;
			while(a[j]>pivot)
				j--;
			if(i<=j){//swap
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}			
		}
		return i;
	}
}