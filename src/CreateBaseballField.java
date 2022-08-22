/**
 * the baseball field is a filled  down triangle, the entry of the baseball field is at the tip of the triangle
 * e.g.:(size 3)
 * 000000000000
 * 000011111110
 * 000001111100
 * 000000111000
 * 000000000000
 *
 * @ x    the x coordinate of the tip of the baseball field
 * @ y    the y coordinate of the top of the  baseball field
 * @ size the side length of the baseball field, must be greater than 2
 */

public class CreateBaseballField extends BasicDrawings implements Constructions {

    final private int size;

    public CreateBaseballField(int x, int y, int size) {
        super.x = x;
        super.y = y;
        this.size = size;
    }

    @Override
    public boolean sizeIsValid() {
        return size > 2;
    }

    @Override
    public boolean coordinateIsValid() {
        return validCoordinate(x, y) && validCoordinate(x - size, y + size) && validCoordinate(x - size, y - size);
    }

    @Override
    public void construct() {
        if (sizeIsValid() && coordinateIsValid()) {
            //create a triangle outline of the baseball field
            drawTriangle(x, y, size, 1, "down");

            //the baseball field is automatically filled
            fill(x - 2, y, 1);

            //open a door at the tip of the baseball field
            setMapValue(x, y, 0);
        } else {

            throw new RuntimeException("The construction of Baseball field fails");

        }

    }
}
