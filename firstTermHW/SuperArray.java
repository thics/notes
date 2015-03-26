public class SuperArray {
  private Object[] o;
  private int size;

  public SuperArray() {
    size = 0;
    o = new Object[size];
  }

  public SuperArray(int s) {
    size = s;
    o = new Object[size];
  }

  public String toString() {
    String s = "";
    for (int i = 0; i < size - 1; i++) {
      s += o[i] + ", ";
    }
    s += o[size - 1];
    return s;
  }

  public void resize() { //Adds one more space to the array
    Object[] a = new Object[o.length + 1];

    for (int i = 0; i < o.length; i++) {
      a[i] = o[i];
    }
    
    o = a;
  }
          
  public void add(Object object) {
    if (o.length == size) { //If there is no empty slot available
      resize(); //Add a slot
    }

    o[o.length - 1] = object;
    size ++;
  }

  public int size() {
    return size;
  }

  public Object get(int i) {
    if (i < size) {
      return o[i];
    } else {
      return null;
    }
  }

  public void add(Object obj, int index) {
    if (index >= 0) {
      if (index < size) {
        resize();        
        for(int i = index; i < size; i++) {
          o[i + 1] = o[i];
        }
        o[index] = obj;
      } else if (index > size) {
        add(obj);
      }
    }
  }

  public Object remove(int index) {
    if (index >= 0) {
      if (index < size) {
        Object original = o[index];
        size--;
        for(int i = index; i < size; i++) {
          o[i] = o[i + 1];
        }

        return original;
      }
      else {
        return null;
      }
    } else {
      return null;
    }
  }

  public Object set(Object obj, int index) {
    if (index >= 0) {
      if (index < size) {
        Object original = o[index];
        o[index] = obj;
        return original;
      }
      else {
        return null;
      }
    } else {
      return null;
    }
  }
      
  public static void main(String[] args) {
    SuperArray rayList = new SuperArray();
    
    System.out.println("size should be 0: " + rayList.size);
    
    rayList.add(103);
    rayList.resize();
    rayList.add(30249);
    rayList.add(302810);
    rayList.add(1092);

    System.out.println(rayList.toString());
    System.out.println("size should be 4: " + rayList.size);    
    
    System.out.println(rayList.get(2));
    System.out.println(rayList.size());
    
    System.out.println();
    
    rayList.add(23, 2);
    System.out.println("Should return 23: " + rayList.get(2));
    rayList.remove(3);
    System.out.println("Should return 23: " + rayList.get(2));
    
    System.out.println("Should return 23: " + rayList.set(24, 2));
    System.out.println("Should return 24: " + rayList.set(24, 2));
    System.out.println(rayList.set(24, 20493050));
 }
}
