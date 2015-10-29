package implementations;

import interfaces.AdtList;
import interfaces.AdtStack;

public class Factory {
	public static AdtList create(){
		return new AdtListImpl();
	}
	
	public static AdtStack createS(){
		return new AdtStackImpl();
	}	
}
