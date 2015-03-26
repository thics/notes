import java.util.*;

public class Robot {

    private int[] hall;
    private int pos;
    private boolean facingRight;

    public Robot() {
      
      hall = new int[5];
      pos = (int)(Math.random() * 100 % hall.length);
      facingRight = true;
      for (int i=0; i<hall.length; i++) 
        hall[i] = (int)(Math.random() * 100 % 10);
    }
  
  public String toString() {
    
    String s = "";
    String t = "";
    for (int i=0; i<hall.length; i++) {
	    s = s + hall[i];
	    if (pos == i && facingRight) 
        t = t + ">";
	    else if (pos == i && !facingRight)
        t = t + "<";
	    else
        t = t + " ";
    }
    return s + "\n" + t;
  }
  private boolean hallIsClear() {
    
    for (int i=0; i<hall.length; i++) 
	    if ( hall[i] != 0 )
        return false;
    return true;
  }
  
  
  /**
   * THESE ARE THE THREE METHODS YOU NEED TO WRITE FOR THE ASSIGNMENT!
   */
  private boolean forwardMoveBlocked() {
    if(pos == hall.length - 1 && facingRight == true ) {
      return true;
    }
    else if(pos == 0 && facingRight == false) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public void move() {
    if(hall[pos] > 0) {
      hall[pos]--;
    }
    if (hall[pos] == 0) {
      if(forwardMoveBlocked()) {
        facingRight = !facingRight;
      }
      else {
        if(facingRight) {
          pos++;
        }
        else {
          pos--;
        }
      }
    }
  }

  
  public int clearHall() {
    int numMoves = 0;
    while(!hallIsClear()) {
      move();
      numMoves++;
    }
    return numMoves;
  }
  //END OF ASSIGNMENT
  
  public static void main(String[] args) {
    
    Robot r = new Robot();
    System.out.println(r);
    System.out.println( r.clearHall() );
    System.out.println(r);
  }
}
