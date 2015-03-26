public class Shapes {
    
    /*======== public static String line() ==========
      Inputs:  String c (single character String)
               int n 
      Returns: A String that contains n copies of c
      ex: Shapes.line( "^", 4 ); ==> "^^^^"
      ====================*/
    public static String line(String c, int n) {
	String s = "";
	for(int p = n; p > 0; p--) {
	    s += c;
	}
	return s;
    }
    
    /*======== public static String box() ==========
      Inputs:  String c (single character)
               int rs
               int cs 
      Returns: A String made up of a rs x cs grid of c
      ex: Shapes.box("*", 2, 3) ==> "***
                                     ***"
     ====================*/
    public static String box(String c, int rs, int cs) {
	String s = "";
	for(int a = rs; a > 0; a--) {
	    for(int b = cs; b > 0; b--) {
		s += c;
	    }
	    if (a > 1){
	    s += "\n";
	    }
	}
	return s;
    }

    /*======== public String tri1() ==========
      Inputs:  String c 
               int h 
      Returns: A "triangle" of c, h lines high
      ex: Shapes.tri1("|", 3); ==> "|
                                    ||
				    |||"
      ====================*/
    public static String tri1(String c, int h) {
	String s = "";
	for(int a = 1; a <= h; a++) {
	    s += line(c, a);
	    if (a < h) {
	    s += "\n";
	    }
	}
	return s;
    }

    /*======== public String tri2() ==========
      Inputs:  String c 
               int h 
      Returns: A differnt "triangle" of c, h lines high
      ex: Shapes.tri2("|", 3); ==> "  |
                                     ||
				    |||"
      ====================*/
     public static String tri2(String c, int height){
        String s="";
	for(int d = height; d > 0; d--) {
	    // White space
	    for(int a = d - 1; a > 0; a--) {
		s += " ";
	    }
	    //Bars
	    for(int b = height - d; b >= 0; b--) {
		s += c;
	    }
	    s += "\n";
	}
	return s;
     }

    /*======== public String tri3() ==========
      Inputs:  String c 
               int h 
      Returns: A different "triangle" of c, h lines high
      ex: Shapes.tri2("|", 3); ==> " |
                                    |||
				   |||||"
      ====================*/
    public static String tri3(String c, int h) {
	String s = "";
	int thickness = 1;
	for(int d = h; d > 0; d--) {
	    //Front Blanks
	    for(int a = d - 1; a > 0; a--) {
		s += " ";
	    }
	    //Characters
	    s += line(c, thickness);
	    //Back Blanks
	    for(int a = d - 1; a > 0; a--) {
		s += " ";
	    }
	    s += "\n";
	    thickness += 2;
	}
	return s;
    }


    /*======== public diamond() ==========
      Inputs:  String c 
               int h 
      Returns: A "diamond" of c, h lines high
      ex: Shapes.tri2("|", 5); ==> " |
                                    |||
				   |||||"
				    |||
				     |"
      ====================*/
    public static String diamond(String c, int h){
	String s = "";
	int thickness = 1;
	int space = (2*(h/2 + 1) - 1)/2;
	boolean bottom = false;
	for(int row = h; row > 0; row--) {
	    //Front Blank Space
	    for(int a = space; a > 0; a--) {
		s += " ";
	    }
	    //Actual Body
	    if(thickness == ( 2*(h/2 + 1) - 1 )) { //Thickness of middle row; Since h can only be odd, we rely on truncation
		bottom = true;
	    }
	    s += line(c, thickness);
	    //Back Blank Space
	    for(int a = space; a > 0; a--) {
		s += " ";
	    }
	    //Go to Next Row Settings (Thickness, etc.)
	    if(bottom) {
		thickness -= 2;
		space ++;
	    }
	    else {
		thickness += 2;
		space --;
	    }
	    s += "\n";
	}
	return s;
    }
    
    public static void main(String[] args) {
	System.out.println("Line Test:");
	System.out.println(Shapes.line("%",10));
	
	System.out.println("Box Test:");
	System.out.println(Shapes.box("#", 5,4));
	System.out.println(Shapes.box("#", 4,5));
	System.out.println();
	
	System.out.println("Tri1 Test:");
	System.out.println(Shapes.tri1("@", 5));
	System.out.println();

	System.out.println("Tri2 Test:");
	System.out.println(Shapes.tri2("+", 5));
	System.out.println();

	System.out.println("Tri3 Test:");
	System.out.println(Shapes.tri3("|", 4));
	System.out.println();

	System.out.println("Diamond Test:");
	System.out.println(Shapes.diamond("*", 5));
    }
}
