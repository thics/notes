#Aim: How to write functioning code

###Do Now
Write a C program that does the following:
      1. Creates a string and sets it to some value.
      2. Finds the length of the string and then prints it (code in main function)

###Basic C File Structure
- You can only assign strings with = at declaration
 - char s[] = "zero"; //ok
 - s = "seven";       //not ok!

- Can declare function heads at top to avoid dependency issues (good practice)

 - Can make header files  
(`<name>.h` files, `#include <path><name>.h` files at top

 - Can just declare entire function on top (might see internal dependency issues, so not great practice)

###Back to Cstrings

####string.h
- C library that includes useful string functions.

- All the functions assume that the parameter strings are always null-terminated

 - `int strlen( char *s)`
  - returns the number of characters from the start of s up to but not including the terminating null

 - `int strcmp( char *s1, char *s2 )`
  - returns 0 if s1 and s2 are identical up to the terminating null.

  - returns a positive number if s1 is greater than s2 (lexicographically)

  - returns a negative number if s1 is less than s2

 - `char * strcpy( char *dest, char *source)`
  - Copies all the chars up to and including the terminating null from source into dest

    returns dest

 - `char * strcat( char *s1, char *s2)`
  - Appends all the characters up to and include the terminating null in s2 to the end of s1

- Many string functions have a "strn" version, these take an extra parameter that sets a limit to the number of bytes you will look at in a string.
	
 - `strncat( char *s1, char*s2, int n)`
