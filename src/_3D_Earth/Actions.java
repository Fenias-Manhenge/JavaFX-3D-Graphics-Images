package _3D_Earth;

/**
 *
 * @author Fenias
 */

import javafx.scene.*;
import javafx.scene.transform.*;

public class Actions extends Group{
    
    Rotate r;
    Transform t = new Rotate();
    
    void rotateByX(double ang){
        r = new Rotate(ang, Rotate.X_AXIS);
        t = t.createConcatenation(r);
        this.getTransforms().clear();
        this.getTransforms().add(t);
    }
    
    void rotateByY(double ang){
        r = new Rotate(ang, Rotate.Y_AXIS);
        t = t.createConcatenation(r);
        this.getTransforms().clear();
        this.getTransforms().add(t);
    }
}
