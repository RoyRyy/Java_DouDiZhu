package doudizhu3;

import java.util.ArrayList;
import java.util.Collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class PokerGame {
    static String[] color = new String[]{"♦", "♣", "♥", "♠"};
    static String[] number = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
    static ArrayList<Poker> pokerList = new ArrayList();
    static ArrayList<Poker> dipai = new ArrayList();
    static ArrayList<Poker> player1 = new ArrayList();
    static ArrayList<Poker> player2 = new ArrayList();
    static ArrayList<Poker> player3 = new ArrayList();

    public PokerGame() {
        Collections.shuffle(pokerList);

        for(int i = 0; i < pokerList.size(); ++i) {
            Poker index = (Poker)pokerList.get(i);
            if (i < 3) {
                dipai.add(index);
            } else if (i % 3 == 0) {
                player1.add(index);
            } else if (i % 3 == 1) {
                player2.add(index);
            } else {
                player3.add(index);
            }
        }

        this.order(dipai);
        this.order(player1);
        this.order(player2);
        this.order(player3);
        this.lookPoker(dipai, true);
        this.lookPoker(player1, true);
        this.lookPoker(player2, true);
        this.lookPoker(player3, true);
    }
    HashMap<String, Integer> hm = new HashMap();
    public void order(ArrayList<Poker> list) {

        hm.put("小王", 101);
        hm.put("大王", 102);
        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        Collections.sort(list, new Comparator<Poker>() {
            public int compare(Poker o1, Poker o2) {
                String color1 = o1.getPokerName().substring(0, 1);
                String number1 = o1.getPokerName().substring(1);
                String color2 = o2.getPokerName().substring(0, 1);
                String number2 = o2.getPokerName().substring(1);
                boolean value1 = false;
                boolean value2 = false;
                int value1x;
                if (hm.containsKey(number1)) {
                    value1x = (Integer)hm.get(number1);
                } else {
                    value1x = Integer.parseInt(number1);
                }

                int value2x;
                if (hm.containsKey(number2)) {
                    value2x = (Integer)hm.get(number2);
                } else {
                    value2x = Integer.parseInt(number2);
                }

                return value1x == value2x ? color1.compareTo(color2) : value2x - value1x;
            }
        });
    }

    /*
    public int getValue(String poker){
        //获取牌上的价值
        String number=poker.substring(1);
        if(hm.containsKey(number)){
            return hm.get(number);
        }else{
            return Integer.parseInt(number);
        }
    }

     */

    public void lookPoker(ArrayList<Poker> list, boolean show) {
        Poker poker;
        for(Iterator var3 = list.iterator(); var3.hasNext(); System.out.print("" + poker + " ")) {
            poker = (Poker)var3.next();
            if (show) {
                poker.setUp(show);
            }
        }

        System.out.println();
    }

    static {
        String[] var0 = number;
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            String n = var0[var2];
            String[] var4 = color;
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String c = var4[var6];
                Poker p = new Poker(c + n, false);
                pokerList.add(p);
            }
        }

        pokerList.add(new Poker("罒小王", false));
        pokerList.add(new Poker("罒大王", false));
    }
}