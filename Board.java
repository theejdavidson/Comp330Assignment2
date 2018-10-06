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
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.Node.*;
import javafx.scene.layout.BorderPane;
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
	
	Image x = new Image("X.png");
	
	Button button1 = new Button("click");//create buttons for clicking
	button1.setTranslateX(-450);//location of button
	button1.setTranslateY(40);
	button1.setPrefWidth(100);
	button1.setPrefHeight(70);
	//button1.setStyle()
	button1.setOnAction(new EventHandler<ActionEvent>(){ //when button is clicked, set the graphic of the button and disables the button (wip)
	@Override public void handle(ActionEvent e) {
	button1.setGraphic(new ImageView(x));
    //button1.setDisable(false);
    }
	});

	BorderPane root1 = new BorderPane();
	BorderPane topLeft = new BorderPane();
	root1.setBottom(button1);
	
    HBox box = new HBox(); //helps manage sizing image
    box.getChildren().addAll(imageView1, button1);

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
