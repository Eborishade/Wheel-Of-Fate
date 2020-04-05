/**
 * @since April 1, 2020 
 * @author Emmanuel Borishade
 * 
 * Program Description: Button Setup for WheelGUI
 * 
 * Program Objective: 
 * Create and implement all Buttons here
 * return buttons in related groups/frames 
 *
 */
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.event.EventHandler;

public class CustomButtons{

    TilePane mutatorButtons; //buttons that change the wheel
    TilePane accessorButtons; //buttons that return data from wheel
    TextArea textBox; 
  
    /**
     * ctor, initialize main elements, call initAll to initialize buttons
     * @param Wheel w
     * @param CustomPie pie
     */
    public CustomButtons(original.Wheel w, CustomPie pie){
        ButtonJobs.setWheel(w);
        mutatorButtons = new TilePane();
        accessorButtons = new TilePane();
        textBox = new TextArea();
        initAll(ButtonJobs.getWheel(), pie, mutatorButtons, accessorButtons);
    }
    

    //Return Methods 

    /**
     * Returns Pane containing all mutator buttons
     * @return TilePane mutatorButtons
     */
    public TilePane getMutatorData(){
        return mutatorButtons;
    }
    
    /**
     * Returns Pane containing all accessor buttons
     * @return TilePane assessorButtons
     */
    public TilePane getAccessorData(){
        return accessorButtons;
    }

    /**
     * Returns Pane containing a Text Area
     * @return TextArea textBox
     */
    public TextArea getTextData(){
        return textBox;
    }


    //Private Methods
    
