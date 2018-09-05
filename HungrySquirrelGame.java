
import java.util.Scanner;

public class HungrySquirrelGame {

    public static void main(String args[]) {

        //var declarations
        Maze maze = new Maze();
        Squirrel squirrel;
        char direction = ' ';

        System.out.println("Welome to the Hungry Squirrel Game!\nMove through the maze and collect nuts to gain points.\n");

        //create an empty maze
        maze.create();

        //display the empty maze
        maze.display();

        //Instantiate a dummy squirrel object. Bad code, but works. Fix later if I have more time
        squirrel = new Squirrel();
        //Call create() from the first dummy instantiation of squirrel object to 
        //  instatiate another key squirrel object with which we play the game. 
        //Again, bad code, but works. Fix later if I have more time
        squirrel.create();
        squirrel = new Squirrel(squirrel.getRow(), squirrel.getCol(), '@');

        //Drop down the nuts:
        //  almond object must be called first before peanut object 
        //  because almond object contains the create() method in its constructor       
        //  create() can only be called once b/c it populates static nutTypes[5] and respective valid position 
        Nut almond = new Almond();
        Nut peanut = new Peanut();
        Nut cashew = new PoisonousCashew();
        //Display the maze with the squirrel and nuts in place
        maze.display();

        //Direction of playing the game
        System.out.println("TURN ON YOUR CAPS LOCK! Press W to move up, A to move left, S to move down, D to move right, and Q to quit the game.\n"
                + "Let's Begin moving the squirrel @ through the maze!\n");

        //Keep playing the game until Quit or Win
        do {
            direction = squirrel.takeDirection();
            squirrel.move(direction);
            if (squirrel.nutsEaten() == 5) {
                System.out.println("\nSquirrel successfully collected all the nuts. Total points: " + squirrel.points());
            } else if (squirrel.points() < 0) {
                System.out.println("Squirrel dies. Game over.");
            }
        } while (direction != 'Q' && squirrel.nutsEaten() != 5 && squirrel.points() >= 0);
        
        //Ending statement
        System.out.println("\nThank you for playing this game!");
    }
}
