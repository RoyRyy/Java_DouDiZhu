package doudizhu1;

import java.util.ArrayList;

public class PokerGame {

   static ArrayList<String> list=new ArrayList<>();

    static{

        String[] color={"♣","♦","♥","♠"};
        String[] number={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

        //牌盒
        //♥3 ♣3

        for(String c:color){
            //c依次表示每一种花色
            for (String n:number) {
                //n依次表示每一个数字
                list.add(c+n);
            }
        }
        list.add("小王");
        list.add("大王");
    }

    public PokerGame(){
        //准备牌
        System.out.println(list);
        //洗牌

        //发牌

        //看牌

    }
}
