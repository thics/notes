int x; 

void setup() {
  x = 0;
  frameRate( 3 );
  size( 400, 400 );
  println("hello");
}

void draw() {
  background( 0, 0, 255); //Resets image
  ellipse( random(width), random(height), 50, 50 );  
}
