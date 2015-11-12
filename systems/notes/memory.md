####SOTD: Breaking The Girl - Red Hot Chili Peppers

#Aim: If you can't (al)locate your memory then... I forget

- Should compile each C file separately

> If you have two C files:

    dwstring.c dwstring.h main.c

    dwstring.o   main.o    //Compile using gcc -c <filename_1> <filename_2>

        a.out	 	   //gcc dwstring.o main.o


**Take a look at makefile in Github repo, compiling c to o, and linking o to a.out (or custom name file) and running**

###Dynamic Memory Allocation
 - `malloc(int x)`
  - Allocates x bytes of memory (from the heap)

   - Returns the address at the beginning of the allocation

   - Returns a void *, always typecast to the correct pointer type.

        int *p;
        p = (int *)malloc( 5 * sizeof(int) );

    - `calloc(int n, int x)`
     - Allocates n * x bytes of memory

     - Ensures that each bit is set to 0

     - Works like malloc in all other ways

            int *p;
            p = (int *)calloc(5, sizeof(int));

 - `realloc(void *p, int x)`
  - Changes the amount of memory allocated to a given block.

   - p must be a pointer to the beginning of an allocated block of memory, but it does not have to be the original pointer

   - If x is smaller than the original size of the allocation, the extra bytes will be released

	    int *p;
	    p = (int *)malloc( 20 );
	    p = (int *)realloc( p, 40);

 - `free( <memory> )`
  - Releases dynamically allocated memory.

  - Takes one parameter, a pointer to the beginning of a dynamically allocated block of memory.

  - Every call to a malloc/calloc should have a corresponding call to free.

	    int *p;
	    p = (int *)malloc(20);
	    free(p);

  - `typedef <real_type> <type_name>;`

   - Provide a new name for an existing data type.
	 
          typedef char* String;
	      String s = "Woohoo I'm back to Java";

###struct
- A collection of values in a single data type

	    struct foo {
	      int a;
	      char x;
	    };		//Don't forget semi-colon

	    struct {
	      int a;
	      char c;
	    } t;

	    t.a = 87;
	    t.c = '^';

	    struct foo s;

	    s.a = 90;

	    typedef struct {int a; char c;} foo;

	    foo b;  	 //Can do that now
	  

	  
