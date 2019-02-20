// 読み込んだ三つの整数値の中央値を表示せよ。
// 例えば、三つの整数値が 10,20,11 ならば、11 を表示する。
// 参考 教科書List 3-12

import java.util.Scanner;

class Ex03 {
    public static void main(String[] args) {
        String gakuban = "16EC003"; // 学籍番号を入力すること
        String yourname = "秋山智暉"; // 氏名を入力すること
        System.out.println(gakuban + " " + yourname + "\n"); // 削除しないこと

        Scanner stdIn = new Scanner(System.in);
        System.out.print("整数a：");  int a = stdIn.nextInt();
        System.out.print("整数b：");  int b = stdIn.nextInt();
        System.out.print("整数c：");  int c = stdIn.nextInt();

        int mid = 0;
        int x;
        
        if(a>=b){
        x=a;
        a=b;
        b=x;
        }
        if(b>=c){
        x=b;
        b=c;
        c=x;
    }
        if(a>=b){
        x=a;
        a=b;
        b=x;
    }
    mid=b;
        System.out.println("中央値は " + mid + " です。");
    }
}