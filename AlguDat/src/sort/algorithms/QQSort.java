package sort.algorithms;

import java.util.Random;

import adt.Interfaces.*;
import sort.MethodPivot;

public class QQSort {
	private QQSort(){}
	
	//QUICKSORT-NORMAL
	public static void quickSort(AdtArray arrayToSort, MethodPivot p){
		if(arrayToSort.lengthA() != 0){		
			getPivot(arrayToSort,p);
		}
	}
	
	//QUICKSORT-RUNTIME
	public static long quickSortRuntime(AdtArray arrayToSort, MethodPivot p){
		long start = System.currentTimeMillis();
		if(arrayToSort.lengthA() != 0){		
			getPivot(arrayToSort,p);
		}
		long end = System.currentTimeMillis();
		return(end - start);
	}
		
	//QUICKSORT-ZUGRIFFE
	public static int[] quickSortAccessCount(AdtArray arrayToSort, MethodPivot p){
		int[] count = new int[4];
		count[2]++;
		count[0]++;
		if(arrayToSort.lengthA() != 0){		
			count[2]++;
			return getPivotAccesses(arrayToSort,p,count);
		}
		return count;
	}
		
		
	//RECURSIONS
	
	//LEFT
	public static void quickSortRecLeft(AdtArray arrayToSort,int l, int r){
		if((r-l) <= 12){ //Bei 12 Elementen 
			InsertionSort.insertionSort(arrayToSort,l,r);
		} else {
			if(r >= l && r > 0){
				int i = l;		//um l nicht zu verändern
				int j = r;		//um r nicht zu verändern
				int pivot = arrayToSort.getA(l);
				while(j > i){ //if Bedingung als "break"
					while(arrayToSort.getA(i) <= pivot && j > i)i++;  
					//Suche nach dem ersten Element von links das größer als pivot
					while(arrayToSort.getA(j) > pivot && j >= i)j--;	
					//Suche nach dem ersten Element von rechts das kleiner/gleich als pivot
					if(j > i){swap(arrayToSort,i,j);}
					//Wenn kleineres Element größeren Index -> Swap
				}
				swap(arrayToSort,l,j);				//j ist weiter in die Mitte gerutscht, nun als Grenze der Partitionen
				quickSortRecLeft(arrayToSort,l,j-1); //Quicksort links
				quickSortRecLeft(arrayToSort,j+1,r); //Quicksort rechts
			}
		}
	}
	
	//RIGHT
	public static void quickSortRecRight(AdtArray arrayToSort,int l, int r){
		if((r-l) <= 12){ //Bei 12 Elementen 
			InsertionSort.insertionSort(arrayToSort,l,r);
		} else {
			if(r >= l && r > 0){
				int i = l;		//um l nicht zu verändern
				int j = r;		//um r nicht zu verändern
				int pivot = arrayToSort.getA(r);
				while(j > i){ //if Bedingung als "break"
					while(arrayToSort.getA(i) <= pivot && j > i)i++;  
					//Suche nach dem ersten Element von links das größer als pivot
					while(arrayToSort.getA(j) > pivot && j > i)j--;	
					//Suche nach dem ersten Element von rechts das kleiner/gleich als pivot
					if(j > i){swap(arrayToSort,i,j);}
					//Wenn kleineres Element größeren Index -> Swap
				}
				swap(arrayToSort,i,r);				//j ist weiter in die Mitte gerutscht, nun als Grenze der Partitionen
				quickSortRecRight(arrayToSort,l,i-1); //Quicksort links
				quickSortRecRight(arrayToSort,i+1,r); //Quicksort rechts
			}
		}
	}
	
	//RANDOM
	public static void quickSortRecRandom(AdtArray arrayToSort,int l, int r){
		if((r-l) <= 12){ //Bei 12 Elementen 
			InsertionSort.insertionSort(arrayToSort,l,r);
		} else {
			if(r >= l && r > 0){
				Random random = new Random();
				int tmp = random.nextInt(r);
				int pivot = arrayToSort.getA(tmp+l);
				int i = l;		//um l nicht zu verändern
				int j = r;		//um r nicht zu verändern
				while(j > i){ //if Bedingung als "break"
					while(arrayToSort.getA(i) <= pivot && j > i)i++;  
					//Suche nach dem ersten Element von links das größer als pivot
					while(arrayToSort.getA(j) > pivot && j > i)j--;	
					//Suche nach dem ersten Element von rechts das kleiner/gleich als pivot
					if(j > i){swap(arrayToSort,i,j);}
					//Wenn kleineres Element größeren Index -> Swap
				}
				swap(arrayToSort,i,r);				//j ist weiter in die Mitte gerutscht, nun als Grenze der Partitionen
				quickSortRecRandom(arrayToSort,l,i-1); //Quicksort links
				quickSortRecRandom(arrayToSort,i+1,r); //Quicksort rechts
			}
		}
	}
	
