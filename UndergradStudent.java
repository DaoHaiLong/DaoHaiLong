package a2_BA9_041.studentman;
import utils.AttrRef;
import utils.DomainConstraint;
import utils.NotPossibleException;

/**
 * @overview UndergradStudent (Undergraduate Student) is a person who go to school and
             take part in the Bachelor program
 * @abstract_properties
 *    P_Student /\
 *    min(id) = 10^5 /\ max(id) = 10^8
 * @author DaoHaiLong
 */
public class UndergradStudent extends Student {
	 private static final int MIN_ID = 100000;
	    private static final int MAX_ID = 100000000;
	
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
	
  @Override
	public boolean repOK() {
	        return super.repOK();
	    }
	 
  @Override
	public String toHtmlDoc() {
	     return "<html>\n<head><title>UndergradStudent:" + getId() + "-" + getName() + "</title></head>\n<body>\n" + getId() + " " + getName() + " " + getPhoneNumber() + " " + getAddress() + "\n</body></html>";
	  }

}
