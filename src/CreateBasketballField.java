/**
 * CreateBasketballField contains four courts,each court has a size of 2:1
 * e.g. (size 1)
 000000000000000000000000000000
 000000000011111011111000000000
 000000000011111011111000000000
 000000000011111011111000000000
 000000000000000500000000000000
 000000000011111011111000000000
 000000000011111011111000000000
 000000000011111011111000000000
 000000000000000000000000000000
 *
 * @ x    the x coordinate of the centre of the four courts
 * @ y    the y coordinate of the centre of the four courts
 * @ size the size of each court, the size is the width of a single court
 */

public class CreateBasketballField extends BasicDrawings implements Constructions {


    private final int size;

    public CreateBasketballField(int x, int y, int size) {
        super.x = x;
        super.y = y;
        this.size = size;
    }

    @Override
    public boolean sizeIsValid() {
        return size > 0;
    }

    @Override
    public boolean coordinateIsValid() {
        return validCoordinate(x + (2 * size + 1), y + (4 * size + 1)) &&
                validCoordinate(x + (2 * size + 1), y - (4 * size + 1)) &&
                validCoordinate(x - (2 * size + 1), y + (4 * size + 1)) &&
                validCoordinate(x - (2 * size + 1), y - (4 * size + 1));
    }

    @Override
    public void construct() {
        if (sizeIsValid() && coordinateIsValid()) {
            //create a single court
            drawRectangleBlock(x - (size + 1), y - (2 * size + 1), size, 2 * size);
            //copy and paste it
            copyAndPaste(x - (size + 1), y - (2 * size + 1), size, 2 * size, x - (2 * size ), y + (size + 2));
            copyAndPaste(x - (size + 1), y - (2 * size + 1), size, 2 * size, x + (2 * size ), y - (size + 2));
            copyAndPaste(x - (size + 1), y - (2 * size + 1), size, 2 * size, x + (2 * size ), y + (size + 2));

        } else {

            throw new RuntimeException("The construction of basketball court fails");

        }
    }


}
