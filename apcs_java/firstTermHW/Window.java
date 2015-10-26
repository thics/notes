import java.util.*;

public class Window {
    
  private int myNumRows, myNumCols;
  private int [ ] [ ] myMat;
    
  public Window(int r, int c) {
    myNumRows = r;
    myNumCols = c;

    myMat = new int[r][c];
    fillWindow();
  }

  public void fillWindow() {
    for (int i=0; i < myNumRows; i++ )
	    for (int j = 0; j < myNumCols; j++ )
        myMat[i][j] = (int)(Math.random() * 90) + 10;
  }
	
  public String toString() {
    String s = "";

    for (int i=0; i < myNumRows; i++ ) {
	    for (int j = 0; j < myNumCols; j++ )
        s+= myMat[i][j] + " ";
	    s+= "\n";
    }
    return s;
  }


  //SOLUTIONS GO HERE!!!

  public boolean isInBounds(int row, int col) {
    if(row >= 0 && row < myNumRows && col >= 0 && col < myNumCols)
      return true;
    return false;
  }
    
  public void colorSquare( int ULrow, int ULcol, int n, int val ) {
    for(int i = ULrow; (i < ULrow + n && i < myNumRows); i++)
      for(int j = ULcol; (i < ULcol + n && i < myNumCols); i++) 
        myMat[i][j] = val;
  }
    
  public void enlarge( int ULrow, int ULcol, int numRows, int numCols, int factor ) {
    ArrayList numsInBox = new ArrayList();
    //Save all distinct numbers first in vertical orientation
    for(int i = ULrow; i < ULrow + numRows; i++) 
      for(int j = ULcol; j < ULcol + numCols; j++) 
        numsInBox.add(myMat[i][j]);

    int index = 0;
    for(int k = ULcol; k < numCols + ULcol; k += factor)
      for(int l = ULrow; l < numRows + ULrow; l += factor) {
        colorSquare(k, l, factor, (Integer)(numsInBox.get(index)));
        index++;
      }
  }
    
  public static void main(String[] args) {

    Window w = new Window(10, 10);

    System.out.println(w);
    
    w.enlarge(0, 0, 2, 3, 5);
    System.out.println(w);
	
  }
}
