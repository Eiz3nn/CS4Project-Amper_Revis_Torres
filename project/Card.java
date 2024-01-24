package project;

import java.util.ArrayList;

public abstract class Card {
    private String name, description, category, type;
    private int id;
    private static ArrayList<Card> deckChance = new ArrayList<Card>();
    private static ArrayList<Card> deckCommunity = new ArrayList<Card>();
    
    public Card(String n, String d, String c, String t, int i){
        name = n;
        description = d;
        category = c;
        type = t;
        id = i;
        if(type == "chance"){deckChance.add(this);}
        if(type == "community"){deckCommunity.add(this);}
        
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the deckChance
     */
    public static ArrayList<Card> getDeckChance() {
        return deckChance;
    }

    /**
     * @return the deckCommunity
     */
    public static ArrayList<Card> getDeckCommunity() {
        return deckCommunity;
    }

}
