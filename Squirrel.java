import java.util.Scanner;

public class Squirrel extends Entity implements Movable {

    private char direction;
//    private char symbol;
    private Entity entity;
    //Keep track of the game
    private int pointsCollected;
    private int totalNutsEaten;
    private Scanner in;
    private Maze maze;

    public Squirrel(int row, int col, char symb) {
        super(row, col, symb);
        direction = ' ';
        pointsCollected = 0;
        totalNutsEaten = 0;
//        this.create(); //Calling Squirrel
    }
    
    public int getRow() {
        return this.row;
    }
    public int getCol() {
        return this.column;
    }
    
//    public boolean checkInput() {
//        //Return true if the position of the Squirrel is not a wall. Otherwise, return false
//
//        
//        return false;
//    }
    
    //NOT YET FINISHED IMPLEMENTING
    public String userInput() {
        String inputPosition;
        System.out.println("Where would you like to place the squirrel? "
                + "Enter the row and column as separated by a comma");
        inputPosition = in.nextLine();
//        while (!maze.available()) {
//            System.out.println("Erroreous input. Try again");
//            inputPosition = in.nextLine();
//            
//        }
//        while(checkInput() == false) {

//        }
        return inputPosition;
    }
    
//    This method prompts the user to enter the initial location of the squirrel in the maze.
//    You have to make sure the location provided by the user is valid and available. 
//    If the user provides an invalid or unavailable location where there is already a wall (‘*’), 
//    the program must ask the user to input a new set of row and column.
    
    //NOT YET IMPLEMENTED
    @Override
    public void create() {
        
    }
    
    public void move(char direction) {
        //Based on the direction chosen, move the Squirrel to a diff maze[][] index
        switch (direction) {
            case 'w':
                entity.put(entity.getRow()+1, entity.getCol(), entity.getSymbol());
                //check space availability
                break;
            case 'd':
                entity.put(entity.getRow(), entity.getCol()+1, entity.getSymbol());
                //check space availability
                break;
            case 's':
                entity.put(entity.getRow()-1, entity.getCol(), entity.getSymbol());
                //check space availability
                break;
            case 'a':
                entity.put(entity.getRow(), entity.getCol()-1, entity.getSymbol());
                //check space availability
                break;
            default:
                System.out.println("Invalid move!");
                break;
        }

    }

}
