import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.geometry.Insets;

public class Shopping extends Application{
    VBox vlist;

    @Override
    public void start (Stage stage){
        TextField tf = new TextField("Add an item");
        VBox vb = new VBox(20);
        vlist= new VBox(20);
        vlist.setPadding(new Insets(0, 0, 0, 10));

        vb.setAlignment(Pos.TOP_CENTER);
        tf.setOnKeyPressed(e1->{
            if (e1.getCode().equals(KeyCode.ENTER)){
                CheckBox cb = new CheckBox(tf.getText());
                cb.setOnAction(e2->{
                    if (cb.isSelected()){
                        vlist.getChildren().remove(cb);
                    }
                });
                vlist.getChildren().addAll(cb);
                tf.setText("");

            }
        }
        );
        vb.getChildren().addAll(tf,vlist);


        Scene scene = new Scene(vb, 400, 600);
        stage.setScene(scene);
        stage.setTitle("My shopping list");
        stage.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}