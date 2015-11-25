package sort.algorithms;

import java.util.Random;

import adt.Interfaces.*;
import sort.MethodPivot;

public class QuickSort {
	private QuickSort(){}
	private static int pivot;

	public static void quickSort(AdtArray arrayToSort, MethodPivot p){
		if(arrayToSort.lengthA() != 0){		
			int l = 0;    //Linke Beschränkung
			int r = arrayToSort.lengthA()-1; //Rechte Besschränkung
			switch(p){
				case LEFT:quickSortRecLeft(arrayToSort,l,r,p);
				default:quickSortRec(arrayToSort,l,r,p);
			}
		}
	}
	
	public static void quickSortRec(AdtArray arrayToSort,int l, int r,MethodPivot p){
		if((r-l) <= 12){ //Bei 12 Elementen 
			InsertionSort.insertionSort(arrayToSort,l,r);
		} else {
			if(r >= l && r > 0){
				int i = l;		//um l nicht zu verändern
				int j = r;		//um r nicht zu verändern
				getPivot(p,l,r,arrayToSort);
				while(j > i){ //if Bedingung als "break"
					while(arrayToSort.getA(i) <= pivot && j > i)i++;  
					//Suche nach dem ersten Element von links das größer als pivot
					while(arrayToSort.getA(j) > pivot && j > i)j--;	
					//Suche nach dem ersten Element von rechts das kleiner/gleich als pivot
					if(j > i){swap(arrayToSort,i,j);}
					//Wenn kleineres Element größeren Index -> Swap
				}
				swap(arrayToSort,i,r);				//j ist weiter in die Mitte gerutscht, nun als Grenze der Partitionen
				quickSortRec(arrayToSort,l,i-1,p); //Quicksort links
				quickSortRec(arrayToSort,i+1,r,p); //Quicksort rechts
			}
		}
	}
	
	public static void quickSortRecLeft(AdtArray arrayToSort,int l, int r, MethodPivot p){
		if((r-l) <= 12){ //Bei 12 Elementen 
			InsertionSort.insertionSort(arrayToSort,l,r);
		} else {
			if(r >= l && r > 0){
				pivot = arrayToSort.getA(l);
//				getPivot(p,l,r,arrayToSort);
				int i = l;		//um l nicht zu verändern
				int j = r;		//um r nicht zu verändern
				while(j > i){ //if Bedingung als "break"
					while(arrayToSort.getA(i) <= pivot && j > i)i++;  
					//Suche nach dem ersten Element von links das größer als pivot
					while(arrayToSort.getA(j) > pivot && j >= i)j--;	
					//Suche nach dem ersten Element von rechts das kleiner/gleich als pivot
					if(j > i){swap(arrayToSort,i,j);}
					//Wenn kleineres Element größeren Index -> Swap
				}
				swap(arrayToSort,j,l);				//j ist weiter in die Mitte gerutscht, nun als Grenze der Partitionen
				quickSortRecLeft(arrayToSort,l,j-1,p); //Quicksort links
				quickSortRecLeft(arrayToSort,j+1,r,p); //Quicksort rechts
			}
		}
	}
	
	public static void swap(AdtArray arrayToSort,int i, int j){
		int tmp = arrayToSort.getA(i);
		arrayToSort.setA(i,arrayToSort.getA(j));
		arrayToSort.setA(j,tmp);
	}
	
	public static void getPivot(MethodPivot p,int l,int r,AdtArray arrayToSort){
		switch(p){
		case RIGHT:
			pivot = arrayToSort.getA(r);
		case RANDOM:
			Random random = new Random();
			int tmp = random.nextInt(r);
			pivot = arrayToSort.getA(tmp+l);
		case MEDIANOF3:
			int middle = r-l/2;
			pivot = arrayToSort.getA((middle + l + r)/3);
		default:
			pivot = arrayToSort.getA(r);
		}
	}
}
