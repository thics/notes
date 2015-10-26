import java.util.*;
import java.io.*;

public class Sudoku {
  int size;
  char[][] board;

  static final String clear = "\033[2J";
  static final String hide = "\033[?25l";
  static final String show = "\033[?25h";

  public String go(int x, int y) {
    return "\033[" + x + ";" + y + "H"; //Huge clear before running
  }

  public Sudoku() {
    size = 9;
    board = new char[size][size];

    try {	    
 	    Scanner sc = new Scanner(new File("sudoku.dat"));
	    int j=0;

	    while (sc.hasNext()) {
        String line = sc.nextLine();
        for (int i=0; i < size; i++) {
          board[i][j] = line.charAt(i);
        }
        j++;
	    }
    }
    catch (Exception e) {}	
  }

  public String toString() {
    String s = "";
    for (int x=0;x<size;x++) {
	    for (int y=0;y<size;y++)
        s = s + Character.getNumericValue(board[x][y]) + ' ';
	    s=s+"\n";
    }
    return s;
  }

  public void solve() {
    solveHelper(0, 0, 1); //Starting cooordinates
  }

  public boolean solveHelper(int x, int y, int number) {
    if(x >= size) {
      return true;      
    }
    if(row(x, y, number)) //Checking for repeats
      return false;
    if(col(x, y, number))
      return false;
    if(x % 3 == 0 && y % 3 == 0 && box(x, y, number))
      return false;

    board[x][y] = (char)(number);
    //x is the row (vertical counting), y is the column (horizontal counting)
    if(y >= size - 1) { //If it hits the end of the row
      y = 0;
      x++; //row
    }
    else
      y++;

    for(int i = 0; i < size; i++)
      if(solveHelper(x, y, i))
        return true;
    
    board[x][y] = (char)('-');
    x--;
    return false;

    /*
      if(solveHelper(x, y, 1)) 
      return true;
      if(solveHelper(x, y, 2)) 
      return true;
      if(solveHelper(x, y, 3)) 
      return true; 
      if(solveHelper(x, y, 4)) 
      return true;
      if(solveHelper(x, y, 5)) 
      return true;
      if(solveHelper(x, y, 6)) 
      return true;
      if(solveHelper(x, y, 7)) 
      return true;
      if(solveHelper(x, y, 8)) 
      return true;
      if(solveHelper(x, y, 9)) 
      return true;
      else {
      board[x][y] = '-';
      return false;
      }*/
  }

  public boolean row(int x, int y, int number) {
    for(int i = y; i >= 0; i--) 
      if(board[x][i] == (char)(number))
        return true;
    for(int i = y; i < size; i++) 
      if(board[x][i] == (char)(number))
        return true;
    return false;
  }

  public boolean col(int x, int y, int number) {
    for(int i = x; i >= 0; i--) { //To check left side
      //      System.out.println(i);
      if(board[i][y] == (char)(number))
        return true;
    }
    for(int i = x; i < size; i++)  { //To check right side
      System.out.println(y);
      if(board[i][y] == (char)(number))
        return true;
    }
    return false;
  }

  public boolean box(int x, int y, int number) {
    for(int i = x; i < x + 3; i++) 
      for(int j = y; j < y + 3; j++)
        if(board[i][y] == (char)(number))
          return true;
    return false;
  }

  public static void main(String[] args) {
    Sudoku s = new Sudoku();
    s.solve();
    System.out.println(s);
  }
}
