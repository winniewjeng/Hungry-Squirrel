

public class Peanut extends Nut {

    public Peanut(int row, int col, char symb) {
        super(row, col, symb);
    }

    public Peanut() {
        this.symbol = 'P';
        System.out.println("LOLOLOL numAlmonds " + getNumAlmonds() + " numPeanuts " + getNumPeanuts());
        for (int i = 0; i < 5; i++) {
            System.out.println("nutType[" + i + "]: " + nutTypes[i] + " has row " + validRowPos[i] + " and col " + validColPos[i]);

        }
        for (int i = 0; i < 5; i++) {
            if (nutTypes[i] == 'P') {
                this.put(validRowPos[i], validColPos[i]);
            }
        }

    }

}