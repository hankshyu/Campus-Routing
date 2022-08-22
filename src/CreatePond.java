
/**
 * the pond is a filled down triangle
 * e.g.
 * 000000000000
 * 000111111100
 * 000011111100
 * 000001111000
 * 000000110000
 * 000000000000
 *
 * @ x    the x coordinate of the tip of the pond
 * @ y    the y coordinate of the tip of the pond
 * @ size the size of the pond, must be greater than 2
 */

public class CreatePond extends BasicDrawings implements Constructions {

    private final int size;

    public CreatePond(int x, int y, int size) {
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
        return validCoordinate(x, y) && validCoordinate(x - size, y - size) && validCoordinate(x - size, y + size);

    }

    @Override
    public void construct() {
        if (sizeIsValid() && coordinateIsValid()) {
            //create the pond
            drawTriangle(x, y, size, 1, "down");
            //the pond is full of water, it is automatically filled
            fill(x - 2, y, 1);
        } else {

            throw new RuntimeException("The construction of pond fails");

        }

    }
}
