package sort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import adt.Interfaces.AdtArray;
import adt.implementations.AdtArrayImpl;

public class NumGenerator {

	private NumGenerator() {}
	
	public static void sortNum(String filename, int quantity) {
		try { 
			FileWriter fw = new FileWriter(filename+".dat");
			BufferedWriter bw = new BufferedWriter(fw);
			Random rnd = new Random(System.currentTimeMillis());
			for (int i = 0; i < quantity; i++) {
				bw.write(rnd.nextInt(quantity)+" ");
			}

	    	bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void sortNum(String filename, int quantity, boolean desc) {
		try { 
			FileWriter fw = new FileWriter(filename+".dat");
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int i = 0; i < quantity && desc == false; i++) {
				bw.write(i+" ");
			}
			for (int i = quantity; i > 0 && desc == true; i++) {
				bw.write(i+" ");
			}

	    	bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static AdtArray readNum(String filename) {
		AdtArray array = AdtArrayImpl.initA();
		try (Scanner scanner = new Scanner(new File(filename+".dat"))) {
			int index = 0;
			while(scanner.hasNextInt()) {
				array.setA(index, scanner.nextInt());
				index++;
			}
		} catch (IOException e) { 
			e.printStackTrace();
			return null;
		}
		return array;
	}
	
	public static void main(String[] args) {
		//main nur zum testen:
		sortNum("hello", 100);
		AdtArray a = readNum("hello");
		for (int i = 0; i < a.lengthA(); i++) {
			System.out.print(a.getA(i)+" ");
			if(i % 10 == 9) 
				System.out.println("");
		}
		
	}
}
