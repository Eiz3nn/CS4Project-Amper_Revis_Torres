package project;

import java.util.ArrayList;

public class Player {
    private String name;
    private int position, money, netWorth, jailTime;
    private boolean inTurn, inJail, inTrade;
    private ArrayList<Obtainable> inventory = new ArrayList<Obtainable>();
    private static ArrayList<Player> players = new ArrayList<Player>();
    private Board board;
    private Tile currentTile;
    private Property currentProperty;
    
   
    
    public Player(String n, Board b){
        name = n;
        position = 0;
        jailTime= 0;
        money = 1500;
        netWorth = 1500;
        board = b;
        board.addPlayer(this);
        players.add(this);
    }
    
    public Player(String n){
        name = n;
        position = 0;
        jailTime = 0;
        money = 1500;
        netWorth = 1500;
        players.add(this);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    /**
     * @return the netWorth
     */
    public int getNetWorth() {
        return netWorth;
    }

    /**
     * @return the jailTime
     */
    public int getJailTime() {
        return jailTime;
    }

    /**
     * @return the inTurn
     */
    public boolean isInTurn() {
        return inTurn;
    }

    /**
     * @return the inJail
     */
    public boolean isInJail() {
        return inJail;
    }

    /**
     * @return the inTrade
     */
    public boolean isInTrade() {
        return inTrade;
    }

    /**
     * @return the inventory
     */
    public ArrayList<Obtainable> getInventory() {
        return inventory;
    }

    /**
     * @return the players
     */
    public static ArrayList<Player> getPlayers() {
        return players;
    }
    
    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }
    
    /**
     * @return the currentTile
     */
    public Tile getCurrentTile() {
        return currentTile;
    }
    
    public Property getCurrentProperty() {
        return currentProperty;
    }
    
    public int roll(){
        return (((int)Math.floor(Math.random()*6))+((int)Math.floor(Math.random()*6)));
    }
    
    public void move(int n){
        position += n;
        if(position>39){
            position -= 40;
        }
        currentTile = board.getTiles().get(position);
        currentProperty = board.getProperties().get(position);
        
    }
    
    public void buy(Property p){
        if(money > p.getValue()){
            money -= p.getValue();
            System.out.printf("Property %s was successfully bought", p.getName());
        } else {
            // throw NotEnoughMoneyException
        }
    }
    
    public void drawCard(String category){
        ArrayList<Card> deck = new ArrayList<Card>();
        Card selected;
        
        switch(category){
            case "chance":
                deck = Card.getDeckChance();
                break;
                
            case "community":
                deck = Card.getDeckCommunity();
                break;
               
        }
        
        selected = deck.get((int)Math.floor(Math.random()*deck.size()));
        
        switch(selected.getType()){
            case "CardMove":
                CardMove cardmove = CardMove.findById(selected.getId());
                position = (cardmove.getPosChange() == 0) ? cardmove.getPosSet() : position + cardmove.getPosChange();
                if(position > 39){position-=39;}
                break;
                
            case "CardMoney":
                CardMoney cardmoney = CardMoney.findById(selected.getId());
                
                
                break;
                
            case "CardJail":
                CardJail.findById(selected.getId());
                break;
        }
        
    }
    
    public void tax(int tax){
        money -= tax;
    }
    
    
}
