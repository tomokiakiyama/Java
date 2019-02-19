/*
 * Ex11
 * 二次元空間上の線分を表す LineSeg クラスにおいて、PointXY クラスで表される点が
 * この線分上に存在するかどうかを判定するインスタンスメソッド isOnLineSeg を作成せよ。
 *     boolean isOnLineSeg(PointXY p): 点 p が線分上に存在すれば true を返す。
 * 
 * ただし、LineSeg クラスは、線分を PointXY クラスの 2 点で表す。
 * また、PointXY クラスは、前回の Ex10 で使用したものと同じである。 
 *
 * 動作例:
 *    LineSeg(a(2, 1), b(5, 7))のとき、isOnLineSeg(p(4, 5)) の返却値は true
 *    なお、z(x, y)は、座標(x, y)で表される点 z の位置を表している。
 */

// 二次元空間上の点を表すクラス
class PointXY {
    private int x, y;    // X, Y の座標値

    // コンストラクタ
    PointXY(int x, int y) { this.x = x; this.y = y; }

    // ゲッタ
    public int getX() { return x; }
    public int getY() { return y; }

    // オブジェクトの文字列表現を得るメソッド
    public String toString() { return "(" + x + ", " + y + ")"; }

    // ２つの点の距離を求めるクラスメソッド
    public static double distance(PointXY p, PointXY q) {
        double dx = p.getX() - q.getX();
        double dy = p.getY() - q.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}

// 二次元空間上の線分を表すクラス
class LineSeg {
    private PointXY a, b;    // 点 a, b 間の線分
    
    // コンストラクタ
    LineSeg(PointXY a, PointXY b) {
        this.a = new PointXY(a.getX(), a.getY());
        this.b = new PointXY(b.getX(), b.getY());
    }

    // オブジェクトの文字列表現を得るメソッド
    public String toString() {
        return "LineSeg(a" + a + ", b" + b + ")";
    }
    
    // 点が直線上に存在するかを判定するメソッド
    boolean isOnLineSeg(PointXY p) {
        if (a.getX()==b.getX()&&a.getX()==p.getX() || a.getY()==b.getY()&&a.getY()==p.getY())
            return true;
        
        double t=(a.getY()-b.getY())/(a.getX()-b.getX());
        double s=a.getY()-t*a.getX();
        if(p.getY()==t*p.getX()+s && ((a.getX()<=p.getX() && p.getX()<=b.getX())||b.getX()<=p.getX() && p.getX()<=a.getX()))
          return true;
        
        else
            return false;
    }
}

class Ex11 {
    static String gakuban = "16EC003"; // 学籍番号を入力すること
    static String yourname = "秋山智暉";  // 氏名を入力すること

/************************************************************
 ************************************************************
 * 実装したメソッドのテストプログラム。ここから下は変更禁止!!
 ************************************************************
 ************************************************************/
    private static String question = "Ex11";
    private static String method = "isOnLineSeg";

    // Execute test by comparing values Expected and Returned
    static void executeTest() {
        PointXY[] param1 = { // Checkpoint 1-1
            new PointXY(2, 1), new PointXY(7, 2), new PointXY(3, 3),
            new PointXY(0, 4), new PointXY(4, 5), new PointXY(6, 6),};
        PointXY[] param2 = { // Checkpoint 1-2
            new PointXY(5, 7), new PointXY(1, 8), new PointXY(3, 0),
            new PointXY(2, 3), new PointXY(6, 7), new PointXY(0, 0),};
        PointXY[] param3 = { // Checkpoint 1-3
            new PointXY(4, 5), new PointXY(3, 6), new PointXY(3, 1),
            new PointXY(0, 4), new PointXY(2, 3), new PointXY(4, 5),};
        boolean[] expect = { // Checkpoint 2-1
            true, true, true, true, false, false,};
        System.out.printf("課題番号:%s, 学籍番号:%s, 氏名:%s\n",
                question, gakuban, yourname);
        int passed = 0;
        for (int i = 0; i < param1.length; i++) {
            String info1 = "", info2 = "";
            Exception ex = null;
            boolean returned = false; //3
            try {
                LineSeg ls = new LineSeg(param1[i], param2[i]);
                returned = ls.isOnLineSeg(param3[i]); //4
                if (expect[i] == returned) { //5
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
                String line = String.format("*** Test#%d %s LineSeg(a%s, b%s).%s(p%s) => ",
                        i + 1, info1, param1[i], param2[i], method, param3[i]);
                if (ex == null) {
                    System.out.println(line + String.format("%s", returned) + info2);
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