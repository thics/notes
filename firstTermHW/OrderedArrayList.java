import java.util.*;

public class OrderedArrayList {

  private ArrayList<Comparable> data;

  public OrderedArrayList() {
    data = new ArrayList<Comparable>();
  }

  public OrderedArrayList(ArrayList d) {
    data = d;
  }

  public String toString() {
    return data.toString();
  }

  public void add(Comparable value) {
    int i = 0;
    while(i < data.size() && data.get(i).compareTo(value) < 0) 
      i++;
    data.add(i, value);
  }

  public int search(Comparable n) {
    /*    for(int i = 0; i < data.size(); i++)
      if((n.compareTo(data.get(i)) == 0))
        return i;
        return -1;*/
    int i = data.size() / 2;
    while(i != 0 && i != data.size()) {
      if(n.compareTo(data.get(i)) == 0)
        return i;
      if(n.compareTo(data.get(i)) > 0)
        i += (data.size() - i) / 2;
      else
        i -= (data.size() - i) / 2;
    }
    return -1;
  }
        

  public Comparable remove(int index) {
    return data.get(index);
  }

  public int size() {
    return data.size();
  }

  public static void main(String[] args) {
    OrderedArrayList oal = new OrderedArrayList();
    
    //To test sorting
    oal.add(3);
    oal.add(-2);
    oal.add(1);
    oal.add(9);
    oal.add(10);
    oal.add(-3);

    System.out.println(oal.search(3));
    System.out.println(oal.search(1));

    System.out.println(oal);
  }
}
