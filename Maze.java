
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

    private String filename;
    private Scanner in;
    private static final int Max_Maze_Row = 20;
    private static final int Max_Maze_Column = 50;
    private Entity[][] maze;
    private String[] mazeArrayRow;
    private char[] mazeArrayToChar;
    private char symbol;
    private Entity entity;

    public Maze() {
        this.filename = "Maze.txt";
        maze = new Entity[Max_Maze_Row][Max_Maze_Column];
        mazeArrayRow = new String[20];
        mazeArrayToChar = new char[1000];
    }

    public void create() {
        try {
            in = new Scanner(new File(filename));
  

            while (in.hasNext()) {
                for (int i = 0; i < 20; i++) {
                    mazeArrayRow[i] = in.nextLine();
                    mazeArrayToChar = mazeArrayRow[i].toCharArray();
                    for (int j = 0; j < 50; j++){
                        symbol = mazeArrayToChar[j];
//                        System.out.print(symbol);
                        maze[i][j] = new Entity(i, j, symbol);
//                        System.out.print(maze[i][j]);
//                        System.out.print("i: " + i + " ");
//                        System.out.print("j: " + j + " ");
//                        System.out.println("symbol: "+ symbol + " ");
                    }
                    
//                    System.out.println();
//                    System.out.println(mazeArrayToChar);
//                    System.out.println(" e "+ mazeArrayRow[i] +" e ");
//                    parse the string into chars
//                    System.out.println(mazeArrayRow[i].toCharArray());
//                    mazeArrayRow[i].toCharArray();
//                    System.out.println(mazeArrayRow[i]);                 
//                    mazeArrayRow[i].toCharArray();
                }
            }
            //Close the file
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + filename);
        }
    }

    public void display() {
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 50; j++){
                System.out.print(maze[i][j]);
//                System.out.print(symbol);
            }
            System.out.println("");
        }
    }

    public boolean available() {
        return false;
    }
}
