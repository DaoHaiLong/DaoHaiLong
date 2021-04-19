package a2_BA9_041.studentman;
import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview PostgradStudent is a person who go to school after completed Bachelor program
 * @attributes
 *  gpa Float float
 * @object A typical PostgradStudent is <i,n,ph,a,g> where id(i), name(n), phoneNumber(ph), address(a), gpa(g)
 * @abstract_properties
 *    P_Student /\
 *    min(id) = 10^8+1 /\ max(id) = 10^9 /\
 *    mutable(gpa) = true /\ optional(gpa) = false /\ min(gpa) = 0 /\ max(gpa) = 4
 * @author Dao Hai Long
 */

public class PostgradStudent extends Student implements Document {
	private static final int MIN_ID = 100000001;
    private static final int MAX_ID = 1000000000;
	@DomainConstraint(type = "Float", mutable = true, optional = false, min = 0.0, max = 4.0)
	private float gpa;

	// constructor methods
	/**
	 * @effects 
	 *          <pre>
	 *            if id, name, phoneNumber, address, gpa are valid
	 *              initialise this as PostgradStudent:<id,name,phoneNumber,address,gpa>
	 *            else
	 *              print error message
	 *          </pre>
	 */
	
public PostgradStudent(@AttrRef("id") int id, @AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber,
			@AttrRef("address") String address, 
			@AttrRef("gpa") float gpa) {
	    super(id, name, phoneNumber, address);
		    if (!validateGpa(gpa)) {
			     throw new NotPossibleException("PostgradStudent.init: invalid gpa: " + gpa);
		       }
		    this.gpa = gpa;
	   }

/**
 * @effects this.gpa=gpa
 */
@DOpt(type = OptType.Mutator)
@AttrRef("gpa")
public void setGpa(float gpa) {
	if (validateGpa(gpa)) {
		this.gpa = gpa;
	} else {
		throw new NotPossibleException("PostgradStudent.setGpa: invalid gpa: " + gpa);
	}
}

/**
 * @effects return <tt>gpa</tt>
 */
@DOpt(type = OptType.Observer)
@AttrRef("gpa")
public float getGpa() {
	return this.gpa;
}



   
   @Override
   public String toString() {
       return "PostgradStudent(" + getName() + ")";
   }


   /**
    * @effects
    *  if gpa is valid
    *    return true
    *  else
    *    return false
    */
   private boolean validateGpa(float gpa) {
		if (gpa < 0.0) {
			return false;
		} else if (gpa > 4.0) {
			return false;
		} else {
			return true;
		}
	}

   /**
    * @effects
    *            if i is valid
    *              return true
    *            else
    *              return false
    */
   @Override
   @DomainConstraint(type = "Integer", min = MIN_ID, max = MAX_ID, optional = false)
   protected boolean validateId(int i) {
       if(!super.validateId(i))
           return false;
       if(i < MIN_ID || i > MAX_ID)
           return false;

       return true;
   }
   
   /**
   *
   * @effects
   *  if this satisfies rep invariant
   *      return true
   *  else
   *      return false
   */
  @Override
  public boolean repOK() {
      if (super.repOK()) {
          return validateGpa(this.gpa);
      }
      else {
          return false;
      }
  }

  /**
   * @effects
   *            return a String containing the text of a simple HTML document generated from the state of the current object
   */
  @Override
  public String toHtmlDoc() {
      return "<html>\n<head><title>PostgradStudent:" + getId() + " " + getName() + "</title></head>\n<body>\n" + getId() + " " + getName() + " " + getPhoneNumber() + " " + getAddress() + " " + getGpa() + "\n</body></html>";
  }

}
