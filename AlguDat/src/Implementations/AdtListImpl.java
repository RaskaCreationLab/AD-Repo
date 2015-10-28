package Implementations;

import Interfaces.AdtList;

public class AdtListImpl implements AdtList{		
	private AdtListImpl(){};
	
	public static AdtListImpl valueOf(){
		return new AdtListImpl();
	}
	
	//List als int-Array
	int[] list = new int[0]; 
	
	@Override
	public boolean isEmpty() {
		if(list.length == 0){
			return true;
		} else return false;
	}
	@Override
	public int laenge() {
		return list.length;
	}
	@Override
	public void insert(int pos, int elem){
		if(list.length >= pos){
			for(int i = pos; )
			list[pos] 
		}
	}
	@Override
	public void delete(int pos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int find(int elem) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int retrieve(int pos) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public AdtList concat(AdtList list) {
		// TODO Auto-generated method stub
		return null;
	}
}
