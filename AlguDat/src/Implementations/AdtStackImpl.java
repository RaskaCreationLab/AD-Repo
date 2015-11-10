package Implementations;

import Interfaces.AdtList;
import Interfaces.AdtStack;

public class AdtStackImpl implements AdtStack{
	AdtStackImpl(){}
	
	public static AdtStack createS() {
		return new AdtStackImpl();
	}
	
	//Errorwert
	int ERRORCODE = -99999999;
	//Interne Liste auf der gearbeitet wird
	AdtList listStack = AdtListImpl.create();
	
	@Override
	//
	public void push(int elem) {
			listStack.insert(1,elem);	
	}

	@Override
	public void pop() {
		if(!listStack.isEmpty()){
			listStack.delete(1);
		}
	}

	@Override
	public int top() {
		if(!listStack.isEmpty()){
			return listStack.retrieve(1);
		}
		return ERRORCODE;
	}

	@Override
	public boolean isEmptyS() {
		return listStack.isEmpty();
	}

}
