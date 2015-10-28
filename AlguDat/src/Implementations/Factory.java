package Implementations;

import Interfaces.AdtList;
import Interfaces.AdtStack;

public class Factory {
	public static AdtList create(){
		return new AdtListImpl();
	}
	
	public static AdtStack createS(){
		return new AdtStackImpl();
	}	
}
