package _3D_Graphics;

/**
 *
 * @author Fenias
 */

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import java.lang.*;
import javax.swing.ImageIcon;

public class Box3D extends Application{
    
    private static final float width = 400;
    private static final float height = 300;
    
    public static void main(String[] args) {
        // start the program by calling launch
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception{
        
        // giving the Stage a title
        myStage.setTitle("Box");
        
        // creating a Box
        Box box = PrepareBox();
        
        Camera camera = new PerspectiveCamera();
        
        // creating a container called "Group"
        Transform3D group = new Transform3D();
        group.getChildren().add(box);

        // creating a Scene
        Scene myScene = new Scene(group, width, height, Color.CYAN);
        
        // setting the camera to the Scene
        myScene.setCamera(camera);
        
        // setting the Scene to the Stage
        myStage.setScene(myScene);
        
        // Moving the box to the center
        group.translateXProperty().set(width / 2);
        group.translateYProperty().set(height / 2);
        group.translateZProperty().set(-200);
        group.intMouseControl(group, myScene, myStage);
        
        // creating Syntaxs that rotate the objects
//        Transform transform = new Rotate(65, new Point3D(1, 0, 0));
//        box.getTransforms().add(transform);
        
        myStage.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            switch(event.getCode()){
                case W: group.translateZProperty().set(group.getTranslateZ() + 50); break; // increasing the size of the box
                case S: group.translateZProperty().set(group.getTranslateZ() - 50); break; // decreasing the size of the box
                case RIGHT: group.rotateByX(10); break;
                case LEFT: group.rotateByX(-10); break;
                case UP: group.rotateByY(10); break;
                case DOWN: group.rotateByY(-10); break;
                case A: group.rotateByZ(10); break;
                case D: group.rotateByZ(-10); break;
            }
        });
        
        // showing the Stage and the Scene
        myStage.show();
    }
    
    private Box PrepareBox(){
        Box box = new Box(100, 20, 50); 
        try{
            PhongMaterial material = new PhongMaterial();
            //material.setDiffuseColor(Color.BLACK);
            Image image = new Image(getClass().getResourceAsStream("/Textures/Texture-7.jpeg"));
            material.setDiffuseMap(image);
            box.setMaterial(material);
        }catch(Exception e){
            String message = e.getMessage();
            System.err.println(message);
        }
        return box;
    }
}
