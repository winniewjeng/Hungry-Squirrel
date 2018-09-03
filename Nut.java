/*
There are two types of nuts available: Almond and Peanut
When a squirrel eats a nut, it gains points. 
A nut shall be removed from the maze once it is eaten.
There shall be total of 5 nuts in the maze.
The nuts locations shall be random and have to be placed in valid locations, 
meaning that a nut cannot be put in a position that is already occupied by a wall (*), a squirrel (@) or a previously created nut. 
The type of nut (peanut or almond) is random based on 50% probability.
 */
import java.util.Random;

public class Nut extends Entity {

    protected static final int TOTAL_NUTS = 5;
    protected static int numAlmonds;
    protected static int numPeanuts;
    private static int nutritionPoints;
    private static char nutType; //A for Almond or P for Peanut
    protected static final char[] nutTypes = new char[5];
    protected static final int[] validRowPos = new int[5];
    protected static final int[] validColPos = new int[5];

    //Constructor
    public Nut(int row, int col, char symb) {
        super(row, col, symb);
    }

    public Nut() {
        nutritionPoints = 0;
        numAlmonds = 0;
        numPeanuts = 0;

//        this.create();
//        this.put(this.row, this.column);
    }

    //This method randomly generated the location of the nut.  
    //A nut cannot be placed over a wall (*), a squirrel (@) or a previously created nut.
    //In other words, it can only be placed where there is a blank space.
    @Override
    public void create() {

        //generate a type of nut, almond or peanut. Store the nuts inside an array.
        generateNuts();

        //generate a valid position within the maze to place down the nuts. Store the positon set inside an array
        generateValidPos();

        for (int i = 0; i < 5; i++) {
            System.out.println("nutType[" + i + "]: " + nutTypes[i] + " has row " + validRowPos[i] + " and col " + validColPos[i]);

        }

    }

    //Nut names generator
    public void generateNuts() {
        Random nutGenerator = new Random();
        int randomIndex; // 0 or 1
        for (int i = 0; i < 5; i++) {
            randomIndex = nutGenerator.nextInt(2);
            if (randomIndex == 0) {
                nutType = 'A';
                numAlmonds++;

            } else {
                nutType = 'P';
                numPeanuts++;
            }
            //store the generated nuts inside an array
            nutTypes[i] = nutType;
        }
    }

    public int generateRowPos() {
        Random nutGenerator = new Random();
        int randomRowPos = nutGenerator.nextInt(20);
//        System.out.println("row " + randomRowPos);

        return randomRowPos;
    }

    public int generateColPos() {
        Random nutGenerator = new Random();
        int randomColPos = nutGenerator.nextInt(50);
//        System.out.println("col " + randomColPos);

        return randomColPos;
    }

    public void generateValidPos() {
        for (int i = 0; i < 5; i++) {
            //Generate a set of row and col
            int rowPos = generateRowPos();
            int colPos = generateColPos();
            //Keep generating a new set of position if the currently generated set is not an available position in maze
            while (!Maze.available(rowPos, colPos)) {
                rowPos = generateRowPos();
                colPos = generateColPos();
            }
            //keep generating a new set of position if the currently generated set is a duplicate position
            for (int j = 1; j < i; j++) {
                if ( i != j && validRowPos[i] == validRowPos[j] && validColPos[i] == validColPos[j]) {
                    rowPos = generateRowPos();
                    colPos = generateColPos();
                }
            }

            //Populate the valid set into the array
            validRowPos[i] = rowPos;
            validColPos[i] = colPos;
        }
    }

    //Abstract class put down the nuts
    public void putNuts() {
//        for (int i = 0 ; i < TOTAL_NUTS; i++) {
//            
//        }
//        this.put(row, row);
    }

    public int getNumPeanuts() {
        return numPeanuts;
    }

    public int getNumAlmonds() {
        return numAlmonds;
    }

//    public void numberOfEachNut() {
//        Random nutNumberGenerator = new Random();
//        //updateNumAlmonds
//        numAlmonds = nutNumberGenerator.nextInt(5);
//        //updateNumPeanuts
//        numPeanuts = TOTAL_NUTS - numAlmonds;
//    }
}
