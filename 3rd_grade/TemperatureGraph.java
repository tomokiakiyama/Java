// Exercise 13: Temperature Graph App
package ex13;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class TemperatureGraph extends Application {

    public static String gakuban = "16EC003"; // 学籍番号を入力すること
    public static String yourname = "秋山智暉"; // 氏名を入力すること

    public static File file = new File("Tokyo201806.csv");

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage primaryStage) {
        // 以下に課題13のコードを記述       
        
        ArrayList<DairyData> list = new ArrayList<>();
        ArrayList<String>data=new ArrayList<>();
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"Shift-JIS"));
            String line=br.readLine();
            while(line!=null){
                data.add(line);
                line=br.readLine();
            }
            for(int i=2;i<data.size();i++){
                String[]dt=data.get(i).split(",");
                int day=Integer.parseInt(dt[2]);
                double x=Double.parseDouble(dt[3]);
                double y=Double.parseDouble(dt[4]);
                list.add(new DairyData(day,x,y));
            }
        }catch(IOException e){
            System.out.println(e);
        }
    
        XYChart.Series maxTempar=new XYChart.Series();     
        maxTempar.setName("最高気温");
        for(DairyData d:list){
            maxTempar.getData().add(new XYChart.Data(
                    d.getDayString(),d.maxTempar));
        }
        
        XYChart.Series minTempar=new XYChart.Series();
        minTempar.setName("最低気温");
        for(DairyData d:list){
            minTempar.getData().add(new XYChart.Data(
                     d.getDayString(),d.minTempar));
        } 
        
        final CategoryAxis xAxis=new CategoryAxis();
        final NumberAxis yAxis=new NumberAxis();
        xAxis.setLabel("日");
        yAxis.setLabel("気温（°C）");
        final LineChart<String,Number> lineChart
                =new LineChart<>(xAxis,yAxis);
        lineChart.setTitle("東京2018年6月");
        lineChart.setLegendSide(Side.TOP);
        lineChart.getData().addAll(maxTempar,minTempar);
        Scene scene=new Scene(lineChart);
        
       
        Stage stage;
        primaryStage.setTitle("Line Chart Sample2");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--TemperatureGraph");
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
