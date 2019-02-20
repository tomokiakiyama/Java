/*
 * Ex07
 * 受け取った秒数を時・分・秒に変換し、フィールドに設定するメソッド setTime を作成せよ。
 *     void setTime(int secs)
 *
 * ただし、パラメータの秒数（secs）は正の整数であり、分（minute）と秒（second）は
 * 0 から 59 までの整数になるように変換すること。。
 * 例えば、setTime(3599)で設定される 時:分:秒 は 0:59:59。
 */

class Time {

    // フィールド（変更禁止）
    private int hour;   // 時
    private int minute; // 分
    private int second; // 秒

    // 時・分・秒を表示するためのメソッド（変更禁止）
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }

    // 時・分・秒を設定するメソッド
    void setTime(int secs) {
        // メソッドのコードを記入
        minute=secs/60;
        hour=minute/60;
        minute=minute%60;
        second=secs%60;
    }
}

class Ex08 {
    static String gakuban = "16EC003"; // 学籍番号を入力すること
    static String yourname = "秋山智暉";  // 氏名を入力すること

/************************************************************
 ************************************************************
 * 実装したメソッドのテストプログラム。ここから下は変更禁止!!
 ************************************************************
 ************************************************************/
    private static String question = "Ex08";
    private static String method = "setTime";

    // Execute test by comparing values Expected and Returned
    static void executeTest() {
        int[] param1 = { // Checkpoint 1-1
            3600, 3720, 3723, 3599, 45296,};
        String[] expect = { // Checkpoint 2-1
            "1:0:0", "1:2:0", "1:2:3", "0:59:59", "12:34:56",};
        System.out.printf("課題番号:%s, 学籍番号:%s, 氏名:%s\n",
                question, gakuban, yourname);
        int passed = 0;
        for (int i = 0; i < param1.length; i++) {
            String info1 = "", info2 = "";
            Exception ex = null;
            String returned = null; //3
            Time obj = new Time();
            try {
                obj.setTime(param1[i]); //4
                returned = obj.toString();
                if (expect[i].equals(returned)) { //5
                    info1 = "OK";
                    passed++;
                } else {
                    info1 = "NG";
                    info2 = String.format(" <= SHOULD BE %s", expect[i]);
                }
            } catch (Exception e) {
                info1 = "NG";
                info2 = "EXCEPTION!!";
                ex = e;
            } finally {
                String line = String.format("*** Test#%d %s %s(%s) => ",
                        i + 1, info1, method, param1[i]);
                if (ex == null) {
                    System.out.println(line + returned + info2);
                } else {
                    System.out.println(line + info2);
                    ex.printStackTrace();
                    // return;
                }
            }
        }
        System.out.printf("Summary: %s,%s,%s,%d/%d\n",
                question, gakuban, yourname, passed, param1.length);
    }

    // Main method
    public static void main(String[] args) {
        gakuban = gakuban.toUpperCase();
        if (!gakuban.matches("[1][0-9]EC[0-9]{3}")) {
            System.out.println("ERROR! 学籍番号に誤りがあります。");
        } else if (yourname.contains("千住")) {
            System.out.println("ERROR! 氏名に誤りがあります。");
        } else {
            executeTest();
        }
    }
}
