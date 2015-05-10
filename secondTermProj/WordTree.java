import java.util.*;
import java.io.*;

public class WordTree {
  private TreeNode root;
  
  public WordTree() {
    root = null;
  }

  public WordTree(char c) {
    root = new TreeNode('-'); //Root will be empty, replaced by '-'
    addLetter(c, root);
  }

  public void addLetter(char c, TreeNode t) {
    if(c == 'A')
      t.setChild(0, new TreeNode(c));
    if(c == 'B')
      t.setChild(1, new TreeNode(c));
    if(c == 'C')
      t.setChild(2, new TreeNode(c));
    if(c == 'D')
      t.setChild(3, new TreeNode(c));
    if(c == 'E')
      t.setChild(4, new TreeNode(c));
    if(c == 'F')
      t.setChild(5, new TreeNode(c));
    if(c == 'G')
      t.setChild(6, new TreeNode(c));
    if(c == 'H')
      t.setChild(7, new TreeNode(c));
    if(c == 'I')
      t.setChild(8, new TreeNode(c));
    if(c == 'J')
      t.setChild(9, new TreeNode(c));
    if(c == 'K')
      t.setChild(10, new TreeNode(c));
    if(c == 'L')
      t.setChild(11, new TreeNode(c));
    if(c == 'M')
      t.setChild(12, new TreeNode(c));
    if(c == 'N')
      t.setChild(13, new TreeNode(c));
    if(c == 'O')
      t.setChild(14, new TreeNode(c));
    if(c == 'P')
      t.setChild(15, new TreeNode(c));
    if(c == 'Q')
      t.setChild(16, new TreeNode(c));
    if(c == 'R')
      t.setChild(17, new TreeNode(c));
    if(c == 'S')
      t.setChild(18, new TreeNode(c));
    if(c == 'T')
      t.setChild(19, new TreeNode(c));
    if(c == 'U')
      t.setChild(20, new TreeNode(c));
    if(c == 'V')
      t.setChild(21, new TreeNode(c));
    if(c == 'W')
      t.setChild(22, new TreeNode(c));
    if(c == 'X')
      t.setChild(23, new TreeNode(c));
    if(c == 'Y')
      t.setChild(24, new TreeNode(c));
    if(c == 'Z')
      t.setChild(25, new TreeNode(c));
    else //(c == '-')
      t.setChild(26, new TreeNode('-'));
  }

  public void addWord(String s) {
    char[] letterArray = new char[s.length()];
    s.getChars(0, letterArray.length, letterArray, 0); //Splits string into characters
    
    addWordHelper(0, root, letterArray);
  }
  
  public TreeNode addWordHelper(int i, TreeNode t, char[] letters) {
    if( i < letters.length )
      t.setChild(i, 
  }
}
