/**
 * builds a triangular building, may choose the shape of the building, but only optional up and down
 * building comes with windows, may choose between north and south or both
 * e.g. :(size 3, triangledescription down, windowdescription north,filled)
 * 00000000000000000
 * 00000001110111000
 * 00000000110111000
 * 00000000010110000
 * 00000000001100000
 * 00000000000000000
 *
 * @ x                   x coordinate of the tip of the triangle
 * @ y                   y coordinate of the top of the triangle
 * @ size                the side length of the triangle, must be greater than 2
 * @ triangleDescription whether the triangle is an up or down triangle
 * @ doorDescription   choose between north or south or both windows
 * @ filled              whether to fill the triangle
 */

public class CreateTriangularBuildings extends BasicDrawings implements SymmetricBuildings {


    final private int size;
    final private String triangleDescription;
    final private String doorDescription;
    final private boolean filled;

    public CreateTriangularBuildings(int x, int y, int size, String triangleDescription, String doorDescription, boolean filled) {
        super.x = x;
        super.y = y;
        this.size = size;
        this.triangleDescription = triangleDescription;
        this.doorDescription = doorDescription;
        this.filled = filled;
    }

    public boolean triangleDescriptionIsValid() {
        if (!triangleDescription.toLowerCase().contains("up") && !triangleDescription.toLowerCase().contains("down")) {
            throw new RuntimeException("Triangle description error ,must contaion \"up\" or \"down\"");

        } else {
            return true;
        }

    }

    @Override
    public boolean sizeIsValid() {
        return size > 2;
    }

    @Override
    public void fillTheBuilding() {
        if (triangleDescription.toLowerCase().contains("up")) {

            //if it is an up triangle
            fill(x + 2, y, 1);

        } else if (triangleDescription.toLowerCase().contains("down")) {
            //if it is a down triangle
            fill(x - 2, y, 1);
        }

    }

    @Override
    public boolean doorDescriptionIsValid() {
        return doorDescription.toLowerCase().contains("north") || doorDescription.toLowerCase().contains("south");
    }

    @Override
    public boolean coordinateIsValid() {
        if (triangleDescription.toLowerCase().contains("up")) {
            //situation where it is a up triangle
            if (!validCoordinate(x, y) || !validCoordinate(x + size, y + size) || !validCoordinate(x + size, y - size)) {
                throw new RuntimeException("The up triangle contains invalid points");
            }
        } else if (triangleDescription.toLowerCase().contains("down")) {
            //situation where it is a down triangle
            if (!validCoordinate(x, y) || !validCoordinate(x - size, y + size) || !validCoordinate(x - size, y - size)) {
                throw new RuntimeException("The down triangle contains invalid points");
            }
        }
        return true;
    }

    @Override
    public void construct() {

        if (triangleDescriptionIsValid() && sizeIsValid() && doorDescriptionIsValid() && coordinateIsValid()) {
            //we directly draw the triangle,
            drawTriangle(x, y, size, 1, triangleDescription);

            //if asked to fill, fill the building
            if (filled) {
              fillTheBuilding();
            }
            //we build the windows as description
            if (triangleDescription.toLowerCase().contains("up")) {
                if (doorDescription.toLowerCase().contains("north")) {
                    drawVerticalLine(x, y, x + size / 2, y, 0);

                } else if (doorDescription.toLowerCase().contains("south")) {
                    drawVerticalLine(x + size / 2, y, x + size, y, 0);
                }
            }
            if (triangleDescription.toLowerCase().contains("down")) {
                if (doorDescription.toLowerCase().contains("north")) {
                    drawVerticalLine(x - size, y, x - (size / 2), y, 0);

                } else if (doorDescription.toLowerCase().contains("south")) {
                    drawVerticalLine(x - (size / 2), y, x, y, 0);
                }
            }
        }
    }
}
