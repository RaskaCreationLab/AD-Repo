package sort.algorithms;

import adt.Interfaces.AdtArray;
import sort.NumGenerator;

public class InsertionSort {

	private InsertionSort() {} //verhindere das instanziieren der Klasse
	
	//InsertionSort :: AdtArray x int x int -> AdtArray :: (array, startIndex, endIndex) ::::
	// sort all elements of AdtArray in between startIndex and endIndex. sorting ascending.
	public static void insertionSort(AdtArray array, int startIndex, int endIndex) {
		if (startIndex < endIndex && startIndex >= 0 && endIndex < array.lengthA()) { //kontrolliere die sortierbereichgrenzen
			for (int sorted = startIndex+1; sorted <= endIndex ; sorted++ ){ //sortiere in den Bereichsgrenzen
				//startIndex+1, da ein Element immer "sortiert" ist
				int insertPosition = sorted; //position an der eingefügt werden soll
				int element = array.getA(sorted); //das einzufügende Element
				while(array.getA(insertPosition-1) > element && insertPosition > startIndex)
					//wenn das Element kleiner als das element an der position hinter der eingefügt werden soll und die position noch 
					//im zu sortierenden Bereich ist
				{
					array.setA(insertPosition, array.getA(insertPosition-1)); //verschiebe das element mit dem vergleichen wurde
					//um eins nach hinten
					insertPosition--;
					//und verringere die einfüge-position um 1
				}
				//sobald die richtige position gefunden wurde
				array.setA(insertPosition, element); //füge das element dort ein.
			}
		}
	}
	
	public static long insertionSortRuntime(AdtArray array, int startIndex, int endIndex) {
		if (startIndex < endIndex && startIndex >= 0 && endIndex < array.lengthA()-1) {
			long startTime = System.currentTimeMillis();
			insertionSort(array, startIndex, endIndex);
			return System.currentTimeMillis() - startTime;
		}
		return -1;
	}

	/**
	 * @param array - der zu sortierende Array
	 * @param startIndex - gibt den Anfang des zu sortierenden Bereichs als Index an
	 * @param endIndex - gibt das Ende des zu sortierenden Bereichs als Index an
	 * @return gibt einen Array aus. der Array ist wie folgt aufgebaut:
	 * [Lese-Zugriffe auf array, Schreib-Zugriffe auf array, Lese-Zugriffe insgesamt, Schreib-Zugriffe insgesamt]
	 */
	public static int[] insertionSortAccessCount(AdtArray array, int startIndex, int endIndex) {
		int[] accesses = {0,0,0,0};
		int readAIndex = 0, writeAIndex = 1, readIndex = 2, writeIndex = 3;
		if (startIndex < endIndex && startIndex >= 0 && endIndex < array.lengthA()) {
			accesses[writeIndex] += 1;
			accesses[readIndex] += 1;
			for (int sorted = startIndex+1; sorted <= endIndex ; sorted++ ){ //sortiere in den Bereichsgrenzen
				accesses[writeIndex] += 1;
				accesses[readIndex] += 1;
				//startIndex+1, da ein Element immer "sortiert" ist
				int insertPosition = sorted; //position an der eingefügt werden soll
				accesses[writeIndex] += 1;
				accesses[readIndex] += 1;
				int element = array.getA(sorted); //das einzufügende Element
				accesses[writeIndex] += 1;
				accesses[readIndex] += 1;
				accesses[writeAIndex] += 1;
				accesses[readAIndex] += 1;
				while(array.getA(insertPosition-1) > element && insertPosition > startIndex)
					//wenn das Element kleiner als das element an der position hinter der eingefügt werden soll und die position noch 
					//im zu sortierenden Bereich ist
				{
					accesses[readIndex] += 2;
					accesses[readAIndex] += 2;
					array.setA(insertPosition, array.getA(insertPosition-1)); //verschiebe das element mit dem vergleichen wurde
					accesses[readIndex] += 2;
					accesses[readAIndex] += 2;
					accesses[writeIndex] += 1;
					accesses[writeAIndex] += 1;
					//um eins nach hinten
					insertPosition--;
					accesses[writeIndex] += 1;
					//und verringere die einfüge-position um 1
				}
				//sobald die richtige position gefunden wurde
				array.setA(insertPosition, element); //füge das element dort ein.
				accesses[writeIndex] += 1;
				accesses[writeAIndex] += 1;
			}
		} else {
			accesses[readAIndex] = -1;
			accesses[readIndex] = -1;
			accesses[writeAIndex] = -1;
			accesses[writeIndex] = -1;
			
		}
		return accesses;
	}
	
	private static void printArray(AdtArray array) {
		for (int i = 0; i < array.lengthA(); i++) {
			System.out.print(array.getA(i)+" ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		AdtArray array = NumGenerator.readNum("zahlen");
		System.out.println(""+array.lengthA());
		printArray(array);
		insertionSort(array, 0, array.lengthA()-1);
		printArray(array);
	}
}
