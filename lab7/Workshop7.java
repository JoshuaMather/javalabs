import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;


// javac11 --module-path ./lib/ --add-modules=javafx.controls Workshop7.java
// java11 --module-path ./lib/ --add-modules=javafx.controls Workshop7

public class Workshop7 extends Application{
      @Override
      public void start (Stage stage){

      Circle sun = new Circle(50, 50, 40);
      sun.setFill(Color.YELLOW);

      VBox root = new VBox(10);
      root.setAlignment(Pos.TOP_RIGHT);
      String style = "-fx-background-color: rgba(0, 0, 225, 1.0);";
      root.setStyle(style);


      VBox vbox1 = new VBox();
      vbox1.setAlignment(Pos.BOTTOM_CENTER);

      Rectangle house = new Rectangle(100,100);
      house.setFill(Color.WHITE);

      house.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                if(sun.getFill().equals(Color.YELLOW)){
                  String style2 = "-fx-background-color: rgba(0, 0, 0, 1.0);";
                  root.setStyle(style2);
                  sun.setFill(Color.WHITE);
                }else{
                  String style2 = "-fx-background-color: rgba(0, 0, 225, 1.0);";
                  root.setStyle(style2);
                  sun.setFill(Color.YELLOW);
                }
            }
        });


      Rectangle grass = new Rectangle(300,150);
      grass.setFill(Color.GREEN);


      Polygon roof = new Polygon();
      roof.getPoints().addAll(new Double[]{
            100.0, 100.0,
            200.0, 100.0,
            100.0, 200.0 });

      roof.setFill(Color.RED);

      vbox1.getChildren().addAll(roof, house, grass);



      root.getChildren().addAll(sun, vbox1);

      Scene scene = new Scene(root);

      /*scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case PLUS:  sun.setRadius(sun.getRadius()+1);
                    //case DOWN:  goSouth = true; break;;
                }
            }
        });*/

        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.ADD) {
                sun.setRadius(sun.getRadius()+1);
            }else if (e.getCode() == KeyCode.SUBTRACT) {
                sun.setRadius(sun.getRadius()-1);
            }

        });

      stage.setScene(scene);
      stage.setTitle("Workshop7");
      stage.show();
    }

    public static void main(String args[]){
      launch(args);
    }
  }
