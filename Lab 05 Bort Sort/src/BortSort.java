import java.util.Scanner;

public class BortSort {
	public static void quickSortBorts(Bort[] a,int left,int right){//sorts array of borts by their number of borts
		//partition
		int index=partition(a,left,right);
		if(a[left].getNumBorts()<a[index-1].getNumBorts())
			quickSortBorts(a,left,index-1);
		if(index<right)
			quickSortBorts(a,index,right);
	}
	private static int partition(Bort[] a,int left,int right){
		int i=left;
		int j=right;
		int pivot=a[(left+right)/2].getNumBorts();
		
		while(i<=j){
			while(a[i].getNumBorts()<pivot)
				i++;
			while(a[j].getNumBorts()>pivot)
				j--;
			if(i<=j){//swap
				Bort temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}			
		}
		return i;
	}
	
	//This creates a new bort given a string, probably what the user entered on the console
	public static Bort createBort(String aBort){ 
		Bort newBort = new Bort(aBort,0);
		aBort = aBort.toLowerCase();
		aBort = aBort.replace(" ","");
		aBort = aBort.replace("bort"," bort ");
		int bortCount = aBort.split("bort",-1).length-1;
		/*Scanner bortScanner = new Scanner(aBort);
		int bortCount = 0;
		String temp;
		while((String temp=bortScanner.next().equals("bort")){
			bortCount++;
		}*/
		newBort.setNumBorts(bortCount);
		System.out.println(bortCount);
		return newBort;
	}

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		System.out.println("Enter any number of strings. When you are done enter quit and I will sort by Borts!");
		LinkedListQueue listOfBorts = new LinkedListQueue();
		String aString = null;
		while(!(aString = user.nextLine()).equals("quit")){
			listOfBorts.enqueue(createBort(aString));
			System.out.println(listOfBorts.peek().toString());
		}
		//listOfBorts.print();
		Bort[] borts = new Bort[listOfBorts.length()];
		for(int i=0;i<borts.length;i++){
			borts[i]=(Bort) listOfBorts.dequeue();
		}
		quickSortBorts(borts,0,borts.length-1);

		System.out.println("Bort Sorted");
		for(int i=0;i<borts.length;i++){
			System.out.println(borts[i].getName());
		}
	}

}

















