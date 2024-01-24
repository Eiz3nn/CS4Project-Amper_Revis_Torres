package project;

public class Tile {
    private String name, type;
    private int position;
    private Player visitor;
  
    
    public Tile(String t) {
        type = t;
    }   
    
    public Tile(String n, String t) {
        name = n;
        type = t;
    }  

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @return the visitor
     */
    public Player getVisitor() {
        return visitor;
    }


    
    
    
   
}
