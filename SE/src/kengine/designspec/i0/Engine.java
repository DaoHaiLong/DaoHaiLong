package src.kengine.designspec.i0;

/**
 * @overview ...(omitted)...
 * @version (iteration) 0
 */
class Engine {

  /**
   * @effects If the uninteresting words not retrievable
   * throws NotPossibleException
   * else
   * creates NonKeyword and initialises the app. state appropriately
   */
  Engine() throws utils.NotPossibleException {

  }

  /**
   * @effects 
   *  If WORD(w) = false or w in NonKeyword 
   *    throws NotPossibleException
   *  else 
   *    sets Keyword = {w}, performs the new query, and returns the result 
   */
  kengine.version1.Query queryFirst(String w) throws utils.NotPossibleException

  /**
   * @effects 
   *  If WORD(w) = false or w in NonKeyword or Key = {} or w in Keyword 
   *    throws NotPossibleException 
   *  else 
   *    add w to Keyword and returns the query result 
   */
  kengine.version1.Query queryMore(String w) throws utils.NotPossibleException
  
  /**
   * @effects 
   *  If t not in Title throws NotPossibleException
   *  else returns the document with title t 
   */
  kengine.version1.Doc findDoc (String t) throws utils.NotPossibleException
    
  /**
   * 
   * @effects 
   *  If u is not a URL for a site containing documents or u in URL 
   *    throws NotPossibleException 
   *  else adds the new documents to Doc.
   *    If no query was in progress 
   *      returns the empty query result 
   *    else
   *      returns the query result that includes any matching new documents
   */
  kengine.version1.Query addDocs(String u) throws utils.NotPossibleException
} // end Engine
