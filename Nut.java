
import java.util.Random;

public class Nut extends Entity {

    protected static final int TOTAL_NUTS = 5;
//    protected static int numAlmonds;
//    protected static int numPeanuts;
    protected static int nutritionPoints;
    private static char nutType; //'A' for Almond or 'P' for Peanut
    protected static final char[] nutTypes = new char[5];
    protected static final int[] validRowPos = new int[5];
    protected static final int[] validColPos = new int[5];

    //Constructor
    public Nut(int row, int col, char symb) {
        super(row, col, symb);
    }

    public Nut() {
        nutritionPoints = 0;
//        numAlmonds = 0;
//        numPeanuts = 0;
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
        //testing lines for the static arrays when child Almond and Peanut classes are called in seperate instances
//        for (int i = 0; i < 5; i++) {
//            System.out.println("nutType[" + i + "]: " + nutTypes[i] + " has row " + validRowPos[i] + " and col " + validColPos[i]);
//        }

    }

    //Nut names generator
    public void generateNuts() {
        Random nutGenerator = new Random();
        int randomIndex; // 0 or 1
        for (int i = 0; i < TOTAL_NUTS; i++) {
            randomIndex = nutGenerator.nextInt(2);
            if (randomIndex == 0) {
                nutType = 'A';
            } else {
                nutType = 'P';
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
        for (int i = 0; i < TOTAL_NUTS; i++) {
            //Generate a set of row and col
            int rowPos = generateRowPos();
            int colPos = generateColPos();
            //keep generating a new set of position if the currently generated set is a duplicate position
            for (int j = 1; j < TOTAL_NUTS; j++) {
                if (i != j && validRowPos[i] == validRowPos[j] && validColPos[i] == validColPos[j]) {
                    rowPos = generateRowPos();
                    colPos = generateColPos();
                }
            }
            //Keep generating a new set of position if the currently generated set is not an available position in maze
            while (!Maze.available(rowPos, colPos)) {
                rowPos = generateRowPos();
                colPos = generateColPos();
            }
            //Populate the valid set into the array
            validRowPos[i] = rowPos;
            validColPos[i] = colPos;
        }
    }

    //Abstract parent class to put down the nuts
    public void putNuts() {
    }

}