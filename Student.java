package a2_BA9_041.studentman;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;
import java.util.Objects;
/**
 * @overview Student is a person who study in school and has personal information such as id, name ,
 *           phoneNumber, address, etc.
 * @attributes 
 * 	id          Integer 
 * 	name        String 
 * 	phoneNumber String 
 * 	address     String
 * @object A typical Student is
 *         <pre>
 * s = <id,name,phoneNumber,address>
 *         </pre>
 *         , where
 *         <pre>
 * id(id), name(name), phoneNumber(phoneNumber), address(address)
 *         </pre>
 * @abstract_properties 
 * 	mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\max(id) = 1000000000 
 * 	mutable(name) = true /\optional(name) = false /\ length(name) = 50
 * 	mutable(phoneNumber) = true /\ optional(phoneNumber) = false/\ length(phoneNumber) = 10 
 * 	mutable(address) = true /\optional(address) = false /\ length(address) = 100
 * @author DaoHaiLong
 */

public class Student implements Comparable<Student>,Document {
	private static final int MIN_ID = 1;
	private static final int MAX_ID = 1000000000;
	@DomainConstraint(type = "Integer", mutable = false, optional = false, min =MIN_ID, max = MAX_ID)
	private int id;
	@DomainConstraint(type = "String", optional = false, length = 50)
	private String name;
	@DomainConstraint(type = "String",  optional = false, length = 10)
	private String phoneNumber;
	@DomainConstraint(type = "String",  optional = false, length = 100)
	private String address;

