package _3D_Graphics;

/**
 *
 * @author Fenias
 */

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Sphere3D extends Application{
    
    private static final int width = 600;
    private static final int height = 500;

    public static void main(String[] args) {
        // Starting program by calling launching
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception{
        
        /*myStage.setOnCloseRequest(event -> {
            System.out.println("Closing the Program!");
        });*/
        
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
        
        myStage.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            switch(event.getCode()){
                case W: sphere.translateZProperty().set(sphere.getTranslateZ() + 100); break;
                case S: sphere.translateZProperty().set(sphere.getTranslateZ() - 100); break;
            }
        });
        
        // setting the the Scene on the Stage
        myStage.setScene(myScene);

        // showing the Stage and it's Scene
        myStage.show();
    }
}
