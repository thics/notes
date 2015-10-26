import java.util.*;

public class Recursion {

  private static ArrayList combinations = new ArrayList();
  public static boolean scrambled = false;
  public static int position = 0;
  
  //Returns n!
  public static int factorial(int n) {
    if(n < 0)
      return -1;
    if(n == 0) 
      return 1;

    return n * factorial(n - 1);
  }

  //Returns n-th term in fib sequence
  public static long fib2(int n, long[] values) {
    
    populate(values, n); //Populates values
    return fib2Helper(n, values);

  }

  public static long fib2Helper(int n, long[] values) {

    if(values.length <= 2)
      return 1;
    
    if(n <= values.length) {
      return values[n];
    }

    return fib2(n - 1, values) + fib2(n - 2, values);
  }
  
  public static long populate(long[] list, int size) {
    list = new long[size];
    for(int i = 0; i < size; i++) {
      if (i < 2)
        list[i] = 1;
      else
        list[i] = list[i - 1] + list[i - 2];
    }

    return 1;
  }


  //Return sqrt using Newton's Approximation Method
  public static double sqrt(double guess, double n) {
    n = Math.abs(n);
    
    if(guess * guess <= n + .001 && guess * guess >= n - .001) {
      return guess;      
    }

    guess = ( n / guess + guess) / 2;
    return sqrt(guess, n);
  }

  //Scrambles a String
  public static ArrayList scramble(String s) {
    ArrayList<String> l = new ArrayList<String>();
    scrambleHelp("", s, l);
    return l;
  }

  public static void scrambleHelp(String pre, String s, ArrayList<String> al)  {
    if (s.length() == 0) 
      al.add(pre);
    else
      for (int i = 0; i < s.length(); i++)
        scrambleHelp(pre + s.charAt(i), s.substring(0, i) + s.substring(i+1), al);
  }

  public static void main(String[] args) {
    System.out.println("Should be 120: " + factorial(5));
    System.out.println("Should be 6: " + factorial(3));
   

    System.out.println("Should be 1: " + fib2(5, new long[0]));
    
    /* for(int i = 0; i < 5; i++) {
       if (fibSeq.size() <= 1)
       fibSeq.add((long)1);
       else 
       fibSeq.add(fibSeq.get(i - 2) + fibSeq.get(i - 1));
       }*/
    
    System.out.println("Should be 10: " + sqrt(1, 100));
    System.out.println("Should be ~1.41: " + sqrt(1, 2));

    System.out.println("Should be ['bat', 'bta', 'abt', 'atb', 'tab', 'tba']: " + scramble("bat"));
  }
}
