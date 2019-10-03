package Models;

import java.util.Random;
import java.util.Stack;

public class MazeBuilder {

    private Maze maze;

    public MazeBuilder(int rows, int cols) {
        maze = new Maze(rows, cols);
    }

    public MazeBuilder randomize() {

        Stack<Block> stack = new Stack<>();
        Block block = maze.getBlock(0,0);

        stack.add(block);

        while(!stack.isEmpty()) {
            block = stack.pop();
            block.setVisited(true);

            Block neighbor = maze.getLonelyNeighbor(block.getRow(), block.getColumn());

            if ( neighbor == null ) {
                continue;
            }

            block.removeWalls(neighbor);

            stack.push(block);
            stack.push(neighbor);
        }

        return this;
    }

    public Maze build() {
        return maze;
    }

}