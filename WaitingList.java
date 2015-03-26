import java.util.*;
import java.io.*;

public class WaitingList {
  private int numNodes;
  private LNode front;

  public int size() {
    return numNodes;
  }
  
  private LNode getKthNode (int k) {
    LNode l = front.getNext();
    for(int i = 0; i < k; i++)
      l = l.getNext();
    return l;
  }

  public void transferNodesFromEnd(WaitingList other, int num) {
    //Rebind Linked List to current list
    LNode secFront = other.getKthNode(other.numNodes - num);
    getKthNode(numNodes - 1).setNext(secFront);
    
    //Terminate other at secFront
    other.getKthNode(other.numNodes - num - 1).setNext(null);
  }
  
  public static void main(String[] args) {

  }

}
