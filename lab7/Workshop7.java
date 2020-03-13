import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;

public class Workshop7 extends Application{
      @Override
      public void start (Stage stage){
      // Do
      // something
      // here
      Circle sun = new Circle(50, 50, 40);
      sun.setFill(Color.YELLOW);

      VBox root = new VBox(10);
      root.setAlignment(Pos.TOP_RIGHT);

      VBox vbox1 = new VBox();
      vbox1.setAlignment(Pos.BOTTOM_CENTER);

      Rectangle house = new Rectangle(100,100);
      house.setFill(Color.GRAY);

      Rectangle grass = new Rectangle(300,150);
      grass.setFill(Color.GREEN);

      Polygon roof = new Polygon();
      roof.getPoints().addAll(new Double[]{
            0.0, 0.0,
            200.0, 100.0,
            100.0, 200.0 });

      vbox1.getChildren().addAll(roof, house, grass);



      root.getChildren().addAll(sun, vbox1);

      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Workshop7");
      stage.show();
    }

    public static void main(String args[]){
      launch(args);
    }
  }
