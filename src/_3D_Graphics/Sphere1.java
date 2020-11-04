package _3D_Graphics;

/**
 *
 * @author Fenias
 */
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;

public class Sphere1 extends Application{

    private static final int width = 600;
    private static final int height = 500;
    
    public static void main(String[] args) {
        // Starting program by calling launching
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception{
        
        // giving the Stage a title
        myStage.setTitle("Sphere");
        
        // creating a Sphere1 with a radius equal to 50
        Sphere sphere = new Sphere(50);
        
        // creating a conteiner Group and passing the sphere as Parameter 
        Group group = new Group(sphere);
        
        // set a Scene on the Stage
        Scene myScene = new Scene(group, width, height);
        
        // redirecting the sphere to the center
        sphere.translateXProperty().set(width / 2);
        sphere.translateYProperty().set(height / 2);
        
        // setting the the Scene on the Stage
        myStage.setScene(myScene);
        
        // showing the Stage and it's Scene
        myStage.show();
    }
}
