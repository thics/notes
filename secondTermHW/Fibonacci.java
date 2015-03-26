import java.util.*;

public class Fibonacci {
  //ArrayList Solution (Efficient, only O(n))
  public static ArrayList<Long> fibSequence;
  public static long fib1, fib2 = 1;

  public static long getFib(int n) {
    fibSequence = new ArrayList();
    fibSequence.add(fib1);
    fibSequence.add(fib2);
    for(int i = 0; i < n - 1; i++) {
      fibSequence.add(fibSequence.get(i) + fibSequence.get(i + 1));
    }
    return fibSequence.get(n);
  }

  //Recursive Solution (Inefficient, as it needs to reevaluate the values every time)
  public static long fib( int k ) {
    if ( k <= 2) //Base Case
      return 1;

    return fib( k - 1) + fib( k - 2); //Recursive Case (Doesn't need to make the sequence!
  }

  //Better Recursive Solution
  public static long fib2( int k, ArrayList<Long> values ) { //Assume values contains all Fib numbers
    if( k <= 2) {
      values.add( 1 );
      return 1;
    }

    if ( k < values.size() )
      return values.get(k-1);
    
    return fib2( k-1, values) + fib2(k-2, values);
  }

  public static void main(String[] args) {
    System.out.println("Should be 1: " + getFib(1));
    System.out.println("Should be 3: " + getFib(4));
    System.out.println("Should be 5: " + getFib(5));

    System.out.println("Should be 1: " + fib(1));
    System.out.println("Should be 3: " + fib(4));
    System.out.println("Should be 5: " + fib(5));

    ArrayList<Long> vals = new ArrayList<Long>();
    System.out.println( Fib.fib2(50), vals ); 

  }
}
