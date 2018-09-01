public class HungrySquirrelGame {

    public static void main(String args[]) {

        Maze maze = new Maze();
        Squirrel squirrel;
        char direction = ' ';

        System.out.println("Welome to the Hungry Squirrel Game!\nMove through the maze and collect nuts to gain points.\n");

        maze.create();
        maze.display();

        //Instantiate a dummy squirrel object. Bad code, but works. Fix later if I have more time
        squirrel = new Squirrel(1, 20, ' ');
        //Call create() from the first dummy instantiation of squirrel object to 
        //  instatiate another key squirrel object with which we play the game. 
        //Again, bad code, but works. Fix later if I have more time
        squirrel.create();
        squirrel = new Squirrel(squirrel.getRow(), squirrel.getCol(), '@');

        //
        //Drop down the nuts
        //
        //
        //Display the maze with the squirrel and nuts
        maze.display();

        //Direction of playing the game
        System.out.println("Press W to move up, A to move left, S to move down, D to move right, and Q to quit the game.\n"
                + "Let's Begin moving the squirrel @ through the maze!\n");

        do {
            direction = squirrel.takeDirection();
            squirrel.move(direction);
//            maze.display();

        } while (direction != 'Q'); // || totalPoints earned < 25 || nutsEaten count != 5
    }
}
