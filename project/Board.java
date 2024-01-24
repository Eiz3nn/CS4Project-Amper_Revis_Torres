package project;

import java.util.ArrayList;

public class Board {
    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Property> properties = new ArrayList<Property>();
    
    
    
    
    
    
    
   
   
    public Board(ArrayList<Tile> t, ArrayList<Player> p){
        tiles = t;
        players = p;
    }

    /**
     * @return the tiles
     */
    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    public ArrayList<Property> getProperties() {
        return properties;
    }
    
    
    public Board(ArrayList<Tile> t){
        tiles = t;
    }
      
    public void addPlayer(Player p){
        players.add(p);
    }
    
    public void removePlayer(Player p){ 
        players.remove(p);
    }
    
    public void addTile(Property t){
        tiles.add(t);
        properties.set(tiles.size(),t);
    }
    
    public void addTile(Tile t){
        tiles.add(t);
    }
    
    

    
    
        
}
