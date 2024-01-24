package project;

import java.util.ArrayList;

public class CardJail extends Card implements Obtainable{
    private int jailTime;
    private boolean getOutOfJailCard;
    private static ArrayList<CardJail> deckCardJail = new ArrayList<CardJail>();
    
    public CardJail(String n, String d, String c, int i, int j, boolean g){
        super(n,d,c,"CardJail",i);
        jailTime = j;
        getOutOfJailCard = g;
    }

    /**
     * @return the jailTime
     */
    public int getJailTime() {
        return jailTime;
    }

    /**
     * @return the getOutOfJailCard
     */
    public boolean isGetOutOfJailCard() {
        return getOutOfJailCard;
    }
    
    public static CardJail findById(int id){
        CardJail card = null;
        
        for(CardJail i : deckCardJail){
            if(i.getId() == id){
                card = i;
            }
        }   
        return card;
        // Throw idNotFoundException?
    }
}
