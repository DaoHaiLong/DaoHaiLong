package src.lect02_th.vehicles;

import src.lect02_th.vehicles.VehicleApp;
import utils.AttrRef;
import utils.DomainConstraint;

/**
 * @overview Bus is a sub-class of Vehicle representing a bus (also omnibus or
 *           autobus), which is a road vehicle designed to carry passengers. Buses have
 *           a capacity as high as 300 passengers and are widely used for public
 *           transportation.
 * @abstract_properties
 *    P_Vehicle /\ 
 *    min(weight)=5000 /\
 *    min(seatingCapacity)=30 /\ length(restre)=8
 * @author dmle
 */
public class Bus extends VehicleApp {


  static final double MIN_WEIGHT = 5000;
  static final double MIN_SEATCAP = 30;

  // constructor methods
  /**
   * @effects <pre>
   *            if n, d, h, l, w, c are valid
   *              initialise this as Bus:<n,d,h,l,w,c>
   *            else
   *              print error message
   *          </pre>
   */
  public Bus(@AttrRef("name") String n, 
      @AttrRef("width") double d, @AttrRef("height") double h, @AttrRef("length") double l, 
      @AttrRef("weight") double w, @AttrRef("seatingCapacity") int c) {
    super(n, d, h, l, w, c);
  }
  
  @Override  
  public String toString() {
    return "Bus(" + getName() + ")";
  }



  /**
   * @effects <pre>
   *   if w is valid 
   *     return true 
   *   else 
   *     return false</pre> 
   */
  @Override
  @DomainConstraint(type="Double",min=MIN_WEIGHT,optional=false)
  protected boolean validateWeight(double w) {
    // not needed: super.validateWeight(w);
    
    if (w < MIN_WEIGHT) 
      return false;
    else // means: w >= MIN_WEIGHT -> w > 0
      return true;
  }

  /**
   * @effects <pre>
   *            if c is valid 
   *              return true 
   *            else 
   *              return false</pre> 
   */
  @Override
  @DomainConstraint(type="Integer",min=MIN_SEATCAP,optional=false)
  protected boolean validateSeatingCapacity(int c) {
    if (c < MIN_SEATCAP)
      return false;
    else 
      return true;
  }

  @Override
  protected String getsymbol() {
    return null;
  }

  public class MIN_WEIGHT {
  }
}
