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

    public static String gakuban = "16EC003"; // �w�Дԍ�����͂��邱��
    public static String yourname = "�H�R�q��"; // ��������͂��邱��

    // �w�Дԍ����������`�����ǂ����𔻒肷�郁�\�b�h
    public static boolean checkSID(String sid) {
        // �ۑ�02-1�̃R�[�h���L�q
          return sid.matches("[0-9][0-9][E|e][C|c][0-9][0-9][0-9]");
    }

    @Override
    public void start(Stage primaryStage) {
        // �ۑ�02-2�̃R�[�h���L�q
               Label label_1=new Label("�w�Дԍ�");
        TextField textField=new TextField();
        
        Button button=new Button("�m�F");
        
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
        // �A�v���P�[�V�������N������
        Application.launch(args);
        System.out.println("����--CheckSIDApp");
    }

}
