package dentaku;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Owner
 */
public class calculator extends Application {
    Stage stage;
    Scene scene;
    Label label0,label1,label2;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7, btn8, btn9,
            point,plus,minus,kakel,waru,ans,del,aldel,back,plumai;
    double num,num1,num2,b;
    int i,j,k,r,s;
    //i 小数判断　j 演算子を連続入力したときの変換　
    String str;
    
        
    @Override
    public void start(Stage primaryStage) {
        i=0;
        k=0;
        j=1;
        s=0;
        num=0;
        stage=primaryStage;
        
        //ボタンの表示
        btn0=new Button("0"); btn1=new Button("1");
        btn2=new Button("2"); btn3=new Button("3");
        btn4=new Button("4"); btn5=new Button("5");
        btn6=new Button("6"); btn7=new Button("7");
        btn8=new Button("8"); btn9=new Button("9");
        plus=new Button("+"); minus=new Button("-");
        kakel=new Button("*"); waru=new Button("/");
        aldel=new Button("     C     "); del=new Button("     CE      ");                
        point=new Button(". "); ans=new Button("="); 
         plumai=new Button("±");
        
        label1=new Label("");
        label0=new Label("0");
        
        point.setOnAction(e->{ 
            if(i==0)
                i=i+1;
                       
        });
        
        btn0.setOnAction(e->{ 
            if(i==0)
                num=num*10+0;
            else if(i>0){
                b=canma(i,b);
                num=num+(0/b); 
                i++;
            }
            k++;
            j++;
            label0.setText(String.valueOf(num)); 
        });
        
       btn1.setOnAction(e->{  
           if(i==0)
               num=num*10+1;
           else if(i>0){
               b=canma(i,b);
               num=num+(1/b); 
               i++;
           }
           k++;
           j++;
           label0.setText(String.valueOf(num));   
       });
        
        btn2.setOnAction(e->{   
            if(i==0)
                num=num*10+2;
            else if(i>0){
                b=canma(i,b);
                num=num+(2/b); 
                i++;
            }
            k++; 
            j++;
            label0.setText(String.valueOf(num));          
        });
        
        btn3.setOnAction(e->{  
            if(i==0)
                num=num*10+3;
            else if(i>0){
                b=canma(i,b);
                num=num+(3/b); 
                i++;
            }
            k++;
            j++;
            label0.setText(String.valueOf(num)); 
        });
        
        btn4.setOnAction(e->{  
            if(i==0)
                num=num*10+4;
            else if(i>0){
                b=canma(i,b);
                num=num+(4/b); 
                i++;
            }
            k++;
            j++;
            label0.setText(String.valueOf(num));          
        });
        
        btn5.setOnAction(e->{   
            if(i==0)
                num=num*10+5;
            else if(i>0){
                b=canma(i,b);
                num=num+(5/b); 
                i++;
            }
            k++;
            j++;
            label0.setText(String.valueOf(num));          
        });
        
        btn6.setOnAction(e->{   
            if(i==0)
                num=num*10+6;
            else if(i>0){
                b=canma(i,b);
                num=num+(6/b); 
                i++;
            }
            k++;
            j++;
            label0.setText(String.valueOf(num));          
        });
        
        btn7.setOnAction(e->{   
            if(i==0)
                num=num*10+7;
            else if(i>0){
                b=canma(i,b);
                num=num+(7/b); 
                i++;
            }
            k++;
            j++;
            label0.setText(String.valueOf(num));          
        });
        
        btn8.setOnAction(e->{
            if(i==0)
                num=num*10+8;
            else if(i>0){
                b=canma(i,b);
                num=num+(8/b); 
                i++;
            }
            k++;
            j++;
            label0.setText(String.valueOf(num));          
        });
        
        btn9.setOnAction(e->{
            if(i==0)
                num=num*10+9;
            else if(i>0){
                b=canma(i,b);
                num=num+(9/b); 
                i++;
            }
            k++;
            j++;
            label0.setText(String.valueOf(num));          
        });
        
         ans.setOnAction(e->{
             if(r==0)
                num1=num;
            if(k!=0) {
                num1=calcu(num1, num, r);
            }
        
                label1.setText("");
               if(r==4 && num==0)
                    label0.setText("0では割れません");
               else
                   label0.setText("ans="+String.valueOf(num1)); 
                str=(String.valueOf(num1));
                j=1; num=0; s=1; k=0;
        });     
         
        
        del.setOnAction(e->{
            i=0;
            k=0;
            num=0;
            label0.setText(String.valueOf(0));
        });
        
        aldel.setOnAction(e->{
            num=0; num1=0; r=0; k=0; j=1;i=0; 
            label0.setText(String.valueOf(0));
            label1.setText("");
            str=("");
            
        });
        
        
        plus.setOnAction(e->{           
            if(r==0)
                num1=num;
            if(k!=0) {
                num1=calcu(num1, num, r);
            }              

            if(j==0 || s==1)
                label1.setText(str+"+");                
            else{
                str=(label1.getText().trim()+String.valueOf(num));
                label1.setText(str+"+");
                if(r==4 && num==0)
                    label0.setText("0では割れません");
                else
                    label0.setText(String.valueOf(num1));
            }            
            num=0; r=1; k=0; j=0; i=0; s=0;
        });

        minus.setOnAction(e->{
            if(r==0)
                num1=num;
            if(k!=0) {
                num1=calcu(num1, num, r);
            }
            
            if(j==0 || s==1)
                label1.setText(str+"-");                
            else{
                str=(label1.getText().trim()+String.valueOf(num));
                label1.setText(str+"-");
                if(r==4 && num==0)
                    label0.setText("0では割れません");
                else
                    label0.setText(String.valueOf(num1));
            }
            num=0; r=2;  k=0; j=0; i=0; s=0;
        });
        
        kakel.setOnAction(e->{
            if(r==0)
                num1=num;
            if(k!=0) {
                num1=calcu(num1, num, r);
            }

            if(j==0 || s==1)
                label1.setText(str+"*");                
            else{
                str=(label1.getText().trim()+String.valueOf(num));
                label1.setText(str+"*");
                if(r==4 && num==0)
                    label0.setText("0では割れません");
                else
                    label0.setText(String.valueOf(num1));
            }
            num=0; r=3; k=0; j=0; i=0; s=0;
        });
        
        waru.setOnAction(e->{
            if(r==0)
                num1=num;
            if(k!=0) {
                num1=calcu(num1, num, r);
            }
            
            if(j==0 || s==1)
                label1.setText(str+"/");                
            else{
                str=(label1.getText().trim()+String.valueOf(num));
                label1.setText(str+"/");
                if(r==4 && num==0)
                    label0.setText("0では割れません");
                else
                    label0.setText(String.valueOf(num1));
                
            }
            num=0; r=4; k=0; j=0; i=0; s=0;        
        });

        
        //レイアウト
        HBox hbox1,hbox2,hbox3,hbox4,hbox5;
        hbox1=new HBox(10,del,aldel);
        hbox2=new HBox(15,btn7,btn8,btn9,waru);
        hbox3=new HBox(15,btn4,btn5,btn6,kakel);
        hbox4=new HBox(15,btn1,btn2,btn3,minus);
        hbox5=new HBox(15,btn0,point,ans,plus);
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.CENTER);
        hbox4.setAlignment(Pos.CENTER);
        hbox5.setAlignment(Pos.CENTER);
        
        VBox pane=new VBox(10,label1,label0,hbox1,hbox2,hbox3,hbox4,hbox5);
        pane.setAlignment(Pos.CENTER);        
        scene =new Scene(pane,200,250);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("電卓");
        primaryStage.show();    
    }
    
    //小数
    public static double canma(int i,double b)
    {
        b=1;
        for(int a=0;a<i;a++){
            b=b*10;           
        }
        return b;
    }
    
    //どの計算方法かの判断
    public static double calcu(double num1,double num2,int r)
    {
        if(r==1)
            num1=plus(num1,num2); 
       else if(r==2)
           num1=minus(num1,num2);
       else if(r==3)
           num1=kakel(num1,num2);
       else if(r==4)
           if(num2==0);
           else
               num1=waru(num1,num2);
        
        return num1;
    }
    
    public static double plus(double num1,double num2)
    {
        num1=num1+num2;
        return num1;
    }    
    public static double minus(double num1,double num2)
    {
        num1=num1-num2;
        return num1;
    }
    public static double kakel(double num1,double num2)
    {
        num1=num1*num2;
        return num1;
    }
    public static double waru(double num1,double num2)
    {
        num1=num1/num2;
        return num1;
    }        
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
