package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import implementations.Factory;
import interfaces.AdtStack;

public class AdtStackTest {             
	int ERRORCODE = -99999999;
	
	@Test
	public void testPush(){
		//Push schiebt immer einen Wert auf den Stack
		AdtStack stack1 = Factory.createS();
		assertEquals(true,stack1.isEmptyS());
		stack1.push(1);
		assertEquals(false,stack1.isEmptyS());
		assertEquals(1,stack1.top());
		stack1.pop();
		assertEquals(true,stack1.isEmptyS());
		stack1.push(1);
		stack1.push(1);
		stack1.push(1);
		assertEquals(1,stack1.top());
		stack1.push(2);
		assertEquals(2,stack1.top());
		//Negative Zahlen können gepusht werden
		stack1.push(-20);
		assertEquals(-20,stack1.top());		
	}
	
	@Test
	public void testPop(){	
		//Falls stack leer, verändert der Stack sich durch pop() nicht
		AdtStack stack1 = Factory.createS();
		stack1.pop();
		assertEquals(true,stack1.isEmptyS());
		stack1.push(2);
		stack1.push(3);
		stack1.pop();
		assertEquals(false,stack1.isEmptyS());
		assertEquals(2,stack1.top());
		stack1.pop();
		assertEquals(true,stack1.isEmptyS());
		stack1.pop();
		assertEquals(true,stack1.isEmptyS());
	}
	
	@Test
	public void testTop(){
		//top() gibt den zuletzt hinzugefügten Wert hinzu
		AdtStack stack1 = Factory.createS();
		stack1.push(1);
		stack1.push(3);
		stack1.push(2);
		stack1.push(11);
		assertEquals(11,stack1.top());
		stack1.pop();
		assertEquals(2,stack1.top());
		stack1.push(3);
		assertEquals(3,stack1.top());
		stack1.pop();
		stack1.pop();
		stack1.pop();
		assertEquals(1,stack1.top());
		stack1.pop();
		//Falls kein Wert im Stack wird der Errorwert ausgegeben
		assertEquals(ERRORCODE,stack1.top());
	}	
	
	@Test
	public void testIsEmptyS(){
		//Stack ist zu Anfang empty
		AdtStack stack1 = Factory.createS();
		assertEquals(true,stack1.isEmptyS());
		stack1.push(1);
		assertEquals(false,stack1.isEmptyS());
		//Stack leer = empty true
		stack1.pop();
		assertEquals(true,stack1.isEmptyS());
	}
}
