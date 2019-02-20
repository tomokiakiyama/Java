// キーボードから球の半径（実数）を読み込み、球の体積と表面積を表示せよ。

import java.util.Scanner;

class Ex02 {

    public static void main(String[] args) {
        String gakuban = "16EC003"; // 学籍番号を入力すること
        String yourname = "秋山智暉"; // 氏名を入力すること
        System.out.println(gakuban + " " + yourname + "\n"); // この行は削除しないこと

        final double PI = 3.1416;   // 円周率

        System.out.print("半径を入力してください。");// 半径の入力を促す
        Scanner stdIn=new Scanner(System.in);
        double x=stdIn.nextInt();// 球の半径を読み込む

        System.out.print("体積は"+((4*PI*x*x*x)/3));// 体積を表示
        System.out.print("表面積は"+(4*PI*x*x));// 表面積を表示
    }

}
