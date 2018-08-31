import java.util.Scanner;

public class HungrySquirrelGame {

    public static void main(String args[]) {

        char move = ' ';
        Scanner in = new Scanner(System.in);
        Maze maze = new Maze();
        Entity squirrel;
        int startRow;
        int startCol;

        System.out.println("Let's play the Hungry Squirrel Game!");
        //Instruction
        System.out.println("Move through the maze and collect nuts to gain points.");
        maze.create();
        maze.display();

//            System.out.println("Enter the starting location of the squirrel.");
//            System.out.print("Row: ");
//            startRow = in.nextInt();
//            System.out.println("Column:");
//            startCol = in.nextInt();
//            squirrel = new Squirrel(startRow, startCol, '@');
        squirrel = new Squirrel(1, 20, ' ');
        squirrel.create();
//        squirrel.put(squirrel.getRow(), squirrel.getCol(), '@'); //doesn't work
        squirrel = new Squirrel(squirrel.getRow(), squirrel.getCol(), '@');
        System.out.println("Press W to move up, A to move left, S to move down, D to move right, and Q to quit the game.");
        maze.display();
//        squirrel.takeDirection();

//take direction in squirrel class. move squirrel in squirrel class

//            System.out.println(maze.available());
//            do {
//                move = in.next().charAt(0);
//                Display the empty maze:
//                
//            } while (move != 'Q');
    }
}