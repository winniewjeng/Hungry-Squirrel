import java.util.Scanner;

public class HungrySquirrelGame {

    public static void main(String args[]) {

        char move = ' ';
        Scanner in = new Scanner(System.in);
        Maze maze = new Maze();
        maze.create();
        maze.display();
        Entity squirrel;
        int startRow;
        int startCol;

        System.out.println("Let's play the Hungry Squirrel Game!");

        //Instruction
        System.out.println("Move through the maze and collect nuts to gain points.");

//            System.out.println("Enter the starting location of the squirrel.");
//            System.out.print("Row: ");
//            startRow = in.nextInt();
//            System.out.println("Column:");
//            startCol = in.nextInt();
//            squirrel = new Squirrel(startRow, startCol, '@');
        squirrel = new Squirrel(7, 15, '@');
        maze.display();

        System.out.println("Press E to move up, S to move left, D to move down, F to move right, and Q to quit the game.");
//            System.out.println(maze.available());
//            do {
//                move = in.next().charAt(0);
//                Display the empty maze:
//                
//            } while (move != 'Q');

    }
}
