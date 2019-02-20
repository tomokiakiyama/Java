// Exercise 12: Ordering App
package ex12;

import java.io.*;
import java.util.*;
import java.time.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.ActionEvent;

public class OrderingApp extends Application {

    public static String gakuban = "16EC003"; // 学籍番号を入力すること
    public static String yourname = "秋山智暉"; // 氏名を入力すること

    final int N = 16;
    Button[] buttons = new Button[N];
    ArrayList<Integer> numbers = new ArrayList<>();
    Label labelRemain, labelMistake, labelTime;
    TilePane tilePane;
    HBox hbox;
    int mistake;
    Instant startTime;

    public void clicked(ActionEvent e) {
        labelTime.setText(Long.toString((Instant.now().toEpochMilli()
                - startTime.toEpochMilli()) / 1000));
        Button btn = (Button) e.getSource();
        
        /* 以下に課題12-2のコードを記述 */
        
        int ans=Integer.parseInt(btn.getText());
        if(ans==numbers.get(0)){
            numbers.remove(0);
            btn.setDisable(true);      
            
            labelRemain.setText(Integer.toString(numbers.size()));
        }
            
            
        else{
            mistake=mistake+1;
            labelMistake.setText(Integer.toString(mistake));
        }
    }

    @Override
    public void start(Stage primaryStage) {
        // Check the Stylesheet
        File cssFile = new File("src/ex12/OrderingStyle.css");
        System.out.println(cssFile.toString());
        if (!cssFile.exists()) {
            System.err.println("ERROR! \"OrderingStyle.css\" cannont be found!");
            return;
        }

        // Create the Board (TilePane)
        tilePane = new TilePane(10, 10);
        tilePane.setPadding(new Insets(10));
        tilePane.setPrefWidth(400);
        tilePane.setVisible(false);

        // Create the Cards (Buttons)
        final double tileSize = 80;
        for (int i = 0; i < N; i++) {
            buttons[i] = new Button();
            buttons[i].setPrefWidth(tileSize);
            buttons[i].setPrefHeight(tileSize);
            buttons[i].setOnAction(e -> clicked(e));
            tilePane.getChildren().add(buttons[i]);
        }

        // Create the MenuBar
        MenuItem menuStart = new MenuItem("開始(_S)");
        menuStart.setOnAction(e -> startGame());
        MenuItem menuExit = new MenuItem("終了(_X)");
        menuExit.setOnAction(e -> primaryStage.close());
        Menu menuFile = new Menu("ファイル(_F)");
        menuFile.getItems().addAll(menuStart, menuExit);
        MenuBar menuBar = new MenuBar(menuFile);

        // Create the StatusBar
        Label label1 = new Label("残り個数: ");
        labelRemain = new Label("16");
        Label label2 = new Label("お手付き: ");
        labelMistake = new Label("0");
        Label label3 = new Label("経過秒数: ");
        labelTime = new Label("0");
        hbox = new HBox(20, new HBox(label1, labelRemain),
                new HBox(label2, labelMistake), new HBox(label3, labelTime));
        hbox.setAlignment(Pos.CENTER);
        hbox.setVisible(false);

        // Create the BorderPane and Scene
        BorderPane pane = new BorderPane(tilePane);
        pane.setTop(menuBar);
        pane.setBottom(hbox);
        pane.setPadding(new Insets(10));

        // Set the Style and show on the Stage
        Scene scene = new Scene(pane, 400, 480);
        scene.getStylesheets().add(cssFile.toURI().toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("OrderingApp");
        primaryStage.show();
    }

    public void startGame() {
        // Set the random numbers
        Random random = new Random();
        numbers.clear();
        for (int i = 0; i < N; i++) {
            int number = random.nextInt(99) + 1;
            buttons[i].setText(Integer.toString(number));
            buttons[i].setDisable(false);
            numbers.add(number);
        }
        Collections.sort(numbers);
        mistake = 0;
        startTime = Instant.now();
        labelRemain.setText(Integer.toString(numbers.size()));
        labelMistake.setText("0");
        labelTime.setText("0");
        tilePane.setVisible(true);
        hbox.setVisible(true);
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--OrderingApp");
    }

}
