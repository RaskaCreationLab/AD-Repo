package implementations;

import interfaces.AdtArray;
import interfaces.AdtQueue;

public class Factory {
	
	public static AdtQueue createQ() {
		return new AdtQueueImpl();
	}
	
	public static AdtArray initA() {
		return new AdtArrayImpl();
	}
	
}
