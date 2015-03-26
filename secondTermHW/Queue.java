import java.io.*;
import java.util.*;

public class Queue<E> {
  private LNode<E> front; //Remove from front
  private LNode<E> back; //Add to back

  public String toString() { //Just for debugging
    String s = "";
    LNode<E> f = front;
    while(f != null) {
      s += f.getData();
      f = f.getNext();
    }
    return s;
  }

  public void enqueue(E data) {
    if(isEmpty()) {
      back = new LNode(data);
      front = back;
      return;
    }
    LNode<E> n = new LNode(data);
    back.setNext(n);
    back = back.getNext();
  }

  public E dequeue() {
    LNode<E> n = front;
    front = front.getNext(); //Deletes front
    return n.getData();
  }

  public E peek() {
    return front.getData();
  }

  public boolean isEmpty() {
    if(front == null)
      return true;
    return false;
  }

  public static void main(String[] args) {
    Queue<Integer> q = new Queue();
    for(int i = 0; i < 10; i++) 
      q.enqueue(i);
    System.out.println(q);
    for(int i = 0; i < 5; i++)
      q.dequeue();
    System.out.println(q);
  }
}
