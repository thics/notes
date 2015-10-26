#include <stdio.h>
#include <stdlib.h>

//#include "stringy.h" (header files)

int len( char *s); //declare functions before usage, each name is unique

int main() {
  char s1[256];
  char s2[256] = "Imagine"
  char s3[] = "Tuesday";
  char *s4 = "Mankind";

  int size = 0;
  /*
  while( s4[size] ) //0 is false!!
    size++;
  */

  while( *s4++ )
    size++;
  
  printf("s4: %s\n", s4);
  printf("size of s4: %d\n", size);
  printf("Length of string: %d\n", sizeof(s4) - 1); //sizeof(s) - 1 to account for null char at end
  printf("Length of string: %d\n", len(s4));
  
  return 0;
}

int len( char *s) {
  int size = 0;

  while( *s++)
    size++;
  return size;
}
