package a2_BA9_041.Studentman;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import a2_BA9_041.kengine.Doc;
import a2_BA9_041.kengine.DocCnt;
import a2_BA9_041.kengine.Engine;
import a2_BA9_041.kengine.Query;
import utils.DomainConstraint;
import utils.NotPossibleException;

/**
 * @overview 
 *   Represents a worksheet program that enables a user to create student objects, 
 *   display a report about them, and to search for objects of interest using keywords.
 * 
 * @attributes
 *   objects    TreeSet<Student>
 *   engine     Engine
 *   
 * @abstract_properties
 *   mutable(objects)=true /\ optional(objects)=false /\
 *   mutable(engine)=false /\ optional(engine)=false /\
 *   size(objects) > 0 -> 
 *     (for all o in objects: o.toHtmlDoc() is in engine)
 * @author dmle
 */
public class ProgStudentMan {
  @DomainConstraint(mutable=true,optional=false)
  private TreeSet<Student> objects;
  @DomainConstraint(mutable=false,optional=false)
  private Engine engine;

  private static final Scanner inputScanner = new Scanner(System.in);
  private final static String[] EmptyArr = {};
  
  /**
   * @effects 
   *   initialise a ProgStudentMan
   *   ask the users to create Student objects and display a report
   *   ask the users to perform a keyword search and display a report
   */
  public static void main(String[] args) {
    // initialise a ProgStudentMan
    System.out.println("Initialising program...");
    ProgStudentMan studentMan = new ProgStudentMan();
    
    try {
      // create some student objects 
      studentMan.manageStudents();

      if (!studentMan.isEmpty()) {
        // do search
        studentMan.manageSearching();        
      }
      
      // end
      System.out.println("\nGood bye.");
    } catch (NotPossibleException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
  
  /**
   * @effects 
   *  Prompt user to input student type and then prompt to enter data to create a student.
   *  Repeat this until no more objects are needed.  
   *  Add the created objects to this.    
   *  Invoke displayReport to display a report about them.
   */
  private void manageStudents() {
    System.out.println("\n* Student Manager *\n");
    while (true) {
      // prompt for student type
      String type = promptForStudentType();
      if (type == null) break;
      
      // prompt for data
      Object[] data = promptForData(type);
      if (data == null) break;
      
      // add to this
      try {
        Student c = null;
        switch(type) {
          case "s":
            c = createStudent(data); break;
          case "u":
            c = createUndergradStudent(data); break;
          case "p":
            c = createPostgradStudent(data); break;
          default:
            System.out.println("Invalid student type: " + type);
        }
        
        if (c != null) {
          addStudent(c);
          // print message
          System.out.println("Added: " + c);
        }
      } catch (NotPossibleException e) {
        e.printStackTrace();
      }
    }
    
    // display a report about the objects
    displayReport();
  }

  /**
   * @effects 
   *  prompt user to input the student type, which can be one one of these:
   *  "s" (student), "u" (undergraduate), "p" (postgraduate) or "c" (cancel)
   *  if input is not valid
   *    prompt again
   *  else if input == "c"
   *    return null
   *  else 
   *    return input
   */
  private String promptForStudentType() {
    while(true) {
      System.out.println("Choose type: [s]udent/[u]ndergraduate/[p]ostgraduate/[C]ancel? ");
      String input = inputScanner.nextLine();
      input = input.trim().toLowerCase();
      if (input.equals("c")) {
        return null;
      } else if (input.equals("s") || 
          input.equals("u") || 
          input.equals("p")) {
        return input; 
      } 
      
      // invalid input: prompt again
    } 
  }
  
  /**
   * @effects 
   *  prompt user to input data suitable for the student typed <tt>type</tt>
   *  return the data as Object[].
   */
  private Object[] promptForData(String type) {
    boolean postgrad = false;
    if (type.equalsIgnoreCase("p")) postgrad = true;
    // prompt for student details
    
    int id; 
    String name, phone, address;
    
    System.out.println("Enter student id: ");
    id = inputScanner.nextInt();
    if (inputScanner.hasNextLine()) inputScanner.nextLine();
    
    System.out.println("Enter student name: ");
    name = inputScanner.nextLine();
    
    System.out.println("Enter student phone number: ");
    phone = inputScanner.nextLine();
    
    System.out.println("Enter student address: ");
    address = inputScanner.nextLine();
    
    if (postgrad) {
      // prompt for income to create HighEarner
      System.out.println("Enter gpa: ");
      float gpa = inputScanner.nextFloat();
      
      return new Object[] {id, name, phone, address, gpa};
    } else {
      return new Object[] {id, name, phone, address};
    }
  }
  
  /**
   * @modifies  System.out
   * @effects   
   *    if this is empty
   *      prints "No students"
   *    else
   *      prints each object in this.objects one per line to the standard output
   */
  private void displayReport() {
    if (isEmpty()) {
      System.out.println("No students");
    } else {
      System.out.println("\nDisplaying student report (sorted by name)...");       
      
      String textReport = toString();
      System.out.println(textReport);
    }
  }
  
  /**
   * @modifies System.out
   * @effects 
   *   (1) invoke promptForKeywords() to prompt the user to enter one or more keywords
   *     if keywords were entered
   *       invoke search(String[]) to search using keywords,
   *       if fails to execute the query
   *         throws NotPossibleException 
   *       else
   *         invoke displaySearchReport to display search result to the standard output.
   *     else if user wanted to cancel
   *       return
   *     else
   *       repeat from (1)
   */
  private void manageSearching() {
    System.out.println("\n* Search Manager *\n");

    String[] keywords;
    do {
      //   prompt the user to enter one or more keywords (separated by spaces)
      keywords = promptForKeywords();
  
      if (keywords != null && keywords.length > 0) { // keywords were entered
        System.out.println("\nSearching for students using keywords: " + Arrays.toString(keywords));
       
        //   invoke operation search(String[]) to search using these keywords
        try {
          Query q = search(keywords);
  
          //   print the query string to the standard output
          displaySearchReport(q);
        } catch (NotPossibleException e) {
          e.printStackTrace();
        }
      }
    } while (keywords != null);
  }
    
  /**
   * @effects 
   *   prompt the user to enter some keywords or to cancel.
   *   If some keywords were entered
   *    return them as <tt>String[]</tt>
   *   else if user wanted to cancel
   *    return null
   *   else
   *    return an empty array
   */
  private String[] promptForKeywords() {
    System.out.println("Enter some keywords (separated by spaces) or 'C' to cancel: ");
    String s = inputScanner.nextLine();
    s.trim();
    if (s.length()==0 ) {
      return EmptyArr;
    } if (s.equalsIgnoreCase("C")) {
      return null;
    } else {
      return s.split(" ");
    }
  }
  
  /**
   * @requires q neq null
   * @effects 
   *  if q has no matches
   *    print "(empty)"
   *  else
   *    print q's matches (one per line) to the standard output
   */
  private void displaySearchReport(Query q) {
    // get matches
    Iterator matches = q.matchIterator();

    // write header
    System.out.println("Query: " + Arrays.toString(q.keys()));
    System.out.println("Matches:");
    if (matches == null) {
      System.out.println("(empty)");
    } else {
      int col1Len = 0;
      while (matches.hasNext()) {
        DocCnt m = (DocCnt) matches.next();
        String t = m.getDoc().title();
        if (t.length() > col1Len) col1Len = t.length();
      }

      int col2Len = "Sum freqs".length();
      StringBuffer hr = new StringBuffer();
      for (int i = 0; i < col1Len + col2Len + 3; i++) hr.append("-");
      String rowFormat = "%-"+col1Len+"s | %s%n";
      System.out.println(hr);
      System.out.printf(rowFormat, "Documents", "Sum freqs");
      System.out.println(hr);
      matches = q.matchIterator();
      
      DocCnt m;
      while (matches.hasNext()) {
        m = (DocCnt) matches.next();
        System.out.printf(rowFormat, m.getDoc().title(), m.getCount());
      }
      
      System.out.println(hr);
    }
  }
  
  /**
   * @effects
   *  if isEmpty() then 
   *    return null
   *  else
   *    return Iterator(Comparable) of the elements in objects 
   */
  public Iterator<?extends Comparable> objectIterator() {
    if (isEmpty())
      return null;
    else
      return objects.iterator();
  }
  
  /**
   * @effects
   *  if isEmpty()
   *    return null
   *  else
   *    return Iterator(Doc) of documents stored in engine
   */
  public Iterator<Doc> docIterator() {
    if (isEmpty())
      return null;
    else
      return engine.docIterator();
  }
  
  /**************************************************************
   * ABOVE THIS LINE ARE GIVEN CODE. STUDENTS SHOULD READ THE SPECS 
   * BUT MUST NOT CHANGE ANYTHING!
   * ------------------------------------------------------------
   * BELOW THIS LINE ARE CODE THAT MUST BE COMPLETED BY STUDENTS.
   **************************************************************/
    
  /**
   * @effects 
   *   initialise this to include an empty set of objects and an empty engine
   */
  public ProgStudentMan() {
	  objects =new TreeSet<Student>();
      engine = new Engine();
  }
  
  /**
   * @effects
   *   if objects is empty
   *     return "empty"
   *   else
   *     return a string containing each object in this.objects one per line
   */
  @Override
  public String toString() {
	  StringBuffer sb = new StringBuffer();
		if (this.objects == null || this.objects.isEmpty()) {
			sb.append("empty");
		} 
		else {
			Iterator<Student> iterator = this.objects.iterator();
			while (iterator.hasNext()) {
				Student c = iterator.next();
				sb.append(c.toString()).append("\n");
			}
		}
		return sb.toString();		
  }
  

  /**
   * @effects 
   *  if objects is empty 
   *    return true
   *  else
   *    return false
   */
  public boolean isEmpty() {
	  if(this.objects.isEmpty()) {
		  return true;
	  }
	  return false;
  }
  
  /**
   * @requires 
   *  data contain id, name, phone, and address values (in that order)
   * @effects 
   *  if data contain valid values for Student
   *    create and return a Student object from the data
   *  else
   *    throws NotPossibleException 
   */
  public Student createStudent(Object[] data) throws NotPossibleException{
   
	@SuppressWarnings("resource")
    Scanner stu = new Scanner(System.in);
   Student c=null;
   int id;
   String name, phoneNumber, address;

   System.out.println("Enter id: ");
   id = stu.nextInt();

   stu = new Scanner(System.in);
   System.out.println("Enter name: ");
   name = stu.nextLine();

   stu = new Scanner(System.in);
   System.out.println("Enter phoneNumber: ");
   phoneNumber = stu.nextLine();

   stu = new Scanner(System.in);
   System.out.println("Enter address: ");
   address = stu.nextLine();
   
   c = new Student(id, name, phoneNumber, address);
   return c;
  }
  /**
   * @requires 
   *  data contain id, name, phone, and address values (in that order)
   * @effects 
   *  if data contain valid values for UndergradStudent
   *    create and return a UndergradStudent object from the data
   *  else
   *    throws NotPossibleException 
   */
  public UndergradStudent createUndergradStudent(Object[] data) throws NotPossibleException{
	  @SuppressWarnings("resource")
	    Scanner uds = new Scanner(System.in);
	  UndergradStudent c=null;
	   int id;
	   String name, phoneNumber, address;

	   System.out.println("Enter id: ");
	   id = uds.nextInt();

	   uds = new Scanner(System.in);
	   System.out.println("Enter name: ");
	   name = uds.nextLine();

	   uds = new Scanner(System.in);
	   System.out.println("Enter phoneNumber: ");
	   phoneNumber = uds.nextLine();

	   uds = new Scanner(System.in);
	   System.out.println("Enter address: ");
	   address = uds.nextLine();
	   
	   c = new UndergradStudent(id, name, phoneNumber, address);
	   return c;
  }
  
  
  /**
   * @requires 
   *  data contain id, name, phone, address, and gpa values (in that order)
   * @effects 
   *  if data contain valid values for PostgradStudent
   *    create and return a PostgradStudent object from the data
   *  else
   *    throws NotPossibleException 
   */
  public PostgradStudent createPostgradStudent(Object[] data) throws NotPossibleException{
	  @SuppressWarnings("resource")
	  Scanner pgs = new Scanner(System.in);
	  PostgradStudent c =null;
	  int id;
	   String name, phoneNumber, address;
      float gpa;
	   System.out.println("Enter id: ");
	   id = pgs.nextInt();

	   pgs = new Scanner(System.in);
	   System.out.println("Enter name: ");
	   name = pgs.nextLine();

	   pgs = new Scanner(System.in);
	   System.out.println("Enter phoneNumber: ");
	   phoneNumber = pgs.nextLine();

	   pgs = new Scanner(System.in);
	   System.out.println("Enter address: ");
	   address = pgs.nextLine();
	   
	   pgs = new Scanner(System.in);
	   System.out.println("Enter gpa: ");
	   gpa =pgs.nextFloat();
	   
	   c = new  PostgradStudent(id, name, phoneNumber, address,gpa);
	  
	   return c;
  }
  
  /**
   * @effects 
   *   add c to this.objects and 
   *   add to this.engine a Doc object created from c.toHtmlDoc
   */
  public void addStudent(Student c) {
	  this.objects.add(c);
      this.engine.addDoc(new Doc(c.toHtmlDoc()));
  }
  
  /**
   * @requires words != null /\ words.length > 0
   * @effects 
   *   search for objects whose HTML documents match with the query containing words
   *   and return a Query object containing the result
   *   
   *   If fails to execute query using words
   *     throws NotPossibleException
   */
  public Query search(String[] words) throws NotPossibleException {
	  Query q = null;
		try {
			q = this.engine.queryFirst(words[0]);
			for (int i = 1; i < words.length; i++) {
				q = this.engine.queryMore(words[i]);
			}
		} 
		catch (NotPossibleException e) {
			throw new NotPossibleException(e.getMessage());
		}
	  return q;
 }
}