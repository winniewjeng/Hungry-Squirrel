
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    
    private String filename = "Maze.txt";
    private Scanner in;
    private int Max_Maze_Row = 20;
    private int Max_Maze_Column = 50;
    //maze needs to be an entity, ie. Entity[][] maze
    private String[][] maze;
    
    //Constructor
    public Maze(){}
    
//    This method reads the file passed to the method (e.g. Maze.txt) 
//    and initializes the 2-dimentional array with the maze content provided in the file.
//    WHY can't it be a static method?
    public void create(String filename) {
        //Open the maze.txt file
        try {
            in = new Scanner(new File(filename));
            //populate the boatArray with all the boat names inside boat.txt
            while (in.hasNextLine()) {
                for (int i = 0; i < Max_Maze_Row; i++) {
                    for (int j = 0; j < Max_Maze_Column; j++) {
                        maze[i][j] = in.next();
                    }
                }
            }
            in.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find " + filename);
        }
    
    }
    
//    This method displays the maze structure and the containing entities.
    public static void display() {}

//    This method takes a row and a column and determines if the location is a 
//    blank space. If it is, it returns true; otherwise, it returns false.
    public static boolean available(int row, int col) {
        
        return false;
    }
    
}
