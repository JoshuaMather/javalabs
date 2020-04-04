/*
/mnt/c/Program\ Files/Java/jdk-11.0.6/bin/javac.exe --module-path ./lib/ --add-modules=javafx.controls
/mnt/c/Program\ Files/Java/jdk-11.0.6/bin/java.exe --module-path ./lib/ --add-modules=javafx.controls
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;


public class Drag extends Application{

    @Override
    public void start (Stage stage){
        Pane p = new Pane();
        Label l = new Label("Move me!");
        l.setLayoutX(300);
        l.setLayoutY(300);
        l.setOnMouseDragged(e->{
            System.out.println(e.getSceneX());
            System.out.println(e.getSceneY());
            l.setText("Moved to\n"+e.getSceneX()+","+e.getSceneY());
            l.setLayoutX(e.getSceneX());
            l.setLayoutY(e.getSceneY());
        });

        p.getChildren().addAll(l);
        Scene scene = new Scene(p,600,600);
        stage.setScene(scene);

        stage.setTitle("DragText");
        stage.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}