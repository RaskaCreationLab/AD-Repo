package tests;

import static org.junit.Assert.*;

import org.junit.Test;

<<<<<<< HEAD
import adt.implementations.*;
import adt.Interfaces.*;
=======
import Implementations.AdtArrayImpl;
import Interfaces.AdtArray;
>>>>>>> refs/remotes/origin/master

public class AdtArrayTest {

	@Test
	public void testSetA() {
		AdtArray a = AdtArrayImpl.initA();
		a.setA(3, 1);
		assertEquals(1, a.getA(3));
		a.setA(3, 5);
		assertEquals(5, a.getA(3));
	}

	@Test
	public void testGetA() {
		AdtArray a = AdtArrayImpl.initA();
		assertEquals(0, a.getA(0));
		assertEquals(0, a.getA(50));
		a.setA(15, 20);
		assertEquals(20, a.getA(15));
	}

	@Test
	public void testLengthA() {
		AdtArray a = AdtArrayImpl.initA();
		assertEquals(0, a.lengthA());
		a.setA(0, 1);
		assertEquals(1, a.lengthA());
		a.setA(20,15);
		assertEquals(21, a.lengthA());
	}

}
