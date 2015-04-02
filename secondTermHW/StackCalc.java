public class StackCalc {

  public static boolean isOperator( char c  ) {
    
    return c == '-' || c == '+' || c == '*' || c == '/';
  }

  public static int getPriority( char op ) {
    if ( op == '-' || op == '+')
	    return 1;
    else
	    return 2;	
  }
    
  public static String toPostfix( String infix ) {

    LStack<Character> temp = new LStack<Character>();
    String postFix = "";
    char[] c = infix.toCharArray();
    int i = 0;

    while(i < c.length) {
      char s = c[i];
      if(!isOperator(s))
        postFix += s;
      else {
        if(temp.isEmpty())
          temp.push(s);
        else {
          while(!temp.isEmpty()) {
            if(getPriority(s) < getPriority(temp.peek()))
              postFix += temp.pop();
            else
              break;
          }
          temp.push(s);
        }
      }
      i++;
    }
    while(!temp.isEmpty()) 
      postFix += temp.pop();

    return postFix;
  }

  public static double evaluate( double b, double a, char operator ) {

    if ( operator == '+' )
	    return a + b;
    else if ( operator == '-' )
	    return a - b;
    else if ( operator == '*' )
	    return a * b;
    else
	    return a / b;
  }
	

  public static double calculate( String postfix ) {

    LStack<Double> values = new LStack<Double>();

    return values.pop();
  }

  public static void main(String[] args) {
	
    String s = "4+3*6/2";
    String p = toPostfix( s );

    System.out.println( p );
	
    //    System.out.println( calculate(p) );
  }

}
