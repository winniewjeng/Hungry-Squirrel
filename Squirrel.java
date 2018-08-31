import java.util.Scanner;

public class Squirrel extends Entity implements Movable {

    //Keep track of the game
    private int pointsCollected;
    private int totalNutsEaten;
    private Scanner in = new Scanner(System.in);
    private Maze maze;

    //Constructor
    public Squirrel(int row, int col, char symb) {
        super(row, col, symb);
        pointsCollected = 0;
        totalNutsEaten = 0;
//        maze.create();
//        this.create(); //Calling Squirrel
//        System.out.println("row " + this.row + " col " + this.column);

    }

//    This method prompts the user to enter the initial location of the squirrel in the maze.
//    You have to make sure the location provided by the user is valid and available. 
//    If the user provides an invalid or unavailable location where there is already a wall (‘*’), 
//    the program must ask the user to input a new set of row and column.
    //NOT YET IMPLEMENTED
    @Override
    public void create() {
        this.takeUserInput(); //this outputs a string?
//        System.out.println("row " + this.row + " col " + this.column);
    }

    //This method prompts for user input
    public String takeUserInput() {
        System.out.print("Where would you like to place the squirrel? "
                + "Enter the row and column as separated by a comma, ie. 7, 23 ");
        String inputPositionStr;
        //Take user input
        inputPositionStr = in.nextLine();
        //CHECK if the input format is correct by calling inputIsValidStr().
        //Keep prompting for new input if input format is wrong
        while (!this.inputIsValid(inputPositionStr)) {
            inputPositionStr = in.nextLine();
        }
        return inputPositionStr;
    }

    //This method inside take userInput checks if user input is valid
    public boolean inputIsValid(String inputPositionStr) {
        //Parse user input into row and column strings and store them as substr inside an array 
        String posRowAndCol[] = inputPositionStr.split(", ");
        if (posRowAndCol.length != 2) {
            System.out.println("Your input format is incorrect. Use \", \" to separate the row from the column. Try again.");
            return false;
        }
        String rowStr = posRowAndCol[0];
        String colStr = posRowAndCol[1];

        //cast the row and column strings into integers. Reassign them
        this.row = Integer.parseInt(rowStr);
        this.column = Integer.parseInt(colStr);

        if (!maze.available(this.row, this.column)) {
            return false;
        }

        return true;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.column;
    }

    //This method checks available() in the Maze class to see if the position can be taken
//    public boolean checkInput() {
//        //Return true if the position of the Squirrel is not a wall. Otherwise, return false
//
//        
//        return false;
//    }
    public char takeDirection() {
        System.out.println("Enter direction ('W', 'A', 'S', 'D'): ");
        char direction = in.next().charAt(0);

        return direction;
    }

    public void move(char direction) {
//        Based on the direction chosen, move the Squirrel to a diff maze[][] index
        switch (direction) {
            case 'W':
                if (maze.available(this.row - 1, this.column)) {
                    entity.put(entity.getRow() - 1, entity.getCol(), entity.getSymbol());
                }
                break;
            case 'A':
                if (maze.available(this.row, this.column - 1)) {
                    entity.put(entity.getRow(), entity.getCol() - 1, entity.getSymbol());
                }
                break;
            case 'S':
                if (maze.available(this.row + 1, this.column)) {
                    entity.put(entity.getRow() + 1, entity.getCol(), entity.getSymbol());
                }
                break;
            case 'D':
                if (maze.available(this.row, this.column + 1)) {
                    entity.put(entity.getRow(), entity.getCol() + 1, entity.getSymbol());
                }
                break;
            default:
                System.out.println("Invalid move!");
                break;
        }
    }

}
