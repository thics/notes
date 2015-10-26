public class RationalNumber {
    //Privates can only be accessed by RationalNumber class, so only objects in this class can access instances (multiply, etc)
    //Instance variables should always be private! In this case, so b != 0 in class, and can NEVER be 0
    private int a;
    private int b;

    public RationalNumber() {
	a = 0;
	b = 1;
    }

    public RationalNumber(int numerator, int denominator) {
	if (denominator == 0) {
	    a = 0;
	    b = 1;
	    System.out.println("Invalid number, denominator must not equal 0. Setting number equal to 0/1");
	}
	else {
	    a = numerator;
	    b = denominator;
	}
    }

    public void display() {
	System.out.println(a/b);
    }

    public double floatValue() {
	return (double)(a/b);
    }
    
    public void multiply(RationalNumber num) {
	a *= (num.a);
	b *= (num.b);
    }

    public void add(RationalNumber num) {
	a = (a * num.b) + (b * num.a);
	b *= num.b;
    }

    public void subtract(RationalNumber num) {
	a = (a * num.b) - (b * num.a);
	b *= num.b;
    }

    public int gcd () {
	int c;
	int d;
	int e; //Temp storage of numerator to avoid runtime errors
       
	if (a > b) {
	    c = a;
	    d = b;
	}
	else {
	    c = b;
	    d = a;
	}

	while (c % d != 0) {
	    e = c;
	    c = d;
	    d = (e % d);
	}
	return d;
    }

    public void reduce() {
	int gcdStore = gcd();
	a /= gcdStore;
	b /= gcdStore;
    }

    public String toString() {
	return (a + " / " + b);
    }

    public static void main(String[] args) {
	RationalNumber x = new RationalNumber();
	RationalNumber y = new RationalNumber(30, 5);
	RationalNumber z = new RationalNumber(8, 2);
	RationalNumber p = new RationalNumber(18, 9);

	x.multiply(y); //Sets x = xy

	System.out.println("Should be 0: ");
	x.display(); //Should print zero

	System.out.println("Should be 4: ");
	z.display(); //Should print out 4

	z.multiply(y);

	System.out.println("Should be 24: ");
	z.display(); //Should display an int, should be 24

	System.out.println("Should be 24.0: ");
	System.out.println( z.floatValue() );  //Should display as a double
	
	///Part 2!
	System.out.println("Should be 9: ");
	System.out.println(p.gcd() );

	p.add(z); //Should return 26
	System.out.println("Should be 26: "); //26
	p.display();

	p.subtract(z); //24
	System.out.println("Should be 2: "); //2
	p.display();

	p.reduce(); //2
	System.out.println ( "Should be 2: ");
	p.display();

	System.out.println(p);
    }
}

	
