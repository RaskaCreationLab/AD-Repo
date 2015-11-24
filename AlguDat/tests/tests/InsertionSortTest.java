package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import adt.Interfaces.AdtArray;

public class InsertionSortTest {

	@Test
	public void testInsertionSort() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertionSortRuntime() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertionSortAccessCount() {
		fail("Not yet implemented");
	}

	public boolean compare(AdtArray ar1, AdtArray ar2){
		if(ar1.lengthA() == ar2.lengthA()){
			for(int i = 0; i < ar1.lengthA(); i++){
				if( ar1.getA(i) != ar2.getA(i))return false;
			}
		} else {
			return false;
		}
		return true;
	}
}
