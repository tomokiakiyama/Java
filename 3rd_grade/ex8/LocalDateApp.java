// Exercise 10: Local Date App
package ex10;

import java.time.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class LocalDateApp extends Application {

    public static String gakuban = "16EC003"; // 学籍番号を入力すること
    public static String yourname = "秋山智暉"; // 氏名を入力すること

    LocalDate date;
    Stage stage;
    Label labelYear, labelMonth, labelDay, labelWeek;
    MenuItem itemNow, itemExit, itemMonth, itemWeek, itemDay;

    public void showDate() {
        // 課題10-1のコードを記述
        int year = date.getYear();
        labelYear.setText(String.valueOf(year));

        int month = date.getMonthValue();
        labelMonth.setText(String.valueOf(month));

        int day = date.getDayOfMonth();
        labelDay.setText(String.valueOf(day));

        int Week = date.getDayOfWeek().getValue();
        String[] a = {"", "月", "火", "水", "木", "金", "土", "日"};
        labelWeek.setText(String.valueOf(a[Week]));
    }

    public void createMenuItems() {
        // 課題10-2のコードを記述
        itemNow = new MenuItem("今日(_N)");
        itemExit = new MenuItem("終了(_X)");
        itemMonth = new MenuItem("翌月(_M)");
        itemWeek = new MenuItem("翌週(_W)");
        itemDay = new MenuItem("翌日(_D)");

        itemNow.setOnAction(e -> {
            date=LocalDate.now();
            showDate();
        });
        
        itemExit.setOnAction(e -> {
            stage.close();

        });

        itemMonth.setOnAction(e -> {
            LocalDate newDate = date.plusMonths(1);
            date = newDate;
            showDate();
        });

        itemWeek.setOnAction(e -> {
            LocalDate newDate = date.plusDays(7);
            date = newDate;
            showDate();
        });

        itemDay.setOnAction(e -> {
            LocalDate newDate = date.plusDays(1);
            date = newDate;
            showDate();
        });
    }
   
    @Override
    public void start(Stage primaryStage) {
        // Create the Menu Items
        createMenuItems();

        // Create the Menu and MenuBar
        Menu menuFile = new Menu("ファイル(_F)");
        menuFile.getItems().addAll(itemNow, itemExit);
        menuFile.setOnAction(e -> {
        });
        Menu menuEdit = new Menu("編集(_E)");
        menuEdit.getItems().addAll(itemMonth, itemWeek, itemDay);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuEdit);

        // Create the Stage and Layout panes
        GridPane gridPane = new GridPane();
        gridPane.add(labelYear = new Label(), 0, 0);
        gridPane.add(new Label("年"), 1, 0);
        gridPane.add(labelMonth = new Label(), 0, 1);
        gridPane.add(new Label("月"), 1, 1);
        gridPane.add(labelDay = new Label(), 0, 2);
        gridPane.add(new Label("日"), 1, 2);
        gridPane.add(labelWeek = new Label(), 0, 3);
        gridPane.add(new Label("曜日"), 1, 3);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        ColumnConstraints cc0 = new ColumnConstraints();
        cc0.setPrefWidth(40);
        cc0.setHalignment(HPos.RIGHT);
        gridPane.getColumnConstraints().add(cc0);
        BorderPane borderPane = new BorderPane(gridPane);
        BorderPane.setAlignment(gridPane, Pos.CENTER);
        borderPane.setTop(menuBar);

        // Get the Today's Date
        date = LocalDate.now();
        showDate();

        // Create and show the Scene on the stage
        stage = primaryStage;
        primaryStage.setScene(new Scene(borderPane, 300, 200));
        primaryStage.setTitle("Local Date App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("完了--LocalDateApp");
    }

}
