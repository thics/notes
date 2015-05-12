import java.util.*;
import java.io.*;

public class Trio {
  public interface MenuItem {
    /** @return the name of the menu item */
    String getName();
    /** @return the price of the menu item */
    double getPrice(); 
  }

  String name;
  double price;

  public Trio(Sandwich s, Salad sal, Drink d) {
    name = s.getName() + "/";
    name += sal.getName() + "/";
    name += d.getName() + " Trio";

    if(s.getPrice() > sal.getPrice() && s.getPrice() > d.getPrice()) //If Sandwich price greatest
      if(sal.getPrice() > d.getPrice())
        price = s.getPrice() + sal.getPrice();
      else
        price = s.getPrice() + d.getPrice();
    else if(sal.getPrice() > s.getPrice() && sal.getPrice() > d.getPrice()) //If Salad price greatest
      if(s.getPrice() > d.getPrice())
        price = sal.getPrice() + s.getPrice();
      else
        price = sal.getPrice() + d.getPrice();
    else //If Drink price greatest
      if(s.getPrice() > sal.getPrice())
        price = d.getPrice() + s.getPrice();
      else
        price = d.getPrice() + sal.getPrice();
  }
}
