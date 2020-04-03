
/**
 * @since April 1, 2020 
 * @author Emmanuel Borishade
 * 
 * Program Description: Wheel of Fate GUI
 * 
 * Program Objective: 
 * Create and run a Gui for custom Wheel object
 * wheel contains items (strings)
 * wheel can spin, return, remove, etc 
 * 
 * Sources:
 *  JavaFX outline:
 *      https://www.tutorialspoint.com/javafx/javafx_application.htm
 * 
 * Button Orientation/Positioning
 *      https://docs.oracle.com/javafx/2/layout/size_align.htm
 *      https://stackoverflow.com/questions/10028587/how-to-position-a-button-or-any-gui-element-in-a-javafx-scene
 */
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.geometry.*;

public class WheelGUI extends Application{
    public static void main(String args[]){
        launch(args);
    }

    /**
     * real "main" method; called in main.
     * Sets up all elements and runs.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //create a new Wheel, pass the items in the wheel to the Pie
        original.Wheel theWheel = new original.Wheel();//Wheel class in subfolder "original"
        String[] items = theWheel.print().split(",");
        CustomPie pie = new CustomPie(items); //custom graphical wheel class

        //Create buttons 
        CustomButtons b = new CustomButtons(theWheel, pie);

        //Pass Buttons, Pies, etc. to Panes 
        StackPane stackPie = new StackPane(pie.getData());
        TilePane mutateButtons = b.getMutatorData();
        TilePane accessButtons = b.getAccessorData();
        TextArea textBox = b.getTextData();
        Text title = new Text(200, 200, theWheel.getName());


        //Format Panes

        //Orientation/Positioning from: https://docs.oracle.com/javafx/2/layout/size_align.htm
        title.setWrappingWidth(300);
        //Font & Color: //from https://docs.oracle.com/javafx/2/text/jfxpub-text.htm
        title.setFill(Color.BLUE); 
        title.setFont(Font.font ("Arial", 30));
        title.setTextAlignment(TextAlignment.CENTER);

        mutateButtons.setPrefColumns(2);
        mutateButtons.setOrientation(Orientation.HORIZONTAL); 
        mutateButtons.setTileAlignment(Pos.CENTER);
        mutateButtons.setVgap(20);
        //Border from https://stackoverflow.com/questions/51279127/javafx-how-to-center-a-tilepane-but-place-the-tilepane-children-from-left-to-ri
        mutateButtons.setStyle("-fx-border-color: blue; -fx-border-width: 2; -fx-padding: 15px");

        accessButtons.setPrefColumns(2);
        accessButtons.setOrientation(Orientation.HORIZONTAL); 
        accessButtons.setTileAlignment(Pos.CENTER);
        accessButtons.setVgap(20);
        accessButtons.setStyle("-fx-border-color: blue; -fx-border-width: 2; -fx-padding: 15px");

        textBox.setPrefHeight(50);
        textBox.setPrefWidth(40);


        //FINAL SETUP 
        VBox box1 = new VBox(mutateButtons);
        VBox box2 = new VBox(title, stackPie);
        VBox box3 = new VBox(accessButtons, textBox);

        box1.setAlignment(Pos.CENTER);
        box2.setAlignment(Pos.CENTER);
        box3.setAlignment(Pos.CENTER);

        HBox window = new HBox(); 
        window.getChildren().addAll(box1, box2, box3);
 
        
        //Group setup (in case future items are added)
        Group root = new Group(); 
        root.getChildren().addAll(window);
        
        //Scene Setup
        Scene scene = new Scene(root, 1025, 500); //width, height
        scene.setFill(Color.BLACK);
        scene.getStylesheets().add("stylesheet.css");//https://docs.oracle.com/javafx/2/css_tutorial/jfxpub-css_tutorial.htm

        //Stage setup
        primaryStage.setTitle("Wheel of Decision");
        primaryStage.setScene(scene);
        primaryStage.show();
   }

}

