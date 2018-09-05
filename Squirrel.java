
import java.util.Scanner;

public class Squirrel extends Entity implements Movable {

    //Keep track of the game
    private int pointsCollected;
    private int totalNutsEaten;
    private Scanner in = new Scanner(System.in);
    private Maze maze;
    private Almond almond;
    private Peanut peanut;
    private Nut nut;
    private static Entity aNut;
    
    //Constructor
    public Squirrel(int row, int col, char symb) {
        super(row, col, symb);
        pointsCollected = 0;
        totalNutsEaten = 0;

    }

    public Squirrel() {
    }

    @Override
    public void create() {
        this.takeUserInput(); //takeUserInput() returns a string
    }

    //This method prompts for user input
    public String takeUserInput() {
        System.out.println("Where would you like to place the squirrel? "
                + "Enter the row and column as separated by a comma, ie. 2, 23 ");
        String inputPositionStr;
        //Take user input
        inputPositionStr = in.nextLine();
        //CHECK if the input format is correct by calling inputIsValidStr()
        //Keep prompting for new input if input format is wrong
        while (!this.inputIsValid(inputPositionStr)) {
            inputPositionStr = in.nextLine();
        }
        return inputPositionStr;
    }

    //This method is embedded inside takeUserInput(); it checks if user input is valid
    public boolean inputIsValid(String inputPositionStr) {
        //Parse user input into row and column strings and store them as substr inside an array 
        String posRowAndCol[] = inputPositionStr.split(", ");
        if (posRowAndCol.length != 2) {
            System.out.println("Your input format is incorrect. Use \", \"-comma and space-to separate row and column. Try again.");
            return false;
        }
        String rowStr = posRowAndCol[0];
        String colStr = posRowAndCol[1];
        //cast the row and column strings into integers
        this.row = Integer.parseInt(rowStr);
        this.column = Integer.parseInt(colStr);
        //if position is unavailable, invalid input, return false
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

    public char takeDirection() {
        System.out.println("Enter direction ('W', 'A', 'S', 'D'): ");
        char direction = in.next().charAt(0);

        return direction;
    }

    public void move(char direction) {
        int oldRow;
        int oldCol;

        if (direction == 'W') {

            if (maze.available(this.row - 1, this.column)) {
                //output a line if squirrel finds a nut in the current position
                this.foundNuts(this.row - 1, this.column);
                //store the current position (this.) inside a temp variable
                oldRow = this.row;
                //replace the old position occupied by squirrel with a blank space ' '
                maze.getMaze()[oldRow][this.column] = new Entity(oldRow, this.column, ' ');
                //update the current row position
                this.row = this.row - 1;
                //call put for the newRow pos
                this.put(this.getRow(), this.getCol());
                //display the updated maze
                maze.display();
            } else {
                System.out.println("Ouch! That's a wall. Try again.");
            }
        } else if (direction == 'A') {
            if (maze.available(this.row, this.column - 1)) {
                this.foundNuts(this.row, this.column - 1);
                oldCol = this.column;
                maze.getMaze()[this.row][oldCol] = new Entity(this.row, oldCol, ' ');
                this.column = this.column - 1;
//                this.foundNuts(this.getRow(), this.getCol());
                this.put(this.getRow(), this.getCol());

                maze.display();
            } else {
                System.out.println("Ouch! That's a wall. Try again.");
            }
        } else if (direction == 'S') {
            if (maze.available(this.row + 1, this.column)) {
                this.foundNuts(this.row + 1, this.column);
                oldRow = this.row;
                maze.getMaze()[oldRow][this.column] = new Entity(oldRow, this.column, ' ');
                this.row = this.row + 1;
                this.put(this.getRow(), this.getCol());
//                this.foundNuts(this.getRow(), this.getCol());
                maze.display();
            } else {
                System.out.println("Ouch! That's a wall. Try again.");
            }
        } else if (direction == 'D') {
            if (maze.available(this.row, this.column + 1)) {
                this.foundNuts(this.row, this.column + 1);
                oldCol = this.column;
                maze.getMaze()[this.row][oldCol] = new Entity(this.row, oldCol, ' ');
                this.column = this.column + 1;
                this.put(this.getRow(), this.getCol());
//                this.foundNuts(this.getRow(), this.getCol());
                maze.display();
            } else {
                System.out.println("Ouch! That's a wall. Try again.");
            }
        } else if (direction == 'Q') {
            System.out.println("Aw you did not choose to complete the game. Total points: " + pointsCollected);
        } else {
            System.out.println("This is not a valid move key. Only enter W, A, S, D");
        }
    }

    public void foundNuts(int row, int col) {

        aNut = maze.getMaze()[row][col];

        if (aNut.getSymbol() == 'A') {
            pointsCollected += 5;
            System.out.println("Squirrel found an almond and gained 5 points! Total points: " + pointsCollected);
            totalNutsEaten++;
        } else if (aNut.getSymbol() == 'P') {
            pointsCollected += 10;
            System.out.println("Squirrel found a peanut and gained 10 points! Total points: " + pointsCollected);
            totalNutsEaten++;
        } else if (aNut.getSymbol() == 'C') {
            pointsCollected -= 15;
            System.out.println("Squirrel ate a poisonous cashew and lost 15 points. Total points: " + pointsCollected);
        }

    }
    
    public int nutsEaten(){
        return totalNutsEaten;
    }
    
    public int points(){
        return pointsCollected;
    }
}