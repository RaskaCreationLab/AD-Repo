package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import adt.implementations.*;
import adt.Interfaces.*;
import sort.algorithms.*;

public class QuickSortTest {

	@Test
	public void sortTest() {
		AdtArray array = AdtArrayImpl.initA();
		AdtArray result = AdtArrayImpl.initA();
		
		array.setA(0,5);
		array.setA(1,3);
		array.setA(2,6);
		array.setA(3,8);
		array.setA(4,7);
		array.setA(5,2);
		array.setA(6,9);
		array.setA(7,1);
		array.setA(8,10);
		array.setA(9,4);
		
		result.setA(0,1);
		result.setA(1,2);
		result.setA(2,3);
		result.setA(3,4);
		result.setA(4,5);
		result.setA(5,6);
		result.setA(6,7);
		result.setA(7,8);
		result.setA(8,9);
		result.setA(9,10);
		
		QuickSort.quickSort(array);
		assertEquals(result,array);
	}

}
