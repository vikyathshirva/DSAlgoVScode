package Graphs;
import java.util.*;

public class SearchInMaze {
    public static class Coordinate {
        public int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o){ 
            if(o == this) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }

            Coordinate that = (Coordinate) o;
            if(that.x != x || that.y != y) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }


    public static enum Color {WHITE, BLACK};

    public static List<Coordinate> searchInMaze(List<List<Color>> maze, Coordinate s, Coordinate e) {
        List<Coordinate> path = new ArrayList<>();
        maze.get(s.x).set(s.y, Color.BLACK);
        path.add(s);
        if(!mazeHelper(maze, s, e, path)) {
            path.remove(path.size()-1);
        }
        return path;
    }


    public static boolean mazeHelper(List<List<Color>> maze, Coordinate cur, Coordinate e, List<Coordinate> path) {
        if(cur == e) {
            return true;
        }

        final int[][] SHIFT = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int [] sh :  SHIFT) {
            Coordinate newcur = new Coordinate(cur.x + sh[0], cur.y + sh[1]);
            if(isFeasible(maze, newcur)) {
                maze.get(newcur.x).set(newcur.y, Color.BLACK);
                path.add(newcur);
                if(mazeHelper(maze, cur, e, path)) {
                    return true;
                }
                path.remove(path.size()-1);
            }
        }

        return false;

    }

    public static boolean isFeasible(List<List<Color>> maze, Coordinate cur) {
        return cur.x >=0 && cur.x < maze.size()
        && cur.y >=0 && cur.y < maze.get(cur.x).size()
        && maze.get(cur.x).get(cur.y) == Color.WHITE;
    }

}