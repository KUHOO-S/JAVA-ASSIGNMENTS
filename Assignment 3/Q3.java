/*Q3. Write a program to demonstrate the knowledge of students in GUI programming using
JavaFX.  */

package com.mycompany.trialjavafx;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
* JavaFX App
*/
public class Q3 extends Application {
@Override
public void start(Stage stage) {
var javaVersion = SystemInfo.javaVersion();
var javafxVersion = SystemInfo.javafxVersion();
var root = new HBox();
root.setPadding(new Insets(25));
final TextField n1 = new TextField();
n1.setPromptText("Enter String 1.");
n1.setPrefColumnCount(10);
GridPane.setConstraints(n1, 0, 0);
final TextField n2 = new TextField();
n2.setPromptText("Enter String 2.");
n2.setPrefColumnCount(10);
GridPane.setConstraints(n2, 0, 1);
final TextField n3 = new TextField();
n3.setPrefColumnCount(10);
GridPane.setConstraints(n3, 0, 2);
var btn = new Button();
btn.setText("Add");
btn.setOnAction((ActionEvent event) -> {
System.out.println("hi"+n2.getText());
n3.setText(n1.getText()+n2.getText());
});
GridPane.setConstraints(btn, 1, 0);
root.getChildren().add(n1);
root.getChildren().add(n2);
root.getChildren().add(btn);
root.getChildren().add(n3);
var scene = new Scene(root, 640, 480);
stage.setScene(scene);
stage.show();
}
public static void main(String[] args) {
launch();
}
}