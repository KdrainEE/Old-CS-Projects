package linkedLists;
//import java.io.*;
public class TacoManager {
	private GenLinkedList<Taco> tacos;
	private static final String DELIM = "\t";
	
	public TacoManager(){
		tacos = new GenLinkedList<Taco>();
	}
	public void AddTaco(Taco aTaco){
		tacos.Insert(aTaco);
	}
	public void RemoveTaco(Taco aTaco){
		tacos.ResetIteration();
		while(tacos.MoreToIterate()){
			if(tacos.GetDataAtCurrent().equals(aTaco)){
				tacos.DeleteCurrent();
				//break;
				return;
			}
			tacos.GoToNext();
		}
	}
}
