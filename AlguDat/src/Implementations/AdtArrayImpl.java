package implementations;

import interfaces.AdtArray;
import interfaces.AdtList;
import interfaces.AdtStack;

public class AdtArrayImpl implements AdtArray{	
	AdtList elemList, posList;
	int ERRORCODE = -99999999;
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
		if(pos >= 0) {
			int posOfPos;
			if(pos+1 > length) {
				length = pos+1;
				posOfPos = ERRORCODE;
			} else {
				posOfPos = posList.find(pos);
			}
			if(posOfPos == ERRORCODE) {
				posList.insert(1, pos);
				elemList.insert(1, elem);
			} else {
				elemList.insert(posOfPos, elem);
			}
		}
	}

	//setA :: Array x pos -> elem :: (pos)
	@Override
	public int getA(int pos) {
		if(pos >= 0) {
			int posOfPos;
			posOfPos = (pos > length) ? ERRORCODE : posList.find(pos);
			if(posOfPos == ERRORCODE || posOfPos == -1) {
				return 0;
			} else {
				return elemList.retrieve(posOfPos);
			}
		} else {
			return ERRORCODE;
		}
	}

	//lengthA :: Array -> int
	@Override
	public int lengthA() {
		return length;
	}

}
