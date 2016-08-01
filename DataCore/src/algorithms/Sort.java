/**
 * 
 */
package algorithms;

import java.util.LinkedList;

/**
 * @author Vaygr
 *
 */
public class Sort {

	/**
	 * 
	 */
	public Sort() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * Sorts an array of integers using selection sort algorithm.
	 * Complexity - O(n^2)
	 * @param input - Array of integers to be sorted.
	 */
	public static void selectionSort(int[] input){
		// Algorithm:
		// -Traverse the array/list
		// -At each element find the smallest element from
		//  that element till the end of the array/List.
		// -If the smallest element so far is less than
		//  the current element, swap them.
		for ( int i=0; i < input.length; i++ ){
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			for ( int j=i; j < input.length; j++) {
				if ( input[j] < min ){
					min = input[j];
					minIdx = j;
				}
			}
			if ( input[i] > min ){
				swapArrayElements(i,minIdx,input);
			}
		}
	}
	
	/**
	 * Sorts an array of integers using insertion sort.
	 * @param input - Array of integers to be sorted.
	 */
	public static void insertionSort(int[] input){
		// Algorithm -
		// - Traverse the array/List
		for ( int i=1; i < input.length; i++ ){
			int j = i;
			while ( j > 0 && (input[j] < input[j-1])){
				swapArrayElements(j, j-1, input);
				j--;
			}
		}
	}
	
	public static void mergeSort(int[] input){
		int left = 0;
		int right = input.length - 1;
		mergeSort(left, right, input);
	}
	
	private static void mergeSort(int left, int right, int[] input){
		// TODO: Implement merge sort.
		// Divide the array/List
		// Sort left part
		// Sort right part
		// And merge two parts. 
		if ( left < right ){		
			int mid = (left + right) / 2;
			mergeSort( left, mid, input );
			mergeSort ( mid+1, right, input);
			merge(left, right, mid, input);
		}
	}
	
	private static void merge(int left, int right, int mid, int[] input) {
		// TODO Auto-generated method stub
		System.out.println("Left: " + left + " Right: " + right + " Mid: " + mid );
		
		LinkedList<Integer> bufferList = new LinkedList<Integer>();
		LinkedList<Integer> leftQ = new LinkedList<Integer>();
		LinkedList<Integer> rightQ = new LinkedList<Integer>();
		
		for ( int i=left; i <= mid; i++ ){
			leftQ.add(input[i]);
		}
		
		System.out.println("L-Queue: " + leftQ);
		
		for ( int j=mid+1; j <= right; j++) {
			rightQ.add(input[j]);
		}
		
		System.out.println("R-Queue: " + rightQ);
		
		int lVal = -1;
		int rVal = -1;
		do {
			lVal = leftQ.peekFirst();
			rVal = rightQ.peekFirst();
			if ( lVal <= rVal ){
				bufferList.add(lVal);
				lVal = leftQ.removeFirst();
			}
			else if ( rVal <= rVal ){
				bufferList.add(rVal);
				rVal = rightQ.removeFirst();
			}
		}
		while ( !leftQ.isEmpty() && !rightQ.isEmpty() );
		
		if ( !leftQ.isEmpty() ){
			bufferList.addAll(leftQ);
		}
		else if ( !rightQ.isEmpty()){
			bufferList.addAll(rightQ);
		}
		
		System.out.println(bufferList);

		for ( int i=left; i <= right; i++){
			if ( !bufferList.isEmpty() ) {
				input[i] = bufferList.removeFirst();
			}
		}
	}

	public static void quickSort(int[] input){
		// TODO: Implement quick sort.
	}
	
	public static void binarySearch(int[] input){
		
	}
	
	private static void swapArrayElements(int i, int minIdx, int[] input) {
		int holder = input[i];
		input[i] = input[minIdx];
		input[minIdx] = holder;
	}

	
	
	

}
