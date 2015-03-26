public class StackArray {
  private Object[] stack;
  private int index;
  private int size;

  public String toString() { //Just for debugging
    String s = "";
    for(int i = 0; i <= index; i++)
      s += stack[i];
    return s;
  }

  public StackArray() {
    size = 100;
    index = -1;
    stack = new Object[size];
  }

  public void push(Object i) throws IndexOutOfBoundsException {
    if(index >= size)
      throw new IndexOutOfBoundsException("Your stack is full!");
    index++;
    stack[index] = i;
  }

  public Object pop() {
    index--;
    return stack[index + 1]; //No need delete b/c push overwrites + can't access
  }

  public boolean isEmpty() {
    if(index <= 0)
      return true;
    return false;
  }

  public Object peek() {
    return stack[index];
  }

  public static void main(String[] args) {
    StackArray s = new StackArray();
    for(int i = 0; i < 10; i++)
      s.push((Integer)i);
    System.out.println(s);
    for(int i = 0; i < 5; i++)
      s.pop();
    System.out.println(s);
  }
}
