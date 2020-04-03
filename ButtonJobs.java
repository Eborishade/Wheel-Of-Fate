/**
 * @since April 1, 2020 
 * @author Emmanuel Borishade
 * 
 * Program Description: Actual Declaration of Buttons
 * 
 * Program Objective: 
 * Declare all Buttons here
 * 
 * Note: Because Everything in this class is static,
 *   wheel will need to be passed into each method. 
 *   
 */
import java.util.Optional;
import javafx.scene.control.TextInputDialog;

public class ButtonJobs{

    private static original.Wheel returnWheel = null; //wheel to be set and returned
    /*
      These variables will be used to get around "var defined in enclosing scope must be final" error.
      By passing the wheel returned from any one of the methods back into button jobs, it becomes accessable
      outside of the Event/enclosing scope. 
      see ~line 98 in CustomButtons.java under "Add Button"
      see ~line 117 in CustomButtons.java under "Print Button"
    */


    /**
     * Set the value/pointer of the Wheel object to be used in getWheel
     * @param Wheel w
     */
    public static void setWheel(original.Wheel w){
        returnWheel = w;
    }


    /**
     * Return the current Wheel Object
     * @param Wheel w
     */
    public static original.Wheel getWheel(){
        return returnWheel;
    }


    /**
     * Adds item to Wheel Object
     * @param Wheel w
     */
    public static void add(original.Wheel w){
        //open text box
        //Text field: https://www.geeksforgeeks.org/javafx-textfield/
        //Text Input Dialog: https://code.makery.ch/blog/javafx-dialogs-official/

        TextInputDialog dialog = new TextInputDialog("Add Item");
        dialog.setTitle("Add Item to Wheel");
        dialog.setHeaderText("Add an Item to: "+ButtonJobs.getWheel().getName());
        
        //get user input
        dialog.setContentText("Please enter item:");
        Optional<String> result = dialog.showAndWait();

         //add userinput to wheel
        if (result.isPresent()){
            w.add( result.get() );
        }
    }


    /**
     * Rename Wheel 
     * @param Wheel w
     */
    public static void name(original.Wheel w){

        TextInputDialog dialog = new TextInputDialog("Name Wheel");
        dialog.setTitle("Name Your Wheel");
        dialog.setHeaderText("Name Your Wheel");
        
        //get user input
        dialog.setContentText("Please enter a Name for Wheel:");
        Optional<String> result = dialog.showAndWait();

         //add userinput to wheel
        if (result.isPresent()){
            w.setName( result.get() );
        }
    }


    /**
     * Return all items in Wheel as String
     * @param Wheel w
     * @return String returning
     */
    public static String print(original.Wheel w){
        //return all wheel items
        String returning = w.print();
        
        return returning; 
    }


    /**
     * Return number of items in Wheel as String
     * @param Wheel w
     * @return String returning
     */
    public static String size(original.Wheel w){
        //return wheel size
        String returning = Integer.toString(w.size());
        
        return returning; 
    }


    /**
     * Return first item in Wheel as String
     * @param Wheel w
     * @return String returning
     */
    public static String first(original.Wheel w){
        //return first item in wheel
        String returning = w.first();
        
        return returning; 
    }


    /**
     * Return last item in Wheel as String
     * @param Wheel w
     * @return String returning
     */
    public static String last(original.Wheel w){
        //return last item in wheel
        String returning = w.last();
        
        return returning; 
    }


    /**
     * Return random item in Wheel as String
     * @param Wheel w
     * @return String returning
     */
    public static String random(original.Wheel w){
        //return random item in wheel
        String returning = (String) w.random();
        
        return returning; 
    }


    /**
     * Spin wheel and return random item in Wheel 
     * @param Wheel w
     * @return String returning
     */
    public static String spin(original.Wheel w){
        //spin wheel: returns random, deletes item. undone by reload.
        String returning = w.spin();

        return returning;
    }


    /**
     * 
     * Roll back wheel to before last spin/clear/reverse
     * @param Wheel w
     */
    public static void reload(original.Wheel w){
        w.reload();
    }


    /**
     * Reverse order of items in Wheel
     * @param Wheel w
     */
    public static void reverse(original.Wheel w){
        //reverse items in wheel
        w.reverse();
    }
    

    /**
     * Delete all items from Wheel
     * @param Wheel w
     */
    public static void clear(original.Wheel w){
        w.clear();
    }

}