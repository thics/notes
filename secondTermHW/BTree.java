/*========== BTree.java ==========
  
  Basic binary tree.
  Uses TreeNode
  
  jdyrlandweaver
  =========================*/

import java.io.*;
import java.util.*;

public class BTree<E> {

  public static final int PRE_ORDER = 0;
  public static final int IN_ORDER = 1;
  public static final int POST_ORDER = 2;    

  private TreeNode<E> root;

  public BTree() {
    root = null;
  }

  /*======== public void add() ==========
    Inputs:   E d
    Returns: 
      
    Wrapper method for the recursive add()
    ====================*/     
  public void add( E d ) {
	
    TreeNode<E> bn = new TreeNode<E>( d );

    if ( root == null )
	    root = bn;
    else
	    add( root, bn );
  }

  /*======== public void add() ==========
    Inputs:   TreeNode<E> curr, TreeNode<E> bn  
    Returns: 
      
    Adds bn to the tree rooted at curr. If curr has 
    an available child space, then attach bn there.

    Otherwise, try to add at the subtree rooted at
    one of curr's children. Choose the child to be
    added to randomly.
    ====================*/
  public void add( TreeNode<E> curr, TreeNode<E> bn ) {
    if(curr.getLeft() == null)
      curr.setLeft(bn);
    else if(curr.getRight() == null)
      curr.setRight(bn);
    else if(Math.random() <= .5)
      add( curr.getLeft(), bn);
    else
      add( curr.getRight(), bn);
  }
    
  public void traverse( int mode) {
    if ( mode == PRE_ORDER )
	    preOrder( root );
    else if ( mode == IN_ORDER )
	    inOrder( root );
    else
	    postOrder( root );
    System.out.println();
  }
  /*======== public void preOrder() ==========
    Inputs:   TreeNode<E> curr  
    Returns: 
      
    Prints out the elements in the tree by doing an
    pre-order Traversal
    ====================*/
  public void preOrder( TreeNode<E> curr ) {
    if(curr == null)
      return;

    System.out.print(curr + " "); //Center Node   
    preOrder(curr.getLeft());
    preOrder(curr.getRight());

  }


  /*======== public void inOrder() ==========
    Inputs:   TreeNode<E> curr  
    Returns: 
      
    Pritns out the elements in the tree by doing an
    in-order Traversal
    ====================*/
  public void inOrder( TreeNode<E> curr ) {
    if(curr == null)
      return;

    preOrder(curr.getLeft());
    System.out.print(curr + " "); //Center Node
    preOrder(curr.getRight());

  }

  /*======== public void postOrder() ==========
    Inputs:   TreeNode<E> curr  
    Returns: 
      
    Prints out the elements in the tree by doing a
    post-order Traversal

    04/05/12 08:56:34
    jdyrlandweaver
    ====================*/
  public void postOrder( TreeNode<E> curr ) {
    if(curr == null)
      return;

    preOrder(curr.getLeft());
    preOrder(curr.getRight());
    System.out.print(curr + " "); //Center Node
  }
    

  /*======== public int getHeight()) ==========
    Inputs:   
    Returns: The height of the tree

    Wrapper for the recursive getHeight method
    ====================*/
  public int getHeight() {
    return getHeight( root );
  }
  /*======== public int getHeight() ==========
    Inputs:   TreeNode<E> curr  
    Returns:  The height of the tree rooted at node curr
      
    ====================*/
  public int getHeight( TreeNode<E> curr ) {
    if(curr == null)
    	return 0;

    if (getHeight( curr.getLeft()) + 1 >= getHeight( curr.getRight()) + 1)
      return getHeight( curr.getLeft()) + 1;
        
    return getHeight( curr.getRight()) + 1;
  }

  /*======== public String getLevel() ==========
    Inputs:   TreeNode<E> curr
    int level
    int currLevel  
    Returns: A string containing all the elements on the
    given level, ordered left -> right
      
    ====================*/
  public String getLevel( TreeNode<E> curr, int level, int currLevel ) {
    String s = "";
    if(level > currLevel)
      return "";
    if(level == currLevel)
      return curr.getData() + " ";
    else {
      s += getLevel( curr.getLeft(), level, currLevel + 1 );
      s += getLevel( curr.getRight(), level, currLevel + 1);
      return s;
    }
  }
    
  /*======== public String toString()) ==========
    Inputs:   
    Returns: A string representation of the tree
     
    This string should display each level as a separate line.
    A simple version might look something like this:

    0
    1 2
    3 4 5

    Note that you cannot tell exactly where 3, 4 and 5 lie.
    That is ok, but if you want a challenge, you can try to
    get the output to look nicer, something like this:

    0
    1     2
    3   4 5

    04/05/12 09:13:06
    jdyrlandweaver
    ====================*/
  public String toString() {
    String s = "";

    for(int i = 0; i < getHeight(); i++)
      s += getLevel(root, i, 0) + "\n";

    return s;
  }
	
  public static void main( String[] args ) {

    BTree<Integer> t = new BTree<Integer>();

    for ( int i=0; i < 8; i++ ) 
      t.add( i );
    System.out.println( "Pre-order: ");
    t.traverse( PRE_ORDER );
    System.out.println( "In-order: ");
    t.traverse( IN_ORDER );
    System.out.println( "Post-order: ");
    t.traverse( POST_ORDER );

    System.out.println("Height: " + t.getHeight());
    System.out.println(t);

  }
}
