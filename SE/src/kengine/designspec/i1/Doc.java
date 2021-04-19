package src.kengine.designspec.i1;

/**
 * @overview ...(omitted)...
 *  
 * @author dmle
 *  
 * @version (iteration) 1.0
 */
class Doc {
  /**
   * @effects 
   *  If d cannot be processed as a document 
   *    throws NotPossibleException
   *  else makes this be the Doc corresponding to d  
   */
  Doc(String d) throws utils.NotPossibleException{}
  
  ///// END version 1.0
  
  /**
   * @effects returns the title of this 
   */
  String title(){
    return null;
  }

  /**
   * @effects returns the body of this
   */
  String body(){
    return null;
  }
} // end Doc
