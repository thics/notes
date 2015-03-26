public class LinkedList<E> {

  private LNode<E> front;

  public LinkedList() {
    front = null;
  }

  public String toString() {
    String s = "";
    LNode<E> currentNode = front;

    while(currentNode.getNext() != null) { //If not last element
      s += currentNode.getData() + ", ";
      currentNode = currentNode.getNext();
    }      

    if(currentNode.getNext() == null) 
      s += currentNode.getData(); //Last element

    return s;
  }

  public void add(char c) {
    LNode<E> currentNode = front;
    if(currentNode == null)
      front = new LNode(c);
    else {
      while(currentNode.getNext() != null) //Keep cycling through LNode<E><E>s
        currentNode = currentNode.getNext();
      currentNode.setNext(new LNode(c)); //If last one, make new LNode<E>
    }
  }

  public void add(char c, int i) {
    LNode<E> currentNode = front;
    LNode<E> insertedNode = new LNode(c);
    for(int j = 1; j < i; j++)
      currentNode = currentNode.getNext(); //Get to position i
    
    insertedNode.setNext(currentNode.getNext()); //Insert and shift
    currentNode.setNext(insertedNode);
  }

  public E get(int i ) {
    LNode<E> currentNode = front;
    for(int j = 0; j < i; j++)
      currentNode = currentNode.getNext(); //Get to position i
    return currentNode.getData();
  }

  public E set(E c, int i) {
    E preVal;
    LNode<E> currentNode = front;
    for(int j = 0; j < i; j++)
      currentNode = currentNode.getNext(); //Get to position i
    preVal = currentNode.getData(); //Save previous value
    currentNode.setData(c); //Set new value
    return preVal;
  }

  public E remove(int i) {
    E preVal;
    LNode<E> currentNode = front;
    for(int j = 0; j < i - 1; j++)
      currentNode = currentNode.getNext(); //Get to the node right before i to cut pointer

    preVal = currentNode.getNext().getData(); //Save value of term
    currentNode.setNext(currentNode.getNext().getNext());
    return preVal;
  }

  public int size() {
    int counter = 1;
    LNode<E> currentNode = front;
    if(currentNode == null)
      return 0;

    while(currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
      counter++;
    }
    return counter;
  }
    
  public static void main(String[] args) {
    LinkedList<Character> l = new LinkedList();
    l.add('A'); //Test add
    l.add('E');
    l.add('R');
    l.add('I', 3);
    l.add('A');
    l.add('E');
    System.out.println(l);

    l.set('L', 5); //Test set
    l.add('B');
    System.out.println(l);

    l.remove(6); //Test remove
    System.out.println(l);
    
    System.out.println("I: " + l.get(3));
    System.out.println("E: " + l.get(1));
    System.out.println("6: " + l.size());
  }
}
