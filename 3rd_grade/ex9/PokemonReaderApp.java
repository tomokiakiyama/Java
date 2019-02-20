// Exercise 11: Pokemon Reader App
package ex11;

import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.FileChooser;

public class PokemonReaderApp extends Application {

    public static String gakuban = "16EC003"; // 学籍番号を入力すること
    public static String yourname = "秋山智暉"; // 氏名を入力すること

    Label label;
    ComboBox<String> combo;
    HashMap<String, String> map;

    public File openFile() {
        // 課題11-1のコードを記述
       FileChooser chooser=new FileChooser();
       chooser.setTitle("Open File");
       chooser.getExtensionFilters().addAll(
               new FileChooser.ExtensionFilter("Text files","*.txt"),
               new FileChooser.ExtensionFilter("All files","*.*"));
       File file=chooser.showOpenDialog(null);       
       
       return file;
    }

    public void readFile(File file) {
        file = openFile();
        map = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] column = line.split("\t");
                map.put(column[1].trim(), column[2].trim());
                combo.getItems().addAll(column[1].trim());
                line = br.readLine();
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        }
    }
    
        


    public void selectPokemon() {
        String Pokemon = combo.getValue();
        label.setText(map.get(Pokemon));

    }

    public void start(Stage primaryStage) {
        // Create the Label to show Pokemon data
        label = new Label();
        label.setWrapText(true);

        // Create the Button to read the File
        Button button = new Button("ファイルを開く");
        button.setOnAction(e -> {
            File file = openFile();
            if (file != null && combo.getItems().size() == 0) {
                readFile(file);
            }
        });

        // Create the ComboBox to select the Pokemon
        combo = new ComboBox<>();
        combo.setPromptText("ポケモンを選ぶ");
        combo.setOnAction(e -> selectPokemon());

        // Create the Layout and show it on the stage
        HBox hbox = new HBox(10, button, combo);
        BorderPane pane = new BorderPane(label);
        pane.setTop(hbox);
        BorderPane.setAlignment(label, Pos.TOP_CENTER);
        BorderPane.setMargin(label, new Insets(10));
        BorderPane.setMargin(hbox, new Insets(10));
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pokemon Reader App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--PokemonReaderApp");
    }
}
