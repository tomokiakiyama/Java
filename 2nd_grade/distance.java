/*
 * Ex10
 * 二次元空間上の点の位置を表す PointXY クラスにおいて、２つの点の距離（直線距離）を
 * 計算するクラスメソッド distance を作成せよ。
 *     static double distance(PointXY p, PointXY q): p点とq点の距離を計算
 *
 * 動作例: p(1, 2), q(3, 4) としたとき、distance(p, q) => 2.8284...
 *        ただし、(a, b) は X 座標の値が a で、Y 座標の値が b であることを示す。
 */

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
        return Math.sqrt((p.x-q.x)*(p.x-q.x)+(p.y-q.y)*(p.y-q.y));
    }
}

class Ex10 {
    static String gakuban = "16EC003"; // 学籍番号を入力すること
    static String yourname = "秋山智暉";  // 氏名を入力すること

/************************************************************
 ************************************************************
 * 実装したメソッドのテストプログラム。ここから下は変更禁止!!
 ************************************************************
 ************************************************************/
    private static String question = "Ex10";
    private static String method = "distance";

    // Execute test by comparing values Expected and Returned
    static void executeTest() {
        PointXY[] param1 = { // Checkpoint 1-1
            new PointXY(0, 0), new PointXY(1, 2), new PointXY(1, 2),
            new PointXY(1, 2), new PointXY(1, 2),};
        PointXY[] param2 = { // Checkpoint 1-2
            new PointXY(4, 0), new PointXY(5, 5), new PointXY(3, 4),
            new PointXY(-2, 1), new PointXY(-11, -3),};
        double[] expect = { // Checkpoint 2-1
            4., 5., 2.828427, 3.162278, 13.,};
        double d = 1e-6;
        System.out.printf("課題番号:%s, 学籍番号:%s, 氏名:%s\n",
                question, gakuban, yourname);
        int passed = 0;
        for (int i = 0; i < param1.length; i++) {
            String info1 = "", info2 = "";
            Exception ex = null;
            double returned = 0.; //3
            try {
                returned = PointXY.distance(param1[i], param2[i]); //4
                if (expect[i] > returned - d && expect[i] < returned + d) { //5
                    info1 = "OK";
                    passed++;
                } else {
                    info1 = "NG";
                    info2 = String.format(" <= SHOULD BE %.6f", expect[i]);
                }
            } catch (Exception e) {
                info1 = "NG";
                info2 = "EXCEPTION!!";
                ex = e;
            } finally {
                String line = String.format("*** Test#%d %s %s(p%s, q%s) => ",
                        i + 1, info1, method, param1[i], param2[i]);
                if (ex == null) {
                    System.out.println(line + String.format("%.6f", returned) + info2);
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