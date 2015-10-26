/*Required
strlen
strcpy/strncpy (choose one)
strcat/strncat (choose one)
strcmp
strchr
strstr

You must test every function you write, you will not get full credit for an untested functions

You do not need to write 8 functions, only 6, but you need to write 1 or the "n" versions.
(So if you do strcpy then you have to do strncat)

Extra
The other strn/str version of the functions you wrote above
Remember you should call them something other than the regular names (like, mystrlen...). 
*/

#include <stdio.h>
#include <stdlib.h>

int mystrlen(char *s);
char* mystrcpy(char *new, char *old); //copys old into new (pointer to array)
char* mystrpcat(char *new, char *old); //concats old to end of new, adds null '\0'
int mystrcmp(char *s1, char *s2); //compares s1 to s2, returns: neg, 0, or pos, lexicographically
char* mystrchr(char *s1, int c); //locates first instance of c, converted to char, in s1 and returns pointer to it
char* mystrstr(char *s1, char *s2); //s2 in s1: returns pointer to first char, if s2 empty, return s1, else return null

int mystrlen(char *s) {
  int i = 0;
  while(*(s + i) != 0)
    i++;

  return i;
}

char* mystrcpy(char *new, char*old) {
  int i = 0;
  while(*(old + i) != 0) {
    *(new + i) = *(old + i);
    i++;
  }
  *(new + i) = 0;
  return new;
}

char* mystrcat(char *new, char*old) {
  int i = mystrlen(new);
  while(*(old + i) != 0) {
    *(new + i) = *(old + i);
    i++;
  }
  *(new + i) = 0;
  return new;
}

int mystrcmp(char *s1, char *s2) { //compares s1 to s2, returns: neg, 0, or pos, lexicographically
  int i = 0;

  //printf("lengths: %d %d \n", mystrlen(s1), mystrlen(s2));

  while( (i < mystrlen(s1)) && (i < mystrlen(s2))) {

    //    printf("lengths: %d %d \n", mystrlen(s1), mystrlen(s2));

    if(*(s1 + i) < *(s2 + i))
      return i*-1;
    if(*(s1 +i) > *(s2 + i))
      return i;
    else
      i++;
  }
  return 0; //if we reach end of one or both strings
  
}

char* mystrchr(char *new, int c) {
  int i = 0;
  while(*(new + i) != c && *(new + 1) != 0)
    i++;
  return (new + i);
}

char* mystrstr(char *s1, char *s2) {
  char *emp = "";
  if(*s2 == *emp)
    return s1;
  
  int i = 0;
  int counter = 0;
  while(i < mystrlen(s1)) {
    if(*(s1 + i) == *(s2 + counter)) //If a letter is matching
      counter++;
    else
      counter = 0; //reset counter
    
    i++;
    
    if(counter == mystrlen(s2)) //If complete s2 substring
      return (s1 + i - counter);
  
  }
  return 0;
  
}

int main() {
  char testString[200] = "Boooooo";
  char *oldString = "Boopo";

  printf("strlen \n\n");
  
  printf("Default: %d \n", strlen(testString));
  printf("Mine: %d \n\n", mystrlen(testString));

  printf("strcpy \n\n");
  
  printf("Default: %s \n", strcpy(testString, oldString));
  printf("Mine: %s \n\n", mystrcpy(testString, oldString));

  printf("strcat \n\n");
  
  printf("Default: %s \n", strcat(testString, oldString)); //Why is both the stringcat and mystringcat doing PooPoo?
  printf("Mine: %s \n\n", mystrcat(testString, oldString));

  char test[] = "Polli";
  char old[] = "Polop";

  printf("strcmp \n\n");
  
  printf("Default: %d \n", strcmp(test, old));
  printf("Mine: %d \n\n", mystrcmp(test, old));

  printf("strchr \n\n");
  
  printf("Default: %p \n", strchr(test, 'o'));
  printf("Mine: %p \n\n", mystrchr(test, 'o'));

  printf("Last function! (mystrstr) \n\n");
  
  //Last function
  char empty[] = "";
  char works[] = "ol";
  char fails[] = "bob";
  
  printf("Default: %p \n", strstr(test, empty));
  printf("Mine: %p \n", mystrstr(test, empty));

  printf("Default: %p \n", strstr(test, works));
  printf("Mine: %p \n", mystrstr(test, works));

  printf("Default: %p \n", strstr(test, fails));
  printf("Mine: %p \n", mystrstr(test, fails));
  
  return 0;
}
