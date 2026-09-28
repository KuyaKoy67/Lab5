/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carl.lab05;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author 2540394
 */
public class App2 extends Application {
    private double price1;
    private double price2;
    private double price3;
    private double price4;
    
    @Override
    public void start(Stage stage) {
        Slider slider = new Slider(0.0, 20, 10.0);
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        Label totalLabel = new Label(String.format("Total: %f", (price1 + price2 + price3 + price4) * slider.getValue()));
        ComboBox beverageComboBox = new ComboBox();
        beverageComboBox.getItems().setAll("Coffee", "Tea", "Soft Drink", "Water",
        "Milk", "Juice");
        beverageComboBox.setOnAction(e -> {
            String choice = (String) beverageComboBox.getValue();
            switch (choice) {
                case "Coffee":
                    price1 = 2.50;
                    break;
                case "Tea":
                    price1 = 2.00;
                    break;
                case "Soft Drink":
                    price1 = 1.75;
                    break;
                case "Water":
                    price1 = 2.95;
                    break;
                case "Milk":
                    price1 = 1.5;
                    break;
                case "Juice":
                    price1 = 2.5;
                default:
                    break;
            }
            totalLabel.setText(String.format("Total: %f", (price1 + price2 + price3 + price4)* slider.getValue()));
        });
        
        ComboBox appetizerComboBox = new ComboBox();
        appetizerComboBox.getItems().setAll("Soup", "Salad", "Spring Rolls", "Garlic Bread",
                "Chips and Salsa");
        appetizerComboBox.setOnAction(e -> {
            String choice = (String) appetizerComboBox.getValue();
            switch (choice) {
                case "Soup":
                    price2 = 4.50;
                    break;
                case "Salad":
                    price2 = 3.75;
                    break;
                case "Spring Rolls":
                    price2 = 5.25;
                    break;
                case "Garlic Bread":
                    price2 = 3.00;
                    break;
                case "Chips and Salsa":
                    price2 = 6.95;
                    break;
                default:
                    break;
            }
            totalLabel.setText(String.format("Total: %f", price1 + price2 + price3 + price4));
        });
        
        ComboBox mainCourseComboBox = new ComboBox();
        mainCourseComboBox.getItems().setAll("Steak", "Grilled Chicken", "Chicken Alfredo",
                "Turkey Club", "Shrimp Scampi", "Pasta", "Fish and Chips");
        mainCourseComboBox.setOnAction(e -> {
            String choice = (String) mainCourseComboBox.getValue();
            switch (choice) {
                case "Steak":
                    price3 = 15;
                    break;
                case "Grilled Chicken":
                    price3 = 13.5;
                    break;
                case "Chicken Alfredo":
                    price3 = 13.95;
                    break;
                case "Turkey Club":
                    price3 = 11.9;
                    break;
                case "Shrimp Scampi":
                    price3 = 18.99;
                    break;
                case "Pasta":
                    price3 = 11.75;
                    break;
                case "Fish and Chips":
                    price3 = 12.25;
                    break;
                default:
                    break;
            }
            totalLabel.setText(String.format("Total: %f", (price1 + price2 + price3 + price4)* slider.getValue()));
        });
        
        ComboBox dessertComboBox = new ComboBox();
        dessertComboBox.getItems().setAll("Apple Pie", "Carrot Cake", "Mud Pie",
                "Pudding", "Apple Crisp");
        dessertComboBox.setOnAction(e -> {
            String choice = (String) dessertComboBox.getValue();
            switch (choice) {
                case "Apple Pie":
                    price4 = 5.95;
                    break;
                case "Carrot Cake":
                    price4 = 4.50;
                    break;
                case "Mud Pie":
                    price4 = 4.75;
                    break;
                case "Pudding":
                    price4 = 3.25;
                    break;
                case "Apple Crisp":
                    price4 = 5.98;
                    break;
                default:
                    break;
            }
            totalLabel.setText(String.format("Total: %f", (price1 + price2 + price3 + price4)* slider.getValue()));
        });
        
        grid.add(beverageComboBox, 1, 0);
        grid.add(appetizerComboBox, 3, 0);
        grid.add(mainCourseComboBox, 5, 0);
        grid.add(dessertComboBox, 7, 0);
        grid.add(totalLabel, 6, 1);
        
        stage.setTitle("Ordering restaurant food");
        Scene scene = new Scene(grid, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
