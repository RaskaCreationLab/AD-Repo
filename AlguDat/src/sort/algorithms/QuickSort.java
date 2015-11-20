package sort.algorithms;

import adt.Interfaces.*;
import sort.MethodPivot;

public class QuickSort {
	private QuickSort(){}

	public static void quickSort(AdtArray arrayToSort){//MethodPivot pivot){
//		if(arrayToSort.lengthA() <= 12){
//			return InsertionsSort.sort(arrayToSort);
//		} else{
				int l = 0;
				int r = arrayToSort.lengthA()-1;
				quickSortRec(arrayToSort,l,r);
//		}
	}
	
	public static void quickSortRec(AdtArray arrayToSort,int l, int r){
		int i = l;
		int j = r;
		
		if(r >= l){  //r - l >= 1
			int pivot = arrayToSort.getA(l);
			
			while(j > i){
				while(arrayToSort.getA(i) <= pivot && i <= r && j > i)i++;
				while(arrayToSort.getA(j) > pivot && j >= l && j >= i)j--;
				if(j > i){swap(arrayToSort,i,j);}
			}
			swap(arrayToSort,l,j);
			quickSortRec(arrayToSort,l,j-1);
			quickSortRec(arrayToSort,j+1,r);
		}
	}

	public static void swap(AdtArray arrayToSort,int i, int j){
		int tmp = arrayToSort.getA(i);
		arrayToSort.setA(i,arrayToSort.getA(j));
		arrayToSort.setA(j,tmp);
	}
}
