package hashTable;
import java.util.*;
public class CarHashTable {
	private ArrayList<Car>[] table;
	private static final int TABLE_SIZE =100;
	
	public CarHashTable()
	{
		table = new ArrayList[TABLE_SIZE];
		for(int i=0;i<table.length;i++)
		{
			table[i] = new ArrayList<Car>();
		}
	}
	//hash function
	private int calcCarIndex(Car aCar)
	{
		int index = 0;
		String makeAndModel = aCar.getMake()+aCar.getModel();
		for(int i=0;i<makeAndModel.length();i++)
			index+= makeAndModel.charAt(i);
		index%= TABLE_SIZE;
		return index;
		
	}
	public void add(Car aCar)
	{
		table[calcCarIndex(aCar)].add(aCar);
	}
	public void remove(Car aCar)
	{
		int index = calcCarIndex(aCar);
		if(table[index].contains(aCar))
			System.out.println(table[index].remove(aCar));
		else
			System.out.println("Car not found");
	}
	public void lookup(Car aCar)
	{
		int index = calcCarIndex(aCar);
		if(table[index].contains(aCar))
			System.out.println(aCar.toString());
		else
			System.out.println("Car not found");
	}
}
