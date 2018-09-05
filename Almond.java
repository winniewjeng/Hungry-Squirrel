
public class Almond extends Nut {

    //Constructor
    public Almond(int row, int col, char symb) {
        super(row, col, symb);

    }

    //Constructor
    public Almond() {
        this.symbol = 'A';
        //create() inside Nut parent class generates  
        this.create();
        this.putNuts();
        nutritionPoints = 5;
    }
    
    @Override
    public void putNuts() {

        for (int i = 0; i < TOTAL_NUTS; i++) {
            if (nutTypes[i] == 'A') {
                this.put(validRowPos[i], validColPos[i]);
            }
        }
    }

}