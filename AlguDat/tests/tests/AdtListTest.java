package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import adt.implementations.*;
import adt.Interfaces.*;

public class AdtListTest {
	int ERRORCODE = -99999999;
	int ERRORCODE2 = -1;
	
	@Test
	public void testIsEmpty() {
		AdtList list1 = AdtListImpl.create();
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
		AdtList list1 = AdtListImpl.create();
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
		AdtList list1 = AdtListImpl.create();
		//L�nge �ndert sich durch Insertierung in eine leere Liste
		list1.insert(1,2);
		assertEquals(1,list1.laenge());
		list1.insert(2,4);
		list1.insert(3,1);
		assertEquals(3,list1.laenge());
		//L�nge �ndert sich nicht bei ung�ltigen inserts
		list1.insert(6,2);
		list1.insert(0,2);
		assertEquals(3,list1.laenge());
		//L�nge �ndert sich durch insertierungen an schon vergebenen stellen
		//Ausserdem wird das neu hinzugef�gte Element dort gefunden
		list1.insert(1,5);
		list1.insert(2,6);
		assertEquals(5,list1.laenge());
		assertEquals(1,list1.find(5));
		assertEquals(2,list1.find(6));
		//Die Werte werden um eins verschoben durch �nderung an vergebener Stelle durch Verschiebung
		assertEquals(5,list1.find(1));
		assertEquals(4,list1.find(4));
	}
	
	@Test
	public void testDelete(){
		AdtList list1 = AdtListImpl.create();
		//Delete �ndert nichts auf leere Liste
		list1.delete(1);
		list1.delete(20);
		//Ung�ltige Position �ndert nichts an der L�nge der Liste
		list1.insert(1,2);
		list1.insert(2,20);
		assertEquals(2,list1.laenge());
		list1.delete(4);
		assertEquals(2,list1.laenge());
		//L�nge �ndert sich durch l�schen einer validen Positionsangabe
		list1.delete(1);
		assertEquals(1,list1.laenge());
		//Alle Positionen werden um 1 minimiert
		assertEquals(1,list1.find(20));
	}
	
	@Test
	public void testFind(){
		AdtList list1 = AdtListImpl.create();
		list1.insert(1,1);
		list1.insert(1,1000);
		assertEquals(1,list1.find(1000));
		list1.insert(1,20);
		assertEquals(2,list1.find(1000));
		list1.insert(3,21);
		list1.insert(3,22);
		assertEquals(2,list1.find(1000));
		assertEquals(4,list1.find(21));
		//Errorcode wenn das Element nicht in der Liste ist
		assertEquals(ERRORCODE2,list1.find(23));
		list1.delete(5);
		list1.delete(1);
		assertEquals(2,list1.find(22));
		assertEquals(1,list1.find(1000));
		
		AdtList list2 = AdtListImpl.create();
		list2.insert(1,1);
		list2.insert(1,1);
		list2.insert(1,1);
		list2.insert(1,1);
		list2.insert(1,1);
		list2.insert(1,1);
		list2.insert(1,1);
		list2.insert(1,1);
		assertEquals(1,list2.find(1));
		//Bei in der Liste nicht vorhandenen Elementen wird ein Errorcode herausgegeben
		assertEquals(ERRORCODE2,list2.find(2));
		assertEquals(ERRORCODE2,list2.find(27));
	}
	
	@Test
	public void testRetrieve(){
		AdtList list1 = AdtListImpl.create();
		list1.insert(1,2);
		assertEquals(2,list1.retrieve(1));
		list1.insert(4,3);
		list1.insert(2,1);
		list1.delete(3);
		list1.insert(1,4);
		list1.delete(1);
		assertEquals(1,list1.retrieve(2));
		//Wenn die Stelle nicht vergeben ist, wird ein Errorcode herausgegeben
		assertEquals(ERRORCODE,list1.retrieve(5));
	}
	
	@Test
	public void testConcat(){
		AdtList list1 = AdtListImpl.create();
		AdtList list2 = AdtListImpl.create();
		AdtList list3 = AdtListImpl.create();
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
		//Eine Liste mit einer leeren Liste ergibt die belegte Liste als neue Liste -> nicht testbar
		//Zwei leere Listen m�ssen eine leere Liste ergeben = kann nicht getestet werden da eine neue Liste zur�ckgegeben wird
	}
}
