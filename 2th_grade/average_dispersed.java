/*
 * Ex06
 * 整数の配列 x の全要素の平均 u と分散 v を出力するプログラムを作成せよ。
 * なお、平均は u = 1/n Σ(xi)、分散は v = 1/n Σ((xi-u)*(xi-u))
 * ただし、xi は各要素、n は要素数、平均と分散は実数とする。
 * 例えば、x = {1, 2, 3, 4} ならば 平均 u = 2.50, 分散 v = 1.25 を出力。
 */
 
import java.util.Scanner;

class Ex06 {
    public static void main(String[] args) {
        String gakuban = "16EC003"; // 学籍番号を入力すること
        String yourname = "秋山智暉"; // 氏名を入力すること
        System.out.println(gakuban + " " + yourname + "\n"); // 削除しないこと

        Scanner stdIn = new Scanner(System.in);
        System.out.print("配列の要素数：");
        int n = stdIn.nextInt();        // 要素数
        
        int[] x = new int[n];           // 配列
        for(int i = 0; i < n; i++) {
            System.out.printf("x[%d]：", i);
            x[i] = stdIn.nextInt();     // 要素の値
        }
        
        double u = 0.;      // 平均
        double v = 0.;      // 分散

        /*平均*/
        for(int i = 0; i < n; i++) {
            u=u+x[i];
        }
        u=u/n;

       /*分散*/
       for(int i = 0; i < n; i++) {
            v=v+((x[i]-u)*(x[i]-u));
        }
       v=v/n;
        
        
        
        
        // 以下の行は削除しないこと
        System.out.printf("平均 u = %4.2f, 分散 v = %4.2f\n", u, v); // 結果を出力する
    }
}

