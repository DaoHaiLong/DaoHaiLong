package a1_BA9_041;
import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview PostgradStudent is a person who study in Master, Ph.D and higher levels, with personal information such as id, name ,
 *           phoneNumber, address
 * @attributes 
 *  id          Integer 
 *  name        String 
 *  phoneNumber String 
 *  address     String 
 *  gpa         Float
 * @object A typical PostgradStudent is
 *         <pre>
 * s = < id,name,phoneNumber,address >
 *         </pre>
 *         , where
 *         <pre>
 * id(id), name(name), phoneNumber(phoneNumber), address(address), gpa(gpa)
 *         </pre>
 * @abstract_properties 
 *  mutable(id)=false /\ optional(id)=false /\ min(id)=100000001 /\ max(id)=1000000000
 *  mutable(name)=true /\ optional(name)=false /\ length(name)=50 
 *  mutable(phoneNumber)=true /\optional(phoneNumber)=false /\ length(phoneNumber)=10
 *  mutable(address)=true /\ optional(address)=false /\length(address)=100 
 *  mutable(gpa)=true /\optional(gpa)=false /\ min(gpa)=0.0 /\ max(gpa)=4.0
 * @author DaoHaiLong
 */

public class PostgradStudent extends Student {
	private static final int MIN_ID = 100000001;
	private static final int MAX_ID = 1000000000;
	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
	private int id;
	@DomainConstraint(type = "String", optional = false, length = 50)
	private String name;
	@DomainConstraint(type = "String", optional = false, length = 10)
	private String phoneNumber;
	@DomainConstraint(type = "String", optional = false, length = 100)
	private String address;
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
			@AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address, @AttrRef("gpa") float gpa)
			throws NotPossibleException {
		super(id, name, phoneNumber, address);
		if (!validateGpa(gpa)) {
			throw new NotPossibleException("PostgradStudent.init: invalid gpa: " + gpa);
		}
		this.gpa = gpa;
	}

	/**
	 * @effects return <tt>id</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("id")
	public int getId() {
		return id;
	}

	/**
	 * @effects this.id = id
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("id")
	public void setId(int id) {
		if (validateId(id)) {
			this.id = id;
		} else {
			throw new NotPossibleException("PostgradStudent.init: invalid id: " + id);
		}
	}

	/**
	 * @effects return <tt>gpa</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("gpa")
	public float getGpa() {
		return gpa;
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

	/**
	 * @effects
	 *          <pre>
	 *            if id is a valid id
	 *             return true 
	 *            else 
	 *              return false
	 *          </pre>
	 */
	@Override
	protected boolean validateId(int id) {
		if (id < MIN_ID) {
			return false;
		} else if (id > MAX_ID) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @effects
	 *          <pre>
	 *            if id is a valid id
	 *             return true 
	 *            else 
	 *              return false
	 *          </pre>
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
	 * @effects return a string present PostgradStudent
	 */
	@Override
	public String toString() {
		return "PostgradStudent(" + getName() + ")";
	}


	// implements: Comparable
	/**
	 * @effects
	 * 
	 *          <pre>
	 * return super.compareByName(o)
	 *          </pre>
	 */
	public int compareTo(Object o) throws NullPointerException, ClassCastException {
		// compare two objects by name
		return super.compareByName(o);
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


}
