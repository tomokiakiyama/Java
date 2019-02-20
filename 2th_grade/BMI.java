/*
 * Ex07
 * 身長と体重からBMIを計算した結果を返却するメソッド getBMI を作成せよ。
 *     public static double getBMI(int height, double weight)
 *
 * ただし、パラメータの身長（height）は整数（単位はcm）、体重（weight）は実数（単位はkg）、
 * 返却値のBMIは実数であり、BMI ＝ 体重kg ÷ (身長m × 身長m) で計算されるものとする。
 * 例えば、getBMI(100, 20.0)の返却値は20.、getBMI(160, 64.)の返却値は25.。
 */

class Ex07 {
    static String gakuban = "16EC003"; // 学籍番号を入力すること
    static String yourname = "秋山智暉";  // 氏名を入力すること
    
    public static double getBMI(int height, double weight) {
              double BMI;
        BMI=(weight/(height*height))*10000;       
        
        return BMI; // 不要ならば削除すること
    }

/************************************************************
 ************************************************************
 * 実装したメソッドのテストプログラム。ここから下は変更禁止!!
 ************************************************************
 ************************************************************/
    private static String question = "Ex07";
    private static String method = "getBMI";

    // Execute test by comparing values Expected and Returned
    static void executeTest() {
        int[] param1 = { // Checkpoint 1-1
            100, 120, 150, 160, 200,};
        double[] param2 = { // Checkpoint 1-2
            20, 36, 40.5, 64, 90,};
        double[] expect = { // Checkpoint 2-1
            20, 25, 18, 25, 22.5,};
        double delta = 1.000001; // Checkpoint 2-2
        System.out.printf("課題番号:%s, 学籍番号:%s, 氏名:%s\n",
                question, gakuban, yourname);
        int passed = 0;
        for (int i = 0; i < param1.length; i++) {
            String info1 = "", info2 = "";
            Exception ex = null;
            double returned = 0.; //3
            try {
                returned = getBMI(param1[i], param2[i]); //4
                if (expect[i] > returned/delta && expect[i] < returned*delta) { //5
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
                String line = String.format("*** Test#%d %s %s(%s, %s) => ",
                        i + 1, info1, method, param1[i], param2[i]);
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