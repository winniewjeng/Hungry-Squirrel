
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

    private static String filename;
    private static Scanner in;
    private static final int Max_Maze_Row = 20;
    private static final int Max_Maze_Column = 50;
    private static Entity[][] maze;
    private static String[] mazeArrayRow;
    private static char[] mazeArrayToChar;
    private static char symbol;
    private static Entity entity;
    private Squirrel squirrel;

    public Maze() {
        this.filename = "Maze.txt";
        maze = new Entity[Max_Maze_Row][Max_Maze_Column];
        mazeArrayRow = new String[20];
        mazeArrayToChar = new char[1000];
    }

    public static Entity[][] getMaze() {
        return maze;
    }

    public static char getSymbol() {
        return symbol;
    }

    public static void create() {
        try {
            in = new Scanner(new File(filename));

            while (in.hasNext()) {
                for (int i = 0; i < 20; i++) {
                    mazeArrayRow[i] = in.nextLine();
                    mazeArrayToChar = mazeArrayRow[i].toCharArray();
                    for (int j = 0; j < 50; j++) {
                        symbol = mazeArrayToChar[j];
                        maze[i][j] = new Entity(i, j, symbol);
//                        System.out.print(maze[i][j]);
//                        System.out.print("i: " + i + " ");
//                        System.out.print("j: " + j + " ");
//                        System.out.println("symbol: "+ symbol + " ");
                    }
                }
            }
            //Close the file
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + filename);
        }
    }

    public static void display() {

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println("");
        }
    }
    
    //Pass in a location. If the location is a wall or out of bounds, return false.
    public static boolean available(int row, int col) {
        if (row < 0 || row > Max_Maze_Row || col < 0 || col > Max_Maze_Column) {
            System.out.println("This position is outside of the boundary of the maze. Try again.");
            return false;
        } else if (maze[row][col].getSymbol() == '*') {
            return false;
        }

        return true;
    }

    public static int getTotalRows() {
        return Max_Maze_Row;
    }

    public static int getTotalCols() {
        return Max_Maze_Column;
    }

    @Override
    public String toString() {

        return this.symbol + "";
    }

}