	/**
	 * @effects
	 *          <pre>
	 *            if id, name, phoneNumber, address are valid
	 *              initialize this as Vehicle: <id,name,phoneNumber,address>
	 *            else
	 *              print error message
	 *          </pre>
	 */
	public Student(@AttrRef("id") int id, @AttrRef("name") String name, @AttrRef("phoneNumber") String phoneNumber,
			@AttrRef("address") String address) throws NotPossibleException {
		if (!validateId(id)) {
			throw new NotPossibleException("Student.init: invalid id: " + id);
		}
		if (!validateName(name)) {
			throw new NotPossibleException("Student.init: invalid name: " + name);
		}
		if (!validatePhoneNumber(phoneNumber)) {
			throw new NotPossibleException("Student.init: invalid phoneNumber: " + phoneNumber);
		}
		if (!validateAddress(address)) {
			throw new NotPossibleException("Student.init: invalid address: " + address);
		}
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	/**
     * @effects
     *  if id is valid
     *      set this.id = id
     *  else
     *      throws NotPossibleException
     */
	@DOpt(type = OptType.Mutator)@AttrRef("id")
	public void setId(int id) {
		if (validateId(id)) {
			this.id = id;
		} else {
			throw new NotPossibleException("Student.setId: invalid id: " + id);
		}
	}
	/**
     * @effects
     *  if name is valid
     *      set this.name = name
     *  else
     *      throws NotPossibleException
     */
	@DOpt(type = OptType.Mutator)@AttrRef("name")
	public void setName(String name) {
		if (validateName(name)) {
			this.name = name;
		} else {
			throw new NotPossibleException("Student.setName: invalid name: " + name);
		}
	}
	
	  /**
     * @effects
     *  if address is valid
     *      set this.address = address
     *  else
     *      throws NotPossibleException
     */
	@DOpt(type = OptType.Mutator)@AttrRef("address")
	public void setAddress(String address) {
		if (validateAddress(address)) {
			this.address = address;
		} else {
			throw new NotPossibleException("Student.setAddress: invalid address: " + address);
		}
	}
	

    /**
     * @effects
     *  if phoneNumber is valid
     *      set this.phoneNumber = phoneNumber
     *  else
     *      throws NotPossibleException
     */
	@DOpt(type = OptType.Mutator)@AttrRef("phoneNumber")
	public void setPhoneNumber(String phoneNumber) {
		if (validatePhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new NotPossibleException("Student.setPhoneNumber: invalid phoneNumber: " + phoneNumber);
		}
	}
	

    /**
     *
     * @effects
     *  return this.id
     */
	@DOpt(type = OptType.Observer)
	@AttrRef("id")
	public int getId() {
		return id;
	}


	   /**
    *
    * @effects
    *  return this.name
    */
	@DOpt(type = OptType.Observer)
	@AttrRef("name")
	public String getName() {
		return name;
	}


	/**
    *
    * @effects
    *  return this.phoneNumber
    */
	@DOpt(type = OptType.Observer)
	@AttrRef("phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	 /**
    *
    * @effects
    *  return this.address
    */
	@DOpt(type = OptType.Observer)
	@AttrRef("address")
	public String getAddress() {
		return address;
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

	protected boolean validateId(int i) {
		if (i < MIN_ID || i > MAX_ID) {
			return false;
		}
		return true;
	
	}

	/**
	 * @effects
	 *          <pre>
	 *            if name is valid 
	 *              return true 
	 *            else 
	 *              return false
	 *          </pre>
	 */
	private boolean validateName(String n) {
		if (n == null || n.length() > 50 || n.isBlank() || n.isEmpty()) {
			return false;
		} 
		return true;
	}

	/**
	 * @effects
	 *          <pre>
	 *            if phoneNumber is valid 
	 *              return true 
	 *            else 
	 *              return false
	 *          </pre>
	 */

	private boolean validatePhoneNumber(String ph) {
		if (ph == null || ph.length() > 10 || ph.isBlank() || ph.isEmpty()) {
			return false;
		} 
		return true;
		
	}

	/**
	 * @effects
	 *          <pre>
	 *            if address is valid 
	 *              return true 
	 *            else 
	 *              return false
	 *          </pre>
	 */

	private boolean validateAddress(String a) {
		if (a == null || a.length() > 100 || a.isBlank() || a.isEmpty()) {
			return false;
		}
		return true;
		
	}

	/**
	 * @effects
	 *          <pre>
	 *            if < i,n,ph,a > is a valid tuple 
	 *              return true
	 *            else
	 *              return false
	 *          </pre>
	 */
	private boolean validate(int i, String n, String ph, String a) {
		return validateId(i) && validateName(n) && validatePhoneNumber(ph) && validateAddress(a);
	}
	/**
	 * @effects
	 *          <pre>
	 *            if this satisfies rep invariant
	 *              return true 
	 *            else
	 *              return false
	 *          </pre>
	 */
	public boolean repOK() {
		return validate(id, name, phoneNumber, address);
	}
	

	/**
	 * @effects return a string present Student
	 */
	   @Override
	    public String toString() {
	        if (this.getClass().getSimpleName() == "UndergradStudent") {
	            return "UndergradStudent(" + name + ")";
	        }
	        else if (this.getClass().getSimpleName() == "PostgradStudent") {
	            return "PostgradStudent(" + name + ")";
	        }
	        else {
	            return "Student" + name + ")";
	        }
	    }

	@Override
    public int compareTo(Student student) {
        int compare = (this.getName()).compareTo(student.getName());
        return compare;
    }
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Student student = (Student) o;
	        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(phoneNumber, student.phoneNumber) && Objects.equals(address, student.address);
	    }
	 
	 @Override
	    public int hashCode() {
	        return Objects.hash(id, name);
	    }

	    /**
	     *
	     * @effects
	     *  return a String containing the text of a simple HTML document generated from the state of the current object
	     */
	    @Override
	    public String toHtmlDoc() {
	        if (this.getClass().getSimpleName() == "UndergradStudent") {
	            return "<html>\n<head><title>UndergradStudent:" + this.id + "-" + this.name + "</title></head>\n<body>\n" + this.id + " " + this.name + " " + this.phoneNumber + " " + this.address + "\n</body></html>";
	        }
	        else if (this.getClass().getSimpleName() == "PostgradStudent") {
	            return "<html>\n<head><title>PostgradStudent:" + this.id + "-" + this.name + "</title></head>\n<body>\n" + this.id + " " + this.name + " " + this.phoneNumber + " " + this.address + "\n</body></html>";
	        }
	        else {
	            return "<html>\n<head><title>Student:" + this.id + "-" + this.name + "</title></head>\n<body>\n" + this.id + " " + this.name + " " + this.phoneNumber + " " + this.address + "\n</body></html>";
	        }
	    }
}