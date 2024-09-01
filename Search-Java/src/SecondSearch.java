/* @author: Krishm Patel
 * @date: November 7, 2022
 */


import java.util.*;


public class SecondSearch {

	
	public static int partition(int numbers[], int low, int high) {
		   int mid = (low + high) / 2;
		   int pivot = numbers[mid];
		   boolean done = true;
		   int temp;
		   int myLow = low;
		   int myHigh = high;

		   while (done) {
		      while (numbers[myLow] < pivot) {
		         myLow++;
		      }

		      while (pivot < numbers[myHigh]) {
		         myHigh--;
		      }
		      if (myLow >= myHigh) {
		         done = false;
		      }
		      else {
		         temp = numbers[myLow];
		         numbers[myLow] = numbers[myHigh];
		         numbers[myHigh] = temp;

		         myLow++;
		         myHigh--;
		      }
		   }
		   return myHigh;
		}
	public static void quickSort(int numbers[], int low, int high) {
		   int mid;
		   
		   if (low >= high) {
		      return;
		   }
		   
		   mid = partition(numbers, low, high);
		   
		   quickSort(numbers, low, mid);
		   quickSort(numbers, mid + 1, high);
		}
	
	public static void merge(int numbers[], int low, int mid, int high) {
		int leftPos = low;
		int rightPos = mid + 1;
		int mergePos = 0;
		int mergeSize = high - low + 1;
		int[] tempArray = new int[mergeSize];

		while (leftPos <= mid && rightPos <= high) {
			if (numbers[leftPos] <= numbers[rightPos]) {
			   tempArray[mergePos] = numbers[leftPos];
			         ++leftPos;
			} else {
			         tempArray[mergePos] = numbers[rightPos];
			         ++rightPos;
			}
	    ++mergePos;
	   }
		   while (leftPos <= mid) {
		      tempArray[mergePos] = numbers[leftPos];
		      ++leftPos;
		      ++mergePos;
		   }
		 
		   while (rightPos <= high) {
		      tempArray[mergePos] = numbers[rightPos];
		      ++rightPos;
		      ++mergePos;
		   }
		 
		   for (mergePos = 0; mergePos < mergeSize; ++mergePos) {
		      numbers[low + mergePos] = tempArray[mergePos];
		   }
		}
	public static void mergeSort(int numbers[], int low, int high) {
		   int mid;
		   
		   if (low < high) {
		      mid = (low + high) / 2;  
		      
		      mergeSort(numbers, low, mid);
		      mergeSort(numbers, mid + 1, high);
		      
		      merge(numbers, low, mid, high);
		   }
		}
	
	
	public static void main(String args[]) {
		
		int randomIntArray[] = new int[1000000];
		int arrNum = 0;
		Random rand = new Random();
		
		for (int i = 0; i < randomIntArray.length; i++) {
			randomIntArray[i] = arrNum;
			arrNum++;
		}
		for (int i = 0; i < randomIntArray.length; i++) {
			int randIndex = rand.nextInt(randomIntArray.length);
			int temp = randomIntArray[randIndex];
			randomIntArray[randIndex] = randomIntArray[i];
			randomIntArray[i] = temp;
		}
		
		int copyArray[] = randomIntArray.clone();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		quickSort(randomIntArray, 0, (randomIntArray.length - 1));
		endTime = System.nanoTime();
		long quickTime = (endTime - startTime) / 1000000;
		
		startTime = System.nanoTime();
		mergeSort(copyArray, 0, copyArray.length - 1);
		endTime = System.nanoTime();
		long mergeTime = (endTime - startTime) / 1000000;
		
		System.out.println("Quick Sort took: " + quickTime + " milliseconds.");
		System.out.println("Merge Sort took: " + mergeTime + " milliseconds.");
		if (quickTime < mergeTime) {
			System.out.println("Quick sort wins!");
		} else if (quickTime > mergeTime) {
			System.out.println("Merge sort wins!");
		} else {
			System.out.println("It was a tie!");
		}

		
	}

	
}
