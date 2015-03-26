public class D2Array {
  public static void main(String[] args) {
    int[][] a = new int[4][3];
    String s = "";

    for(int i = 0; i < a.length; i++) {
      for(int j = 0; j < a[i].length; j++) {
        a[i][j] = j + (i*a[i].length);
        s += j + (i*a[i].length) + " ";
      }
      s += "\n";
    }

    System.out.println(s);
  }
}
