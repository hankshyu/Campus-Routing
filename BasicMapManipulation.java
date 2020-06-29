
public class BasicMapManipulation {

    private static int[][] map;



    /**
     * a constructing method that initialise the map
     *
     * @param row    rows of the map
     * @param column columns of the map
     */

    public static void createMap(int row, int column) {
        map = new int[row][column];
    }

    /**
     * getter
     *
     * @return map
     */

    public static int[][] getMap() {
        return map;
    }

    /**
     * setter
     *
     * @param map the value of setting the entire map
     */

    public static void setMap(int[][] map) {
        BasicMapManipulation.map = map;
    }


    /**
     * get the specific value according to the coordinate
     *
     * @param x the target x coordinate
     * @param y the target y coordinate
     * @return the value of the coordinate
     */

    public static int getMapValue(int x, int y) {
        return map[x][y];
    }

    /**
     * set the specific value in the map
     *
     * @param x     target x coordiante
     * @param y     target y coordinate
     * @param value value to set in the coordinate
     */

    public static void setMapValue(int x, int y, int value) {
        map[x][y] = value;
    }

    /**
     * clears the entire map and gives an initial value of 0;
     */

    public static void clearMap() {
        setMap(new int[getMap().length][getMap()[0].length]);
    }

    /**
     * method that prints the map
     */

    public static void printMap() {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    /**
     * method that checks whether the target coordinate is in the map we created
     *
     * @param x x coordinate of the target coordinate
     * @param y y coordiante of the target coordinate
     * @return whether it is in the map
     */

    public static boolean validCoordinate(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[x].length;
    }

    /**
     * method that rotates the entire map to the right
     */

    public static void rotateMapRight() {
        int[][] newmap = new int[map[0].length][map.length];
        for (int i = 0; i < newmap.length; i++) {
            for (int j = 0; j < newmap[0].length; j++) {
                newmap[i][newmap[0].length - j - 1] = map[j][i];
            }
        }
        setMap(newmap);
    }

    /**
     * method that rotates the entire map to the left
     */

    public static void rotateMapLeft() {
        int[][] newmap = new int[map[0].length][map.length];
        for (int i = 0; i < newmap.length; i++) {
            for (int j = 0; j < newmap[0].length; j++) {
                newmap[newmap.length - i - 1][j] = map[j][i];
            }
        }
        setMap(newmap);
    }

    /**
     * method that flips the map upside down
     */

    public static void flipMap() {
        int[][] newmap = new int[getMap().length][map[0].length];
        for (int i = 0; i < newmap.length; i++) {
            for (int j = 0; j < newmap[0].length; j++) {
                newmap[newmap.length - i - 1][j] = map[i][j];
            }
        }
        setMap(newmap);
    }

}
