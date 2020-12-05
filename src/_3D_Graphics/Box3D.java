package _3D_Graphics;

/**
 *
 * @author Fenias
 */

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.shape.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import java.lang.*;
import javafx.animation.AnimationTimer;
import javafx.scene.transform.*;

public class Box3D extends Application{
    
    private static final float width = 600;
    private static final float height = 500;
    
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
        //camera.setNearClip(1);
        //camera.setFarClip(100);
        
        // creating a container called "Group"
        Transform3D group = new Transform3D();
        group.getChildren().addAll(box, new AmbientLight(Color.GREEN));
        group.getChildren().addAll(PrepareLightSource());

        // creating a Scene
        Scene myScene = new Scene(group, width, height, Color.GREY);
        
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
                // Rotating the Box
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
        
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // rotating the sphere(point litght) increasing 1 degree each time
                pointLight.setRotate(pointLight.getRotate() + 1);
            }
        };
        timer.start();
    }
    
    
    // creating the variable of the point light
    private final PointLight pointLight = new PointLight(Color.RED);
    
    // Creating the box and applying texture on it 
    private Box PrepareBox(){
        Box box = new Box(100, 20, 50); // creating the Box
        try{
            PhongMaterial material = new PhongMaterial();
            material.setDiffuseMap(new Image(getClass().getResourceAsStream("/Textures/pikapau.jpg"))); // applying texture on the box
            material.setSpecularMap(new Image(getClass().getResourceAsStream("/Textures/AbText.jpg"))); 
            box.setMaterial(material); // setting the material on the box
        }catch(Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return box;
    }
    
    private Node[] PrepareLightSource(){
//        AmbientLight ambientLight = new AmbientLight(Color.BLUEVIOLET);
//        return ambientLight;

        pointLight.getTransforms().add(new Translate(0, -70, 100));
        pointLight.setRotationAxis(Rotate.X_AXIS); // Rotating the point light on the X axis
        
        Sphere sphere = new Sphere(4);
        sphere.getTransforms().setAll(pointLight.getTransforms()); // setting all the transformations of the point light to the Sphere
        sphere.rotateProperty().bind(pointLight.rotateProperty());
        sphere.rotationAxisProperty().bind(pointLight.rotationAxisProperty());
        
        return new Node[]{pointLight, sphere};
    }
}
