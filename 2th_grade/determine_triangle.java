/*
 * Ex09
 * 三角形を表す Triangle クラスにおいて、三角形の種類を判定する以下の４つの
 * インスタンスメソッドを作成せよ。
 *    boolean isTriangle()    // 三辺の長さが三角形の構成条件を満たす場合に true
 *    boolean isEquilateral() // 正三角形の場合に true
 *    boolean isIsosceles()   // 二等辺三角形(正三角形を含む)の場合に true
 *    boolean isRectangled()  // 直角三角形の場合に true
 *
 * ただし、三辺の長さはインスタンスフィールドに整数で保持されるものとする。
 */

class Triangle {

    // フィールド（変更禁止）
    private int a, b, c;   // 三辺の長さ

    // コンストラクタ（変更禁止）
    public Triangle(int a, int b, int c) {
        this.a = a; this.b = b; this.c = c;
    }

    // 総合判定した結果を文字列表現するメソッド（変更禁止）
    public String getTypeName() {
        String result = "三角形";
        if (!isTriangle())
            result = "非" + result;
        else if (isEquilateral())
            result = "正" + result;
        else {
            if (isIsosceles())
                result = "二等辺" + result;
            if (isRectangled())
                result = "直角" + result;
        }
        return result;
    }
    
    // 三角形の構成条件を満たすか判定するメソッド
    boolean isTriangle() {
 if(this.a<this.b+this.c && this.b<this.a+this.c && this.c<this.a+this.b)
           return true;
       else
           return false;
    }
    
    // 正三角形か判定するメソッド
    boolean isEquilateral() {
   if(this.a==this.b && this.b==this.c && this.a==this.c)
           return true;
       else
           return false;
    }
    
    // 二等辺三角形か判定するメソッド
    boolean isIsosceles() {
        if(this.a==this.b || this.a==this.c || this.b==this.c)
            return true;
        else 
            return false; 
    }

    // 直角三角形か判定するメソッド
    boolean isRectangled() {
        if((this.a*this.a)==(this.b*this.b)+(this.c*this.c) || (this.b*this.b)==(this.a*this.a)+(this.c*this.c) || (this.c*this.c)==(this.b*this.b)+(this.a*this.b^2) )
           return true;
        else
           return false;
    }
}

class Ex09 {
    static String gakuban = "16EC003"; // 学籍番号を入力すること
    static String yourname = "秋山智暉";  // 氏名を入力すること

/************************************************************
 ************************************************************
 * 実装したメソッドのテストプログラム。ここから下は変更禁止!!
 ************************************************************
 ************************************************************/
    private static String question = "Ex09";
    private static String method = "Rectangle";

    // Execute test by comparing values Expected and Returned
    static void executeTest() {
        int[] param1 = { // Checkpoint 1-1
            5, 6, 7, 8, 10,};
        int[] param2 = { // Checkpoint 1-2
            5, 10, 5, 9, 5,};
        int[] param3 = { // Checkpoint 1-3
            5, 8, 3, 9, 5,};
        String[] expect = { // Checkpoint 2-1
            "正三角形", "直角三角形", "三角形", "二等辺三角形", "非三角形",};
        System.out.printf("課題番号:%s, 学籍番号:%s, 氏名:%s\n",
                question, gakuban, yourname);
        int passed = 0;
        for (int i = 0; i < param1.length; i++) {
            String info1 = "", info2 = "";
            Exception ex = null;
            String returned = null; //3
            Triangle triangle;
            try {
                triangle = new Triangle(param1[i], param2[i], param3[i]);
                returned = triangle.getTypeName(); //4
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
                String line = String.format("*** Test#%d %s %s(%s, %s, %s) => ",
                        i + 1, info1, method, param1[i], param2[i], param3[i]);
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
