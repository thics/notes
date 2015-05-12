import java.util.*;

public class LStack<E> {

    private LNode<E> top;

    public void push( E d ) {
	
	LNode<E> n = new LNode<E>( d );

	n.setNext(top);
	top = n;
    }

    public E pop() throws NoSuchElementException {

	if ( top == null )
	    throw new NoSuchElementException();

	E d = top.getData();
	top = top.getNext();
	return d;
    }

    public E peek() {
	
	if ( top == null )
	    throw new NoSuchElementException();

	return top.getData();
    }

    public boolean isEmpty() {
	return top == null;
    }

    public static void main(String[] args) {

	LStack<Integer> ls = new LStack<Integer>();
	
	for (int i = 0; i < 10; i++)
	    ls.push(i);


	while ( !ls.isEmpty() )
	    System.out.println( ls.pop() );
    }
}
