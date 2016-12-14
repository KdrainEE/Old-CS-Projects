package searchTester;
import java.util.*;

public class SearchTester {
	
	public static Random rand = new Random();
	
	public static void printArray(int[] data){
		for(int i=0;i<data.length;i++){
			System.out.println(data[i]);
		}
	}
	
	public static int[] createSearchable(){
		int[] searchable = new int[1000];
		for (int i=0;i<searchable.length;i++){
			searchable[i] = rand.nextInt(1000);
		}
		SortingAlgorithms.bubbleSort(searchable);
		return searchable;
	}

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		
		System.out.println("Welcome to the search tester.");
		System.out.println("Let's see which method performs better.");
		int[] linCounts = new int[20];
		int[] binCounts = new int[20];
		
		for (int i=0;i<20;i++){
			int searchVal = rand.nextInt(1000);
			int[] searchable = createSearchable();
			//linear search
			System.out.println("Searching using linear search");
			int linCount = 0;
			boolean linFound = false;
			for(int j=0;j<searchable.length;j++){
				linCount++;
				if(searchable[j] == searchVal){
					linFound = true;
					break;
				}		
			}
			if(linFound)
				System.out.println("Found");
			else
				System.out.println("Not found");
			
			//binary search
			System.out.println("Searching using binary search.");
			int binCount = 0;
			boolean binFound = false;
			int minIndex = 0;
			int maxIndex = searchable.length-1;
			while(minIndex<=maxIndex){
				binCount++;
				int midIndex = (maxIndex+minIndex)/2;
				if(searchable[midIndex]==searchVal){
					binFound = true;
					break;
				}
				else if(searchVal>searchable[midIndex])
					minIndex = midIndex+1;
				else if(searchVal<searchable[midIndex])
					maxIndex = midIndex-1;
			}
			if(binFound)
				System.out.println("Found");
			else
				System.out.println("Not found");
			
			linCounts[i] = linCount;
			binCounts[i] = binCount;
			System.out.println("Linear checks: "+linCount);
			System.out.println("Binary checks: "+binCount);
			System.out.println();
		}
		int totalLin = 0;
		for(int j=0;j<linCounts.length;j++){
			totalLin += linCounts[j];
		}
		int avgLin = totalLin/20;
		
		int totalBin = 0;
		for(int k=0;k<binCounts.length;k++){
			totalBin += binCounts[k];
		}
		int avgBin = totalBin/20;
		System.out.println("The average number of checks for 20 iterations were:");
		System.out.println("Linear search: "+avgLin);
		System.out.println("Binary search: "+avgBin);
		
	}
}

























