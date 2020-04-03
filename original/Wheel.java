package original;

/**
 * @since Jan 29, 2020 
 * @author Emmanuel Borishade
 * 
 * Program Description: Wheel to be Spun 
 * 
 * Program Objective: 
 * Create a wheel that holds items 
 * Wheel can spin and returns items, removing them from wheel
 * requires a main
 * 
 * see javadocs for list of methods
 */
public class Wheel{
 
 private String name = "Wheel of Fate";
 EList list = new EList();
 EList backup; 
 Boolean spinning = false;
  
 
 public Wheel(){}
 //copy ctor using EList copy ctor
 public Wheel(Wheel w){
   list = new EList(list);
 }
   

 //mutators/modifiers
 /** 
  * @param n
  */
 public void setName(String n){
   name = n;
 }
   
 /** 
  * @param item
  */
 public void add(String item){
   list.addToEnd(item);
 }

 public void reverse(){
   if (list != null){
    backup = new EList(list);
    list.reverse();
   }
 }

 public void clear(){
   backup = new EList(list);
   list = new EList();
 }

 //can only be used after a reverse(), clear(), or spin()
 public void reload(){
   list = backup;
   spinning = false;
 }


 //accessors

 /** 
  * @return int
  */
 public int size(){
   if (list != null){
    return list.numItems();
   }
   return 0;
 }
   
 
 /** 
  * Return first item in Wheel
  * @return String
  */
 public String first(){
   if (list != null){
    return list.getFirst();
   }
   return "";
 }
   
 
 /** 
  * Return last item in Wheel
  * @return String
  */
 public String last(){
   if (list != null){
    return list.getLast();
   }
   return "";
 }
   
 
 /** 
  * Prints Wheel as String
  * @return String
  */
 public String print(){
   if (list == null){
     return "\n[Empty]";
   }

   if (list.isEmpty()){
      return "\n[Empty]";
   }
   return list.toString();
 }

 
 /** 
  * Returns Name of Wheel
  * @return String
  */
public String getName(){
   return name;
 }
   
 
 /** 
  * Returns random item in Wheel
  * @return String
  */
 public String random(){
   if (list != null){
    //range concept from: https://www.java67.com/2015/01/how-to-get-random-number-between-0-and-1-java.html
    int length = size();
    int random = (int)( Math.random()*(length-1) ); //generates a random number between 0 and the length of the list
    
    return list.get(random);
   }
   return "";
 }

 
 /** 
  * Returns all wheel name and all items as String
  * @return String
  */
 public String toString(){
   return name +"\n"+print(); 
 }

 
 /** 
  * Removes passed String item from Wheel
  * @param String item
  * @return Boolean
  */
 public Boolean remove(String item){
   if (list != null){
    Boolean removed = list.remove(item);

    return removed;
   }
   return false;
 }

 
 /** 
  * Removes String from passed location in Wheel
  * @param loc
  * @return Boolean
  */
 public Boolean remove(int loc){
   if (list != null){
    Boolean removed = list.remove(loc);

    return removed;
   }
   return false;
 }

 
 
 /** 
  * backup Wheel, return & delete random item from wheel
  * @return String
  */
 public String spin(){

   if (spinning == false){
      backup = new EList(list);
      spinning = true;
   }
   String item = random();
   Boolean removed = remove(item);

   if (removed){
      return item;
   } else {
      return "Error. Please spin again.";
   }
 }
 
 
}