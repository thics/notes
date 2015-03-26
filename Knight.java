import java.util.*;

public class Knight {
  int[][] b;
  int width;
  int turn; //Global version of move

  //  static final String clear = "\033[2J";
  
  public Knight() {
    width = 5;
    turn = 0;
  }
  
  public String toString() {
    String s = "";
    for (int y=0;y<width;y++) {
	    for (int x=0;x<width;x++) {
        if(b[x][y] < 10)
          s = s + b[x][y] + "  "; 
        else
          s = s + b[x][y] + " ";
      }
	    s=s+"\n";
    }
    return s;
  }
  
  public void resetBoard() {
    b = new int[width][width];
    //Reinitialize b
    for(int i = 0; i < width; i++)
      for(int j = 0; j < width; j++)
        b[i][j] = 0;
  }    

  public void solve(int width, int x, int y) {
    this.width = width;
    turn = 1;


    resetBoard();
    //    System.out.println("Before");
    solveHelper(x, y, turn);
    // System.out.println("After");
  }
  
  public boolean solveHelper( int x, int y, int move) {
    if(move > width*width) //If finished (Starts at 1)
      return true;
    // System.out.println(2);
    if(x >= width || x < 0 || y >= width || y < 0) { //If out of bounds
      return false;
    }
    //System.out.println(3);
    if(b[x][y] != 0)
      return false;

    b[x][y] = move;
    move++;

    if(solveHelper( x + 2, y + 1, move)) { //Everytime it tests the method, ++ move, so horrible.
      return true;
    }
    if(solveHelper( x + 2, y - 1, move)) {
      return true;
    }
    if(solveHelper( x - 2, y + 1, move)) {
      return true;
    }
    if(solveHelper( x - 2, y - 1, move)) {
      return true;
    }
    if(solveHelper( x + 1, y + 2, move)) {
      return true;
    }
    if(solveHelper( x - 1, y + 2, move)) {
      return true;
    }
    if(solveHelper( x + 1, y - 2, move)) {
      return true;
    }
    if(solveHelper( x - 1, y - 2, move)) {
      return true;
    }
    else {
      //      resetBoard();
      b[x][y] = 0;
      return false;
    }
  }

  public static void main(String[] args) {
    Knight k = new Knight();
    k.solve(8, 0, 0);
    System.out.println(k);
    k.solve(20, 2, 0);
    System.out.println(k);
    k.solve(6, 3, 2);
    System.out.println(k);
  }
}
