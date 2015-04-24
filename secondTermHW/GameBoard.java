import java.util.*;
import java.io.*;

public class GameBoard {
  private TreeNode root; //the root of the tree
  
  /* Creates a full binary tree rooted at root with numLevels levels
   * with a random integer from 0 to 9, inclusive, generated for each node
   * @param numLevels the number of levels in the tree
   * Precondition: numLevels > 0
   */
  
  public GameBoard(int numLevels) {
    populate(root, numLevels, 0);
  }

  //Constructor helper
  private void populate(TreeNode curr, int numLevels, int currLevel) {
    Random r = new Random();
    if(currLevel != numLevels) {
      if(root == null)
        root = new TreeNode(r.nextInt(10));     
      if(curr == null)
        curr = new TreeNode(r.nextInt(10));

      if(curr != null) {
        curr.setLeft(new TreeNode(r.nextInt(10)));
        curr.setRight(new TreeNode(r.nextInt(10)));
        //        System.out.println(curr);
        populate(curr.getLeft(), numLevels, currLevel + 1);
        populate(curr.getRight(), numLevels, currLevel + 1);
      }
    }
  }

  /* @return the maximum path score for this GameBoard
   */
  public int getMaxScore() {
    return getMaxHelper(root);
  }

  /* @param current the root of the subtree to be processed
   * @return the maximum path score for the subtree rooted at current
   */
  private int getMaxHelper(TreeNode current) { 
    if(current == null)
      return 0;
    else {
      if(getMaxHelper(current.getLeft()) <= getMaxHelper(current.getRight()))
        return (int)(current.getData()) + getMaxHelper(current.getRight());
      else
        return (int)(current.getData()) + getMaxHelper(current.getLeft());
    }
  }

  // There may be fields, constructors, and methods that are not shown.
  public static void main(String args[]) {
    GameBoard g = new GameBoard(4);
    System.out.println(g.getMaxScore());
  }
}
