package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Implementations.Factory;
import Interfaces.AdtList;

public class ListTest {
	AdtList list1 = Factory.create();
	AdtList list2 = Factory.create();
	
	@Test
	public void testIsEmpty() {
		assertEquals(true,list1.isEmpty());
		list1.insert(1,1);
		list1.insert(2,1000);
		assertEquals(false,list1.isEmpty());
		list1.delete(1);
		list1.delete(2);
		assertEquals(true,list1.isEmpty());
	}
	
	@Test
	public void testLaenge(){
		list1.insert(1,1);
		list1.insert(2,1000);
		assertEquals(2,list1.laenge());
		list1.insert(3,2);
		list1.insert(4,1);
		//geht nicht, da 6 > 4+1
		list1.insert(6,1);
		assertEquals(4, list1.laenge());
		list1.delete(5);
		assertEquals(4, list1.laenge());
		list1.delete(1);
		list1.delete(2);
		list1.delete(3);
		assertEquals(1, list1.laenge());
		
		list2.insert(1,50);
		list2.insert(2,51);
		list2.insert(3,80);
		list2.insert(4,10);
		AdtList list3 = list1.concat(list2);
		assertEquals(5, list3.laenge());
	}

}
