package doudizhu1;

import java.util.ArrayList;
import java.util.Collections;

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
        //洗牌
        Collections.shuffle(list);
        //发牌
        ArrayList<String> lord=new ArrayList<>();
        ArrayList<String> player1=new ArrayList<>();
        ArrayList<String> player2=new ArrayList<>();
        ArrayList<String> player3=new ArrayList<>();

        //遍历牌盒得到每一张牌
        for (int i = 0; i < list.size(); i++) {
            String poker=list.get(i);
            if(i<=2){
                lord.add(poker);
                continue;
            }

            //给三个玩家轮流发牌
            if(i%3==0){
                player1.add(poker);
            }else if(i%3==1){
                player2.add(poker);
            }else if(i%3==2){
                player3.add(poker);
            }
        }

        //看牌
        lookPoker("底牌",lord);
        lookPoker("蔡徐坤",player1);
        lookPoker("真爱粉",player2);
        lookPoker("小黑紫",player3);

    }

    /*
    参数一：玩家的名字
    参数二：每位玩家的牌
     */
    public void lookPoker(String name,ArrayList<String> list){
        System.out.println(name+":");
        for(String poker:list){
            System.out.print(poker+" ");
        }
        System.out.println();

    }
}
