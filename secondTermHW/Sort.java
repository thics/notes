/*========== Sort.java ==========

  Class used to test various sorting algorithms.
  The constructor will create an array of ints and then
  populate them with random values.
  
  The class also contains variables to keep track
  of the number of swaps and comparisons performed
  for a given sort.

  Complete bubble(), selection() and insertion()
  jdyrlandweaver
  =========================*/

import java.io.*;
import java.util.*;

public class Sort {

  public static int DEFAULT_SIZE = 1000;

  /*======== public void populate()) ==========
    Inputs: int[] list   
    Returns: 
      
    populates the list with random ints in the 
    range [0, list.length)
    ====================*/
  public static void populate( int[] list ) {

    Random r = new Random();
    for (int i=0; i<list.length; i++)
	    list[i] = r.nextInt() % list.length;
  }

  /*======== public void duplicate () ==========
    Inputs:  int[] a
    Returns: A new array of ints that is an exact
    duplicate of a      
    ====================*/
  public static int[] duplicate ( int[]  a ) {

    int[] n = new int[ a.length ];
    
    for (int i=0; i<a.length; i++)
	    n[i] = a[i];

    return n;
  }

  public static String show(int[] list) {
    String s = "";
    for (int i=0; i<list.length - 1; i++)
	    s = s + list[i] + ", ";
    return s + list[list.length-1];
  }


  /*======== public boolean isSorted()) ==========
    Inputs:   
    Returns: true if the list is sorted
    false if the list is unsorted

    ====================*/
  public static boolean isSorted(int[] list) {
    for (int i=0; i<list.length - 1; i++)
	    if (list[i] > list[i+1])
        return false;
    return true;
  }

  /*======== public void swap() ==========
    Inputs:  int a
    int b  
    Returns: 
      
    Swaps the values at postitons a and b in list
    ====================*/    
  public static void swap(int a, int b, int[] list) {
    int c = list[a];
    list[a] = list[b];
    list[b] = c;
  }

  public static void insertionSort(int[] a) {
    int t, pos;
    for (int i=1; i < a.length; i++) {
	    pos = i;
	    t = a[pos];
	    while ( pos > 0 && a[pos - 1] > t ) {
        a[pos] = a[pos - 1];
        pos --;
	    }
	    a[pos] = t;
    }
  }
    

  /*======== public static int[] merge() ==========
    Inputs:  int[] a
    int[] b  
    Returns: A new sorted array containing the 
    combined elements of a and b
              
    This method must run in linear time.      
    ====================*/
  public static int[] merge( int[] a, int[] b )  { //Sorts between two sorted lists
    int[] sorted = new int[a.length + b.length];
    int indA = 0; 
    int indB = 0;
    int indS = 0;
    while(indS < sorted.length) {

      if(indA >= a.length) { // If A is done
        for(int i = indB; i < b.length; i++) {
          sorted[indS] = b[i];
          indS++;
        }
        break;
      }
      if(indB >= b.length) { // If B is done
        for(int i = indA; i < a.length; i++) {
          sorted[indS] = a[i];
          indS++;
        }
        break;
      }

      if(a[indA] <= b[indB]) {
        sorted[indS] = a[indA];
        indA++;
        indS++;
      }
      else {
        sorted[indS] = b[indB];
        indB++;
        indS++;
      }
    }
    return sorted;
  }

  public static int[] mergeSort( int[] list ) {
    int[] front = new int[list.length / 2];
    int[] back = new int[list.length - front.length];

    if(list.length <= 1)
      return list;

    if(list.length >= 2) {
      //Split
      for(int i = 0; i < front.length; i++) //Split list
        front[i] = list[i];
      
      for(int j = 0; j < back.length; j++)
        back[j] = list[j + front.length];

      //Keep splitting if not sorted
      front = mergeSort(front);      
      back = mergeSort(back);
    }
    
    list = merge(front, back);
    return list;
  }

  public static void main(String[] args) {

    int[] a1 = new int[10];
    int[] a2 = new int[10];
    int[] a3 = new int[10];

    populate(a1);
    populate(a2);
    insertionSort(a1);
    insertionSort(a2);
    //    System.out.println( show(a1) );
    //    System.out.println( show(a2) );
    
    int[] merged = merge( a1, a2 );
    //    System.out.println( show( merged ) );
	
    populate(a3);
    System.out.println(show(a3));

    System.out.println( show(mergeSort(a3)));
    
  }
}
