import java.util.*;

public class ALFun {
  public static Random r = new Random();

    /**
     * Populate the parameter al with n random
     * ints, with each int being in the range 0 <= i <= 10
     */
    static void populateAL( ArrayList al, int n ) {	
      for (int i = 0; i < n; i++) {
        al.add(r.nextInt(11));
      }
    }

    /**
     * Removes all CONSECUTIVE duplicate values in al
     * Example:
     *   If al: [1, 4, 5, 5, 5, 4, 4, 1, 3 ]
     *   after collapseDuplicates: [1, 4, 5, 4, 1, 3]
     */
    static void collapseDuplicates( ArrayList al ) {
      for (int i = 0; i < al.size() - 1; i++) {
        if (al.get(i) == al.get(i + 1)) {
          al.remove(i);
          i--; //It shifts left
        }
      }
    }

    public static void main(String[] args) {
      
      ArrayList a = new ArrayList();
      System.out.println( "Before populate: " + a);
      populateAL( a, 40 );
      System.out.println( "After populate: " + a );
      collapseDuplicates( a );
      System.out.println( "After collapse: " + a );
    }
}
