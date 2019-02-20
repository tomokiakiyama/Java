// Exercise 03-2: AddTax Application
package ex03;

import java.util.function.LongUnaryOperator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import java.text.NumberFormat;

public class AddTaxApp extends Application {

    public static String gakuban = "16EC003"; // 学籍番号を入力すること
    public static String yourname = "秋山智暉"; // 氏名を入力すること

    // 税込み価格を計算するラムダ式
    public static LongUnaryOperator addTax
        // 課題03-1のコードを記述
	=(price) ->  (long) (price*(1+0.01*8))/10*10;
	

    @Override
    public void start(Stage primaryStage) {
        // 課題03-2のコードを記述
 //ラベル作成
        Label label=new Label("税抜き価格");
        //テキストフィールド作成
        TextField textField_1=new TextField();
        TextField textField_2=new TextField();
        //ボタン作成
        Button button=new Button("税込み価格に変換する");

        //イベント作成
        button.setOnAction((ActionEvent event) ->{
            String p =textField_1.getText().trim();
            if(p.length()==0)
                textField_2.setText("0");
            else{
                 textField_2.setText("0");
                 long pl=Long.parseLong(p);
                 if(pl>=0){
                     long str=addTax.applyAsLong(pl);
                     NumberFormat nfNum = NumberFormat.getNumberInstance();    //カンマ区切り形式
                     textField_2.setText(""+nfNum.format(str));
                 }
                 else
                     textField_2.setText("0");
            }});  
   
        //ペインを作成
        VBox pane =new VBox(label,textField_1,button,textField_2);
        Scene scene=new Scene(pane,300,100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--AddTaxApp");
    }

}
