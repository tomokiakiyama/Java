// Exercise 14: Weather Application
package ex14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class WeatherApp extends Application {

    public static String gakuban = "16EC003"; // 学籍番号を入力すること
    public static String yourname = "秋山智暉"; // 氏名を入力すること
    
    public static File file = new File("Tokyo201707-1806.csv");

    ComboBox<Integer> cbmonth;
    TextField tfBottom;
    Button btnReset;
    Integer month,year;
    double min=100,max=0,wat=0;
    int mind,maxd,raind,watd=0,t=0;
    int n=0,h=0,m=0,w=0,ne=0,nw=0,se=0,sw=0,
                            nne=0,nnw=0,ene=0,ese=0,sse=0,ssw=0,wsw=0,wnw=0;
    Alert alert;
     
    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage primaryStage) {
        
        Scene scene1,scene2,scene3;
        Stage stage,stage1,stage2,stage3;
        stage=primaryStage;
        stage1=new Stage();
        stage2=new Stage();
        stage3=new Stage();
        ArrayList<DairyData> list = new ArrayList<>();
        ArrayList<String>data=new ArrayList<>();
        
        Label label1=new Label("月");
        tfBottom=new TextField("");
        
        
        //月の選択
        Integer[] money={1,2,3,4,5,6,7,8,9,10,11,12};
        ComboBox<Integer> cbmonth=new ComboBox<>();
        cbmonth.getItems().addAll(money);   
        Button result=new Button("決定");
        Label label=new Label("月を選択してください");
        
        Button end2=new Button("終了");
        HBox hbox=new HBox(10,cbmonth,label1,result);
        hbox.setAlignment(Pos.CENTER);
        VBox pane1=new VBox(10,label,hbox,end2);
        pane1.setAlignment(Pos.CENTER);        
                
        scene1 =new Scene(pane1,200,100);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("天候");
        primaryStage.show();
        
        //最高気温
        Label labelm,label0,label2,label3,label4,label5,label6;
        labelm=new Label("");
        label0=new Label("月の気象情報");
        HBox hbox0=new HBox(labelm,label0);
        hbox0.setAlignment(Pos.CENTER);
        
        label2=new Label("最高気温:");                  
        label3=new Label("");
        label4=new Label("日");
        HBox hbox11=new HBox(label3,label4);
        label5=new Label("");
        label6=new Label("度");
        HBox hbox12=new HBox(label5,label6);
        HBox hbox1=new HBox(5,label2,hbox11,hbox12);
        hbox1.setAlignment(Pos.CENTER);
        
        //最低気温
        Label label7,label8,label9,label10,label11;
        label7=new Label("最低気温:");
        label8=new Label("");
        label9=new Label("日");
        HBox hbox21=new HBox(label8,label9);
        label10=new Label("");
        label11=new Label("度");
        HBox hbox22=new HBox(label10,label11);
        HBox hbox2=new HBox(5,label7,hbox21,hbox22);
        hbox2.setAlignment(Pos.CENTER);
        
        //降水量
        Label label12,label13,label14,label15,label16;
        label12=new Label("降水量:");
        label13=new Label("");
        label16=new Label("mm");
        HBox hbox31=new HBox(label13,label16);
        label14=new Label("");
        label15=new Label("日間");
        HBox hbox32=new HBox(label14,label15);
        HBox hbox3=new HBox(8,label12,hbox31,hbox32);
        hbox3.setAlignment(Pos.CENTER);

        
        Label label17,label18;
        label17=new Label("気温折れ線グラフ");
        Button oresen=new Button("表示");
        HBox hbox41=new HBox(3,label17,oresen);
        label18=new Label("風向きの円グラフ");
        Button en=new Button("表示");
        HBox hbox42=new HBox(3,label18,en);
        HBox hbox4=new HBox(5,hbox41,hbox42);
        hbox4.setAlignment(Pos.CENTER);
        
        Button res=new Button("戻る");
        Button end=new Button("終了");
        HBox btn=new HBox(50,res,end);
        btn.setAlignment(Pos.CENTER);
        
        VBox pane2=new VBox(10,hbox0,hbox1,hbox2,hbox3,hbox4,btn);
        pane2.setAlignment(Pos.CENTER);
        scene2=new Scene(pane2,350,200);
        
        Label label19=new Label("最多風向き方向");
        Label label20=new Label("　北　"),label21=new Label("0"),label22=new Label("回　　東　"),label23=new Label("0"),
                label24=new Label("回　　南　"),label25=new Label("0"),label26=new Label("回　　西　"),label27=new Label("0"),label28=new Label("回");
        HBox hbox5=new HBox(5,label20,label21,label22,label23,label24,label25,label26,label27,label28);
        hbox5.setAlignment(Pos.CENTER);
        Label label29=new Label("　北東"),label30=new Label("0"),label31=new Label("回　　北西"),label32=new Label("0"),
                label33=new Label("回　　南東"),label34=new Label("0"),label35=new Label("回　　南西"),label36=new Label("0"),label37=new Label("回");
        HBox hbox6=new HBox(5,label29,label30,label31,label32,label33,label34,label35,label36,label37);
        hbox6.setAlignment(Pos.CENTER);
        Label label38=new Label("北北東"),label39=new Label("0"),label40=new Label("回　北北西"),label41=new Label("0"),
                label42=new Label("回　西北西"),label43=new Label("0"),label44=new Label("回　東北東"),label45=new Label("0"),label46=new Label("回");
        HBox hbox7=new HBox(5,label38,label39,label40,label41,label42,label43,label44,label45,label46);
        hbox7.setAlignment(Pos.CENTER);
        Label label47=new Label("南南東"),label48=new Label("0"),label49=new Label("回　南南西"),label50=new Label("0"),
                label51=new Label("回　東南東"),label52=new Label("0"),label53=new Label("回　西南西"),label54=new Label("0"),label55=new Label("回");
        HBox hbox8=new HBox(5,label47,label48,label49,label50,label51,label52,label53,label54,label55);
        hbox8.setAlignment(Pos.CENTER); 
        
        VBox pane3=new VBox(10,hbox5,hbox6,hbox7,hbox8);
        pane3.setAlignment(Pos.CENTER);
        scene3=new Scene(pane3,350,300);
        
        result.setOnAction((ActionEvent e)->{
            //データ挿入
            month=cbmonth.getValue();
            if(month==null){
                alert=new Alert(Alert.AlertType.ERROR,"選択してください");
                alert.showAndWait();  
            }
            else{
                
                try{ 
                    if(t==0){              
                BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"Shift-JIS"));
                String line=br.readLine();
                while(line!=null){
                    data.add(line);
                    line=br.readLine();
                }                
                    }
                for(int i=4;i<data.size();i++){
                    String[]dt=data.get(i).split(",");  
                    System.out.println(dt[2]);
                    if(month!=Integer.parseInt(dt[1]))
                        continue;                        
                    year=Integer.parseInt(dt[0]);
                    int day=Integer.parseInt(dt[2]);
                    
                    double x=Double.parseDouble(dt[4]);
                    if(x<min){
                        min=x;
                        mind=day;
                    }
                    double y=Double.parseDouble(dt[3]);
                    if(y>max){
                        max=y;
                        maxd=day;
                    }
                    double z=Double.parseDouble(dt[5]);
                    if(z!=0){
                        wat=wat+z;
                        watd=watd+1;
                    }                    
                    String s=dt[8];
                        if(s.equals("北"))
                            n+=1;
                        else if(s.equals("東"))
                            h+=1;                
                        else if(s.equals("南"))
                            m+=1;
                        else if(s.equals("西"))
                            w+=1;
                        else if(s.equals("北東"))
                            ne+=1;
                        else if(s.equals("北西"))
                            nw+=1;
                        else if(s.equals("南東"))
                            se+=1;
                        else if(s.equals("南西"))
                            sw+=1;
                        else if(s.equals("北北東"))
                            nne+=1;
                        else if(s.equals("北北西"))
                            nnw+=1;
                        else if(s.equals("東北東"))
                            ene+=1;
                        else if(s.equals("東南東"))
                            ese+=1;
                        else if(s.equals("南南東"))
                            sse+=1;
                        else if(s.equals("南南西"))
                            ssw+=1;
                        else if(s.equals("西南西"))
                            wsw+=1;
                        else if(s.equals("西北西"))
                            wnw+=1;                     
                        
                    list.add(new DairyData(day,x,y));
                }
                
                
        }catch(IOException a){
            System.out.println(e);            
        }
         if(month!=null){
             labelm.setText(Integer.toString(month));
             label3.setText(Integer.toString(maxd));   
             label5.setText(Double.toString(max));
             label8.setText(Integer.toString(mind));   
             label10.setText(Double.toString(min));
             label13.setText(Double.toString(wat));   
             label14.setText(Integer.toString(watd));
             label21.setText(Integer.toString(n));
             label23.setText(Integer.toString(h));
             label25.setText(Integer.toString(m));
             label27.setText(Integer.toString(w));
             label30.setText(Integer.toString(ne));
             label32.setText(Integer.toString(nw));
             label34.setText(Integer.toString(se));
             label36.setText(Integer.toString(sw));
             label39.setText(Integer.toString(nne));
             label41.setText(Integer.toString(nnw));
             label43.setText(Integer.toString(wnw));
             label45.setText(Integer.toString(ene));
             label48.setText(Integer.toString(sse));
             label50.setText(Integer.toString(ssw));
             label52.setText(Integer.toString(ese));
             label54.setText(Integer.toString(wsw));

             primaryStage.setScene(scene2); 
             primaryStage.setX(560);
             primaryStage.setY(200);
             
             stage2.setTitle("風向き");
             stage2.setScene(scene3);
             stage2.setX(200);
             stage2.setY(200);
             stage2.show();
         }}});
        
        oresen.setOnAction((ActionEvent e)->{
            XYChart.Series maxTempar=new XYChart.Series();     
             maxTempar.setName("最高気温");
             for(DairyData d:list){
                 if(d.maxTempar==100 && t!=0)
                     continue;
                 maxTempar.getData().add(new XYChart.Data(
                         d.getDayString(),d.maxTempar));                 
             }
             XYChart.Series minTempar=new XYChart.Series();
             minTempar.setName("最低気温");
             for(DairyData d:list){
                 if(d.minTempar==100 && t!=0)
                     continue;
                 minTempar.getData().add(new XYChart.Data(
                         d.getDayString(),d.minTempar));
             }
        final CategoryAxis xAxis=new CategoryAxis();
        final NumberAxis yAxis=new NumberAxis();
        xAxis.setLabel("日");
        yAxis.setLabel("気温（°C）");
        final LineChart<String,Number> lineChart
                =new LineChart<>(xAxis,yAxis);
        lineChart.setTitle("東京"+year+"年"+month+"月");
        lineChart.setLegendSide(Side.TOP);
        lineChart.getData().addAll(maxTempar,minTempar);
        
        Scene scene4=new Scene(lineChart);
        
       
        
        stage1.setTitle("気温変化");
        stage1.setScene(scene4);
        stage1.show();
        stage1.setX(1000);
        stage1.setY(0);
    });
        //円グラフ
         en.setOnAction(e->{
               Scene scene6 = new Scene(new Group());              
               stage3.setTitle("最多風向き");
               stage3.setWidth(500);
               stage3.setHeight(430);
               
               ObservableList<PieChart.Data> pieChartData
                       = FXCollections.observableArrayList(
                               new PieChart.Data("北", n),
                               new PieChart.Data("東", h),
                               new PieChart.Data("南", m),
                               new PieChart.Data("西", w),
                               new PieChart.Data("北東", ne),
                               new PieChart.Data("北西", nw),
                               new PieChart.Data("南東", se),
                               new PieChart.Data("南西", sw),
                               new PieChart.Data("北北東", nne),
                               new PieChart.Data("北北西", nnw),
                               new PieChart.Data("東北東", ene),
                               new PieChart.Data("東南東",ese),
                               new PieChart.Data("南南東", sse),
                               new PieChart.Data("南南西", ssw),
                               new PieChart.Data("西南西", wsw),
                               new PieChart.Data("西北西", wnw));
               
               final PieChart chart = new PieChart(pieChartData);
               chart.setTitle("最多風向き");
               final Label caption = new Label("");
               caption.setTextFill(Color.DARKORANGE);
               caption.setStyle("-fx-font: 24 arial;");
               chart.getData().stream().forEach((date) -> {
                   date.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                           (MouseEvent b) -> {
                               caption.setTranslateX(b.getSceneX());
                               caption.setTranslateY(b.getSceneY());
                               caption.setText(String.valueOf(date.getPieValue())
                                       + "%");
                           });
               });
               
               ((Group) scene6.getRoot()).getChildren().addAll(chart, caption);
               stage3.setScene(scene6);
               stage3.setX(1000);
               stage3.setY(434);
               stage3.show();
         });
         
          res.setOnAction(e->{
              stage1.close();
              stage2.close();
              stage3.close();
              min=100;max=0;wat=0;
              mind=0;maxd=0;raind=0;watd=0;
              n=0;h=0;m=0;w=0;ne=0;nw=0;se=0;sw=0;
              nne=0;nnw=0;ene=0;ese=0;sse=0;ssw=0;wsw=0;wnw=0;
              tfBottom=new TextField("");
              month=null;
              year=null;
              cbmonth.setValue(null);
              t+=1;
              
              XYChart.Series maxTempar=new XYChart.Series();     
             maxTempar.setName("最高気温");
             for(DairyData d:list){
                 d.maxTempar=100;
             }
             XYChart.Series minTempar=new XYChart.Series();
             minTempar.setName("最低気温");
             for(DairyData d:list){
                 d.minTempar=100;                         
             }
              
              primaryStage.setScene(scene1);
              primaryStage.setTitle("天候");
              primaryStage.show();      
          });
          end.setOnAction(e->{
              stage1.close();
              stage2.close();
              stage3.close();
              stage.close();      
          });
          end2.setOnAction(e->{
              stage1.close();
              stage2.close();
              stage3.close();
              stage.close();      
          });
         
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--" + gakuban + ":" + yourname);
    }
}
class DairyData {

