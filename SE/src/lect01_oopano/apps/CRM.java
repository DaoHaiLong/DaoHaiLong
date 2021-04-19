package lect01_oopano.apps;

import lect01_oopano.Customer;

/**
 * @overview A program that creates Customer objects and displays their details
 * @author dmle
 */
public class CRM {
  private static int idCounter = 1;
  
  /**
   * @effects <pre>
   *            if name is valid
   *             returns a new Customer <id,name> where id 
   *             is auto-incremented
   *            else
   *              returns null</pre>
   */
  public Customer createCustomer(String name) {
    int id = idCounter;
    Customer c = new Customer(id,name);
    
    idCounter++;
    
    // not an intended use but acceptable!
    if (c.repOK()) {
      return c;
    } else {
      return null;
    }
  }

  /**
   * The run method
   * 
   * @effects create some valid and invalid customer objects and display their details
   */
  public static void main(String[] args) {
    CRM bp = new CRM();
    
    String[] names = {"Nguyen Van A", null, "Trần Văn Tuấn"};
    Customer c;
    for (String name: names) {
      c = bp.createCustomer(name);
      if (c == null) {
        System.err.println("Could not create a customer with name: " + name);        
      } else {
        System.out.println("Created customer: " + c);
      }
    }
  }
} // end CRM
