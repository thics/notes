import java.util.*;
import java.io.*;

public class TreeNode {
  private TreeNode[] children;
  private char data;

  public TreeNode(char d) {
    data = d;
    children = new TreeNode[27]; //One for each letter, 27 for end of word '-'
    for(int i : children)
      i = new TreeNode('');
  }

  public String toString() {
    return "" + data;  
  }

  public char setData(int i, char c) {
    char temp = children[i];
    children[i] = c;
    return temp;
  }

  public char getData() {
    return data;
  }

  public TreeNode getChild(int i) {
    return children[i];
  }

  public TreeNode setChild(int i, TreeNode t) {
    TreeNode temp = children[i];
    children[i] = t;
    return temp;
  }
}
