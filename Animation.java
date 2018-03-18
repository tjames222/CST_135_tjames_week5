/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;


/**
 *
 * @author mrtim
 */
public class Animation extends Pane {
    
    public final double atCart = 500;
    private double x = 300, y = 12;
    private Line line = new Line(x, 5, atCart, y);
    private Timeline animation;
    private Image img = new Image("file:src/DispenserDesign/IndividualProducts/CokePicture.png");
    
    public Animation() {
    getChildren().add(new ImageView(img));
    
    animation = new Timeline(
            new KeyFrame(Duration.millis(50), e -> moveImage()));
        animation.setCycleCount(Timeline.INDEFINITE);  
    }
    
    public void play() {
        animation.play();
    }
    
    public void pause() {
        animation.pause();
    }
    
    protected void moveImage() {
    
    PathTransition pt = new PathTransition();
    pt.setDuration(Duration.millis(4000));
    pt.setPath(line);
    pt.setNode(new ImageView(img));
    pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    pt.setCycleCount(Timeline.INDEFINITE);
    pt.setAutoReverse(false);
    pt.play();
    
    FadeTransition ft = new FadeTransition();
    ft.setDuration(Duration.seconds(3));
    ft.setNode(new ImageView(img));
    ft.setFromValue(1.0);
    ft.setToValue(0.0);
    ft.setCycleCount(0);
    ft.setAutoReverse(false);
    ft.play();  
    
    }   
    
    public static void main(String[] args) {
        launch(args);
    }
}
