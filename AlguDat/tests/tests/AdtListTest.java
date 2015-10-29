package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import implementations.Factory;
import interfaces.AdtList;

public class AdtListTest {
	int ERRORCODE = -99999999;
	int ERRORCODE2 = -1;
	
	@Test
	public void testIsEmpty() {
		AdtList list1 = Factory.create();
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
		assertEquals(ERRORCODE2,list1.find(23));
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
		assertEquals(ERRORCODE2,list2.find(2));
		assertEquals(ERRORCODE2,list2.find(27));
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
		assertEquals(ERRORCODE,list1.retrieve(5));
	}
	
	@Test
	public void testConcat(){
		AdtList list1 = Factory.create();
		AdtList list2 = Factory.create();
		AdtList list3 = Factory.create();
		//zwei listen
		list1.insert(1,2);
		list1.insert(2,3);
		list1.insert(3,4);
		list1.insert(4,5);
		list2.insert(1,6);
		list2.insert(2,7);
		//resultatsliste
		list3 = list1.concat(list2);
		assertEquals(6,list3.laenge());
		list3.insert(1, 5);
		assertEquals(7,list3.laenge());
	}
}
