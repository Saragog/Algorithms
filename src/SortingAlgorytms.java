import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortingAlgorytms {

	
	public SortingAlgorytms()
	{
		
	}
	
	private void switchTwo(ArrayList<Integer> inputList, int first, int second)
	{
		Integer temp = inputList.get(first);
		inputList.set(first, Integer.valueOf(inputList.get(second)));
		inputList.set(second, temp);
		return;
	}
	
	public void bubbleSort(ArrayList<Integer> inputList)
	{
		System.out.println("Input list:");
		for(Integer i : inputList)
			System.out.println(i);
		
		boolean hasChanged;
		for (int step = 0, size = inputList.size(); step < size; step++)
		{
			hasChanged = false;
			for(int elem1 = size - 2, elem2 = size - 1; elem1 >= 0; elem1--, elem2--)
			{
				if (inputList.get(elem1) > inputList.get(elem2))
				{
					switchTwo(inputList, elem1, elem2);
					hasChanged = true;
				}
			}
			if (!hasChanged) break;
		}
		
		System.out.println("Result list:");
		for(Integer i : inputList)
			System.out.println(i);
		
		return;
	}
	
	public void selectionSort(ArrayList<Integer> inputList)
	{
		System.out.println("Input list:");
		for(Integer i : inputList)
			System.out.println(i);
		
		boolean hasToChange;
		int smallestPosition;
		
		for (int actualSwapPosition = 0,
				size = inputList.size();
				actualSwapPosition < size;
				actualSwapPosition++)
		{
			hasToChange = false;
			smallestPosition = actualSwapPosition;
			for (int actualCheckedPosition = actualSwapPosition, smallestValue = inputList.get(actualCheckedPosition);
					actualCheckedPosition < size;
					actualCheckedPosition++)
			{
				if (inputList.get(actualCheckedPosition) < smallestValue)
				{
					smallestValue = inputList.get(actualCheckedPosition);
					smallestPosition = actualCheckedPosition;
					hasToChange = true;
				}
			}
			if (hasToChange)
			{
				switchTwo(inputList, actualSwapPosition, smallestPosition);
			}
		}
		
		System.out.println("Result list:");
		for(Integer i : inputList)
			System.out.println(i);
		
		return;
	}
	
	private void pushRestToRight(List<Integer> inputList, int fromWhere)
	{
		int size = inputList.size();
		for(int actualElementPosition = fromWhere, 
				nextElementPosition = fromWhere+1, 
				val1 = inputList.get(actualElementPosition).intValue(), 
				val2 = inputList.get(nextElementPosition).intValue(); 
				nextElementPosition < size;
				actualElementPosition++,
				nextElementPosition++,
				val1 = val2,
				val2 = inputList.get(nextElementPosition).intValue()
				)
		{
			if (inputList.get(nextElementPosition).intValue() == -1)
			{	
				inputList.set(nextElementPosition, Integer.valueOf(val1));
				break;
			}
			inputList.set(nextElementPosition, Integer.valueOf(val1));
		}
		
		return;
	}
	
	private void insertValueToSortedList(List<Integer> inputList, int newValue) 
	{
		int size = inputList.size();
		
		for (int position = 0; position < size; position++)
		{
			if (inputList.get(position) == -1)
			{
				inputList.set(position, Integer.valueOf(newValue));
				return;
			}
			else if (inputList.get(position).intValue() >= newValue)
			{
				pushRestToRight(inputList, position);
				inputList.set(position, Integer.valueOf(newValue));
				break;
			}
		}
		
	}
	
	public void insertionSort(List<Integer> inputList)
	{
		System.out.println("Input list:");
		for(Integer i : inputList)
			System.out.println(i);
		
		int size = inputList.size();
		List<Integer> resultList = new ArrayList<Integer>(inputList);
		for (int step = 0; step < size; step++) resultList.set(step, Integer.valueOf(-1));
		for(int actualCheckedNumberPosition = 0;
				actualCheckedNumberPosition < size;
				actualCheckedNumberPosition++)
			insertValueToSortedList(resultList, inputList.get(actualCheckedNumberPosition).intValue());
	
		System.out.println("Result list:");
		for(Integer i : resultList)
			System.out.println(i);
		
		return;
	}
	
	private Pair<Integer, Integer> findExtremeValues(List<Integer> inputList)
	{
		int minValue, maxValue, actualValue, size = inputList.size();
		if (size == 0) return new Pair<Integer, Integer>(-1,-1);		
		minValue = inputList.get(0).intValue();
		maxValue = inputList.get(0).intValue();
		for (int actualNumberIndex = 1;
				actualNumberIndex < size;
				actualNumberIndex++)
		{
			actualValue = inputList.get(actualNumberIndex).intValue();
			if (actualValue < minValue) minValue = actualValue;
			else if (actualValue > maxValue) maxValue = actualValue;
		}
		return new Pair<Integer, Integer>(minValue, maxValue);
	}
	
	public void countingSort(List<Integer> inputList)
	{
		System.out.println("Input list:");
		writeList(inputList);		
		int[] valuesCounts;
		int actualValue, minValue, maxValue;
		int size = inputList.size();
		if (size <= 1) return;
		List<Integer> resultList = new ArrayList<Integer>(inputList);
		Pair<Integer, Integer> extremes = findExtremeValues(inputList);
		minValue = extremes.getFirst().intValue();
		maxValue = extremes.getSecond().intValue();
		valuesCounts = new int[maxValue - minValue + 1];
		
		for (int actualNumberIndex = 0; actualNumberIndex < size; actualNumberIndex++)
		{
			actualValue = inputList.get(actualNumberIndex);
			valuesCounts[actualValue - minValue]++;			
		}
		
		actualValue = minValue;
		for (int actualStep = 0, valueCount; actualStep < size; actualStep++, actualValue++)
		{
			valueCount = valuesCounts[actualStep];
			for (int x = 0; x < valueCount; x++)
				resultList.add(actualValue);
		}
		
		System.out.println("Result list:");
		writeList(resultList);

		return;
	}
	
	private Integer compareValuesFromLists(Pair<List<Integer>, Integer> firstPair, Pair<List<Integer>, Integer> secondPair)
	{
		int size1 = firstPair.getFirst().size(), size2 = secondPair.getFirst().size();
		int actualNumberIndex1, actualNumberIndex2;
		actualNumberIndex1 = firstPair.getSecond().intValue();
		actualNumberIndex2 = secondPair.getSecond().intValue();
		
		if (actualNumberIndex1 == size1)
			return secondPair.getFirst().get(actualNumberIndex2);
		else if (actualNumberIndex2 == size2)
			return firstPair.getFirst().get(actualNumberIndex1);
		else if (firstPair.getFirst().get(actualNumberIndex1).intValue() < secondPair.getFirst().get(actualNumberIndex2).intValue())
			return firstPair.getFirst().get(actualNumberIndex1);
		else 
			return secondPair.getFirst().get(actualNumberIndex2);		
	}
	
	private List<Integer> mergeIntoOne(List<Integer> first, List<Integer> second)
	{
		List<Integer> result = new LinkedList<Integer>();
		Integer valueToAdd;
		int size1 = first.size(), size2 = second.size();
		System.out.println("Size1: " + size1 + " Size2: " + size2);
		for (int actualNumberIndex1 = 0, actualNumberIndex2 = 0;
				 actualNumberIndex1 < size1 || actualNumberIndex2 < size2;)
		{
			valueToAdd = compareValuesFromLists(new Pair<List<Integer>, Integer>(first, Integer.valueOf(actualNumberIndex1)),
												new Pair<List<Integer>, Integer>(second, Integer.valueOf(actualNumberIndex2)));
			result.add(valueToAdd);
			if (actualNumberIndex1 < size1 && valueToAdd.intValue() == first.get(actualNumberIndex1).intValue()) actualNumberIndex1++;
			else actualNumberIndex2++;
		}
		return result;
	}
	
	private List<Integer> recursiveMergeSort(List<Integer> inputList)
	{
		int size = inputList.size();
		List<Integer> firstPart;
		List<Integer> secondPart;
		if (size <= 1) return inputList;
		firstPart = inputList.subList(0, size / 2);
		secondPart = inputList.subList((size / 2), size);
		return mergeIntoOne(recursiveMergeSort(firstPart), recursiveMergeSort(secondPart));
	}
	
	public void mergeSort(List<Integer> inputList)
	{
		System.out.println("Input list:");
		writeList(inputList);		
		int size = inputList.size();
		List<Integer> resultList = recursiveMergeSort(inputList);
		System.out.println("Result list:");
		writeList(resultList);
	}
	
	private List<Integer> recursiveQuickSort(List<Integer> inputList)
	{
		List<Integer> firstPart = new ArrayList<Integer>();
		List<Integer> secondPart = new ArrayList<Integer>();

		// ----
		
		// TODO znajdowanie wartosci dzielacej na 2 czesci i wykonywanie podzialu
		
		
		
		// ----
		
		firstPart = recursiveQuickSort(firstPart);
		firstPart.addAll(recursiveQuickSort(secondPart));
		return firstPart;
	}
	
	public void quickSort(List<Integer> inputList)
	{
		System.out.println("Input list: ");
		writeList(inputList);
		List<Integer> resultList = recursiveQuickSort(inputList);
		System.out.println("Result list:");
		writeList(resultList);
		return;
	}
	
	private static void writeList(List<Integer> inputList)
	{
		for(Integer i : inputList)
			System.out.println(i);
		return;
	}
	
	
}
