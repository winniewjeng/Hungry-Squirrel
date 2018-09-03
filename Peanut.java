
public class Peanut extends Nut {

    public Peanut(int row, int col, char symb) {
        super(row, col, symb);
//        nutritionPoints = 10;
    }

    public Peanut() {
        this.symbol = 'P';
        putNuts();
        nutritionPoints = 10;
    }

    //loop through the static array of nutTypes and put down every peanuts that it finds in the array
    public void putNuts() {
        for (int i = 0; i < TOTAL_NUTS; i++) {
            if (nutTypes[i] == 'P') {
                this.put(validRowPos[i], validColPos[i]);
            }
        }
    }
    
}