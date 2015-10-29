package implementations;

import interfaces.AdtArray;
import interfaces.AdtList;

public class AdtArrayImpl implements AdtArray{

	AdtList elemList, posList;
	int ERRORCODE = -99999999;
	int length;
	
	AdtArrayImpl() {
		length = 0;
		elemList = Factory.create();
		posList = Factory.create();
	}
	
	
	//setA :: Array x pos x elem -> Array :: (pos, elem)
	@Override
	public void setA(int pos, int elem) {
		if(pos >= 0) {
			int posOfPos;
			if(pos > length) {
				length = pos;
				posOfPos = ERRORCODE;
			} else {
				posOfPos = posList.find(pos);
			}
			if(posOfPos == ERRORCODE) {
				posList.insert(posList.laenge()+1, pos);
				elemList.insert(posList.laenge()+1, elem);
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
			if(posOfPos == ERRORCODE) {
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
