import Models.Maze;
import Models.MazeBuilder;

public class Main {

    public static void main(String args[]) {

        Maze maze = new MazeBuilder(35,35).randomize().build();
        System.out.println(maze.toString());
    }

}