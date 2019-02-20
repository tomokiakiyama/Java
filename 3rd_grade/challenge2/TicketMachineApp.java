// Exercise 09: Ticket Machine Application
package ex09;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class TicketMachineApp extends Application {

    public static String gakuban = "16EC003"; // 学籍番号を入力すること
    public static String yourname = "秋山智暉"; // 氏名を入力すること
    @Override
    public void start(Stage primaryStage) {
        // プログラムを作成   
        Integer tic[]={null,null};
                
        //Create GridPane
        GridPane pane=new GridPane();
        pane.setHgap(10);
        pane.setVgap(20);
        
        
        //Create Header
        Label label1=new Label("自動券売機");
        label1.setUnderline(true);
        pane.add(label1,1, 1, 5, 1);
        GridPane.setHalignment(label1, HPos.CENTER);
        
        Label label2=new Label("発券ボタンを押してください");
        pane.add(label2,1, 2, 5, 1);
        GridPane.setHalignment(label2, HPos.CENTER);

                
        //Create Ticket&number Selecter
        Label label3=new Label("料金");
        Integer[] ticket={170,200,240,280,310};
        ComboBox<Integer> cbTicket=new ComboBox<>();
        cbTicket.getItems().addAll(ticket);
       
        Label label4=new Label("枚数");        
        Integer[] num={1,2,3,4,5};
        ComboBox<Integer> cbCount=new ComboBox<>();
        cbCount.getItems().addAll(num);
        
        HBox hbox1=new HBox(10,label3,cbTicket,label4,cbCount);
 
        
        //Create Button
        Button btn500=new Button("500円"); 
        Button btn100=new Button("100円");
        Button btn50=new Button("50円");
        Button btn10=new Button("10円");
        HBox hbox2=new HBox(5,btn500,btn100,btn50,btn10);
        
        VBox vbox2=new VBox(20,hbox1,hbox2);
        GridPane.setHalignment(vbox2,HPos.LEFT);
        
        pane.add(vbox2,1,3);
        
       
        //Create Money
        Label label5=new Label("必要金額");        
        TextField text1=new TextField(null);
        text1.setPrefColumnCount(5);
        text1.setEditable(false);
        HBox hbox3=new HBox(5,label5,text1);
        
        Label label6=new Label("投入金額");
        TextField text2=new TextField("0");  
        text2.setPrefColumnCount(5);
        text2.setEditable(false);
        HBox hbox4=new HBox(5,label6,text2);    
        
        VBox vbox3=new VBox(20,hbox3,hbox4);         
        GridPane.setHalignment(vbox3,HPos.RIGHT);
        
        pane.add(vbox3,3,3);
        
        
        //Create Moving
        Button btnSet=new Button("発券する");
        pane.add(btnSet,1, 4, 2, 3);
        GridPane.setHalignment(btnSet, HPos.CENTER);
        
        Button btnReset=new Button("キャンセル");
        pane.add(btnReset,2, 4, 2, 3);
        
        
        //表示
        Scene scene2,scene3,scene4,pan;
        pan=new Scene(pane,375,250);
        primaryStage.setScene(pan);
        primaryStage.setTitle("Ticket Vending Machine");
        primaryStage.show();
        
        
        //error.1        
        Label labelER1=new Label("チケットの種類と枚数を選択してください");
        Button back1=new Button("戻る");
        VBox vbox4=new VBox(10,labelER1,back1);
        vbox4.setAlignment(Pos.CENTER);
        scene2=new Scene(vbox4,300,200);        
        
        //error.2
        Label labelER2=new Label("お金が足りません"); 
        Button back2=new Button("戻る");
        VBox vbox5=new VBox(10,labelER2,back2);
        vbox5.setAlignment(Pos.CENTER);
        scene3=new Scene(vbox5,300,200);
        
        
        //scecces
        Label label7=new Label("");
        Label label8=new Label("");
        Label label9=new Label("");        
        Button check=new Button("確認");
        VBox vbox6=new VBox(label7,label8,label9,check);
        vbox6.setAlignment(Pos.CENTER);
        scene4=new Scene(vbox6,300,200);        
        
        
        //Button Action
        
        cbTicket.setOnAction(e->{
            tic[0]=cbTicket.getValue();
            tic[1]=cbCount.getValue();
            if(tic[0]!=null && tic[1]!=null)
                text1.setText(String.valueOf(tic[0]*tic[1]));
        });
        
        cbCount.setOnAction(e->{
            tic[0]=cbTicket.getValue();
            tic[1]=cbCount.getValue();
            if(tic[0]!=null && tic[1]!=null)
                text1.setText(String.valueOf(tic[0]*tic[1]));
        });
        
        
        btn500.setOnAction(e->{
            int num1=Integer.parseInt(text2.getText().trim());
            text2.setText(String.valueOf(num1+500));
        });
        
        btn100.setOnAction(e->{
            int num1=Integer.parseInt(text2.getText().trim());
            text2.setText(String.valueOf(num1+100));
        });
        
        btn50.setOnAction(e->{
            int num1=Integer.parseInt(text2.getText().trim());
            text2.setText(String.valueOf(num1+50));
        });
        
        btn10.setOnAction(e->{
            int num1=Integer.parseInt(text2.getText().trim());
            text2.setText(String.valueOf(num1+10));
        });
        
        btnReset.setOnAction(e->{
            cbTicket.setValue(null);
            cbCount.setValue(null);
            text1.setText(null);
            text2.setText("0");
        });
        
        btnSet.setOnAction(e->{
            if(tic[0]==null || tic[1]==null)
                primaryStage.setScene(scene2);        
            else {
                int result=Integer.parseInt(text1.getText().trim());
                int money=Integer.parseInt(text2.getText().trim());
                
                if(result>money)
                    primaryStage.setScene(scene3);
                else{label7.setText("ご購入チケット  "+String.valueOf(tic[0]));
                    label8.setText("     枚数　　　  "+String.valueOf(tic[1])+"枚");
                    label9.setText(" 　 　おつり　　 　"+Integer.toString(money-result)+"円");
                    primaryStage.setScene(scene4);
                }
            }            
        });
        
        back1.setOnAction(e->{
            cbTicket.setValue(null);
            cbCount.setValue(null);
            text1.setText(null);
            text2.setText("0");
            primaryStage.setScene(pan);
        });
        
        back2.setOnAction(e->{
            primaryStage.setScene(pan);
        });
        
        check.setOnAction(e->{
            cbTicket.setValue(null);
            cbCount.setValue(null);
            text1.setText(null);
            text2.setText("0");
            primaryStage.setScene(pan);
        });
        
        
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--" + gakuban + ":" + yourname);
    }

}

/* 考察 -- 調査したこと、考慮したこと、工夫したことを記述
プログラミングの記述した順番によってlabel7とlabel8とlabel9に一過程無駄ができてしまった。scene作成ごとにボタン作成を行えばこの無駄が省けた。
今回のプログラム作成によってLabelに下線を引く方法、TextFieldを入力不可にする方法を理解できた。
 */
