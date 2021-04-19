package a2_BA9_041.Studentman;

import utils.AttrRef;
import utils.NotPossibleException;




/**
 * @overview UndergradStudent (Undergraduate Student) is a person who go to school and
             take part in the Bachelor program
 * @abstract_properties
 *    P_Student /\
 *    min(id) = 10^5 /\ max(id) = 10^8
 * @author DaoHaiLong
 */
public class UndergradStudent extends Student implements Document {

	
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
	public UndergradStudent(@AttrRef("id") int id,
			@AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber, 
			@AttrRef("address") String address) throws NotPossibleException {
		super(id, name, phoneNumber, address);
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
	public int compareTo(Student student) throws NullPointerException, ClassCastException {
		// compare two undergrade students by name
		return super.compareByName(student);
	}
	
	  @Override
	    public boolean repOK() {
	        return super.repOK();
	    }
	  
	  @Override
		public String toHtmlDoc() {
			StringBuffer sb = new StringBuffer();
			sb.append("<html>");
			sb.append("<head>");
			sb.append("<title>: UndergradStudent" + this.getName() + "</title>");
			sb.append("</head>");
			sb.append("<body>");
			sb.append(this.getId() + " " + this.getName() + " "+ this.getPhoneNumber() + " " + this.getAddress());
			sb.append("</body></html>");
			return sb.toString();
		}

}
