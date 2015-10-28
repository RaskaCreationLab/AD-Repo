package Implementations;

import Interfaces.AdtStack;

public class AdtStackImpl implements AdtStack{
	private AdtStackImpl(){};
	
	public static AdtStack valueOf(){
		new AdtStackImpl();
	}
	
	@Override
	public void push(int elem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int top() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmptyS() {
		// TODO Auto-generated method stub
		return false;
	}

}
