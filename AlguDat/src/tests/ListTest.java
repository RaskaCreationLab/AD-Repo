package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import implementations.Factory;
import interfaces.AdtList;

public class ListTest {
	int errorCode = -99999999;
	
	@Test
	public void testIsEmpty() {
		AdtList list1 = Factory.create();
		AdtList list2 = Factory.create();
		assertEquals(true,list1.isEmpty());
		list1.insert(1,1);
		list1.insert(1,1000);
		assertEquals(false,list1.isEmpty());
		list1.delete(1);
		list1.delete(1);
		assertEquals(true,list1.isEmpty());
	}
	
	@Test
	public void testLaenge(){
		AdtList list1 = Factory.create();
		AdtList list2 = Factory.create();
		list1.insert(1,1);
		list1.insert(1,1000);
		assertEquals(2,list1.laenge());
		list1.insert(3,2);
		list1.insert(4,1);
		//geht nicht, da 6 > 4+1
		list1.insert(6,1);
		assertEquals(4, list1.laenge());
		list1.delete(5);
		assertEquals(4, list1.laenge());
		list1.delete(1);
		list1.delete(1);
		list1.delete(1);
		assertEquals(1, list1.laenge());
		
		list2.insert(1,50);
		list2.insert(2,51);
		list2.insert(3,80);
		list2.insert(4,10);
		list2.insert(5,70);
		AdtList list3 = list1.concat(list2);
		assertEquals(5, list3.laenge());
	}
	
	@Test
	public void testInsert(){
		//Durch Rückgabetyp void so nicht testbar		
	}
	
	@Test
	public void testDelete(){
		//Durch Rückgabetyp void so nicht testbar	
	}
	
	@Test
	public void testFind(){
		AdtList list1 = Factory.create();
		list1.insert(1,1);
		list1.insert(1,1000);
		assertEquals(1,list1.find(1000));
		list1.insert(1,20);
		assertEquals(2,list1.find(1000));
		list1.insert(3,21);
		list1.insert(3,22);
		assertEquals(2,list1.find(1000));
		assertEquals(4,list1.find(21));
		assertEquals(errorCode,list1.find(23));
		list1.delete(5);
		list1.delete(1);
		assertEquals(2,list1.find(22));
		assertEquals(1,list1.find(1000));
		
		AdtList list2 = Factory.create();
		list2.insert(1,1);
		list2.insert(1,1);
		list2.insert(1,1);
		list2.insert(1,1);
		list2.insert(1,1);
		list2.insert(1,1);
		list2.insert(1,1);
		list2.insert(1,1);
		assertEquals(1,list2.find(1));
		assertEquals(errorCode,list2.find(2));
		assertEquals(errorCode,list2.find(27));
		assertEquals(errorCode,list2.find(27));
		assertEquals(errorCode,list2.find(8));
		assertEquals(errorCode,list2.find(7));
		assertEquals(errorCode,list2.find(6));
	}
	
	@Test
	public void testRetrieve(){
		AdtList list1 = Factory.create();
		list1.insert(1,2);
		assertEquals(2,list1.retrieve(1));
		list1.insert(4,3);
		list1.insert(2,1);
		list1.delete(3);
		list1.insert(1,4);
		list1.delete(1);
		assertEquals(1,list1.retrieve(2));
		assertEquals(errorCode,list1.retrieve(5));
	}
	
	@Test
	public void testConcat(){
		
	}

}
