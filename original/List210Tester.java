package original;

/**
 * Class tests any List210
 * Note: Improve so it only prints on error (maybe)
 * @author Prof Bill
 */
public class List210Tester {
    static int numErrors = 0;
  
    /**
     * Run diagnostic tests on a List210.
     * @param theList The list being tested. If null, then an error is printed.
     */
    public static int runDiagnostics( List210 theList) {
      // if list is null, print error message and return
      if( theList == null) {
        System.out.println( "  ~~> No diagnostic tests run; theList is null!");
        return 1;
      }
  
      numErrors = 0; // reset to get started
  
      // A. test empty list
      theList.clear();
      zap( theList.isEmpty(), "A1");
      zap( theList.numItems() == 0, "A2");
      //zap( theList.getFirst() == null, "A3");
      //zap( theList.getLast() == null, "A4");
  
      // B. test addToEnd
      theList.addToEnd( "Bill");
      theList.addToEnd( "Luis G");
      zap( ! theList.isEmpty(), "B1");
      zap( theList.numItems() == 2, "B2");
      zap( theList.getFirst().equals("Bill"), "B3");
      zap( theList.getLast().equals( "Luis G"), "B4");
  
      // C. test addToBeginning, get(str), and get(i)
      theList.clear();
      theList.addToBeginning("Bulls");
      theList.addToBeginning("Blackhawks");
      theList.addToBeginning("Bears");
      zap( theList.getFirst().equals( "Bears"), "C1");
      zap( theList.get(1).equals( "Bears"), "C2"); //1 is Blackhawks not Bears
      zap( theList.getLast().equals( "Bulls"), "C3");
      zap( theList.get(3).equals( "Bulls"), "C4"); //is 3 should be get(2)
  
      // D. test reverse
      theList.clear();
      theList.addToEnd( "Bill");
      theList.addToEnd( "Luis G");
      theList.addToEnd( "Vinny K");
      theList.addToEnd( "Brennan S");
      theList.addToEnd( "Zach S");
      zap( theList.numItems() == 5, "D1");
      zap( theList.get(3).equals( "Vinny K"), "D2");// 3 is Brennan S not VinnyK
      theList.reverse();
      zap( theList.numItems() == 5, "D3"); 
      zap( theList.getFirst().equals( "Zach S"), "D4");
      zap( theList.getLast().equals( "Bill"), "D5");
      zap( theList.get(3).equals( "Vinny K"), "D6"); // 3 is Luis G not Vinny K
  
      // E. test remove(i), remove(str)
      boolean flag = false;
      theList.clear();
      flag = theList.remove(1); // should fail, return false
      zap( !flag, "E1"); 
      flag = theList.remove( "Missing"); // should fail, return false
      zap( !flag, "E2");
      theList.addToEnd( "Frank");
      theList.addToEnd( "Dean");
      theList.addToEnd( "Sammy");
      theList.remove(3); 
      zap( theList.getLast().equals( "Dean"), "E3");
      theList.remove( "Frank");
      zap( theList.numItems() == 1, "E4");
      flag = theList.get( "Dean");
      zap( flag, "E5");
  
      return numErrors;
    }
  
    /**
     * Zap show results of one test, printing only if there's an error.
     * @param testResult The result of the test; false means failure.
     * @param errorID A string ID of the test that failed.
     */
    private static void zap( boolean testResult, String errorID) {
      if( !testResult) {
        numErrors++;
        System.out.println( "  ~~> ZAP! Error at test #" + errorID);
      }
    }
  

    public static void main(String[] args){
        List210 testing = new EList();
        runDiagnostics(testing);

    }
}
