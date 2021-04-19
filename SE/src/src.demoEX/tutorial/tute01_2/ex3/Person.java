package src.src.demoEX.tutorial.tute01_2.ex3;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.AttrRef;
import utils.DOpt;
import utils.OptType;

/**
 * @overview A human being that is characterised by attributes such as id and name
 * @attributes
 *  id      Integer         int
 *  name    String      
 *  phone   MobilePhone 
 *  
 * @object
 *  A typical Person is <i,n,p> where id(i), name(n), phone(p)
 * 
 * @abstract_properties
 *  mutable(id)=false /\ optional(id)=false /\ min(id)=1 /\
 *  mutable(name)=true /\ optional(name)=false /\ length(name)=30 /\
 *  mutable(phone)=true /\ optional(phone)=true
 *  
 * @author dmle
 * @version 
 */
public class Person {
    // STATE SPACE
    @DomainConstraint(type="Integer",mutable=false,optional=false,min=1)
    private int id;

    @DomainConstraint(type="String",mutable=true,optional=false,length=30)
    private String name;

    @DomainConstraint(type="MobilePhone",mutable=true,optional=true)    
    private MobilePhone phone;
    
    // BEHAVIOUR SPACE
    /**
     * @effects 
     *  if id, name are valid
     *      initialise this as <id,name>
     *  else
     *      throws NotPossibleException
     */
    public Person(@AttrRef("id") int id, @AttrRef("name") String name) throws NotPossibleExceptionPossibleException
    
    /**
     * @effects 
     *  return id
     */
    @DOpt(type=OptType.Observer) @AttrRef("id")     
    public int getId()
    
    /**
     * @effects 
     *  return name
     */
    @DOpt(type=OptType.Observer) @AttrRef("name")     
    public String getName()
    
    /**
     * @effects 
     *  return phone
     */
    @DOpt(type=OptType.Observer) @AttrRef("phone") 
    public MobilePhone getPhone()
    
    /**
     * @modifies this.name
     * @effects 
     *  if name is valid
     *      set this.name = name
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Mutator) @AttrRef("name") 
    public boolean setName(String name)

    /**
     * @modifies this.phone
     * @effects 
     *  if phone is valid
     *      set this.phone = phone
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Mutator) @AttrRef("phone") 
    public boolean setPhone(MobilePhone phone);

    @Override
    public String toString()
    
    @Override
    public boolean equals(Object o)
    
    /**
     * @effects 
     *  if this is valid with regards to abstract properties
     *      return true
     *  else
     *      return false
     */
    public boolean repOK()
    
    /**
     * @effects 
     *  if id is valid
     *      return true
     *  else
     *      return false
     */
    private boolean validateId(int id)
    
    /**
     * @effects 
     *  if name is valid
     *      return true
     *  else
     *      return false
     */
    private boolean validateName(String name)
    
    /**
     * @effects 
     *  if phone is valid
     *      return true
     *  else
     *      return false
     */
    private boolean validatePhone(MobilePhone phone)
}
