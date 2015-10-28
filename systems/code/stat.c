#include <stdio.h>
#include <stdlib.h>

#include <sys/stat.h>

int main() {

  struct stat sb1, sb2;

  stat( "test/randdump", &sb1 );
  // stat ( "test", &sb2 );

  printf("size: %lu\tuser: %d\tmode: %o\tmtime: %lu\n", sb1.st_size, sb1.st_uid, sb1.st_mode, sb1.st_mtime );

  //printf("size: %lu\tuser: %d\tmode: %o\tmtime: %lu\n", sb2.st_size, sb2.st_uid, sb2.st_mode, sb2.st_mtime );

  return 0;
}
