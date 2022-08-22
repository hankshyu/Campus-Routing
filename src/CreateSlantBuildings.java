/**
 * create a slant building,construct by the right side length and the left side length, containing a window
 * e.g.(leftsidesize 3, rightsidesize 4,windowDescription southwest,filled)
 * 000000000000000000
 * 000000111000000000
 * 000001111100000000
 * 000011111110000000
 * 000011110111000000
 * 000001101111000000
 * 000000011110000000
 * 000000011100000000
 * 000000001000000000
 * 000000000000000000
 *
 * @ x                 the x coordinate of the upper tip of the building
 * @ y                 the y coordinate of the upper tip of the building
 * @ leftSideSize      the left side length of the building
 * @ rightSideSize     the right side length of the building
 * @ windowDescription which side to open widow, at least have a window
 * @ filled            whether the building to be filled
 */

public class CreateSlantBuildings extends BasicDrawings implements NoneSymmetricBuildings {


    final private int leftSideSize;
    final private int rightSideSize;
    final private String DoorDescription;
    final private boolean filled;

    public CreateSlantBuildings(int x, int y, int leftSideSize, int rightSideSize, String windowDescription, boolean filled) {
        super.x = x;
        super.y = y;
        this.leftSideSize = leftSideSize;
        this.rightSideSize = rightSideSize;
        this.DoorDescription = windowDescription;
        this.filled = filled;
    }

    @Override
    public boolean sizesAreValid() {
        return leftSideSize >= 2 && rightSideSize >= 2;
    }

    @Override
    public void fillTheBuilding() {
        fill(x + 2, y, 1);

    }

    public void slantBuildingResetCentre() {
        super.x = x + leftSideSize / 2 + rightSideSize / 2;
        super.y = y - leftSideSize / 2 + rightSideSize / 2;
    }

    @Override
    public boolean doorDescriptionIsValid() {
        //check if the windowdedescription is invalid
        return DoorDescription.toLowerCase().contains("northeast") ||
                DoorDescription.toLowerCase().contains("northwest") ||
                DoorDescription.toLowerCase().contains("southeast") ||
                DoorDescription.toLowerCase().contains("southwest");
    }

    @Override
    public boolean coordinateIsValid() {
        return validCoordinate(x, y) &&
                validCoordinate(x + leftSideSize, y - leftSideSize) &&
                validCoordinate(x + leftSideSize, y + rightSideSize) &&
                validCoordinate(x + leftSideSize + rightSideSize, y - leftSideSize + rightSideSize);
    }

    @Override
    public void construct() {
        if (sizesAreValid() && doorDescriptionIsValid() && coordinateIsValid()) {
            //build the wall
            drawStairs(x, y, x + leftSideSize, y - leftSideSize, 1);
            drawStairs(x + leftSideSize, y - leftSideSize, x + leftSideSize + rightSideSize, y - leftSideSize + rightSideSize, 1);
            drawStairs(x + leftSideSize + rightSideSize, y - leftSideSize + rightSideSize, x + rightSideSize, y + rightSideSize, 1);
            drawStairs(x + rightSideSize, y + rightSideSize, x, y, 1);

            //fill the building if permitted
            if (filled) {
                fill(x + 2, y, 1);

            }
            //open windows

            if (DoorDescription.toLowerCase().contains("northeast")) {
                drawDiagonalUnclosedLine(x + rightSideSize / 2, y + rightSideSize / 2, x + leftSideSize / 2 + rightSideSize / 2, y - leftSideSize / 2 + rightSideSize / 2, 0);
            }
            if (DoorDescription.toLowerCase().contains("northwest")) {
                drawDiagonalUnclosedLine(x + leftSideSize / 2, y - leftSideSize / 2, x + leftSideSize / 2 + rightSideSize / 2, y - leftSideSize / 2 + rightSideSize / 2, 0);
            }
            if (DoorDescription.toLowerCase().contains("southeast")) {
                drawDiagonalUnclosedLine(x + rightSideSize + leftSideSize / 2, y + rightSideSize - leftSideSize / 2, x + leftSideSize / 2 + rightSideSize / 2, y - leftSideSize / 2 + rightSideSize / 2, 0);
            }
            if (DoorDescription.toLowerCase().contains("southwest")) {
                drawDiagonalUnclosedLine(x + leftSideSize + rightSideSize / 2, y - leftSideSize + rightSideSize / 2, x + leftSideSize / 2 + rightSideSize / 2, y - leftSideSize / 2 + rightSideSize / 2, 0);
            }
        }
        slantBuildingResetCentre();

    }

}
