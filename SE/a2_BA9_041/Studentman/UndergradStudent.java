package a2_BA9_041.Studentman;
import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview UndergradStudent is a person who study in university, college and has personal information such as id, name ,
 *           phoneNumber, address
 * @attributes 
 * 	id          Integer 
 *  name        String 
 *  phoneNumber String 
 *  address     String
 * @object A typical UndergradStudent is
 *         <pre>
 * s = < id,name,phoneNumber,address >
 *         </pre>
 *         , where
 *         <pre>
 * id(id), name(name), phoneNumber(phoneNumber), address(address)
 *         </pre>
 * @abstract_properties 
 *  mutable(id)=false /\ optional(id)=false /\
 *  min(id)=100000 /\ max(id)=100000000 mutable(name)=true
 *  /\ optional(name)=false /\ length(name)=50
 *  mutable(phoneNumber)=true /\ optional(phoneNumber)=false
 *  /\ length(phoneNumber)=10 mutable(address)=true /\
 *  optional(address)=false /\ length(address)=100
 * @author DaoHaiLong
 */

public class UndergradStudent extends Student {
	private static final int MIN_ID = 100000;
	private static final int MAX_ID = 100000000;
	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
	private Integer id;
	@DomainConstraint(type = "String", optional = false, length = 50)
	private String name;
	@DomainConstraint(type = "String", optional = false, length = 10)
	private String phoneNumber;
	@DomainConstraint(type = "String", optional = false, length = 100)
	private String address;

	// constructor methods
	/**
	 * @effects
	 *          <pre>
	 *            if id, name, phoneNumber, address are valid
	 *              initialise this as UndergradStudent:<id,name,phoneNumber,address>
	 *            else
	 *              print error message
	 *          </pre>
	 */
	public UndergradStudent(@AttrRef("id") int id, @AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address)
			throws NotPossibleException {
		super(id, name, phoneNumber, address);
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
			throw new NotPossibleException("UndergradStudent.init: invalid id: " + id);
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

	protected boolean validateId(int id) {
		if (id <MIN_ID) {
			return false;
		} else if(id>MAX_ID){
			return false;
		}else {
			return true;
		}
	}

	/**
	 * @effects return a string present UndergradStudent
	 */
	@Override
	public String toString() {
		return "UndergradStudent(" + getName() + ")";
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
		// compare two undergrade students by name
		return super.compareByName(o);
	}

}
