####SOTD: In The Waiting Line - Zero 7

#Aim: Where do compsci priests live? - In directory!

* **ctime( <TIME> )**
 * TIME is type time_t*
  * returns the time as a string

* **time( <TIME> )**
 * TIME is type time_t*
  * sets the parameter to the current time

###Directories
* a *nix directory is a file containing the names of the files within the directory
	along with basic information like file type.

* Moving files into/out of a directory means changing the directory file,  
  not actually moving any data

####opendir - <dirent.h>

 * Open a directory file

 * This will not change the cwd, it only allows your program to read  
   the contents of the directory file

   opendir( <PATH> );

  * Returns a pointer to a directory stream (DIR *)

####closedir - <dirent.h>

 * Closes the directory stream and frees the pointer  
   associated with it.

  closedir( <DIRECTORY STREAM> )

####readdir - <dirent.h>

readdir( <DIRECTORY STREAM> )

 * Returns a pointer to the next entry in a directory  
   stream, or NULL if all entries have already been  
   returned.

struct dirent - <sys/types.h>

 * Directory struct that contains the information  
   stored in a directory file.

* Some of the data members

	d_name: file's name
	d_type: file's type

####rewinddir - <dirent.h>

 * Resets the directory stream to the beginning of the directory

	rewinddir( <DIRECTORY STREAM> )
