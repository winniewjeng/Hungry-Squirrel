//My Wall class is implemented as part of the Maze class.
//It would be difficult, if not redundant, to separate the two
//Since the maze wall is static final in the Maze Class.


public class Wall extends Entity {
    
    public Wall(int row, int column, char symbol) {
        super(row, column, symbol);
    }
    
}
