// Exercise 04: Count Down Application
package ex04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CountUpDownApp extends Application {

    public String gakuban = "16EC003"; // 学籍番号を入力すること
    public String yourname = "秋山智暉"; // 氏名を入力すること

    Alert alert;
    Scene scene1, scene2;
    Label label1, label2;
    TextField textField1;
    int counter = 0;

    @Override
    public void start(Stage primaryStage) {
        // Create Scene1
        // 以下のコードはダミー。課題04-1のコードで書き換え
        label1=new Label("カウント値");
        textField1 = new TextField("0");
        Button button1= new Button("設定する");
       
         button1.setOnAction(e ->{
             String num=textField1.getText().trim();
             try{
                 Integer.parseInt(num);
                 counter=Integer.parseInt(num);             
             }catch(NumberFormatException ex){
                 counter=0;
             }
             if(counter>0){
               primaryStage.setScene(scene2);
               label2.setText(Integer.toString(counter));   
             }
             else{
              alert=new Alert(Alert.AlertType.ERROR,
                         "正の整数を入力してください");
              alert.showAndWait();                
             }

         });
         
        HBox pane1 = new HBox(10, label1, textField1, button1);
        pane1.setAlignment(Pos.CENTER);
        scene1 = new Scene(pane1, 400, 100);
        

        // Create Scene2
        // 以下のコードはダミー。課題04-2のコードで書き換え
        Button Button_1=new Button("カウントアップ");
        Button Button_2=new Button("カウントダウン");
        label2 = new Label(String.valueOf(counter));
        
        Button_1.setOnAction(e->{
        Button_2.setText("カウントダウン");
        counter+=1;
        label2.setText(String.valueOf(counter));
        });
        
        Button_2.setOnAction(e->{
            Button_2.setText("カウントダウン");
            counter-=1;
            label2.setText(String.valueOf(counter));
            if(counter==0)
                Button_2.setText("設定しなおす");
            else if(counter==-1)
                primaryStage.setScene(scene1);
        });
                
        
        VBox pane2 = new VBox(10, Button_1,label2,Button_2);
        pane2.setAlignment(Pos.CENTER);
        scene2 = new Scene(pane2, 200, 200);

        // Add the scene to the stage, set the title and show the stage
        primaryStage.setScene(scene1);
        primaryStage.setTitle("CountUpDownApp");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--CountUpDownApp");
    }

}