	//MEDIANOF3
	public static void quickSortRecMedian(AdtArray arrayToSort,int l, int r){
		if((r-l) <= 12){ //Bei 12 Elementen 
			InsertionSort.insertionSort(arrayToSort,l,r);
		} else {
			if(r >= l && r > 0){
				int middle = r-l/2;
				int pivot = arrayToSort.getA((middle + l + r)/3);
				int i = l;		//um l nicht zu verändern
				int j = r;		//um r nicht zu verändern
				while(j > i){ //if Bedingung als "break"
					while(arrayToSort.getA(i) <= pivot && j > i)i++;  
					//Suche nach dem ersten Element von links das größer als pivot
					while(arrayToSort.getA(j) > pivot && j > i)j--;	
					//Suche nach dem ersten Element von rechts das kleiner/gleich als pivot
					if(j > i){swap(arrayToSort,i,j);}
					//Wenn kleineres Element größeren Index -> Swap
				}
				swap(arrayToSort,i,r);				//j ist weiter in die Mitte gerutscht, nun als Grenze der Partitionen
				quickSortRecMedian(arrayToSort,l,i-1); //Quicksort links
				quickSortRecMedian(arrayToSort,i+1,r); //Quicksort rechts
			}
		}
	}
	
	//SWAP

	public static void swap(AdtArray arrayToSort,int i, int j){
		int tmp = arrayToSort.getA(i);
		arrayToSort.setA(i,arrayToSort.getA(j));
		arrayToSort.setA(j,tmp);
	}
	
	//ENUM-ZUGRIFF
	
	public static void getPivot(AdtArray arrayToSort,MethodPivot p){
		switch(p){
		case LEFT:
			quickSortRecLeft(arrayToSort,0,arrayToSort.lengthA()-1);
		case RIGHT:
			quickSortRecRight(arrayToSort,0,arrayToSort.lengthA()-1);
		case RANDOM:
			quickSortRecRandom(arrayToSort,0,arrayToSort.lengthA()-1);
		case MEDIANOF3:
			quickSortRecMedian(arrayToSort,0,arrayToSort.lengthA()-1);
		default:
			quickSortRecLeft(arrayToSort,0,arrayToSort.lengthA()-1);
		}
	}
	
	//ENUM-ZUGRIFF-QUICKSORTZUGRIFFE
	
	public static int[] getPivotAccesses(AdtArray arrayToSort,MethodPivot p, int[] count){
		count[2]++;
		switch(p){
		case LEFT:
			return quickSortRecLeftAccesses(arrayToSort,0,arrayToSort.lengthA()-1,count);
		case RIGHT:
			return quickSortRecRightAccesses(arrayToSort,0,arrayToSort.lengthA()-1,count);
		case RANDOM:
			return quickSortRecRandomAccesses(arrayToSort,0,arrayToSort.lengthA()-1,count);
		case MEDIANOF3:
			return quickSortRecMedianAccesses(arrayToSort,0,arrayToSort.lengthA()-1,count);
		default:
			return quickSortRecLeftAccesses(arrayToSort,0,arrayToSort.lengthA()-1,count);
		}
	}
	
	//ZUGRIFF-REKURSIONEN
	
	//LEFT
	public static int[] quickSortRecLeftAccesses(AdtArray arrayToSort,int l, int r,int[] count){
		if((r-l) <= 12){ //Bei 12 Elementen 
			int[] countIns = InsertionSort.insertionSortAccessCount(arrayToSort,l,r);
			count[0]+=countIns[0];
			count[1]+=countIns[1];
			count[2]+=countIns[2];
			count[3]+=countIns[3];
		} else {
			count[2]+=2;
			if(r >= l && r > 0){
				int i = l;		//um l nicht zu verändern
				int j = r;		//um r nicht zu verändern				
				int pivot = arrayToSort.getA(l);
				count[2]++;
				count[0]++;
				count[3]+=2;
				while(j > i){ //if Bedingung als "break"
					count[0]++;
					count[2]+=3;
					while(arrayToSort.getA(i) <= pivot && j > i){
						i++;
						count[3]++;
					}
					count[0]++;
					count[2]+=3;
					while(arrayToSort.getA(j) > pivot && j >= i){
						j--;
						count[3]++;
					}
					count[2]++;
					if(j > i){
						count[2]++;
						swapAccesses(arrayToSort,i,j,count);
					}
				}
				count[2]++;
				swapAccesses(arrayToSort,l,j,count);		
				count[2]++;
				count[3]++;
				quickSortRecLeft(arrayToSort,l,j-1);
				count[2]++;
				count[3]++;
				quickSortRecLeft(arrayToSort,j+1,r);
			}
		}
		return count;
	}
	
