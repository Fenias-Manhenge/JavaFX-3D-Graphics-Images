package _3D_Earth;

/**
 *
 * @author Fenias
 */

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.*;
import javafx.stage.*;
import javafx.scene.shape.Sphere;
import javax.swing.JOptionPane;
//import javafx.scene.

public class Earth extends Application{
    
    private static final double width = 500;
    private static final double heigth = 400;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage){
        // giving title my Stage
        myStage.setTitle("Earth");
        
        Sphere sphere = sphere3D();
        
        Camera camera = new PerspectiveCamera();
        
        Actions group = new Actions();
        
        group.getChildren().add(sphere);
        
        Scene myScene = new Scene(group, width, heigth, Color.AZURE);
        
        group.translateXProperty().set(width / 2);
        group.translateYProperty().set(heigth / 2);
        
        myStage.addEventHandler(KeyEvent.KEY_PRESSED, (event) -> {
            switch(event.getCode()){
                case UP: group.translateZProperty().set(group.getTranslateZ() + 25); break;
                case DOWN: group.translateZProperty().set(group.getTranslateZ() - 25); break;
                case LEFT: group.rotateByX(-10); break;
                case RIGHT: group.rotateByY(10); break;
            }
        });
        
        myScene.setCamera(camera);
        
        myStage.setScene(myScene);
        
        myStage.show();
    }
    
    private Sphere sphere3D(){
        Sphere sphere = new Sphere(60);
        
        try {
            PhongMaterial material = new PhongMaterial();
            material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Textures/EarthMap_2500x1250.jpg")));
            sphere.setMaterial(material);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        }
        
        return  sphere;
    }
}
