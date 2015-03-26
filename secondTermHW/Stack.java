import java.io.*;
import java.util.*;

public class Stack<E> {
  private LNode<E> top;

  public String toString() { //Just for debugging
    String s = "";
    LNode<E> t = top;
    while(t != null) {
      s += t.getData() + "\n";
      t = t.getNext();
    }
    return s;
  }

  public void push(E item) {
    LNode<E> n = new LNode(item);
    LNode<E> oldTop = top; //
    top = n;
    top.setNext(oldTop); //Go from top to bottom
  }

  public boolean isEmpty() {
    if(top == null)
      return true;
    return false;
  }

  public E peek() throws NoSuchElementException {
    if(isEmpty())
      throw new NoSuchElementException("Stack is empty!");
    return top.getData();
  } 

  public E pop() throws NoSuchElementException {
    if(isEmpty())
      throw new NoSuchElementException();
    LNode<E> n = top;
    top = top.getNext(); //No more reference to current top, so top is removed and go to next
    return n.getData();
  }

  public static void main(String[] args) {
    Stack<Integer> s = new Stack();
    for(int i = 0; i < 10; i++)
      s.push((Integer)i);
    System.out.println(s);
    for(int i = 0; i < 5; i++)
      s.pop();
    System.out.println(s);
  }
}
