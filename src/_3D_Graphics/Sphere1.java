package _3D_Graphics;

/**
 *
 * @author Fenias
 */
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javax.swing.*;

public class Sphere1 extends Application{

    private static final int width = 600;
    private static final int height = 500;
    
    public static void main(String[] args) {
        // Starting program by calling launching
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception{
        
        myStage.setOnCloseRequest(event -> {
            System.out.println("Closing the Program!");
        });
        
        // giving the Stage a title
        myStage.setTitle("Sphere");
        
        // creating a Sphere1 with a radius equal to 50
        Sphere sphere = new Sphere(50);
        
        // creating a conteiner Group and passing the sphere as Parameter 
        Group group = new Group(sphere);
        
        // set a Scene on the Stage
        Scene myScene = new Scene(group, width, height);
        
        Camera camera = new PerspectiveCamera();
        
        myScene.setCamera(camera);
        
        // setting a new color to the Scene
        myScene.setFill(Color.SILVER);
        
        // redirecting the sphere to the center
        sphere.translateXProperty().set(width / 2);
        sphere.translateYProperty().set(height / 2);
        
        sphere.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.A){
                sphere.translateZProperty().set(sphere.getTranslateZ() + 10);
            }
            else if (event.getCode() == KeyCode.B)
                sphere.translateZProperty().set(sphere.getTranslateZ() - 10);
        });
        
        // setting the the Scene on the Stage
        myStage.setScene(myScene);

        // showing the Stage and it's Scene
        myStage.show();
    }
}
