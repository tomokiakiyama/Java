// Exercise 05: Golden Button Application
package ex05;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;


public class GoldenButtonApp extends Application {

    public static String gakuban = "16EC003"; // 学籍番号を入力すること
    public static String yourname = "秋山智暉"; // 氏名を入力すること

    Scene scene1,scene2,scene3,scene4,scene5,scene6;
    Label label1,label2,label3,label4,label5,label6 ;
    Stage stage;
    int start;
    int ans;
        
    @Override
    public void start(Stage primaryStage) {
        // プログラムを作成
        stage = primaryStage;

        label1=new Label("ボタンをどれか押してください");
        Button button1=new Button("金");
        Button button2=new Button("銀");
        Button button3=new Button("銅");
        
        button1.setOnAction(e ->{
            start=2;
            primaryStage.setScene(scene2);
        });
        button2.setOnAction(e ->{
            start=3;
            primaryStage.setScene(scene2);
        });
        button3.setOnAction(e ->{
            start=4;
            primaryStage.setScene(scene2);
        });       
        
       
        
        HBox pane1=new HBox(10, button1, button2 ,button3);
        VBox pan1=new VBox(10, label1, pane1);
        pane1.setAlignment(Pos.CENTER);
        pan1.setAlignment(Pos.CENTER);
        scene1=new Scene(pan1, 400, 100);
        
        
        //金のボタン//              
        label2=new Label("あなたが押したのは金のボタンですか？");
        Button button4=new Button("はい");
        Button button5=new Button("いいえ");
        
        button4.setOnAction(e ->{
            ans=ans+2; 
             primaryStage.setScene(scene3);
        });
         button5.setOnAction(e ->{  
            primaryStage.setScene(scene3);
        });        
        
        HBox pane2=new HBox(10, button4, button5);
        VBox pan2=new VBox(10, label2, pane2);
        pane2.setAlignment(Pos.CENTER);
        pan2.setAlignment(Pos.CENTER);
        scene2=new Scene(pan2, 400, 100);
        
        
        //銀のボタン//
        label3=new Label("あなたが押したのは銀のボタンですか？");
        Button button6=new Button("はい");
        Button button7=new Button("いいえ");   
        button6.setOnAction(e ->{
            ans=ans+3;  
             primaryStage.setScene(scene4);
        });        
        button7.setOnAction(e ->{  
            primaryStage.setScene(scene4);
        }); 
               
        HBox pane3=new HBox(10, label3, button6, button7);
        VBox pan3=new VBox(10, label3, pane3);
        pane3.setAlignment(Pos.CENTER);
        pan3.setAlignment(Pos.CENTER);
        scene3=new Scene(pan3, 400, 100);
        
        
        //銅のボタン//
        label4=new Label("あなたが押したのは銅のボタンですか？");
        Button button8=new Button("はい");
        Button button9=new Button("いいえ");     
        
        button8.setOnAction(e ->{
            ans=ans+4;    
            if(start==ans)
                primaryStage.setScene(scene5);
            else
                primaryStage.setScene(scene6);
        });        
        button9.setOnAction(e ->{     
            primaryStage.setScene(scene5);
           if(start==ans)
                primaryStage.setScene(scene5);
            else
                primaryStage.setScene(scene6);
        }); 
               
        HBox pane4=new HBox(10, label4, button8, button9);
        VBox pan4=new VBox(10, label4, pane4);
        pane4.setAlignment(Pos.CENTER);
        pan4.setAlignment(Pos.CENTER);
        scene4=new Scene(pan4, 400, 100);
        
        
        //結果(正直者)//          
        label5=new Label("あなたは正直者です");
        Button button10=new Button("最初に戻る");
        Button button11=new Button("終了");
        
        button10.setOnAction(e ->{
            ans=0; 
            start=0;
            primaryStage.setScene(scene1);     
        });
        
        button11.setOnAction(e ->{
        stage.close();   
        });
        
        HBox pane5=new HBox(10, button10, button11);
        VBox pan5=new VBox(10, label5, pane5);
        pane5.setAlignment(Pos.CENTER);
        pan5.setAlignment(Pos.CENTER);
        scene5=new Scene(pan5, 400, 100);
        
        
        //結果(うそつき)//
        label6=new Label("あなたは嘘つきです");
        Button button12=new Button("最初に戻る");
        Button button13=new Button("終了");
        
        button12.setOnAction(e ->{
            ans=0; 
            start=0;
            primaryStage.setScene(scene1);     
        });
        
        button13.setOnAction(e ->{
        stage.close();   
        });

        HBox pane6=new HBox(10, button12, button13);
        VBox pan6=new VBox(10, label6, pane6);
        pane6.setAlignment(Pos.CENTER);
        pan6.setAlignment(Pos.CENTER);
        scene6=new Scene(pan6, 400, 100);
        
        
        
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--GoldenButtonApp");
    }

}

/* 考察 -- 調査したこと、考慮したこと、工夫したことを記述

はじめは正直者とうそつきを同じsceneで正確ならlabel5に正直者、間違いならlabel5にうそつきを入れるように書いていたがなぜか上手く動作しなかったためsceneを分けたやり方にしlabelもlabel6を作った。そうしたらようやく成功した。
金のボタンを押したら1、銀のボタンを押したら2、銅のボタンを押したら3、を入れるようにしておいたがその場合だと金と銀をおしても3になってしまい結果が正直者になってしまったためそれぞれ、金を2、銀を3、銅を3に変更した。
。

