package implementations;

import interfaces.AdtArray;
import interfaces.AdtQueue;
import interfaces.AdtList;
import interfaces.AdtStack;

public class Factory {

	public static AdtList create() {
		return new AdtListImpl();
	}
	
	public static AdtStack createS() {
		return new AdtStackImpl();
	}

	public static AdtQueue createQ() {
		return new AdtQueueImpl();
	}
	
	public static AdtArray initA() {
		return new AdtArrayImpl();
	}
	
}
