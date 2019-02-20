// Exercise 08: Ticket Calculator
package ex08;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;


public class TicketCalculator extends Application {

    public static String gakuban = "16EC003"; // 学籍番号を入力すること
    public static String yourname = "秋山智暉"; // 氏名を入力すること

    ComboBox<Integer> cbTicket, cbCount;
    TextField tfBottom;
    Button btnReset;

    @Override
    public void start(Stage primaryStage) {
        // 課題08-1
        Stage stage;
        stage=primaryStage;
        Label label1=new Label("チケット計算機");
        Label label2=new Label("料金");
        Label label3=new Label("枚数");
        Label label4=new Label("金額");
        tfBottom=new TextField("");
        btnReset=new Button("リセット");
        HBox hbox1,hbox2,hbox3,hbox4,hbox5;
        Integer tic[]={0,0};
        
        //料金
        Integer[] money={170,200,240,280,310};
        ComboBox<Integer> cbTicket=new ComboBox<>();
        cbTicket.getItems().addAll(money);
        
        //枚数
        Integer[] num={1,2,3,4,5};
        ComboBox<Integer> cbCount=new ComboBox<>();
        cbCount.getItems().addAll(num);
        
        
        hbox1=new HBox(label1);
        hbox2=new HBox(10,label2,cbTicket,label3, cbCount);
        hbox3=new HBox(10,label4,tfBottom,btnReset);
        hbox4=new HBox();
        hbox5=new HBox();
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.CENTER);        
        
        BorderPane pane;
        pane = new BorderPane(hbox2,hbox1,hbox4,hbox3,hbox5);
                
        Scene scene =new Scene(pane,250,130);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ticket Calculation");
        primaryStage.show();
        
        //課題2
        
        cbTicket.setOnAction(e->{
            tic[0]=cbTicket.getValue();
            tic[1]=cbCount.getValue();
            if(tic[0]!=null && tic[1]!=null)
                tfBottom.setText(String.valueOf(tic[0]*tic[1]));
        });
        
        cbCount.setOnAction(e->{
            tic[0]=cbTicket.getValue();
            tic[1]=cbCount.getValue();
            if(tic[0]!=null && tic[1]!=null)
                tfBottom.setText(String.valueOf(tic[0]*tic[1]));
        });
        
        btnReset.setOnAction(e ->{
            tfBottom.setText(null);
            cbTicket.setValue(null);
            cbCount.setValue(null);
        });
        
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--TicketCalculator");
    }

}
