import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class WordSearch {
  
  //Instance Variables
  private Character[][] grid;
  private ArrayList<String> hidden;
  
  //Constructor
  public WordSearch () {
    grid = new Character[10][10];
    hidden = new ArrayList<String>();
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++) {
        grid[i][j] = ' ';
      }
    }
  }
  
  public WordSearch (int length, int width) {
    grid = new Character[length][width];
    hidden = new ArrayList<String>();
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++) {
        grid[i][j] = ' ';
      }
    } 
  }
  
  public String toString() {
    String s = "    WORD SEARCH GRID    /n";
    for (int i = 0; i < grid.length;i++) {
	    for (int j = 0; j < grid[0].length;j++) 
        s += grid[i][j] + " ";
	    s += "\n";  
    }
    String t = "Hidden words: ";
    for (int k = 0; k < hidden.size();k++) {
	    t += hidden.get(k) + "\n";
    }
    return s;
  }

  public boolean addWordH(int row, int col, String s) {
    //If word fits horizontally
    if(s.length() + col >= grid[row].length) {
      return false;
    } 
    else {
      //Break down s into characters and add them horizontally
      for(int i = 0; i < s.length(); i++) {
        grid[row][col + i] = (s.charAt(col + i));
      }
      return true;
    }
  }

  public boolean addWordV(int row, int col, String s) {
    if(s.length() + row >= grid.length) {
      return false;
    }
    else {
      for(int i = 0; i < s.length(); i++) {
        grid[row + i][col] = s.charAt(row + i);
      }
      return true;
    }
  }

  public boolean addWordD(int row, int col, String s) {
    if(s.length() + row >= grid.length && s.length() + col >= grid[row].length) {
      return false;
    }
    else {
      for(int i = 0; i < s.length(); i++) {
        grid[row + i][col + i] = s.charAt(i);
      }
      return true;
    }
  }

  //Here is code to read in words from wordlist and return it as an ArrayList:
  public ArrayList<String> loadDictionary() {
    String s = "zzz";
    ArrayList<String> dictionary = new ArrayList<String>();
	
    try {
	    FileReader f = new FileReader("wordlist.txt");
	    BufferedReader b = new BufferedReader(f);
	    while( s != null ) {
        s = b.readLine();
        if ( s != null )
          dictionary.add(s);
      }
    }
    catch (IOException e) {}
    
    return dictionary;
  }  
}
