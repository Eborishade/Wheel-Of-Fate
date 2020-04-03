package original;

/**
 * @since Jan 29, 2020 
 * @author Emmanuel Borishade
 * 
 * Program Description: Wheel of Fate, runs Wheel
 * 
 * Program Objective: 
 * Create and run a Wheel
 * wheel contains items (strings)
 * wheel can spin, return, remove, etc 
 * 
 * see //Rules under //main program for list of commands
 */
import java.util.Scanner;

public class WheelOfFate{
 public static void main(String[] args){

  String command = "null";
  Scanner scan = new Scanner(System.in);
  Wheel wheel = new Wheel();


  System.out.println("Wheel Of Fate.");
  System.out.println("Initiating...");


  //main program 
  while(command.equals("exit") == false){
    //Rules
    System.out.println(wheel.getName());
    System.out.println("Available commands:");
    System.out.println("add <item>    | Add item to wheel at end of list");
    System.out.println("name <wheel>  | name wheel ");
    System.out.println("print         | print wheel items in order");
    System.out.println("size          | print number of items in wheel");
    System.out.println("first         | print first item in wheel");
    System.out.println("last          | print last item in wheel");
    System.out.println("random        | print random item in wheel");
    System.out.println("spin          | spin wheel, show special effects, select item at random, remove it, show item");
    System.out.println("reload        | reload wheel; undo spin, reverse, clear");
    System.out.println("reverse       | reverse item order in wheel");
    System.out.println("clear         | clear all items from wheel");
    System.out.println("exit          | exit program");
    //How to
    System.out.println("\nHow to Use:");
    System.out.println("First Enter a command (all lowercase).\nAfter confirmation, enter parameters if neccissary.");


    //Begin
    System.out.print("\nEnter a command >> ");
    command = scan.next();
    
    //add
    if ( command.equals("add") ){
      System.out.println("Description: Add item to wheel at end of list.");
      System.out.print("Enter parameter (single word) >> ");
      String param = scan.next();

      wheel.add(param);
      System.out.println("Confirmed.");
    }
    
    //name
    if ( command.equals("name") ){
      System.out.println("Description: name the wheel");
      System.out.print("Enter parameter (single word) >> ");
      String name = scan.next();

      wheel.setName(name);
      System.out.println("Confirmed.");
    }

    //print
    if ( command.equals("print") ){
      System.out.println("Confirmed. \n printing...");
      System.out.println(wheel.print());
    }

    //size
    if ( command.equals("size") ){
      System.out.println("Confirmed.");
      System.out.println("Number of Items in Wheel: " +wheel.size());
    }

    //first
    if ( command.equals("first") ){
      System.out.println("Confirmed.");
      System.out.println("First Item in List: " +wheel.first());
    }

    //last
    if ( command.equals("last") ){
      System.out.println("Confirmed.");
      System.out.println("Last Item in List: " +wheel.last());
    }

    //random  
    if ( command.equals("random") ){
      System.out.println("Description: print random item in wheel");
      System.out.println("Item in List: " +wheel.random());
    }

    //spin
    if ( command.equals("spin") ){
      System.out.println("Warning: To end spin, please type \"reload\" ");
      System.out.println("Spinning... ");
      System.out.println("Initiating special effects...");
      try{
        Thread.sleep(2000); //1000milliseconds = 1 second
      } catch (InterruptedException e){}

      System.out.println();
      System.out.println("            ___-------___                  ");
      System.out.println("         -                -                ");
      System.out.println("       -                    -              ");
      System.out.println("     -                        -            ");
      System.out.println("    |                          |           ");
      System.out.println("    |                          |           ");
      System.out.println("    |                          |           ");
      System.out.println("    |                          |           ");
      System.out.println("     -                        -            ");
      System.out.println("       -                     -             ");
      System.out.println("         -                 -               ");
      System.out.println("            ---_______---\n                ");

      try{
        Thread.sleep(2000); //1000milliseconds = 1 second
      } catch (InterruptedException e){}
      System.out.println("              "+wheel.spin());  

      try{
        Thread.sleep(2000); //1000milliseconds = 1 second
      } catch (InterruptedException e){}
    
    }

    //reverse
    if ( command.equals("reverse") ){
      System.out.println("Saving...");
      System.out.println("Reversing all items in list...");

      wheel.reverse();
      System.out.println("Confirmed");
    }
    
    //clear
    if ( command.equals("clear") ){
      System.out.println("Saving...");
      System.out.println("Deleting all items from list...");
      wheel.clear();
      System.out.println("Confirmed");

    }

    //reload
    if ( command.equals("reload") ){
      wheel.reload();
      System.out.println("Confirmed. reloading from last save...");
    }

    System.out.println("\n");
        

  }//end while 
  scan.close();


/*status: sucess!

add: works!
name: works!
print: works!
size: works!

first, last: works, fix crash on empty list
random: acceptable, no problems, but best when used with lists of size > 5. throws pointer exception if size > 2
spin: acceptable, could use more special effects 
reload: works! also works with reverse and clear! logic allows for potential to work with any command.
clear: works!
exit: works!


Grading Notes:

Overall:
  fix crash on empty list. 
    -see EList.java -> getFirst(), getLast(), get()
  add help() class 
  Boolean vs boolean


Wheel.java:
  private variables
  better javadocs
  fix spacing
  delete getList()


EList.java:
  update comments.
  better javadocs
    -see get(int i)
  rename l 
    -see EList(Elist l)







*/


 }
}