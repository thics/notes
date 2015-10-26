#include <stdio.h>;

int main() {
  /*
  int i;
  double d;
  char c;

  int *pi = &i;
  double *pd = &d;
  char *pc = &c;

  printf("Int pi: %lu\n Double pd: %lu\n Char pc: %lu\n", pi, pd, pc);

  pi++;
  pd++;
  pc++;

  printf("Int pi: %lu\n Double pd: %lu\n Char pc: %lu\n", pi, pd, pc);
  */

  int ray[5];
  int *rp = ray;
  ray[0] = 3;
  ray[2] = 5;

  printf( "ray = %p\n", ray );
  printf( "rp = %p\n", rp);

  printf( "*(ray = %d\n", *ray );
  printf( "rp = %d\n", *rp);
  
  printf( "*(ray + 2) = %d\n", *(ray + 2) );
  printf( "rp[2] = %d\n", *(rp + 2));
  printf( "2[rp] = %d\n", *(2 + rp));

  rp++;
  //Cannot ray++; !! Can't change value of array valuable
  
  return 0;
}
