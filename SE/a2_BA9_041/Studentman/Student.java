package a2_BA9_041.Studentman;

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

public class Student implements Comparable<Object> {
	private static final int MIN_ID = 1;
	private static final int MAX_ID = 1000000000;
	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1, max = 1000000000)
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
	 * @effects return <tt>id</tt>
	 */
	@DOpt(type = OptType.Observer)@AttrRef("id")
	public int getId() {
		return id;
	}

	/**
	 * @effects this.id = id
	 */
	@DOpt(type = OptType.Mutator)@AttrRef("id")
	public void setId(int id) {
		if (validateId(id)) {
			this.id = id;
		} else {
			throw new NotPossibleException("Student.init: invalid id: " + id);
		}
	}

	/**
	 * @effects return <tt>name</tt>
	 */
	@DOpt(type = OptType.Observer)@AttrRef("name")
	public String getName() {
		return name;
	}

	/**
	 * @effects this.name=name
	 */
	@DOpt(type = OptType.Mutator)@AttrRef("name")
	public void setName(String name) {
		if (validateName(name)) {
			this.name = name;
		} else {
			throw new NotPossibleException("Student.init: invalid name: " + name);
		}
	}

	/**
	 * @effects return <tt>phoneNumber</tt>
	 */
	@DOpt(type = OptType.Observer)@AttrRef("phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @effects this.phoneNumber = phoneNumber
	 */
	@DOpt(type = OptType.Mutator)@AttrRef("phoneNumber")
	public void setPhoneNumber(String phoneNumber) {
		if (validatePhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new NotPossibleException("Student.init: invalid phoneNumber: " + phoneNumber);
		}
	}

	/**
	 * @effects return <tt>address</tt>
	 */
	@DOpt(type = OptType.Observer)@AttrRef("address")
	public String getAddress() {
		return address;
	}

	/**
	 * @effects this.address = address
	 */
	@DOpt(type = OptType.Mutator)@AttrRef("address")
	public void setAddress(String address) {
		if (validateAddress(address)) {
			this.address = address;
		} else {
			throw new NotPossibleException("Student.init: invalid address: " + address);
		}
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
		return "Student(" + name + ")";
	}

	/**
	 * @effects
	 *          <pre>
	 *            if < i,n,p,a > is a valid tuple 
	 *              return true
	 *            else
	 *              return false
	 *          </pre>
	 */
	boolean validate(int i, String n, String p, String a) {
		return validateId(i) && validateName(n) && validatePhoneNumber(p) && validateAddress(a);
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
	 *            if name is valid 
	 *              return true 
	 *            else 
	 *              return false
	 *          </pre>
	 */
	private boolean validateName(String name) {
		if (name == null)
			return false;
		else if (name.length() > 50) {
			return false;
		} else {
			return true;
		}

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

	private boolean validatePhoneNumber(String phoneNumber) {
		if (phoneNumber == null) {
			return false;
		} else if (phoneNumber.length() > 10) {
			return false;
		} else {
			return true;
		}
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

	private boolean validateAddress(String address) {
		if (address == null) {
			return false;
		} else if (address.length() > 100) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @effects compare student name
	 */

	public int compareByName(Object student) throws NullPointerException, ClassCastException {

		if (student == null)
			throw new NullPointerException("Student.compareByName");
		else if (!(student instanceof Student))
			throw new ClassCastException("Student.compareByName: not a Student " + student);

		Student s = (Student) student;
		return this.name.compareTo(s.name);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return (this.getName().compareTo(((Student) o).getName()));
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

    public String toHtmlDoc() {
		return String ;
    }
}
