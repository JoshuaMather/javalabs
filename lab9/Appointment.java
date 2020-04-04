/*
/mnt/c/Program\ Files/Java/jdk-11.0.6/bin/javac.exe --module-path ./lib/ --add-modules=javafx.controls
/mnt/c/Program\ Files/Java/jdk-11.0.6/bin/java.exe --module-path ./lib/ --add-modules=javafx.controls
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.DatePicker;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;


public class Appointment extends Application{

    @Override
    public void start (Stage stage){
        VBox vb = new VBox(20);
        vb.setAlignment(Pos.TOP_LEFT );
        vb.setPadding(new Insets(10, 10, 10, 10));

        //#1
        Label l1 = new Label("Pick a date");
        DatePicker dp = new DatePicker();

        HBox hb1 = new HBox(10);
        hb1.setAlignment(Pos.TOP_LEFT);
        hb1.getChildren().addAll(l1,dp);

        //#2
        HBox hb2 = new HBox(10);
        hb2.setAlignment(Pos.TOP_LEFT);

        Label l2 = new Label("Pick a time");
        ChoiceBox cb = new ChoiceBox();
        cb.getItems().addAll("07:00","07:15","07:30","07:45","08:00");
        hb2.getChildren().addAll(l2,cb);

        //#3
        TextArea ta = new TextArea("Write your symptoms");
        HBox hb3 = new HBox(10);
        hb3.setAlignment(Pos.TOP_LEFT);
        hb3.getChildren().addAll(ta);

        //#4
        VBox rbox = new VBox(10);
        ToggleGroup group = new ToggleGroup();
        RadioButton b1 = new RadioButton("Dr. Smith");
        b1.setToggleGroup(group);
        RadioButton b2 = new RadioButton("Dr. Patel");
        b2.setToggleGroup(group);
        rbox.getChildren().addAll(b1,b2);

        //#5
        Button b = new Button("Book appointment");
        b.setOnAction(e->{
            LocalDate date = dp.getValue();
            String dr=null;
            System.out.println(cb.getValue().toString());
            if (b1.isSelected())
                dr="Dr. Smith";
            else if (b2.isSelected())
                dr="Dr Patel";
            System.out.println();
            showAlert(date.toString(),cb.getValue().toString(),dr,ta.getText());
        });

        vb.getChildren().addAll(hb1,hb2,hb3,rbox,b);

        Scene scene = new Scene(vb,400,600);
        stage.setScene(scene);
        stage.setTitle("Early appointment app");
        stage.show();
    }

    public static void main(String args[]){
        launch(args);
    }

    private void showAlert(String date, String time, String doctor, String symptoms){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Your appointment is booked on "+date+" at "+time+" with "+doctor+".\nWe communicated your symptoms to your GP: "+symptoms);
        alert.showAndWait();
    }
}