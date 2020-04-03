
/**
 * @since April 1, 2020 
 * @author Emmanuel Borishade
 * 
 * Program Description: Customized PieChart for Wheel
 * 
 * Program Objective: 
 *  Create PieChart that acts as if responding to commands for Wheel
 * 
 * Source Honorable Mentions:
 *      Orbit: http://www.hameister.org/JavaFX_TimelineAnimation.html
 *      DartBoard: http://www.hameister.org/JavaFX_Dartboard.html
 *      Customize Labels: https://stackoverflow.com/questions/57769490/displaying-additional-label-in-javafx-pie-chart
 *    
 */
import javafx.util.Duration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.animation.RotateTransition;


public class CustomPie{
    PieChart pieChart;
    ObservableList<PieChart.Data> pieData;
    

    /**
     * ctor, Initiates PieChart using reset()
     * @param String[] list
     */
    public CustomPie(String[] list){
        //ObservableList: http://what-when-how.com/javafx-2/using-the-javafx-piechart-creating-charts-in-javafx/
        pieData = FXCollections.observableArrayList();
        reset(list);
        
        //Create PieChart 
        //Source: https://www.geeksforgeeks.org/javafx-piechart-class/
        pieChart = new PieChart(); 
        pieChart.setData(pieData);
        pieChart.setLabelsVisible(true);
        pieChart.setLegendVisible(false); 
        pieChart.setStyle(".chart-pie-label {-fx-fill: #228B22; }");
        //colors: https://www.w3schools.com/cssref/css_colors.asp
        //css: https://docs.oracle.com/javafx/2/charts/css-styles.htm

    }


    /**
     * Reset the CustomPie chart based on new String array of Items
     * @param String[] i
     */
    public void reset(String[] i){
        /*
        hypothetically, Pie Charts are observable much like ImageView in this stackFlow example, so the pie chart
        should reflect all changes to the array list "items". 
        https://www.developer.com/java/data/understanding-java-observable-and-javafx-observable.html
        https://stackoverflow.com/questions/29500761/javafx-change-the-image-in-an-imageview
        status: SUCCESS!
        */
        if (i == null || i[0].equals(" ") || i[0].equals("")){
            pieData.clear();
            pieData.add(new PieChart.Data("[Empty]", 100));
        } else {
            String[] items = i;
            int numItems = items.length;                  
            double percent = (1.0/numItems)*100; 
            
            pieData.clear();
            for (int x = 0; x < numItems; x++) { 
                pieData.add(new PieChart.Data(items[x], percent)); 
            } 
        }

    }


    /**
     * Rotate the Pie Chart by int x degrees
     * @param int x
     */
    public void rotate(int x){
        /*
        Sources:
            Rotate:
                https://stackoverflow.com/questions/45101510/how-to-rotate-shapes-in-javafx
                http://www.java2s.com/Code/Java/JavaFX/rotateby45degrees.htm
          
            Better rotate: https://www.youtube.com/watch?v=ISEtiXCkESY
        */
        RotateTransition rotator = new RotateTransition(Duration.seconds(5), pieChart);
        rotator.setFromAngle(0);
        
        /* note:
        to determine potential wheel position in wheel numbered 1, 8: 
            if x = value current position and y = desired position
            x - y = z
            8 - z = number of rotations. 
            360 / numItems * numOfRotations ====setToAngle()
            This formula can be used to "predict" where a specific item on wheel will land if chosen.
        */
        rotator.setToAngle(360*x);
        rotator.play();
    }


    /**
     * Return Pie Chart to be added to Javafx Scene
     * @return pieChart 
     */
    public PieChart getData(){
        return pieChart;
    }

}