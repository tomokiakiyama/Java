/*
 * Ex12
 * トランプのカードを表す Card クラスは、4種類のスーツと13種類のランクでカードの
 * 種類を表す。なお、スーツはClub, Diamond, Heart, Spadeの順に、1から4までの数を
 * 対応させ、ランクはA, 2, 3, ..., 10, J, Q, Kの順に、1から13の数を対応させる。
 *
 * Card クラスの。サブクラスとして ExCard クラスを派生させる。ExCard クラスは、
 * Card クラスの 52 種類のカードに加え、Joker（スーツ、ランクの値はともに0）を持つ。
 * この ExCard クラスにおいて、カードの文字列表現を返却する toString メソッドと、
 * 自身のカードと他のカードの順位を比較する compareTo メソッドを作成せよ。
 *    public String toString() 
 *    public int compareTo(ExCard that)
 * 
 * ただし、カードの順位は低い方から順に、Joker, Club-A, Club-2, Club-3, ..., Club-K,
 * Diamond-A, ..., Diamond-K, Heart-A, ..., Heart-K, Spade-A, ..., Spade-K とする。
 * また、toString メソッドは、インスタンスが Joker の場合は "Joker"、それ以外の場合は 
 * Card クラスの toString メソッドと同じ文字列を返却する。
 * また、compareTo メソッドは、自身と that が同じならば 0、自身の順位が低ければ -1、
 * 自身の順位が高ければ +1 を返却する。
 *
 * 動作例:
 *    ExCard me = ExCard(3, 13); // King of Heart
 *    ExCard you = ExCard(4, 1); // Ace of Spade
 *    int x = me.compareTo(you); // x の値は -1
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

/** 拡張 Card クラス */
class ExCard extends Card {
    
    private static final String JOKER = "Joker";

    ExCard(int suit, int rank) {
        super(suit, rank);
    }
    
    /** 拡張 Card の文字列表現を返却する */
    public String toString() {
        if(this.suit==0)
            return JOKER;
        else
            return super.toString();
    }
    
    /** 拡張 Card の大きさを比較する */
    public int compareTo(ExCard that) {
        if(this.suit<that.suit)
                return -1;
        else if(this.suit==that.suit){
            if(this.rank<that.rank)
                return -1;
            else if(this.rank>that.rank)
                return 1;
            else if(this.rank==that.rank)
                return 0;
        }
        else if(this.suit>that.suit)
            return 1;                        

        return 0;   // 不要ならばこの行を削除すること
    }
}

class Ex12 {
    static String gakuban = "16EC003"; // 学籍番号を入力すること
    static String yourname = "秋山智暉";  // 氏名を入力すること

/************************************************************
 ************************************************************
 * 実装したメソッドのテストプログラム。ここから下は変更禁止!!
 ************************************************************
 ************************************************************/
    private static String question = "Ex12";
    private static String method = "ExCard";

    // Execute test by comparing values Expected and Returned
    static void executeTest() {
        ExCard[] param1 = { // Checkpoint 1-1
            new ExCard(0, 0), new ExCard(3, 13), new ExCard(4, 1),
            new ExCard(4, 1), new ExCard(3, 1),};
        String[] expect = { // Checkpoint 2-1
            "Joker", "King of Heart", "Ace of Spade",
            "-1", "-1", "0", "1", "1",};
        System.out.printf("課題番号:%s, 学籍番号:%s, 氏名:%s\n",
                question, gakuban, yourname);
        for (int i = 0; i < param1.length; i++) {
            System.out.println("c" + i + " = new ExCard(" +
                    param1[i].suit + ", " + param1[i].rank + ");");
        }
        int passed = 0;
        for (int i = 0; i < 8; i++) {
            String info1 = "", info2 = "";
            Exception ex = null;
            String returned = ""; //3
            try {
                if (i < 3) {
                    returned += param1[i].toString();
                } else {
                    returned += param1[i - 3].compareTo(param1[(i - 2) % 5]);
                }
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
                String line;
                if (i < 3) {
                    line = String.format("*** Test#%d %s c%d.toString() => ",
                            i + 1, info1, i);
                } else {
                    line = String.format("*** Test#%d %s c%d.compareTo(c%d) => ",
                            i + 1, info1, i - 3, (i - 2) % 5);
                }
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