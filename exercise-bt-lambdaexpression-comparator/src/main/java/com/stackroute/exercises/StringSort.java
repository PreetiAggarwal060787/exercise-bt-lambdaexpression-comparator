package com.stackroute.exercises;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class StringSort {
    //write here logic to sort a string List
	public String stringSorter(List<String> stringList, String sortingOrder) {
        if (stringList == null || sortingOrder == null || stringList.isEmpty() || sortingOrder.trim().isEmpty()) {
            return "Given stringList or sortingOrder is empty, null or blank space";
        }
        if (stringList.stream().anyMatch(s -> s == null || s.trim().isEmpty() || s.trim().equals(""))) {
            return "The list contains an empty or blank space value";
        }
        if (!sortingOrder.equalsIgnoreCase("asc") && !sortingOrder.equalsIgnoreCase("desc")) {
            return "No sorting order present for given string '" + sortingOrder + "' , 'asc' for ascending order sort and 'desc' for descending order sort";
        }
        if (stringList.size() == 1) {
            return "The list contains only one value";
        }
        Comparator<String> comparator = sortingOrder.equalsIgnoreCase("asc") ? Comparator.naturalOrder() : Comparator.reverseOrder();
        List<String> sortedList = stringList.stream().sorted(comparator).collect(Collectors.toList());
        return "[" + String.join(", ", sortedList) + "]";
    }
	
	  public static void main(String[] args) {
	        StringSort sorter = new StringSort();
	        List<String> stringList = Arrays.asList("Kennedy", "John", "Apple");
	        String sortingOrder = "asc";
	        String sortedStringList = sorter.stringSorter(stringList, sortingOrder);
	        System.out.println(sortedStringList);
	    }
}