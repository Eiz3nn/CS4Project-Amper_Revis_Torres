package project;

public class Colored extends Property {
    private int houses, houseValue, hotelValue;
    private boolean hotel, setComplete;
    
    public Colored(String n, int i, int v, String s, int h){
        super(n, "colored", i, v, s);
        houseValue = h;
        
    }
}
