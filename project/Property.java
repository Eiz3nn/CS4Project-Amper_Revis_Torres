package project;

import java.util.ArrayList;

public class Property extends Tile implements Obtainable{
    private int initialRent, value, rent;
    private ArrayList<Property> set = new ArrayList<Property>();
    private String setName;
    
    public Property(String n, String t, int i, int v, String s) {
        super(n, t);
        initialRent = i;
        value = v;
        setName = s;
    }
    
    public Player getOwner(){
        return owner;
    }

    /**
     * @return the initialRent
     */
    public int getInitialRent() {
        return initialRent;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the rent
     */
    public int getRent() {
        return rent;
    }

    /**
     * @return the set
     */
    public ArrayList<Property> getSet() {
        return set;
    }

    /**
     * @return the setName
     */
    public String getSetName() {
        return setName;
    }
    

}
