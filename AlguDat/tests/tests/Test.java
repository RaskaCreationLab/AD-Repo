package tests;

public class Test {

}
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import adt.implementations.*;
import adt.Interfaces.*;
import sort.MethodPivot;
import sort.NumGenerator;
import sort.algorithms.*;

public class QuickSortTest {

	@Test
	public void sortTest() {
		AdtArray array1 = AdtArrayImpl.initA();
		AdtArray result1 = AdtArrayImpl.initA();

		AdtArray array2 = AdtArrayImpl.initA();
		AdtArray result2 = AdtArrayImpl.initA();

		AdtArray array3 = AdtArrayImpl.initA();
		AdtArray result3 = AdtArrayImpl.initA();
		
		array1.setA(0,5);
		array1.setA(1,3);
		array1.setA(2,6);
		array1.setA(3,8);
		array1.setA(4,7);
		array1.setA(5,2);
		array1.setA(6,9);
		array1.setA(7,1);
		array1.setA(8,10);
		array1.setA(9,4);
		
		result1.setA(0,1);
		result1.setA(1,2);
		result1.setA(2,3);
		result1.setA(3,4);
		result1.setA(4,5);
		result1.setA(5,6);
		result1.setA(6,7);
		result1.setA(7,8);
		result1.setA(8,9);
		result1.setA(9,10);
		
//		Weitergabe an Insertionsort
		QuickSort.quickSort(array1,MethodPivot.LEFT);		
		assertEquals(true,compare(array1,result1));
		
		//Mit länger als 12 Zeichen
		array2.setA(0,5);
		array2.setA(1,11);
		array2.setA(2,6);
		array2.setA(3,8);
		array2.setA(4,14);
		array2.setA(5,2);
		array2.setA(6,15);
		array2.setA(7,16);
		array2.setA(8,10);
		array2.setA(9,13);
		array2.setA(10,1);
		array2.setA(11,12);
		array2.setA(12,3);
		array2.setA(13,7);
		array2.setA(14,9);
		array2.setA(15,4);
				
		result2.setA(0,1);
		result2.setA(1,2);
		result2.setA(2,3);
		result2.setA(3,4);
		result2.setA(4,5);
		result2.setA(5,6);
		result2.setA(6,7);
		result2.setA(7,8);
		result2.setA(8,9);
		result2.setA(9,10);
		result2.setA(10,11);
		result2.setA(11,12);
		result2.setA(12,13);
		result2.setA(13,14);
		result2.setA(14,15);
		result2.setA(15,16);

		QuickSort.quickSort(array2,MethodPivot.LEFT);
		assertEquals(true,compare(array2,result2));
		
		array2.setA(0,5);
		array2.setA(1,11);
		array2.setA(2,6);
		array2.setA(3,8);
		array2.setA(4,14);
		array2.setA(5,2);
		array2.setA(6,15);
		array2.setA(7,16);
		array2.setA(8,10);
		array2.setA(9,13);
		array2.setA(10,1);
		array2.setA(11,12);
		array2.setA(12,3);
		array2.setA(13,7);
		array2.setA(14,9);
		array2.setA(15,4);
		
		QuickSort.quickSort(array2,MethodPivot.RIGHT);
		assertEquals(true,compare(array2,result2)); 
		
		array2.setA(0,5);
		array2.setA(1,11);
		array2.setA(2,6);
		array2.setA(3,8);
		array2.setA(4,14);
		array2.setA(5,2);
		array2.setA(6,15);
		array2.setA(7,16);
		array2.setA(8,10);
		array2.setA(9,13);
		array2.setA(10,1);
		array2.setA(11,12);
		array2.setA(12,3);
		array2.setA(13,7);
		array2.setA(14,9);
		array2.setA(15,4);
		
		QuickSort.quickSort(array2,MethodPivot.RANDOM);
		assertEquals(true,compare(array2,result2));
		
		array2.setA(0,5);
		array2.setA(1,11);
		array2.setA(2,6);
		array2.setA(3,8);
		array2.setA(4,14);
		array2.setA(5,2);
		array2.setA(6,15);
		array2.setA(7,16);
		array2.setA(8,10);
		array2.setA(9,13);
		array2.setA(10,1);
		array2.setA(11,12);
		array2.setA(12,3);
		array2.setA(13,7);
		array2.setA(14,9);
		array2.setA(15,4);
		
		QuickSort.quickSort(array2,MethodPivot.MEDIANOF3);
		assertEquals(true,compare(array2,result2));
		
		result3.setA(0,0);
		result3.setA(1,0);
		result3.setA(2,3);
		result3.setA(3,3);
		result3.setA(4,3);
		result3.setA(5,4);
		result3.setA(6,4);
		result3.setA(7,5);
		result3.setA(8,5);
		result3.setA(9,6);	
		result3.setA(10,6);
		result3.setA(11,7);
		result3.setA(12,9);
		result3.setA(13,10);
		result3.setA(14,10);
		result3.setA(15,11);
		result3.setA(16,14);
		result3.setA(17,16);
		result3.setA(18,18);
		result3.setA(19,19);
		
		array3 = NumGenerator.readNum("test");
		QuickSort.quickSort(array3,MethodPivot.LEFT);
		assertEquals(true,compare(array2,result2));
		array3 = NumGenerator.readNum("test");
		QuickSort.quickSort(array3,MethodPivot.RIGHT);
		assertEquals(true,compare(array2,result2));
		array3 = NumGenerator.readNum("test");
		QuickSort.quickSort(array3,MethodPivot.RANDOM);
		assertEquals(true,compare(array2,result2));
		array3 = NumGenerator.readNum("test");
		QuickSort.quickSort(array3,MethodPivot.MEDIANOF3);
		assertEquals(true,compare(array2,result2));
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
