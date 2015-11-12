####SOTD: Low Rider - War

#Aim: Zelda's in trouble, get Link!

###Do Now: What's wrong with this function?
- (Assume node has been declared correctly)

	node* insert_front( note* n, int i) {
	
	node new;
    
	new.i = i;
	new.next = n;
    
	return &new;
	}
