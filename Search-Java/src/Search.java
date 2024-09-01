/* @author: Krishm Patel
 * @date: November 7, 2022
 */


import java.util.*;


public class Search {


	
	public static int linearSearch(int[] array, int key) {
		int linearLoops = 0;
		for (int i = array.length - 1; i > 0; i--) {
			if (array[i] == key) {
				linearLoops = array.length - i;
				return linearLoops;
			}
		}
		linearLoops = array.length;
		return -1;
	}
	
	public static int binarySearch(int[] array, int key) {
		
		int binaryGuesses = 0;
		int low = 0;
		int high = array.length - 1;
		int mid = (high + low) / 2;

		while (high >= low) {
			mid = (high + low) / 2;
			binaryGuesses++;
			if (array[mid] == key) {
				return binaryGuesses;
			} else if (array[mid] < key) {
				high = mid - 1;
			} else if ( array[mid] > key) {
				low = mid + 1;
			}
		}
		return -1;
		
	}
	
	
	public static void main(String args[]) {
		int arrayNum = 999999;
		int myArray[] = new int[1000000];
		
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = arrayNum;
			arrayNum--;
		}
		
		Random rand = new Random();
		int myKey = rand.nextInt(myArray.length);
		
		int linearNum = linearSearch(myArray, myKey);
		int binaryNum = binarySearch(myArray, myKey);
		
		System.out.println("[Linear Vs. Binary Search]");
		System.out.println("The target value is: " + myKey);		
		System.out.println("Linear Search: " + linearNum + " loop(s).");
		System.out.println("Binary Search: " + binaryNum + " guess(es).");
		
		if (linearNum == -1){
			System.out.println("Number does not exist!");
		} else if (linearNum == binaryNum) {
			System.out.println("Both searches took the same amount of time!");
		} else if (linearNum > binaryNum) {
			System.out.println("Binary Search was faster!");
		} else {
			System.out.println("Linear Search was faster!");
		}
		
		
	}
	
	
	
	
	
}
