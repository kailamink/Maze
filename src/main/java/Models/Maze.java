package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Maze {

    private final int rows;
    private final int cols;
    
    private final Block blocks[][];

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.blocks = new Block[rows][cols];

        for (int rr = 0; rr < rows; ++rr) 
        {
            for (int cc = 0; cc < cols; ++cc) 
            {
                blocks[rr][cc] = new Block(rr, cc);
            }
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        addTopLine(builder);
        for (int rr = 0; rr < rows; ++rr) 
        {
            builder.append("|");
            for (int cc = 0; cc < cols; ++cc) 
            {
                Block block = blocks[rr][cc];
                builder.append(block);
            }
            builder.append("\n");
        }

        return builder.toString();
    }
    private void addTopLine(StringBuilder builder)
    {
        if(rows != 0 && cols != 0)
        {
            int cc = 0;
            builder.append((" "));
            while(cc < cols) { builder.append("_ "); ++cc; }
            builder.append("\n");
        }
    }

    public Block getBlock(int row, int col) 
    {
        return blocks[row][col];
    }

    public boolean isLonely(int row, int col) 
    {
        return !getBlock(row, col).isVisited();
    }

    public Block getLonelyNeighbor(int row, int col) {
        List<Block> list = getLonelyNeighbors(row, col);

        if (list.isEmpty()) {
            return null;
        }

        Collections.shuffle(list);
        return list.get(0);
    }

    public List<Block> getLonelyNeighbors(int row, int col) {
        List<Block> list = new ArrayList<>();

        // NORTH
        if ( row > 0 && isLonely(row - 1, col)) {
            list.add(getBlock(row - 1, col));
        }
        // SOUTH
        if (row < rows - 1 && isLonely(row + 1, col)) {
            list.add(getBlock(row + 1, col));
        }
        // WEST
        if (col > 0 && isLonely(row, col - 1)) {
            list.add(getBlock(row, col - 1));
        }
        // EAST
        if (col < cols - 1 && isLonely(row, col + 1)) {
            list.add(getBlock(row, col + 1));
        }
        return list;
    }
}