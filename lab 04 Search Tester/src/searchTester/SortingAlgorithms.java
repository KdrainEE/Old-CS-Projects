package searchTester;

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
	public static void mergeSort(int[] a, int left, int right){
		int mid;
		if(right>left){
			mid =(right+left)/2;
			mergeSort(a,left,mid);
			mergeSort(a,mid+1,right);
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
}






























