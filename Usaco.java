import java.util.*;

public class Usaco {
  public static int length;
  public static ArrayList<Integer> list;
  public static double sum;
  public static int swaps;
  public static int comps;

  public void swap(int a, int b) {
    int c = list.get(a);
    list.set(a, b);
    list.set(b, c);
    swaps++;
  }

  public static void insertion() {
    int shifts = 0;
    for(int i = 1; i < list.size(); i++) {
      int value = list.get(i);
      int check = i - 1;
      while(value < list.get(check) && check > 0) {
        list.set(check + 1, check);
        check--;
        comps++;
        shifts++;
        if(shifts == 3) {
          swaps++;
          shifts = 0;
        }
      }
      list.set(check, value);
    }
  }

  public static double mean() {
    sum = 0;
    for(int i = 0; i < list.size(); i++)
      sum += list.get(i);
    return sum / list.size();
  }

  public static double median() { //If sorted
    if(list.size() % 2 == 0) 
      return ((list.get(list.size() / 2) + list.get((list.size() / 2) - 1)) / 2);
    else
      return list.get(list.size() / 2 - 1);
  }

  public static void sort() {
    for(int i = 0; i < list.size(); i++) {
      int current = list.get(i);
      for(int j = 0; j < list.size() - 1; j++) {
        if(list.get(j + 1) < current);
        current = list.get(j);
      }
      list.set(i, current);
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    list = new ArrayList();

    System.out.println("Enter list length: ");
    length = s.nextInt();
    System.out.println("Enter all elements: ");
    while(length > 0) {
      list.add(s.nextInt());
      length --;
    }
    insertion();
    //System.out.println(list.size());
    
    System.out.println("Median: " + median());
    System.out.println("Mean: " + mean());
  }
}
