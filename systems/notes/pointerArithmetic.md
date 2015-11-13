####SOTID: Lump - The Presidents of the United States of America

#Aim: Ok, now we're really going to get to the point

###Do Now:
   1. Declare int, double, and char variables.
   2. Declare int, double and char pointers.
   3. Initialize each pointer to the address of the corresponding variable
   4. Print out the pointer's value for each (as an unsigned long).
   5. Add 1 to each pointer.
   6. Print out the pointers again.
   
   What happened?

- Declare pointers with *, use without *
- Get variable pointer value with &

- & is used to get the address of a variable

- `*` is used to declare a variable as a pointer type

		`ex. int *p, double *d, char *r, ...`

- `*` is also used as the de-reference operator
 - It accesses the value referenced by the pointer

- All pointer variable types are same size

###Pointer Arithmetic

	int *p = &i;
	char *c = &c;

	p++; //will add 4 to p
	c++; //will add 1 to p

- Array variables are immutable pointers

- Pointers can be assigned to array variables

		int ray[5];
		int *rp = ray;

		ray[3] <==> ?

		ray[3] == *(rp + 3)
