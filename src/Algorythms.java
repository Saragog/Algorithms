import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
public class Algorythms {

	private static SortingAlgorytms sorting;
	
	public static void main(String[] args) {
		
		sorting = new SortingAlgorytms();
		
		//sorting.bubbleSort(new ArrayList<Integer>(Arrays.asList(4,2,3,5)));
		//sorting.selectionSort(new ArrayList<Integer>(Arrays.asList(4,2,3,5,1,2,9,7)));
		//sorting.insertionSort(new ArrayList<Integer>(Arrays.asList(3,1,5,3,16,8,2,1,12,6)));
		//sorting.countingSort(new ArrayList<Integer>(Arrays.asList(3,1,5,3,16,8,2,1,12,6)));
		//sorting.mergeSort(new ArrayList<Integer>(Arrays.asList(2,12,3,6,3,1,11,5,8)));
		sorting.quickSort(new ArrayList<Integer>(Arrays.asList(2,12,3,6,3,1,11,5,8)));
		
		int a = 5;
		/*
		switch (a)
		{
		case 0:
			System.out.println(0);
			break;
		default:
			System.out.println(-1);
			break;
		case 1:
			System.out.println(1);
			break;
		case 5:
			//System.out.println(5);
			break;
		}
		
		
		int aNumber = 3;
		
		if (aNumber >= 0)
		    if (aNumber == 0)
		        System.out.println("first string");
		else 
		    System.out.println("second string");
		else
			System.out.println("third string");
		System.out.println("fourth string");
		
		*/
	}

}
