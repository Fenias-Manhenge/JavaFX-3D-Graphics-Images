package _3D_Graphics;

/**
 *
 * @author Fenias
 */

import javafx.scene.*;
import javafx.scene.transform.*;

public class Transform3D extends Group{
    
    Rotate r;
    Transform t = new Rotate();
    
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
}
