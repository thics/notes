import java.util.*;

public class Stat {

    private SuperArray grades;

    /**
     * Initialize the data array to a size of your choosing.
     */
    public Stat()  {
      grades = new SuperArray(10);
    }
    
    /**
     * Initialize the data array to the specified size.
     */
    public Stat(int s)  {
      grades = new SuperArray(s);
    }

    /**
     * Returns a string that contains all the elements of the array.
     */
    public String toString() {
      return grades.toString();
    }
    
    /*
     * Go through the array and have the user enter 
     * values for each available space.
     */
    public void setValues() {
      Scanner s = new Scanner(System.in);
      for(int i = 0; i < grades.size(); i++) {
        System.out.print("Enter value: ");
        int input = s.nextInt();
        grades.add(input, i);
      }
    }

    /**
     * Return the sum of all the data in the array.
     */
    public int calcSum() {
      int s = 0;
      for(int i = 0; i < grades.size(); i++) {
        s += (int)grades.get(i);
      }
      return s;
    }

    /**
     * Return the average of the data in the array.
     */
    public double calcAvg() {
      double i = ((double)calcSum() / (double)grades.size());
      return i;    
    }
  
    /**
     * Return the smallest value in the array.
     */
  public int findMin() {
    int currentSmallest = (int)grades.get(0);
    for(int i = 1; i < grades.size(); i++) {
      if ((int)grades.get(i) < currentSmallest) {
        currentSmallest = (int)grades.get(i);
      }
    }    
    return currentSmallest;
  }
  
  /**
   * Return the largest value in the array.
   */
  public int findMax() {
    int currentLargest = 0;
    for(int i = 1; i < grades.size(); i++) {
      if ((int)grades.get(i) > currentLargest) {
        currentLargest = (int)grades.get(i);
      }
    }
    return currentLargest;
  }
  
  public int freq(int n) {
    int counter = 0;
    for( int i = 0; i < grades.size(); i++) {
      if ( (int)grades.get(i) == n) {
        counter += 1;
      }
    }
    return counter;
  }

  public boolean evenBalance() {
    int leftSide = 0;
    int rightSide = 0;
    for( int i = 0; i < grades.size(); i++) {
      if( i < grades.size() / 2) {
        leftSide += (int)grades.get(i);
      }
      else if (i >= (grades.size() - grades.size() / 2)) {
        rightSide += (int)grades.get(i);
      }
    }
    return leftSide == rightSide;
  }

  public int mode() {
    int mode = (int)grades.get(0);
    for(int i = 1; i < grades.size(); i++) {
      if ( freq(mode) < freq((int)grades.get(i))) {
        mode = (int)grades.get(i);
      }
    }
    return mode;
  }

  public int[] mode2() { 
    int mode[] = new int[(int)grades.size()];
    mode[0] = (int)grades.get(0);
    int numOfModes = 0;
    
    for(int i = 1; i < (int)grades.size(); i++) {
      if ( freq(mode[i]) < freq((int)grades.get(i))) {
        mode[i] = (int)grades.get(i);
        
        numOfModes = 1;
      }
      else if ( freq(mode[i]) == freq((int)grades.get(i))) {
        numOfModes++;
      }
    }

    for(int p = 0; p < mode.length - 1; p++ ){
      while(mode[p] == 0) {
        mode[p] = mode[p + 1];
      }
    }
    return mode;
  }

    public static void main( String[] args ) {
      
      int n;
      Stat s;
      Scanner scan = new Scanner( System.in );
	
      System.out.print("Number of entries: ");
      n = scan.nextInt();

      s = new Stat(n);

      s.setValues();
      
      System.out.println();
      System.out.println("Data: " + s.toString() );
      System.out.println("Sum: " +  s.calcSum() );
      System.out.println("Average: " + s.calcAvg() );
      System.out.println("Min: " + s.findMin() );
      System.out.println("Max: " + s.findMax() );
      System.out.println("Freqency of Mode: " + s.freq(s.mode()));
      System.out.println("Sum of Left Half = Sum of Right: " + s.evenBalance());
      System.out.println("Mode: " + s.mode());
    }
}
