package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import adt.implementations.*;
import adt.Interfaces.*;

public class AdtQueueTest {

	private int errorCode = -99999999;
	@Test
	public void testQueue() {
		AdtQueue q = AdtQueueImpl.createQ();
		assertEquals(true, q.isEmptyQ());
		assertEquals(errorCode, q.front());
		q.enqueue(3);
		assertEquals(false, q.isEmptyQ());
		assertEquals(3, q.front());
		q.enqueue(4);
		assertEquals(3, q.front());
		q.dequeue();
		assertEquals(4, q.front());
		q.dequeue();
		assertEquals(errorCode, q.front());
		assertEquals(true, q.isEmptyQ());
	}

}
