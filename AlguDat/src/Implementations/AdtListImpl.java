package implementations;

import interfaces.AdtList;

public class AdtListImpl implements AdtList{		
	AdtListImpl(){};
	
	//List als int-Array
	int[] listArray = new int[0]; 
	//Error Ausgabe
	int errorCode = -99999999;
	
	
	@Override
	public boolean isEmpty() {
		if(listArray.length == 0){
			return true;
		} else return false;
	}
	@Override
	public int laenge() {
		return listArray.length;
	}
	
	@Override
	public void insert(int pos, int elem){
		int[] resultList = new int[listArray.length+1];
		if(listArray.length == 0){
			resultList[pos-1] = elem;
			listArray = resultList;
		}else if(resultList.length >= pos && pos > 0){	
			//Alles vor dem zu verrückenden Teil füllen mit der alten Liste
			for(int j = 0; j < pos-1; j++){
				resultList[j] = listArray[j];
			}
			resultList[pos-1] = elem;
			//Verrücken
			for(int i = pos; i < resultList.length; i++){
				resultList[i] = listArray[i-1]; 
			}
			listArray = resultList;
		}
	}
	
	@Override
	public void delete(int pos) {
		if(listArray.length >= pos && pos > 0){	
			int[] resultList = new int[listArray.length-1];
			//Alles vor dem zu verrückenden Teil füllen mit der alten Liste
			for(int j = 0; j < pos-1; j++){
				resultList[j] = listArray[j];
			}
			//Verrücken
			for(int i = pos; i < listArray.length; i++){
				resultList[i-1] = listArray[i]; 
			}
			listArray = resultList;
		}	
	}
	
	@Override
	public int find(int elem) {
		for(int i = 0;i < listArray.length; i++){
			if(listArray[i] == elem){
				return i+1;
			}
		}
		return errorCode;
	}
	
	@Override
	public int retrieve(int pos) {
		if(listArray.length >= pos){
			return listArray[pos-1];
		}
		return errorCode;
	}
	
	@Override
	public AdtList concat(AdtList list) {
		AdtList resultList = Factory.create();
		int laenge = this.laenge() + list.laenge();
		for(int i = 1; i <= this.laenge(); i++){
			resultList.insert(i,this.retrieve(i));
		}
		for(int j = this.laenge()+1; j < laenge; j++){
			resultList.insert(j, list.retrieve(j-this.laenge()));	
		}
		return resultList;
	}
}
