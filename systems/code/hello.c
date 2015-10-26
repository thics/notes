#include <stdio.h>
#include <stdlib.h>
//#include "mylib.h" //library in current directory, not default C libs

int main() {
  
  int bob = 7;
  int a[5];
  int fred = 86;
  
  printf( "Hi Everybody!\n");
  printf( "bob = %d\n", bob); //%d = formatting for decimal, if multiple formatting chars: inserts in order of params

  a[0] = 10
  printf( "a[0] = %d\n", a[0]);
  printf( "a[-1] = %d\n", a[-1]);
  printf( "a[-2] = %d\n", a[-2]);
  a[-1] = 246;
  printf( "fred = %d\n", fred);
  printf( "a[0] = %d\n", a[0]);
  printf( "address of fred: %lu\n", %fred);
  printf( "address of bob: %lu\n", %bob);
  
  return 0; //standard return value
}
 
