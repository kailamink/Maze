package Models;

public class Block {

    private int row;
    private int col;
    private boolean visited;
    private boolean northWall;
    private boolean southWall;
    private boolean eastWall;
    private boolean westWall;

    public Block(int row, int col) {
        this.row = row;
        this.col = col;
        northWall = true;
        southWall = true;
        eastWall = true;
        westWall = true;
    }

    public int getColumn() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isNorthWall() {
        return northWall;
    }

    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    public boolean isSouthWall() {
        return southWall;
    }

    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    public boolean isEastWall() {
        return eastWall;
    }

    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }

    public boolean isWestWall() {
        return westWall;
    }

    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }

    public String toString() {
        return (isSouthWall() ? "_" : " ") + (isEastWall() ? "|" : " ");
    }

    public void removeWalls(Block neighbor)
    {
        if (neighbor != null)
        {
            if (col == neighbor.col)
            {
                if (row == neighbor.row - 1)
                {
                    // SOUTH
                    southWall = false;
                    neighbor.northWall = false;
                }
                else if (row == neighbor.row + 1)
                {
                    // NORTH
                    northWall = false;
                    neighbor.southWall = false;
                }
            }
            else if (row == neighbor.row)
            {
                if (col == neighbor.col - 1)
                {
                    // EAST
                    eastWall = false;
                    neighbor.westWall = false;
                }
                else if (col == neighbor.col + 1)
                {
                    // WEST
                    westWall = false;
                    neighbor.eastWall = false;
                }
            }
        }
    }
}