package src.src.demoEX.tutorial.tute01_2;
import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

import java.util.Objects;

import static utils.OptType.Mutator;

/**
 * @overview
 *  manName
 * model
 * @attributes
 * manName      String
 * model       String
 * color       Character
 * year        Integer       int
 * guaranteed    Boolean
 * @object A typical MobilePhone is <N, m, c,y,g>  where manName(N), model(m),
 *  color(c) ,year(y),guaranteed(g).
 * @abstract_properties
 *  mutable(manName)=false /\ optional(manName) =false /\ length(manName)=30
 *  mutable(model)=false /\ optional(model) =false /\ length(manName)=50
 *     model =M-ABC-MNP
 *     model [0,1] ="M-"
 *      for all  c in model [2,4], is Leetter(c)
 *      for all c in midel [6.8], numeric(c)
 *  mutable(color)=true /\ optional(color) =false /\ length(manName)=1
 *  mutable(year)=false /\ optional(year) =false /\ min(year)=1876
 *  mutable(guaranteed )= true /\ optional(guaranteed ) =true
 * @author Duc Minh Le (ducmle)
 *
 * @version
 */
public class MobilePhone {
    // object represention
    @DomainConstraint(mutable=false,optional=false,min=1)
    private String manName;
    // TODO: domain constraint
    @DomainConstraint(mutable=false,optional=false,min=1)
    private String model;
    private  Character color;
    private int year;
    private boolean guaranteed;
    /**
     * @effects
     *  if N, m are valid
     *    initialise this as <N, m>
     *  else
     *    throws NotPossibleException
     */
    public MobilePhone(
            @AttrRef("manName") String N ,
            @AttrRef("model") String m,
            @AttrRef("color") Character c)
            throws NotPossibleException {
        //
    }
    /**
     * @effects
     *   if manName is valid
     *     set this.manName = manName
     *     return true
     *   else
     *     return false
     */
    @DOpt(type= Mutator) @AttrRef("manName")
    public boolean setmanName(String manName) {
        return true;
        return false;
    }
    //  setmodel(model: String)
    public  String getModel(){
        return model;
    }
    // setcolor(color: Character)
    public  Character getColor(){
        return  color;
    }
    //  setyear(year: Integer (int))
    public  int getYear(){
        return year;
    }
    //  setGuaranteed(guaranteed: Boolean)
    public boolean isGuaranteed() {
        return guaranteed;
    }
    p


    @Override
    public String toString() {
        return "MobilePhone{" +
                "manName='" + manName + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                ", year=" + year +
                ", guaranteed=" + guaranteed +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilePhone that = (MobilePhone) o;
        return year == that.year && guaranteed == that.guaranteed && Objects.equals(manName, that.manName) && Objects.equals(model, that.model) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manName, model, color, year, guaranteed);
    }
    /**
     * @effects
     *  if this is valid
     *    return true
     *  else
     *    return false
     */
    public boolean repOK() {
        //TODO
        if ()
            return true;
        return false;
    }
    /**
     * @effects
     *  if manName is valid
     *    return true
     *  else
     *    return false
     */
    private boolean validatemanName(String manName) {
        return true;
        return false;
    }
    /**
     * @effects
     *  if manName is valid
     *    return true
     *  else
     *    return false
     */
    private boolean validatemodel(String model){
        if (this == model)
            return true;
        return false;
    }

    public static void main(String[] args) {

    }

}


