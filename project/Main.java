package project;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        String input;

        ArrayList<Tile> tiles = new ArrayList<Tile>(); 

        Tile tile0 = new Tile("GO","go");                                   // 0th tile
        Tile tile1 = new Colored("Ajisakki",2,50,"yellow",10);
        Tile tile2 = new Tile("Lunch Period","community");
        Tile tile3 = new Colored("Back Lobby",5,70,"yellow",20);
        Tile tile4 = new Tile("Late Tax","inc");
        Tile tile5 = new Railroad("Hallway",25,200,"common area");          // 5th tile
        Tile tile6 = new Colored("Chem Unit",7,90,"amber",20);
        Tile tile7 = new Tile("Study Period","chance");
        Tile tile8 = new Colored("Bio Unit",9,100,"amber",30);
        Tile tile9 = new Colored("Res Unit",10,110,"amber",40);
        Tile tile10 = new Tile ("Discipline Office", "free");               // 10th tile
        Tile tile11 = new Colored("Library",13,140,"orange",40);
        Tile tile12 = new Utility("Classrooms",150,120,"utility");
        Tile tile13 = new Colored("GCU",13,140,"orange",50);
        Tile tile14 = new Colored("Humanities Faculty",14,160,"orange",60);
        Tile tile15 = new Railroad("Pavement",25,200,"common area");        // 15th tile
        Tile tile16 = new Colored("Learning Center",15,180,"black",60);
        Tile tile17 = new Tile("Lunch Period","community");
        Tile tile18 = new Colored("3F Auditorium",15,180,"black",70);
        Tile tile19 = new Colored("Math Faculty",16,190,"black",80);
        Tile tile20 = new Tile("Gym Parking","free");                       // 20th tile
        Tile tile21 = new Colored("Basketball Court",17,210,"navy",80);
        Tile tile22 = new Tile("Study Period","chance");
        Tile tile23 = new Colored("Gym",18,230,"navy",90);
        Tile tile24 = new Colored("Pool",20,240,"navy",90);
        Tile tile25 = new Railroad("Corridor",25,200,"common area");        // 25th tile
        Tile tile26 = new Colored("Front Lobby",21,250,"gray",100);
        Tile tile27 = new Colored("Admin Bldg",23,270,"gray",110);
        Tile tile28 = new Utility("Labs",150,120,"utility");
        Tile tile29 = new Colored("Gate 1",24,280,"gray",110);
        Tile tile30 = new Tile("Go to Disciplinary Office","jail");         // 30th tile
        Tile tile31 = new Colored("ASTB Hall",25,290,"cyan",130);
        Tile tile32 = new Colored("CS Unit",26,300,"cyan",140);
        Tile tile33 = new Tile("Lunch Period","community");
        Tile tile34 = new Colored("Physics Unit",27,320,"cyan",160);
        Tile tile35 = new Railroad("Stairwell",25,200,"common area");       // 35th tile
        Tile tile36 = new Tile("Study Period","chance");
        Tile tile37 = new Colored("Kalachuchi Lane",37,370,"blue",170);
        Tile tile38 = new Tile("Absent Tax","super");
        Tile tile39 = new Colored("Field",60,450,"blue",190);

        Board b1 = new Board(tiles);

        b1.addTile(tile0);
        b1.addTile(tile1);
        b1.addTile(tile2);
        b1.addTile(tile3);
        b1.addTile(tile4);
        b1.addTile(tile5);
        b1.addTile(tile6);
        b1.addTile(tile7);
        b1.addTile(tile8);
        b1.addTile(tile9);
        b1.addTile(tile10);
        b1.addTile(tile11);
        b1.addTile(tile12);
        b1.addTile(tile13);
        b1.addTile(tile14);
        b1.addTile(tile15);
        b1.addTile(tile16);
        b1.addTile(tile17);
        b1.addTile(tile18);
        b1.addTile(tile19);
        b1.addTile(tile20);
        b1.addTile(tile21);
        b1.addTile(tile22);
        b1.addTile(tile23);
        b1.addTile(tile24);
        b1.addTile(tile25);
        b1.addTile(tile26);
        b1.addTile(tile27);
        b1.addTile(tile28);
        b1.addTile(tile29);
        b1.addTile(tile30);
        b1.addTile(tile31);
        b1.addTile(tile32);
        b1.addTile(tile33);
        b1.addTile(tile34);
        b1.addTile(tile35);
        b1.addTile(tile36);
        b1.addTile(tile37);
        b1.addTile(tile38);
        b1.addTile(tile39);

        Player p1 = new Player("Shawn",b1);
        Player p2 = new Player("Gio",b1);
        Player p3 = new Player("Eizen",b1);
       
        boolean valid = false;
       
       
        while(b1.getPlayers().size()>1){
            for(Player i : b1.getPlayers()){
                while(i.ifInTurn()){
                    System.out.println("Would you like to do any actions?");
                    System.out.println("Choices: ");
                    System.out.println("1 - Roll");
                    System.out.println("2 - View inventory");
                    System.out.println("3 - Buy houses");
                    System.out.println("4 - Sell houses");
                    System.out.println("5 - Mortgage properties");
                    System.out.println("6 - Unmortgage properties");
                    System.out.println("7 - Trade");
                    System.out.println("8 - End turn\n");

                    input = scanner.nextLine();
                
                    switch(input){
                        
                        case "1": // SCENARIO 1:
                            i.move(i.roll());
                            System.out.printf("You arrived at %s, located at tile %d.\n",i.getCurrentTile().getName(),b1.getTiles().indexOf(i.getCurrentTile()));

                            switch (i.getCurrentTile().getType()) {
                                case "colored":           
                                case "railroad":
                                case "utility":
                                    if(i.getCurrentProperty().getOwner() == null){
                                        System.out.println("Property is not yet owned. Would you like to purchase this property? (y/n)");
                                        System.out.printf("Property costs %d PhP", b1.getProperties().get(b1.getTiles().indexOf(i.getCurrentTile())).getValue());
                                        input = scanner.nextLine();

                                        while(!valid) {
                                            switch(input){
                                                case "y":
                                                    i.buy(i.getCurrentProperty());
                                                    valid = true;
                                                    break;

                                                case "n":
                                                    System.out.printf("Property %s was not bought", i.getCurrentProperty().getName());
                                                    valid = true;
                                                    break;

                                                default:
                                                    System.out.println("Invalid input. Please try again.");
                                            }
                                        }
                                        valid = false;

                                    } else {
                                        i.pay(i.getCurrentProperty().getOwner(),i.getCurrentProperty().getRent());
                                    }
                                    break;


                                case "chance": // SCENARIO 2.1
                                    i.drawCard("chance");
                                    break;

                                case "community": // SCENARIO 2.2
                                    i.drawCard("community");
                                    break;

                                case "free":
                                    // do nothing
                                    break;

                                case "income":
                                    i.tax(100);
                                    break;

                                case "super":
                                    i.tax(200);
                                    break;

                                case "jail": // SCENARIO 3
                                    i.goToJail();
                                    i.endTurn();
                                    break;
                            }         
                            break;

                        case "2":
                            break;
                            
                        case "3":
                            break;

                        case "4":
                            break;

                        case "5":
                            break;

                        case "6":
                            break;
                              
                        case "7": 

                        case "8":
                            i.endTurn();
                            break;
                            
                        default:
                            // Throw invalidActionException
                    }

                }
            }
               
        }
    }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       

    }
    
    /* 
        < FORMAT > 

        Tile tile = new Colored(name,initialRent,value,setName,houseValue);
        Tile tile = new Railroad(name,initialRent,value,setName,rentMultiplier);
        Tile tile = new Utility(name,initialRent,value,setName,rollMultiplier);
        Tile tile = new Tile(name,type);
    */  
    
    
}
