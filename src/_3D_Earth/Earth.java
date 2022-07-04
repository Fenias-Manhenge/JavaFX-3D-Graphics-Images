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
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.transform.*;
import javax.swing.JOptionPane;

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
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("earth_planet.png")));
        
        Sphere sphere = sphere3D();
        
        Camera camera = new PerspectiveCamera();
        
        Actions group = new Actions();
        
        group.getChildren().add(sphere);
        
        Scene myScene = new Scene(group, width, heigth, true, SceneAntialiasing.BALANCED);
        
        group.translateXProperty().set(width / 2);
        group.translateYProperty().set(heigth / 2);
        
        myStage.addEventHandler(KeyEvent.KEY_PRESSED, (event) -> {
            switch(event.getCode()){
                case UP -> group.translateZProperty().set(group.getTranslateZ() + 25);
                case DOWN -> group.translateZProperty().set(group.getTranslateZ() - 25);
                case LEFT -> group.rotateByX(-10);
                case RIGHT -> group.rotateByY(10);
            }
        });
        
        // Escalando o Group como uma Unidade
        ScaleTransition myScaleTransZ = new ScaleTransition(Duration.seconds(5), group);
        myScaleTransZ.setCycleCount(1);
        myScaleTransZ.setByX(1.7);
        myScaleTransZ.setByY(1.7);
        
        // Criando animacao da esfera e nao o Group como uma unidade
        RotateTransition myRotateTransY = new RotateTransition(Duration.seconds(15), sphere);
        myRotateTransY.setCycleCount(Animation.INDEFINITE);
        myRotateTransY.setAxis(Rotate.Y_AXIS);
        myRotateTransY.setInterpolator(Interpolator.LINEAR);
        myRotateTransY.setByAngle(360);
        
        /*
        group.setRotationAxis(Rotate.Y_AXIS);
        KeyValue kvRotate360 = new KeyValue(group.rotateProperty(), 360);
        
        KeyFrame kf = new KeyFrame(Duration.seconds(10), kvRotate360);
        
        Timeline timLine = new Timeline(kf);
        timLine.setCycleCount(Animation.INDEFINITE);
        timLine.setDelay(Duration.seconds(2));
        */
        
        SequentialTransition seqTrans = new SequentialTransition(myScaleTransZ, myRotateTransY);
        
        seqTrans.play(); 
        
        myScene.setCamera(camera);

        myStage.setScene(myScene);
        myStage.show();
    }
    
    private Sphere sphere3D(){
        Sphere sphere = new Sphere(60);
        
        try {
            PhongMaterial material = new PhongMaterial();
            //material.setBumpMap(new Image(getClass().getResourceAsStream("bump_map1.jpg")));
            material.setDiffuseMap(new Image(getClass().getResourceAsStream("textureEarth2.png")));
            sphere.setMaterial(material);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        }
        
        return  sphere;
    }
}
