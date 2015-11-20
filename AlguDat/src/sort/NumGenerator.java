package sort;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import adt.Interfaces.AdtArray;
import adt.implementations.AdtArrayImpl;

public class NumGenerator {

	private NumGenerator() {}
	
	public static void sortNum(String filename, int quantity) {
		
	}
	
	public static void sortNum(String filename, int quantity, boolean desc) {
		
	}
	
	public static AdtArray readNum(String filename) {
		AdtArray array = AdtArrayImpl.initA();
		try (Scanner scanner = new Scanner(new File(filename+".dat"))) {
			
			int index = 0;
			while(scanner.hasNextInt()) {
				array.setA(index, scanner.nextInt());
			}
		} catch (IOException e) { 
			e.printStackTrace();
			return null;
		}
		return array;
	}
}
