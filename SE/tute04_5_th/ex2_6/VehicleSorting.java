package tute04_5_th.ex2_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @overview 
 *
 * @author Duc Minh Le (ducmle)
 *
 * @version 
 */
public class VehicleSorting {
  public static void main(String[] args) {
    List<Vehicle> vehs = new ArrayList<>();
    
    vehs.add(new Vehicle("Stary sky", 20, 30, 40, 20, 10));
    vehs.add(new Vehicle("Blue diamond", 10, 30, 50, 40, 20));
    vehs.add(new Vehicle("Ambient Rock", 10, 10, 10, 10, 10));
    vehs.add(new Vehicle("VinSuper", 10, 10, 10, 10, 10));
    vehs.add(new Vehicle("Silver Bullet", 10, 10, 10, 10, 10));
    
    sortUsingComparable(vehs);
    
//    sortUsingComparator(vehs);
    
    for (Vehicle v : vehs) {
      System.out.println(v);
    }
  }

  /**
   * @modifies vehs
   * @effects 
   */
  private static void sortUsingComparable(List<Vehicle> vehs) {
    Collections.sort(vehs);
  }

  /**
   * @modifies vehs
   * @effects 
   * 
   */
  private static void sortUsingComparator(List<Vehicle> vehs) {
    // different ways of initialising Comparator objects:
    Comparator<Vehicle> comp =
        // ASC #1: invoke Comparator.comparing directly
        Comparator.comparing(Vehicle::getName);
        // ASC #2: lambda expression of a method reference
        // Vehicle::compareByNameAsc;
        // DESC #1: lambda expression of a method reference
        // Vehicle::compareByNameDesc;
        // DESC #2: reversed lambda expression of an ASC-typed lambda expression
        // comp = comp.reversed();
    
    vehs.sort(comp);    
  }
}
