package a2_BA9_041.Studentman;
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
 * @effects return <tt>gpa</tt>
 */
@DOpt(type = OptType.Observer)
@AttrRef("gpa")
public float getGpa() {
	return this.gpa;
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
		throw new NotPossibleException("PostgradStudent.init: invalid gpa: " + gpa);
	}
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
          return validateGpa(gpa);
      }
      else {
          return false;
      }
  }
//implements: Comparable
	/**
	 * @effects
	 * 
	 *          <pre>
	 * return super.compareByName(o)
	 *          </pre>
	 */
	public int compareTo(Student student) throws NullPointerException, ClassCastException {
		// compare two objects by name
		return super.compareByName(student);
	}
	
	@Override
	public String toHtmlDoc() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>: PostgradStudent" + this.getName() + "</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append(this.getId() + " " + this.getName() + " "+ this.getPhoneNumber() + " " + this.getAddress() + " "+ this.getGpa());
		sb.append("</body></html>");
		return sb.toString();
	}

}
