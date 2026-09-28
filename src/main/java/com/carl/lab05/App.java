package com.carl.lab05;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        ListView<String> bagListView = new ListView<>();
        bagListView.getItems().addAll("Full Decorative", "Beaded", "Pirate Design",
                "Fringed", "Leather", "Plain");
        bagListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        bagListView.setOrientation(Orientation.HORIZONTAL);
        bagListView.setPrefSize(200, 50);
        
        ComboBox<String> numComboBox = new ComboBox<>();
        numComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        
        RadioButton radio1 = new RadioButton("Small");
        RadioButton radio2 = new RadioButton("Medium");
        RadioButton radio3 = new RadioButton("Large");
        ToggleGroup toggleGroup = new ToggleGroup();
        radio1.setToggleGroup(toggleGroup);
        radio2.setToggleGroup(toggleGroup);
        radio3.setToggleGroup(toggleGroup);
        
        Label messageLabel = new Label("");
        
        Button orderBtn = new Button("Order");
        orderBtn.setOnAction(e -> {
            String selectedItem = bagListView.getSelectionModel().getSelectedItem();
            String selectednumItem = numComboBox.getValue();
            String size = "";
            if (radio1.isSelected()) {
                size = "small";
            } else if (radio2.isSelected()) {
                size = "medium";
            } else if (radio3.isSelected()) {
                size = "large";
            }
            messageLabel.setText(String.format("You ordered %s %s %s bags", selectednumItem, size, selectedItem));
        });
        
        Button clearBtn = new Button("Clear");
        clearBtn.setOnAction(e -> {
            bagListView.getSelectionModel().clearSelection();
            numComboBox.setValue(null);
            toggleGroup.selectToggle(null);
            messageLabel.setText("");
        });
        
        Scene scene = new Scene(grid, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}