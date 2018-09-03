
public class Entity {
//    This instance variable is a character symbol by which an entity is identified on the Maze. 
//    For example, a squirrel is represented by ‘@’. Each nut will be represented by the first 
    protected char symbol;
//    This instance variable is the row position of the entity in the maze.
    protected int row;
//    This instance variable is the column position of the entity in the maze.
    protected int column;
    protected Entity entity;

    //Constructor
    public Entity(int row, int column, char symbol) {
        this.row = row;
        this.column = column;
        this.symbol = symbol;
        this.put(this.row, this.column);
    }
    public Entity(){}

    //abstract method
    public void create() {
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.column;
    }

    public char getSymbol() {
        return this.symbol;
    }

//    This method puts an entity at location (newRow, newCol) in the maze. 
//    This method returns an object that was replaced in the maze. 
    public Entity put(int newRow, int newCol) {
        //Ideally, oldEntity is a blank space so newEntity can be dropped there. 
        //If not, if it's a nut, oldEntity can still be replaced by newEntity
        //But if the oldEntity is a '*', then return err msg

        //Most likely, oldEntity is a blank space. Occassionally oldEntity is a Nut
        Entity oldEntity = Maze.getMaze()[newRow][newCol];
        
        //"this" refers to the entity that calls the put() method
        //the new position indicated becomes the entity that calls the put()
        Maze.getMaze()[newRow][newCol] = this;
////        System.out.println("pass pos row " + newRow + " column " + newCol);
//System.out.println("this is " + this );
        //put() returns the object that was replaced
        return oldEntity;
    }

    @Override
    public String toString() {
        return symbol + "";
    }

}