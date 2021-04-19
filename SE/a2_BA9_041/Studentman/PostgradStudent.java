package a2_BA9_041.Studentman;
import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.OptType;
import utils.NotPossibleException;
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
	@DomainConstraint(type = "Float", mutable = true, optional = false, min = 0.0, max = 4.0)
	private float gpa;

	/**
	 * @effects
	 *            if i,n,p,a,g are valid
	 *              initialise this as PostgradStudent:<i,n,p,a,g>
	 *            else
	 *              print error message
	 *
	 */
	public PostgradStudent(@AttrRef("id") int id,
						   @AttrRef("name") String name,
						   @AttrRef("phoneNumber") String phoneNumber,
						   @AttrRef("address") String address,
						   @AttrRef("gpa") float gpa)
			throws NotPossibleException{
		super(id,name,phoneNumber,address);
		if(!validateGpa(gpa)) {
			throw new NotPossibleException("PostgradStudent.init: invalid gpa: " + gpa);
		}
		else {
			this.gpa = gpa;
		}
	}

	/**
	 *
	 * @effects
	 *  return this.gpa
	 */
	@DOpt(type = OptType.Observer) @AttrRef("gpa")
	public float getGpa() {
		return this.gpa;
	}


	/**
	 * @effects
	 *  if gpa is valid
	 *    set this.gpa = gpa
	 *  else
	 *    print error message
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("gpa")
	public void setGpa(float gpa) {
		if (validateGpa(gpa)) {
			this.gpa = gpa;
		} else {
			throw new NotPossibleException("PostgradStudent.init: invalid id: " + gpa);
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
		if (gpa < 0.0 || gpa > 4.0) {
			return false;
		}
		return true;
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
		if(!super.validateId(i)) {
			return false;
		}
		if(i < MIN_ID || i > MAX_ID) {
			return false;
		}
		return true;
	}
}
