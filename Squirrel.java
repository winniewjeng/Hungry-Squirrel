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
                + "Enter the row and column as separated by a comma, ie. 2, 23 ");
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
        int oldRow;
        int oldCol;
        //CHANGE THE CODE BELOW TO SWITCH STATEMENTS IF I HAVE MORE TIME
        if (direction == 'W') {
            if (maze.available(this.row - 1, this.column)) {
                //store the current position (this.) inside a temp variable
                oldRow = this.row;
//                System.out.println("oldRow " + oldRow + " was a " + maze.getMaze()[oldRow][this.column]);
                //replace the old position occupied by squirrel with a blank space ' '
                maze.getMaze()[oldRow][this.column] = new Entity(oldRow, this.column, ' ');
//                System.out.println("oldRow at " + oldRow + " after put should be a " + replacement + ".");

                //update the current row position
                this.row = this.row - 1;
                //call put for the newRow pos
                this.put(this.getRow(), this.getCol());
                maze.display();

                //Brute force debugging lines
//                System.out.println("thisRow " + this.row + " was a " + maze.getMaze()[this.row][this.column]);
//                System.out.println("thisRow at " + this.row + " after put should be a " + maze.getMaze()[oldRow][this.column] + ".");
//                System.out.println(this.getRow()); // this works
//                System.out.println(entity.getRow()); //this crashes
//                this.put(this.getRow(), this.getCol()); //this works 
//                entity.put(entity.getRow(), entity.getCol(), entity.getSymbol()); // this crashes
            }
        } else if (direction == 'A') {
            if (maze.available(this.row, this.column - 1)) {
                oldCol = this.column;
                maze.getMaze()[this.row][oldCol] = new Entity(this.row, oldCol, ' ');
                this.column = this.column - 1;
                this.put(this.getRow(), this.getCol());
                maze.display();
            }
        } else if (direction == 'S') {
            if (maze.available(this.row + 1, this.column)) {
                oldRow = this.row;
                maze.getMaze()[oldRow][this.column] = new Entity(oldRow, this.column, ' ');
                this.row = this.row + 1;
                this.put(this.getRow(), this.getCol());
                maze.display();
            }
        } else if (direction == 'D') {
            if (maze.available(this.row, this.column + 1)) {
                oldCol = this.column;
                maze.getMaze()[this.row][oldCol] = new Entity(this.row, oldCol, ' ');
                this.column = this.column + 1;
                this.put(this.getRow(), this.getCol());
                maze.display();
            }
        } else if (direction == 'Q') {
            //Do nothing. Quit game
        } else {
            System.out.println("This is not a valid move key. Only enter W, A, S, D");
        }
    }

}
