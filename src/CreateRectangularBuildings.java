/**
 * builds a building with format of:
 * length
 * |
 * width-center-width
 * |
 * length
 * <p>
 * e.g. :(length 3, width 2,windowdescroption north east, filled true)
 * 0000000000000
 * 0000001101100
 * 0000001101100
 * 0000001101100
 * 0000001100000
 * 0000001111100
 * 0000001111100
 * 0000001111100
 * <p>
 * the building comes with windows, the building has north, south, east, west windows, building must at least equip with one
 * window description is "North south"if willing to have north and south windows
 * filled house would fill the spaces in the building
 *
 * @x     the x coordinate of teh centre of the building
 * @y      the y coordinate of the centre of the building
 * @length the length of the building
 * @width  the width of the building
 * @DoorDescription whether to build windows
 * @filled whether to fill the building
 */

public class CreateRectangularBuildings extends BasicDrawings implements NoneSymmetricBuildings {


    final int length;
    final int width;
    final String DoorDescription;
    final boolean filled;

    public CreateRectangularBuildings(int x, int y, int length, int width, String DoorDescription, boolean filled) {
        super.x = x;
        super.y = y;
        this.length = length;
        this.width = width;
        this.DoorDescription = DoorDescription;
        this.filled = filled;
    }

    @Override
    public boolean sizesAreValid() {
        return length >= 1 && width >= 1;
    }

    @Override
    public void fillTheBuilding() {
        fill(x, y, 1);
    }

    @Override
    public boolean doorDescriptionIsValid() {
        return DoorDescription.toLowerCase().contains("north") || DoorDescription.toLowerCase().contains("south") ||
                DoorDescription.toLowerCase().contains("east") || DoorDescription.toLowerCase().contains("west");
    }

    @Override
    public boolean coordinateIsValid() {
        return validCoordinate(x - length, y - width) && validCoordinate(x - length, y + width)
                && validCoordinate(x + length, y - width) && validCoordinate(x + length, y + width);
    }

    @Override
    public void construct() {
        if (sizesAreValid() && doorDescriptionIsValid() && coordinateIsValid()) {
            //build the wall
            drawRectangle(x, y, length, width, 1);

            //fill if suggested
            if (filled) {
                fillTheBuilding();
            }

            //read the windowDescription and construct the window
            if (DoorDescription.toLowerCase().contains("north")) {

                drawVerticalLine(x, y, x - length, y, 0);

            }
            if (DoorDescription.toLowerCase().contains("south")) {
                drawVerticalLine(x, y, x + length, y, 0);

            }
            if (DoorDescription.toLowerCase().contains("east")) {
                drawHorizontalLine(x, y, x, y + width, 0);

            }
            if (DoorDescription.toLowerCase().contains("west")) {
                drawHorizontalLine(x, y, x, y - width, 0);

            }
        }else{
            throw new RuntimeException("The construction of Rectangular Building fails");
        }
    }
}
