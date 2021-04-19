package src.src.demoEX.tutorial.tute01_2;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

import java.util.Objects;

/**
 * @overview Person is a human being characterised by attributes like 
 *  id and name.
 *
 * @attributes
 *  id    Integer   int
 *  name  String  
 *  phone MobilePhone
 *
 * @object A typical Person is <i, n, p> where id(i), name(n), 
 * phone(p).
 *
 * @abstract_properties
 *    mutable(id)=false /\ optional(id) = false /\ min(id)=1 /\ 
 *    mutable(name)=true /\ optional(name) = false /\ length(name)=30 /\ 
 *    mutable(phone)=true /\ optional(phone) = true
 *
 * @author Duc Minh Le (ducmle)
 */
public class Person {
  // object represention
  @DomainConstraint(mutable=false,optional=false,min=1)
  private int id;

  // TODO: domain constraint
  @DomainConstraint(mutable=false,optional=false,min=1)
  private String name;

  // TODO: domain constraint
  src.src.demoEX.tute01_2.tute01_2.MobilePhone phone;

  // TODO: operations
  /**
   * @effects
   *  if i, n are valid
   *    initialise this as <i, n>
   *  else
   *    throws NotPossibleException
   */
  public Person(
          @AttrRef("id") int i,
          @AttrRef("name") String n)
          throws NotPossibleException {
    // 
  }

  /**
   * @effects
   *   if name is valid
   *     set this.name = name
   *     return true
   *   else
   *     return false 
   */
  @DOpt(type=OptType.Mutator) @AttrRef("name")
  public boolean setName(String name) {
    //TODO
    return false;
  }

  //  setPhone(phone: MobilePhone)
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public src.src.demoEX.tute01_2.tute01_2.MobilePhone getPhone() {
    return phone;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setPhone(src.src.demoEX.tute01_2.tute01_2.MobilePhone phone) {
    this.phone = phone;
  }
  public String toString(){
    return "Person{" +
            "id='" + id + '\'' +
            ", name='" + name+ '\'' +
            ", phone=" + phone +
            '}';
  }
  @Override
  public boolean equals(Object a) {
    if (this == a) return true;
    if (a == null || getClass() != a.getClass()) return false;
    Person that = (Person) a;
    return id== that.id && name == that.name&& Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(phone, that.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, phone);
  }


  /**
   * @effects
   *  if this is valid
   *    return true
   *  else
   *    return false
   */
  public boolean repOK() {
    if ()
      return true;
    return false;
  }

  /**
   * @effects
   *  if id is valid
   *    return true
   *  else
   *    return false
   */
  private boolean validateId(int id) {
    if (this== id)
      return true;
    return false;
  }
  /**
   * @effects
   *  if Name is valid
   *    return true
   *  else
   *    return false
   */
  private boolean validateName( String Name){
    if (this == Name)
      return true;
    return false;
  }

  //  validateName(name: String): boolean
  public static void main(String[] args) {

  }
}
