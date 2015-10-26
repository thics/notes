
Blob[] blobs;
int popSize = 16;
int rad = 5;

/*=====================================
 The trickiest part of setup is to make 
 the screen an appropriate size for the
 grid of blobs. The grid should be just
 big enough to contain all of the blobs.
 ====================================*/
void setup() {
  background(100, 100, 200);
  blobs = new Blob[popSize];
  int numPerRow = (int)(Math.sqrt(popSize));
  
  size(numPerRow * rad, (popSize / numPerRow) * rad);
  populate();
}

/*=====================================
 The main purpose of draw is to go through 
 the array of blobs and display each.
 ====================================*/
void draw() {
  for(Blob i : blobs)
    i.display();
}

/*=====================================
 Populate the array of blobs.
 You can use any values for radius, number of sides
 and wobble factor that you'd like, but you must
 use x and y coordinates that ensure the blobs
 are drawn in a grid without overlaping each other.
 
 Your code should work for any reasonable value
 of population (i.e. something that would fit on a
 normal monitor).
 ====================================*/
void populate() {
  int numPerRow = (int)(Math.sqrt(popSize));
  for(int i = 0; i < blobs.length / numPerRow; i++)
    for(int j = 0; j < numPerRow; j++)
      blobs[i + j] = new Blob( j * width / numPerRow, i * height / numPerRow , rad, rad, 1, 1);
}

