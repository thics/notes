#include <string.h>
#include <errno.h>
#include <dirent.h>
#include <unistd.h>
#include <fcntl.h>

int main() {
  int fd, b;
  char buff[200];

  fd = open( "test", O_RDONLY );
  if( fd < 0 )
    printf( "error %d: %s\n", errno, strerror(errno));

  b = read(fd, buff, sizeof(buff));
  if( b < 0)
    printf( "error: %d: %s\n", errno, strerror(errno));

  printf("read %d bytes: *%s*\n", b, buff);
  
  return 0;
}
