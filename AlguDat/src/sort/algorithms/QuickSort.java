package sort.algorithms;

import adt.Interfaces.*;
import sort.MethodPivot;

public class QuickSort {
	private QuickSort(){}

	public static void quickSort(AdtArray arrayToSort){//MethodPivot pivot){
//		if(arrayToSort.lengthA() <= 12){
//			return InsertionsSort.sort(arrayToSort);
//		} else{
				int l = 1;
				int r = (arrayToSort.lengthA()-1);
				quickSortRec(arrayToSort,l,r);
//		}
	}
	
	private static void quickSortRec(AdtArray arrayToSort, int l, int r){
//		if(arrayToSort.lengthA() <= 12){
//			InsertionsSort.insertionSort();
//		}
		if(l < r){
			int i = l;
			int j = r-1;
			int pivot = arrayToSort.getA(r);
			while(true){
				while(arrayToSort.getA(i) < pivot){
					i++;
				} 
				while(arrayToSort.getA(j) >= pivot){
					if(j <= 0){
						break;
					} else {
						j--;
					}
				}
				if(i>=j)break;
				swap(arrayToSort,i,j);
			}
			swap(arrayToSort,i,r);
			quickSortRec(arrayToSort,l,i--);
			quickSortRec(arrayToSort,i++,r);
		}
	}
	
	public static void swap(AdtArray arrayToSort,int i, int j){
		int tmp = arrayToSort.getA(i);
		arrayToSort.setA(i,j);
		arrayToSort.setA(j,tmp);
	}
}
