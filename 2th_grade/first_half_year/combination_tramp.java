/*
 * Ex13
 * トランプのカードを表す Card クラスは、4種類のスーツと13種類のランクでカードの
 * 種類を表す。なお、スーツはClub, Diamond, Heart, Spadeの順に、1から4までの数を
 * 対応させ、ランクはA, 2, 3, ..., 10, J, Q, Kの順に、1から13の数を対応させる。
 *
 * 手持ちの 5 枚のカードを表す Hand クラスは、Card クラスの異なるインスタンス 5 個
 * を配列として持つ抽象クラスであり、下記の抽象メソッドを持つ。
 *    abstract int evaluate();
 *
 * Hand クラスのサブクラスである Pocker クラスにおいて上記メソッドを実装せよ。
 * ただし、evaluate メソッドは、5 枚のカードで構成される役を以下の条件で判定する
 * こと。
 * 条件a: 同じランクのカードが 4 枚あれば、4 を返却する。
 * 条件b: 条件aを満たさず、同じランクのカードが 3 枚あれば、3 を返却する。
 * 条件c: 条件bを満たさず、同じランクのカードが 2 枚あれば、2 を返却する。
 * 条件d: 条件cを満たさなければ、1 を返却する。
 * なお、ランクが 7-7-7-8-8 の場合は条件bを満たすので 3 を返却、
 * ランクが 7-7-8-8-9 の場合は条件cを満たすので 2 を返却すること。
 */

/** Card クラス 【変更禁止】 */
class Card {

    private static final String[] SUITS = {null, "Club", "Diamond", "Heart", "Spade"};
    private static final String[] RANKS = {null, "Ace", "2", "3", "4", "5", "6",
        "7", "8", "9", "10", "Jack", "Queen", "King"};
    protected int suit;
    protected int rank;

    Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString() {
        return RANKS[rank] + " of " + SUITS[suit];
    }
}

/** Hand クラス 【変更禁止】 */
abstract class Hand {
    
    protected Card[] hand;
    
    Hand() {
        hand = new Card[5];
    }
    
    void setCard(int i, int suit, int rank) {
        if (i >= 0 && i < 5)
            hand[i] = new Card(suit, rank);
    }
    
    public String toString() {
        String s = "";
        for (Card c: hand)
            s += c.toString() + ", ";
        return s;
    }
    
    abstract int evaluate();
}

/** Pocker クラス */
class Pocker extends Hand {
    
    /** 役を判定する */
    int evaluate() {
        int[] a=new int[5];
        a[0]=1;
        a[1]=1;
        a[2]=1;
        a[3]=1;
        int max=0;
        int i;
        int j;
        for(i=0;i<=4;i++){
            for(j=0;j<=4;j++){
                if(i==j)
                    continue;
                
                if(hand[i].rank==hand[j].rank)
                    a[i]=a[i]+1;
            }
        }
        for(i=0;i<=4;i++){
            if(max<a[i])
                max=a[i];
         }           
        return max; 
    }
}

class Ex13 {
    static String gakuban = "16EC003"; // 学籍番号を入力すること
    static String yourname = "秋山智暉";  // 氏名を入力すること

/************************************************************
 ************************************************************
 * 実装したメソッドのテストプログラム。ここから下は変更禁止!!
 ************************************************************
 ************************************************************/
    private static String question = "Ex13";
    private static String method = "evaluate";

    // Execute test by comparing values Expected and Returned
    static void executeTest() {
        int[] param1 = { // Checkpoint 1-1
            2, 3, 5, 7, 9,};
        int[] expect = { // Checkpoint 2-1
            1, 2, 3, 4, 3};
        System.out.printf("課題番号:%s, 学籍番号:%s, 氏名:%s\n",
                question, gakuban, yourname);
        Pocker test = new Pocker();
        for (int i = 0; i < 5; i++) {
            test.setCard(i, i % 4 + 1, param1[i]);
        }
        int passed = 0;
        for (int i = 0; i < param1.length; i++) {
            if (i > 0 && i < 4)
                test.setCard(i, i % 4 + 1, 9);
            else if (i == 4)
                test.setCard(1, 2, 2);
            System.out.println(test);
            String info1 = "", info2 = "";
            Exception ex = null;
            int returned = 0; //3
            try {
                returned = test.evaluate();
                if (expect[i] == (returned)) { //5
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
                String line;
                line = String.format("*** Test#%d %s %s() => ",
                            i + 1, info1, method);
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
                question, gakuban, yourname, passed, 8);
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