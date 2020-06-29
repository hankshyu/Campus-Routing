/**
 * builds a rhombus building with format of:
 * size
 * |
 * size-centre-size
 * |
 * size
 * e.g. :(size 3,windowdescription northeast,filled false)
 * 00000000000000
 * 00000000100000
 * 00000001110000
 * 00000011001000
 * 00000110001100
 * 00000011011000
 * 00000001110000
 * 00000000100000
 * 00000000000000
 * <p>
 * the building comes with windows, the building has northeast, northwest, southeast, southwest windows, building must at least equip with one
 * window description is "Southeast northwest"if willing to have southeast and northwest windows
 * filled house would fill the spaces in the building
 *
 * @ x                 the centre x coordinate
 * @ y                 the centre y coordiante
 * @ size              the size of the rhombus buliding
 * @ DoorDescription how the windows are formed
 * @ filled            whether the building be filled
 */
public class CreateRhombusBuildings extends BasicDrawings implements SymmetricBuildings {

    final int size;
    final String DoorDescription;
    final boolean filled;

    public CreateRhombusBuildings(int x, int y, int size, String doorDescription, boolean filled) {
        super.x = x;
        super.y = y;
        this.size = size;
        DoorDescription = doorDescription;
        this.filled = filled;
    }

    @Override
    public boolean sizeIsValid() {
        return size >= 2;
    }

    @Override
    public void fillTheBuilding() {
        fill(x, y, 1);

    }

    @Override
    public boolean doorDescriptionIsValid() {
        return DoorDescription.toLowerCase().contains("northeast") || DoorDescription.toLowerCase().contains("northwest") ||
                DoorDescription.toLowerCase().contains("southeast") || DoorDescription.toLowerCase().contains("southwest");
    }

    @Override
    public boolean coordinateIsValid() {
        return validCoordinate(x + size, y + size) && validCoordinate(x + size, y - size)
                && validCoordinate(x - size, y + size) && validCoordinate(x - size, y - size) ;
    }

    @Override
    public void construct() {
        if (sizeIsValid() && doorDescriptionIsValid() && coordinateIsValid()) {
            drawRhombus(x, y, size, 1);
            drawRhombus(x, y, size - 1, 1);//this closes the wall

            //fill the building if suggested
            if (filled) {
                fill(x, y, 1);
            }

            //read the windowdescription and construct the window
            if (DoorDescription.toLowerCase().contains("northeast")) {
                drawDiagonalUnclosedLine(x, y, x - size / 2, y + size / 2, 0);

            }
            if (DoorDescription.toLowerCase().contains("northwest")) {
                drawDiagonalUnclosedLine(x, y, x - size / 2, y - size / 2, 0);

            }
            if (DoorDescription.toLowerCase().contains("southeast")) {
                drawDiagonalUnclosedLine(x, y, x + size / 2, y + size / 2, 0);
            }
            if (DoorDescription.toLowerCase().contains("southwest")) {
                drawDiagonalUnclosedLine(x, y, x + size / 2, y - size / 2, 0);
            }
        } else {
            throw new RuntimeException("The construction of create Rhombus Building fails");
        }

    }
}
