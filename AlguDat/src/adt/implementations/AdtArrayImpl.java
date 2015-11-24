package adt.implementations;

import adt.Interfaces.*;

public class AdtArrayImpl implements AdtArray{	
	AdtList elemList, posList;
	int ERRORCODE = -99999999;
	int ERRORCODE2 = -1;
	int length;
	
	AdtArrayImpl() {
		length = 0;
		elemList = AdtListImpl.create();
		posList = AdtListImpl.create();
	}
	
	public static AdtArray initA() {
		return new AdtArrayImpl();
	}	
	
	//setA :: Array x pos x elem -> Array :: (pos, elem)
	@Override
	public void setA(int pos, int elem) {
		if(pos >= 0) { //check if pos is valid
			int posOfPos;
			if(pos+1 > length) { //if pos is higher than length, incease size
				length = pos+1;
				posOfPos = ERRORCODE;
			} else {
				posOfPos = posList.find(pos);
			} //if pos is not set, add entry for pos/elem
			if(posOfPos == ERRORCODE || posOfPos == ERRORCODE2) {
				posList.insert(1, pos);
				elemList.insert(1, elem);
			} else { //overwrite pos with elem
				elemList.delete(posOfPos);
				elemList.insert(posOfPos, elem);
			}
		}
	}

	//setA :: Array x pos -> elem :: (pos)
	@Override
	public int getA(int pos) {
		if(pos >= 0) { //check if pos is valid
			int posOfPos;
			posOfPos = (pos > length) ? ERRORCODE : posList.find(pos);
			if(posOfPos == ERRORCODE || posOfPos == -1) {
				return 0; //if pos is not set return 0;
			} else {
				return elemList.retrieve(posOfPos);
			} //return elem of pos
		} else {
			return 0;
		} //return 0 as error value
	}

	//lengthA :: Array -> int
	@Override
	public int lengthA() {
		return length;
	}
}
