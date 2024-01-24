package project;

import java.util.ArrayList;

public class CardMoney extends Card {
    private int moneyGive, moneyCollect;
    private static ArrayList<CardMoney> deckCardMoney = new ArrayList<CardMoney>();
    
    public CardMoney(String n, String d, String c, int i, int g, int C){
        super(n,d,c,"CardMoney",i);
        moneyGive = g;
        moneyCollect = C;

    }

    /**
     * @return the moneyGive
     */
    public int getMoneyGive() {
        return moneyGive;
    }

    /**
     * @return the moneyCollect
     */
    public int getMoneyCollect() {
        return moneyCollect;
    }
    
    public static CardMoney findById(int id){
        CardMoney card = null;
        
        for(CardMoney i : deckCardMoney){
            if(i.getId() == id){
                card = i;
            }
        }   
        return card;
        // Throw idNotFoundException?
    }
}
