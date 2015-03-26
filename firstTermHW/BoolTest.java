public class BoolTest {
    public static void main(String[] args) {

	String a = "hello";
	String b = "hello";
	String c = new String("hello");
	String d = c; //Calls the same object! "c" only calls the object, it is NOT the object!

	System.out.println( a );
	System.out.println( b );
	System.out.println( c );

	System.out.println( a == b);
	System.out.println( a == c);
	System.out.println( d == c); //Is the  same, because they call the same object

    }
}
