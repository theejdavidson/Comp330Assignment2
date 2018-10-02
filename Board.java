import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

import java.util.Scanner;

public class Board extends Application
{
  public static void main(String[] args)
  {
      launch(args);
  }

  @Override public void start(Stage stage)
  {
    Canvas canvas = new Canvas(500, 400); //adds a Canvas (the window itself), graphics are put in it
    GraphicsContext gc = canvas.getGraphicsContext2D();
    Scanner keyboard = new Scanner (System.in);
    int number;

    Image image = new Image("file:boardImage.jpg");
    ImageView imageView1 = new ImageView();
    imageView1.setImage(image);
    imageView1.setFitWidth(500);
    imageView1.setFitHeight(500);
    imageView1.setPreserveRatio(true);
    imageView1.setSmooth(true);
    imageView1.setCache(true);

    HBox box = new HBox(); //helps manage sizing image
    box.getChildren().add(imageView1);

    Group root = new Group(); //holds observable children (what can be in a group)
    root.getChildren().add(box);
    root.getChildren().add(canvas);

    Scene scene = new Scene(root); //like the backgound of the canvas
    scene.setFill(Color.WHITE);

    stage.setTitle("Tic Tac Toe");
    stage.setWidth(415); //affects where the window will appear on screen
    stage.setHeight(200);
    stage.setScene(scene);
    stage.sizeToScene();
    stage.show();

  }


}
