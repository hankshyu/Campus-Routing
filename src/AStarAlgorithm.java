import java.util.ArrayList;
import java.util.List;

public class AStarAlgorithm {


    private static int[][] map;
    public void setmap(int[][] map){
        this.map=map;
    }

    public static void setMap(int[][] map) {
        AStarAlgorithm.map = map;
    }

    /**
     * Main A Star Search method
     *
     * @param start starting grid
     * @param end   ending grid
     * @return the ending grid, we may use parent nodes to track the entire path
     */


    public static grid astarsearch(grid start, grid end) {
        //openlist records the grids that are potentially the path
        ArrayList<grid> openlist = new ArrayList<grid>();
        //closelist is the list with grids that we have already inspected
        ArrayList<grid> closelist = new ArrayList<grid>();
        openlist.add(start);
        while (openlist.size() > 0) {
            //choosing the one to carry on
            grid currentgrid = findmingrid(openlist);
            openlist.remove(currentgrid);
            closelist.add(currentgrid);
            //inspect the neighbors
            List<grid> neighbors = findneighbor(currentgrid, openlist, closelist);
            for (grid grid : neighbors) {
                if (!openlist.contains(grid)) {
                    grid.initgrid(currentgrid, end);
                    openlist.add(grid);
                }
            }
            //ending scenario
            for (grid grid : openlist) {
                if ((grid.x == end.x) && (grid.y == end.y)) {
                    return grid;
                }
            }
        }
        return null;
    }

    /**
     * findmingrid inspects all valid paths and picks the most suitable one
     *
     * @param openlist the list with candidates
     * @return the most suitable path to go which is the next step, returning a grid
     */

    private static grid findmingrid(ArrayList<grid> openlist) {
        grid tempgrid = openlist.get(0);
        for (grid grid : openlist) {
            if (grid.f < tempgrid.f) {
                tempgrid = grid;
            }
        }
        return tempgrid;
    }

    /**
     * findneighbor picks up the up, down, left, right grids, check whether they are valid and returns them by wrapping them in a list
     *
     * @param grid      the grid that is the last step
     * @param openlist  we have to inspect whether it is in the openlist already
     * @param closelist we have to inspect whether it is in the closelist already
     * @return a wrapped list contains valid candidate of the next step
     */

    private static ArrayList<grid> findneighbor(grid grid, List<grid> openlist, List<grid> closelist) {
        ArrayList<grid> gridlist = new ArrayList<grid>();
        if (isvalidgrid(grid.x, grid.y - 1, openlist, closelist)) {
            gridlist.add(new grid(grid.x, grid.y - 1));
        }
        if (isvalidgrid(grid.x, grid.y + 1, openlist, closelist)) {
            gridlist.add(new grid(grid.x, grid.y + 1));
        }
        if (isvalidgrid(grid.x - 1, grid.y, openlist, closelist)) {
            gridlist.add(new grid(grid.x - 1, grid.y));
        }
        if (isvalidgrid(grid.x + 1, grid.y, openlist, closelist)) {
            gridlist.add(new grid(grid.x + 1, grid.y));
        }

        if (isvalidgrid(grid.x-1, grid.y - 1, openlist, closelist)) {
            gridlist.add(new grid(grid.x-1, grid.y - 1));
        }
        if (isvalidgrid(grid.x+1, grid.y + 1, openlist, closelist)) {
            gridlist.add(new grid(grid.x+1, grid.y + 1));
        }
        if (isvalidgrid(grid.x - 1, grid.y+1, openlist, closelist)) {
            gridlist.add(new grid(grid.x - 1, grid.y+1));
        }
        if (isvalidgrid(grid.x + 1, grid.y-1, openlist, closelist)) {
            gridlist.add(new grid(grid.x + 1, grid.y-1));
        }

        return gridlist;
    }

    /**
     * isvalidgrid checks whether the grid is a new grid that is potentially the path
     *
     * @param x         x coordinate
     * @param y         y coordinate
     * @param openlist  list which grid is already under evalutaion
     * @param closelist list which grid is already checked
     * @return the validity of the grid
     */

    private static boolean isvalidgrid(int x, int y, List<grid> openlist, List<grid> closelist) {
        //whether we have crossed the border
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return false;
        }
        //whether there is an obstacle
        if (map[x][y] == 1) {
            return false;
        }
        //if openlist and close list contains the grid ,we have found it already
        if (containgrid(openlist, x, y)) {
            return false;
        }
        if (containgrid(closelist, x, y)) {
            return false;
        }
        return true;
    }

    /**
     * Iterate the whole list to see if the list contains certain grid
     *
     * @param grids the list to be inspected
     * @param x     target x coordinate
     * @param y     target y coordinate
     * @return whether the list contains certain grid
     */
    public static boolean containgrid(List<grid> grids, int x, int y) {
        for (grid n : grids) {
            if ((n.x == x) && (n.y) == y) {
                return true;
            }
        }
        return false;
    }
//

    /**
     * basic grid class draws the outline of how a element in the map looks like
     * (x,y) is the coordinate of the element
     * f is the overall evaluation of the grid, which f = g + h
     * g is the cost of going from the start to the current grid
     * h is the evaluation cost of arriving the target ,which neglects the obstacles
     * parent grid is the linking grid while the path is found, we may track the entire path by the linking parent grids
     */
    static class grid {
        public int x;
        public int y;
        public int f;
        public int g;
        public int h;
        public grid parent;

        //constructor
        public grid(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void initgrid(grid parent, grid end) {
            this.parent = parent;
            if (parent != null) {
                this.g = parent.g + 1;
            } else {
                this.g = 1;
            }
            this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
            this.f = this.g + this.h;
        }
    }

    public static int[][] executesearch (int[][] map, int startx, int starty, int endx, int endy) {
        //construct the startgrid and the endgrid

        setMap(map);
        grid startgrid = new grid(startx, starty);
        grid endgrid = new grid(endx, endy);
        grid resultgrid = astarsearch(startgrid, endgrid);
        ArrayList<grid> path = new ArrayList<grid>();
        //tracking the path back
        while (resultgrid != null) {
            path.add(new grid(resultgrid.x, resultgrid.y));
            resultgrid = resultgrid.parent;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (containgrid(path, i, j)) {
                    map[i][j] = 7;
                }
            }

        }
        return map;

    }
//
//    public static void main(String[] args) {
//        int[][] schoolmap = new int[][]{
//                {0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0},
//
//        };
//
//        AStarAlgorithm aStarAlgorithm = new AStarAlgorithm();
//        aStarAlgorithm.setmap(schoolmap);
//
//        int[][] ans = aStarAlgorithm.executesearch(map, 2, 1, 2, 5);
//        for (int i = 0; i < ans.length; i++) {
//            for (int j = 0; j < ans[i].length; j++) {
//                System.out.print(ans[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//
//    }
}