    /**
     * Initializes and passes all Button methods 
     * @param Wheel wheel
     * @param CustomPie pie
     * @param TilePane mutatePane
     * @param TilePane accessPane
     */
    private void initAll(original.Wheel wheel, CustomPie pie, TilePane mutatePane, TilePane accessPane){
        //Initialize Buttons

        add(mutatePane, pie); 
        name(mutatePane);

        print(accessPane);
        size(accessPane);
        first(accessPane);
        last(accessPane);
        random(accessPane);
        spin(accessPane, pie);

        reload(mutatePane, pie);
        reverse(mutatePane, pie);
        clear(mutatePane, pie);

        //Initialize Exit button; does not need separate method

        //How to Create Button: https://www.geeksforgeeks.org/javafx-button-with-examples/
        //mouse Events: http://java-buddy.blogspot.com/2015/02/javafx-detect-right-click-on-mouse.html
        Button exitButton = new Button("Exit");
        exitButton.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
            public void handle(MouseEvent e) 
            { 
                System.exit(0);
            }
        }); 

       
        //Pass buttons to frames; frames will be passed to main GUI using .getData() 
        //note: multiple pass functions may be neccissary depending on frame layouts...

        mutatePane.getChildren().add(exitButton);
    }


    //Button Methods

    /*
    note: Due to now resolved error (see buttonJobs line 24), ButtonJobs.setWheel & .getWheel was used to pass wheel to methods.
    Although error requiring this has been resolved, passing wheel to each method would be inefficient,
    so ButtonJobs.getWheel will still be used.
    */


    //These methods create an AlertBox

    /**
     * Add item to wheel 
     * @param TilePane pane
     * @param CustomPie pie
     */
    private void add(TilePane pane, CustomPie pie){
        Button addButton = new Button("Add");
        addButton.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
            public void handle(MouseEvent e) 
            {   
                //use class buttonjobs to display a box for user input, add item to wheel, return wheel 
                ButtonJobs.add(ButtonJobs.getWheel());
                
                //Refresh Pie items - PieChart class is Observable, reset may be unnecessary, but still nice effect 
                String wheelItems = ButtonJobs.getWheel().print();
                String[] items = wheelItems.split(",");
                pie.reset(items);
            } 
        });   
        pane.getChildren().add(addButton);
    }

    /**
     * Change the Name of the Wheel
     * @param TilePane pane
     */
    private void name(TilePane pane){
        Button nameButton = new Button("Name");
        nameButton.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
            public void handle(MouseEvent e) 
            { 
                ButtonJobs.name(ButtonJobs.getWheel()); 
            } 
        }); 
        pane.getChildren().add(nameButton);
    }


    //These methods use a TextBox

    /**
     * Return all items in Wheel through TextBox
     * @param TilePane pane
     */
    private void print(TilePane pane){
        Button printButton = new Button("Print");
        printButton.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
            public void handle(MouseEvent e) 
            { 
                //Will return wheel.print as text in TextBox
                textBox.setText( ButtonJobs.print(ButtonJobs.getWheel()) );
            } 
        }); 
        pane.getChildren().add(printButton);
    }

    /**
     * Return number of items in Wheel through TextBox
     * @param TilePane pane
     */
    private void size(TilePane pane){
        Button sizeButton = new Button("Size");
        sizeButton.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
            public void handle(MouseEvent e) 
            { 
                textBox.setText( ButtonJobs.size(ButtonJobs.getWheel()) );
            } 
        }); 
        pane.getChildren().add(sizeButton);
    }
 
    /**
     * Return first item in Wheel through TextBox
     * @param TilePane pane
     */
    private void first(TilePane pane){
        Button firstButton = new Button("First item");
        firstButton.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
            public void handle(MouseEvent e) 
            { 
                textBox.setText( ButtonJobs.first(ButtonJobs.getWheel()) );
            } 
        }); 
        pane.getChildren().add(firstButton);
    }
 
    /**
     * Return last item in Wheel through TextBox
     * @param TilePane pane
     */
    private void last(TilePane pane){
        Button lastButton = new Button("Last item");
        lastButton.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
            public void handle(MouseEvent e) 
            { 
                textBox.setText( ButtonJobs.last(ButtonJobs.getWheel()) );   
            } 
        }); 
        pane.getChildren().add(lastButton);
    }

    /**
     * Return random item in Wheel through TextBox
     * @param TilePane pane
     */
    private void random(TilePane pane){
        Button randomButton = new Button("Random item");
        randomButton.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
            public void handle(MouseEvent e) 
            { 
                textBox.setText( ButtonJobs.random(ButtonJobs.getWheel()) );
            } 
        }); 
        pane.getChildren().add(randomButton);
    }

    /**
     * Spin the wheel and return random item in Wheel
     * @param TilePane pane
     * @param CustomPie pie
     */
    private void spin(TilePane pane, CustomPie pie){
        Button spinButton = new Button("Spin Wheel");
        spinButton.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
            public void handle(MouseEvent e) 
            {
                //rotate
                pie.rotate(5);//rotate 360, 5 timess

                //return item
                textBox.setText( ButtonJobs.spin(ButtonJobs.getWheel()) );
                
                //Refresh Pie 
                String wheelItems = ButtonJobs.getWheel().print();
                String[] items;
                if (wheelItems == null){
                    items = null;
                } else {
                    items = wheelItems.split(",");
                }
                pie.reset(items);
            } 
        }); 
        pane.getChildren().add(spinButton);
    }


    //These Methods Directly Modify Wheel

    /**
     * Roll back wheel to before last spin/clear/reverse
     * @param TilePane pane
     * @param CustomPie pie
     */
    private void reload(TilePane pane, CustomPie pie){
        Button reloadButton = new Button("Reload Wheel");
        reloadButton.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
            public void handle(MouseEvent e) 
            { 
                ButtonJobs.reload(ButtonJobs.getWheel());

                //Refresh Pie 
                String wheelItems = ButtonJobs.getWheel().print();
                String[] items = wheelItems.split(",");
                pie.reset(items);
            } 
        }); 
        pane.getChildren().add(reloadButton);
    }
 
    /**
     * Reverse order of items in wheel
     * @param TilePane pane
     * @param CustomPie pie
     */
    private void reverse(TilePane pane, CustomPie pie){
        Button reverseButton = new Button("Reverse Output");
        reverseButton.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
            public void handle(MouseEvent e) 
            { 
                ButtonJobs.reverse(ButtonJobs.getWheel());

                //Refresh 
                String wheelItems = ButtonJobs.getWheel().print();
                String[] items = wheelItems.split(",");
                pie.reset(items);
            } 
        }); 
        pane.getChildren().add(reverseButton);
    }

    /**
     * Clear wheel of all items
     * @param TilePane pane
     * @param CustomPie pie
     */
    private void clear(TilePane pane, CustomPie pie){
        Button clearButton = new Button("Clear");
        clearButton.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
            public void handle(MouseEvent e) 
            { 
                ButtonJobs.clear(ButtonJobs.getWheel());

                //Refresh pie items
                String wheelItems = ButtonJobs.getWheel().print();
                String[] items = wheelItems.split(",");
                pie.reset(items);
            }
        }); 
        pane.getChildren().add(clearButton);
    }
 
}
