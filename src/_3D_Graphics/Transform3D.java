package _3D_Graphics;

/**
 *
 * @author Fenias
 */

import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.transform.*;
import javafx.beans.property.*;
import javafx.event.*;
import javafx.stage.*;

public class Transform3D extends Group{
    
    Rotate r;
    Transform t = new Rotate();
    
    private double scenePosX, scenePosY; // variables to store the position of the scene grapth
    private double anchorAngleX = 0, anchorAngleY = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
    
    // method that will rotate the object on the X axis
    void rotateByX(int ang){
        r = new Rotate(ang, Rotate.X_AXIS);
        t = t.createConcatenation(r);
        this.getTransforms().clear();
        this.getTransforms().add(t);
    }
    
    // method that will rotate the object on the Y axis
    void rotateByY(int ang){
        r = new Rotate(ang, Rotate.Y_AXIS);
        t = t.createConcatenation(r);
        this.getTransforms().clear();
        this.getTransforms().add(t);
    }
    
    void rotateByZ(int ang){
        r = new Rotate(ang, Rotate.Z_AXIS);
        t = t.createConcatenation(r);
        this.getTransforms().clear();
        this.getTransforms().add(t);
    }
    
    public void intMouseControl(Transform3D group, Scene scene, Stage myStage){
        Rotate xRotate, yRotate;
        
        group.getTransforms().addAll(xRotate = new Rotate(0, Rotate.X_AXIS), yRotate = new Rotate(0, Rotate.Y_AXIS));
        
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);
        
        scene.setOnMousePressed(event ->{
            // storing the position of the mouse click
            scenePosX = event.getSceneX(); 
            scenePosY = event.getSceneY();
            // storing the current angle of the angle X_AXIS and Y_AXIS
            anchorAngleX = angleX.get();
            anchorAngleY = angleY.get();
        });
        
        scene.setOnMouseDragged(event -> {
            angleX.set(anchorAngleX - (scenePosY - event.getSceneY()));
            angleY.set(anchorAngleY + scenePosX - event.getSceneX());
        });
        
        // increasing and decreasing the size of the 3D box
        myStage.addEventHandler(ScrollEvent.SCROLL, event -> {
            double delta = event.getDeltaY();
            group.translateZProperty().set(group.getTranslateZ() + delta);
        });
    }
}
