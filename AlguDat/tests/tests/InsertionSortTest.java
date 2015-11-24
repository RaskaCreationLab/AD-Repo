package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

import adt.Interfaces.AdtArray;
import adt.implementations.AdtArrayImpl;
import sort.algorithms.InsertionSort;

public class InsertionSortTest {

	@Test
	public void testInsertionSort() {
		//test without elements
		AdtArray test = AdtArrayImpl.initA();
		AdtArray result = AdtArrayImpl.initA();
		InsertionSort.insertionSort(test, 0, 0);
		assertEquals(true, compare(test, result));
		
		//test with 1 element
		test.setA(0, 1);
		result.setA(0, 1);
		InsertionSort.insertionSort(test, 0, 0);
		assertEquals(true, compare(test, result));
		
		//test with more than 1 element, not ordered
		test.setA(1, 3);
		test.setA(2, 2);
		result.setA(1, 2);
		result.setA(2, 3);
		InsertionSort.insertionSort(test, 0, 2);
		assertEquals(true, compare(test, result));
		
		//aufsteigend sortierte Liste
		test = AdtArrayImpl.initA();
		result = AdtArrayImpl.initA();
		for(int i = 0; i < 100; i++) {
			test.setA(i, i);
			result.setA(i, i);
		}
		InsertionSort.insertionSort(test, 0, 99);
		assertEquals(true, compare(test, result));
		
		//absteigend sortierte Liste
		test = AdtArrayImpl.initA();
		result = AdtArrayImpl.initA();
		for(int i = 0; i < 100; i++) {
			test.setA(i, 99-i);
			result.setA(i, i);
		}
		InsertionSort.insertionSort(test, 0, 99);
		assertEquals(true, compare(test, result));
		
		//unsortierte Liste mit sicher doppelten Elementen 
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random r = new Random();
		for(int i = 0; i < 100; i++) {
			list.add(r.nextInt(50));
		}
		
		test = AdtArrayImpl.initA();
		result = AdtArrayImpl.initA();
		for(int i = 0; i < 100; i++) {
			test.setA(i, list.get(i));
		}
		Collections.sort(list);
		for(int i = 0; i < 100; i++) {
			result.setA(i, list.get(i));
		}
		InsertionSort.insertionSort(test, 0, 99);
		assertEquals(true, compare(test, result));
		
		//teilbereich-Sortierung in unsortierter Liste.
		ArrayList<Integer> pre = new ArrayList<Integer>();
		ArrayList<Integer> mid = new ArrayList<Integer>();
		ArrayList<Integer> post = new ArrayList<Integer>();
		r = new Random();
		for(int i = 0; i < 5; i++) {
			pre.add(r.nextInt(20));
			mid.add(r.nextInt(20));
			post.add(r.nextInt(20));
		}
		
		test = AdtArrayImpl.initA();
		result = AdtArrayImpl.initA();
		for(int i = 0; i < 5; i++) {
			test.setA(i, pre.get(i));
			test.setA(i+5, mid.get(i));
			test.setA(i+10, post.get(i));
		}
		Collections.sort(mid);
		for(int i = 0; i < 5; i++) {
			result.setA(i, pre.get(i));
			result.setA(i+5, mid.get(i));
			result.setA(i+10, post.get(i));
		}
		InsertionSort.insertionSort(test, 5, 9);
		assertEquals(true, compare(test, result));
		
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
