#include <stdio.h>
#include <stdlib.h>

int main( int argc, char *argv[] ) {

  int i;
  printf("argc: %d\n", argc);
  for(i = 0; i < argc; i++) 
    printf( "argv[%d]: %s\n", i, argv[i]);

  printf("\n");

  int x;
  //scanf("%d", &x);
  //  printf("x = %d\n", x);

  float f;
  char s[10];

  fgets(s, sizeof(s), stdin );
  printf("[%s]\n", s);

  sscanf( s, "%d", &x ); //reads from a string
  printf( "s = %d\n", x);
  
  return 0;
}
