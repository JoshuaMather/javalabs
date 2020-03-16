import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Workshop73 extends Application{

      @Override
      public void start (Stage stage){
      //Define context
      HBox pane = new HBox(10);
      pane.setAlignment(Pos.CENTER);

      //Create button and event handler. Defined in the lecture as Mode 2
      Button bOK = new Button("OK");
      bOK.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(final ActionEvent AE){
          System.out.println("OK button clicked");
        }
      });


      //  //Create buttons
      //  Button bOK = new Button("OK");
      //  bOK.setOnAction(e->{
      //    System.out.println("OK button clicked");
      //  });


      //Create button and event handler. Defined in the lecture as Mode 1
      Button bCancel = new Button("Cancel");
      CancelHandlerClass handler2 = new CancelHandlerClass();
      bCancel.setOnAction(handler2);

      // Button bCancel = new Button("Cancel");
      // bCancel.setOnAction(e->{
      //   System.out.println("Cancel button clicked");
      // });


      pane.getChildren().addAll(bOK, bCancel);
      Scene scene = new Scene(pane,200,200);

      stage.setScene(scene);
      stage.setTitle("Workshop7c");
      stage.show();
    }

    public static void main(String args[]){        
      launch(args);
    }

    class CancelHandlerClass implements EventHandler<ActionEvent>{
      @Override
      public void handle(final ActionEvent AE){
        System.out.println("Cancel button clicked");
      }
    }}


