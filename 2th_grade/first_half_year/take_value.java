// 正の整数 n を読み込み、1 以上 n 以下で、かつ 2, 3, 5, 7 のいずれでも割り切れない整数を同じ行に昇順に表示する。
// なお、n は 1 から 50 までの値が入力されるものとする。
// 出力例　1, 11, 13, 17, 19, ・・・
// 参考 教科書List 4-12

import java.util.Scanner;

class Ex04 {
    public static void main(String[] args) {
        String gakuban = "16EC003"; // 学籍番号を入力すること
        String yourname = "秋山智暉"; // 氏名を入力すること
        System.out.println(gakuban + " " + yourname + "\n"); // 削除しないこと

        Scanner stdIn = new Scanner(System.in);
        System.out.print("正の整数：");  int n = stdIn.nextInt();

        int a=0;

        while(a<=n){
        if(a%2!=0)
        if(a%3!=0)
        if(a%5!=0)
        if(a%7!=0)
        System.out.print(a+" ");
        a=a+1;
        }
    }
}