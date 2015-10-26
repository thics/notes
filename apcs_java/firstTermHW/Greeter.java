public class Greeter {

    // Instance Variables
    private String message;
    private String myName;
    private int myAge;

    //Methods
    public void setMessage( String m ) {
	message = m;
    }

    public void greet() {
	System.out.println( message );
    }

    public void greet( String name ){ 
	System.out.println( message + " " + name );
    }

    // Introduce myself
    public void setMyName(String name) {
	myName = name;
    }

    public void sayMyName() {
	System.out.println( "Hi!, my name is " + myName );
    }

    // Introduce my Age
    public void setMyAge(int age) {
	myAge = age;
    }

    public void sayMyAge() {
	System.out.println( "I am " + myAge + " old!" );
    }

    //Main Methods (This actually runs)
    public static void main(String[] args) {
	Greeter g = new Greeter();
	Greeter bob = new Greeter();
	Greeter Sam = new Greeter();

	//Set Messages for Objects
	g.setMessage( "Good News Everyone!" );
	bob.setMessage( "Hullo~" );
	Sam.setMessage( "Hello guys!");
	Sam.setMyAge( 16 );

	// Run Methods for Objects
	g.greet();
	bob.greet();
	Sam.greet();
	Sam.sayMyAge();
	Sam.sayMyName();

    }
}