	//RIGHT
	public static int[] quickSortRecRightAccesses(AdtArray arrayToSort,int l, int r,int[] count){
		if((r-l) <= 12){ //Bei 12 Elementen 
			int[] countIns = InsertionSort.insertionSortAccessCount(arrayToSort,l,r);
			count[0]+=countIns[0];
			count[1]+=countIns[1];
			count[2]+=countIns[2];
			count[3]+=countIns[3];
		} else {
			count[2]+=2;
			if(r >= l && r > 0){
				int i = l;		//um l nicht zu verändern
				int j = r;		//um r nicht zu verändern				
				int pivot = arrayToSort.getA(r);
				count[2]++;
				count[0]++;
				count[3]+=2;
				while(j > i){ //if Bedingung als "break"
					count[0]++;
					count[2]+=3;
					while(arrayToSort.getA(i) <= pivot && j > i){
						i++;
						count[3]++;
					}
					count[0]++;
					count[2]+=3;
					while(arrayToSort.getA(j) > pivot && j >= i){
						j--;
						count[3]++;
					}
					count[2]++;
					if(j > i){
						count[2]++;
						swapAccesses(arrayToSort,i,j,count);
					}
				}
				count[2]++;
				swapAccesses(arrayToSort,i,r,count);		
				count[2]++;
				count[3]++;
				quickSortRecLeft(arrayToSort,l,i-1);
				count[2]++;
				count[3]++;
				quickSortRecLeft(arrayToSort,i+1,r);
			}
		}
		return count;
	}
	
	//RANDOM
	public static int[] quickSortRecRandomAccesses(AdtArray arrayToSort,int l, int r,int[] count){
		if((r-l) <= 12){ //Bei 12 Elementen 
			int[] countIns = InsertionSort.insertionSortAccessCount(arrayToSort,l,r);
			count[0]+=countIns[0];
			count[1]+=countIns[1];
			count[2]+=countIns[2];
			count[3]+=countIns[3];
		} else {
			count[2]+=2;
			if(r >= l && r > 0){
				int i = l;		//um l nicht zu verändern
				int j = r;		//um r nicht zu verändern
				Random random = new Random();
				int tmp = random.nextInt(r);
				count[3]++;
				count[2]++;
				int pivot = arrayToSort.getA(tmp+l);
				count[2]++;
				count[0]++;
				count[3]+=2;
				while(j > i){ //if Bedingung als "break"
					count[0]++;
					count[2]+=3;
					while(arrayToSort.getA(i) <= pivot && j > i){
						i++;
						count[3]++;
					}
					count[0]++;
					count[2]+=3;
					while(arrayToSort.getA(j) > pivot && j >= i){
						j--;
						count[3]++;
					}
					count[2]++;
					if(j > i){
						count[2]++;
						swapAccesses(arrayToSort,i,j,count);
					}
				}
				count[2]++;
				swapAccesses(arrayToSort,i,r,count);		
				count[2]++;
				count[3]++;
				quickSortRecLeft(arrayToSort,l,i-1);
				count[2]++;
				count[3]++;
				quickSortRecLeft(arrayToSort,i+1,r);
			}
		}
		return count;
	}
	
	//MEDIANOF3
		public static int[] quickSortRecMedianAccesses(AdtArray arrayToSort,int l, int r,int[] count){
			if((r-l) <= 12){ //Bei 12 Elementen 
				int[] countIns = InsertionSort.insertionSortAccessCount(arrayToSort,l,r);
				count[0]+=countIns[0];
				count[1]+=countIns[1];
				count[2]+=countIns[2];
				count[3]+=countIns[3];
			} else {
				count[2]+=2;
				if(r >= l && r > 0){
					int i = l;		//um l nicht zu verändern
					int j = r;		//um r nicht zu verändern
					int middle = r-l/2;
					count[3]++;
					count[2]+=2;
					int pivot = arrayToSort.getA((middle + l + r)/3);
					count[2]++;
					count[0]++;
					count[3]+=2;
					while(j > i){ //if Bedingung als "break"
						count[0]++;
						count[2]+=3;
						while(arrayToSort.getA(i) <= pivot && j > i){
							i++;
							count[3]++;
						}
						count[0]++;
						count[2]+=3;
						while(arrayToSort.getA(j) > pivot && j >= i){
							j--;
							count[3]++;
						}
						count[2]++;
						if(j > i){
							count[2]++;
							swapAccesses(arrayToSort,i,j,count);
						}
					}
					count[2]++;
					swapAccesses(arrayToSort,i,r,count);		
					count[2]++;
					count[3]++;
					quickSortRecLeft(arrayToSort,l,i-1);
					count[2]++;
					count[3]++;
					quickSortRecLeft(arrayToSort,i+1,r);
				}
			}
			return count;
		}
	
	//SWAP ACCESSES
	public static int[] swapAccesses(AdtArray arrayToSort,int i, int j,int[] count){
		int tmp = arrayToSort.getA(i);
		arrayToSort.setA(i,arrayToSort.getA(j));
		arrayToSort.setA(j,tmp);
		count[1]+=4;
		count[3]++;
		return count;
	}
	
}
