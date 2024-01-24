package project;

import java.util.ArrayList;

public class CardMove extends Card {
    private int posChange, posSet;
    private static ArrayList<CardMove> deckCardMove = new ArrayList<CardMove>();
    
    public CardMove(String n, String d, String c, int i, int C, int s){
        super(n,d,c,"CardMove",i);
        posChange = C;
        posSet = s;

    }

    /**
     * @return the posChange
     */
    public int getPosChange() {
        return posChange;
    }

    /**
     * @return the posSet
     */
    public int getPosSet() {
        return posSet;
    }
    
    public static CardMove findById(int id){
        CardMove card = null;
        
        for(CardMove i : deckCardMove){
            if(i.getId() == id){
                card = i;
            }
        }   
        return card;
        // Throw idNotFoundException?
    }
}
