public class Entity {
//    This instance variable is a character symbol by which an entity is identified on the Maze. 
//    For example, a squirrel is represented by ‘@’. Each nut will be represented by the first 
    private char symbol;
//    This instance variable is the row position of the entity in the maze.
    private int row;
//    This instance variable is the column position of the entity in the maze.
    private int column;
    private Entity entity;
    //Constructor
    public Entity(int row, int column, char symb) {
        this.row = row;
        this.column = column;
        this.symbol = symb;
    }
    
    //abstract method
    public void create(){}
    
//    This method puts an entity at location (newRow, newCol) in the maze. 
//    This method returns an object that was replaced in the maze. 
//    (hint: This can be useful when moving the squirrel and determining if the squirrel found a nut).
    public Entity put(int newRow, int newCol, char symb) {
        this.row = newRow;
        this.column = newCol;
        this.symbol = symb;
        
        return entity;
    }

    @Override
    public String toString() {
        return symbol + "";
    }
    
}
