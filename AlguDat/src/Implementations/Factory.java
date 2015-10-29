package implementations;

import interfaces.AdtArray;
import interfaces.AdtQueue;
import interfaces.AdtList;
import interfaces.AdtStack;

public class Factory {

	public static AdtQueue createQ() {
		return new AdtQueueImpl();
	}
	
	public static AdtArray initA() {
		return new AdtArrayImpl();
	}
	
}
