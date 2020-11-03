package _3D_Graphics;

/**
 *
 * @author Fenias
 */
import java.util.Collection;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;

public class Sphere1 extends Application{

    public Sphere1(int par) {
    }
    
    public static void main(String[] args) {
        // Starting program by calling launching
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception{
        
        // giving the Stage a title
        myStage.setTitle("Sphere");
        
        // creating a root node (FlowPlane)
        FlowPane rootNode = new FlowPane();
        
        // creating a Sphere1 with a radius equal to 50
        Sphere sphere = new Sphere(50);
        // creating a conteiner Group and passing the sphere as Parameter 
        Group group = new Group(sphere);
        
        // adding a conteiner group in the root node
        rootNode.getChildren().add(group);
        
        // set a Scene on the Stage
        Scene myScene = new Scene(group, 600, 500);
        
        // setting the the Scene on the Stage
        myStage.setScene(myScene);
        
        // showing the Stage and it's Scene
        myStage.show();
    }
}
