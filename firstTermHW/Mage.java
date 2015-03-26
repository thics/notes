public class Mage extends Character {
    
    int energy;
   
    public Mage() {
	health = 10;
	damage = 10;
    }
    
    public void display() {
	String s = name + " ";
	s += health + " ";
	s += damage + " ";
	s += experience + " ";
	s+= energy + " ";
	System.out.println(s);
    }

    public void attack() {
	super.attack();
	System.out.println( "pew pew" );
    }
}
