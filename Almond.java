


public class Almond extends Nut {

    private int numAlmonds;

    public Almond(int row, int col, char symb) {
        super(row, col, symb);
    }

    public Almond() {
        numAlmonds = 0;
        this.symbol = 'A';
        this.create();
        this.putNuts();
    }

//    @Override
//    //If the board contain peanuts (no almonds), generate a random number of almonds b/n 0 and 5 and put them down.
//    //If the board contains almonds (no peanuts), numAlmonds = TOTAL_NUTS-numPeanuts. Put down #numAlmonds of almonds
//    //in a loop. Before enteringthe loop, make sure TOTAL_NUTS < 5.
//    public void putNuts() {
//
//        for (int i = 0; i < Maze.getTotalRows(); i++) {
//            for (int j = 0; j < Maze.getTotalCols(); j++) {
//                System.out.print("Maze.getMaze()[i][j] " + Maze.getMaze()[i][j]);
//            }
//            System.out.println("");
//        }
//
//        System.out.println(
//                "numAlmonds " + numAlmonds + "\n numPeanuts " + numPeanuts);
//        for (int i = 0; i < numAlmonds; i++) {
//            this.put(validRowPos[i], validColPos[i]);
//        }
//    }
//tHIS FUNCTION WORKS. COMMENTING OUT FOR THE MOMENT TO EDIT THE CLASS
    public void putNuts() {

        for (int i = 0; i < 5; i++) {
            if (nutTypes[i] == 'A') {
                this.put(validRowPos[i], validColPos[i]);
            }
        }
        System.out.println("qwoOWoWOOWOWOWnumAlmonds " + getNumAlmonds() + " numPeanuts " + getNumPeanuts());
    }

    public int numAlmonds() {
        return numAlmonds;
    }

    public int intNumPeanuts() {
        return numPeanuts;
    }

}
