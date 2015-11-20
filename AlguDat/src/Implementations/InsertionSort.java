package Implementations;

import Interfaces.AdtArray;

public class InsertionSort {

	private InsertionSort() {}
	
	public static void insertionSort(AdtArray array, int startIndex, int endIndex) {
		
	}
	
	public static long insertionSortRuntime(AdtArray array, int startIndex, int endIndex) {
		long startTime = System.currentTimeMillis();
		insertionSort(array, startIndex, endIndex);
		return System.currentTimeMillis() - startTime;
	}

	public static int[] insertionSortAccessCount(AdtArray array, int startIndex, int endIndex) {
		int readArray = 0, writeArray = 0, readAll = 0, writeAll = 0;
		int[] accesses = {readArray, writeArray, readAll, writeAll};
		return accesses;
	}
}
