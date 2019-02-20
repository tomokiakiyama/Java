// Exercise 02: CheckSID Application
package ex02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class CheckSIDApp extends Application {

    public static String gakuban = "16EC003"; // 学籍番号を入力すること
    public static String yourname = "秋山智暉"; // 氏名を入力すること

    // 学籍番号が正しい形式かどうかを判定するメソッド
    public static boolean checkSID(String sid) {
        // 課題02-1のコードを記述
          return sid.matches("[0-9][0-9][E|e][C|c][0-9][0-9][0-9]");
    }

    @Override
    public void start(Stage primaryStage) {
        // 課題02-2のコードを記述
               Label label_1=new Label("学籍番号");
        TextField textField=new TextField();
        
        Button button=new Button("確認");
        
        Label label_2=new Label(" ");
        button.setOnAction((ActionEvent event)->{
            String name=textField.getText().trim();

            if(checkSID(name)){ 
                label_2.setText("OK");
            }
            else label_2.setText("NG");    
        });
            VBox pane_1=new VBox(label_1, textField,button,label_2);
            Scene scene=new Scene(pane_1,300,100);   
            primaryStage.setScene(scene);   
                                        
                
        primaryStage.show();
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--CheckSIDApp");
    }

}