    public int day;
    public double maxTempar;
    public double minTempar;

    public DairyData(int day, double maxTempar, double minTempar) {
        this.day = day;
        this.maxTempar = maxTempar;
        this.minTempar = minTempar;
    }

    public String getDayString() {
        return Integer.toString(day);
    }

    @Override
    public String toString() {
        return String.format("(%d, %f, %f)", day, maxTempar, minTempar);
    }
}

/* 考察 -- 調査したこと、考慮したこと、工夫したことを記述
今回のプログラムでは、まず指定した月のみの表示のプログラム作成に時間がかかった。integer型とstring型で比べることができなかっため、string型のものをinteger型に直してから比べるようにした。
風向きのヒストグラム作成では配列を用いたプログラム作成を試みたが表示させることがうまくいかなかったためすべての方位に変数を作る方法へ変えた。そのため変数の数が非常に多くなってしまった。
ヒストグラムとそれぞれのグラフで別のstageを用いたため表示させる際にすべてのstageが被らないように表示場所をずらした。これによって移動をさせなくてもすべてを一度に見ることができるため見やすくなった
一度表示させてからもう一度別の月のデータを表示させる際に折れ線グラフのデータ表示で前に表示させたデータが残ってしまいかなり見にくいグラフになってしまった。そのため戻るボタンを押したときに一度０を代入した。こうした場合は二回目以降のグラフには100が表示されてしまうが、100のを表示しないように条件分岐をつけることで特定のデータのみをグラフ化させることに成功した。


 */
