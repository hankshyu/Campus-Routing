public class BasicDrawings extends BasicMapManipulation {
    //it stores a pair of x, y as a coordinte
    public int x;
    public int y;

    /**
     * apply dfs to fill spaces, the effect is similar to the print screen method
     *
     * @param x the x coordinate to start filling
     * @param y the y coordinate to start filling
     */

    public static void fill(int x, int y, int value) {
        setMapValue(x, y, value);
        if (validCoordinate(x + 1, y)) {
            if (getMapValue(x + 1, y) == 0)
                fill(x + 1, y, value);

        }

        if (validCoordinate(x - 1, y)) {
            if (getMapValue(x - 1, y) == 0)
                fill(x - 1, y, value);

        }
        if (validCoordinate(x, y + 1)) {
            if (getMapValue(x, y + 1) == 0)
                fill(x, y + 1, value);

        }
        if (validCoordinate(x, y - 1)) {
            if (getMapValue(x, y - 1) == 0)
                fill(x, y - 1, value);

        }

    }

    /**
     * copies a rectangle in the map and paste it to a target area
     * the rectangle has a format of:
     * length
     * |
     * width-centre_width
     * |
     * length
     *
     * @param copyx  the centre x coordinate to copy
     * @param copyy  the centre y coordinate to paste
     * @param length the length of the copy rectangle
     * @param width  the width of the copy rectangle
     * @param pastex the centre x coordinate to paste
     * @param pastey the centre y coordinate to paste
     */

    public static void copyAndPaste(int copyx, int copyy, int length, int width, int pastex, int pastey) {
        //check the borders of the place to copy and paste down
        //check copy
        if (
                !validCoordinate(copyx + length, copyy + width) ||
                        !validCoordinate(copyx + length, copyy - width) ||
                        !validCoordinate(copyx - length, copyy + width) ||
                        !validCoordinate(copyx - length, copyy - width) ||

                        //check paste
                        !validCoordinate(pastex + length, pastey + width) ||
                        !validCoordinate(pastex + length, pastey - width) ||
                        !validCoordinate(pastex - length, pastey + width) ||
                        !validCoordinate(pastex - length, pastey - width)
        ) {
            throw new RuntimeException("The copy and paste procedure contains points not in the map");
        }
        //start copy procedure
        int[][] copyarr = new int[2 * length + 1][2 * width + 1];
        for (int i = 0; i < copyarr.length; i++) {
            for (int j = 0; j < copyarr[i].length; j++) {
                copyarr[i][j] = getMapValue(copyx - length + i, copyy - width + j);

            }
        }
        //paste on the target space

        for (int i = 0; i < copyarr.length; i++) {
            for (int j = 0; j < copyarr[i].length; j++) {
                setMapValue(pastex - length + i, pastey - width + j, copyarr[i][j]);
            }
        }
    }

    /**
     * method that draws a horizontal line in the map
     * e.g: value 1
     * 00000000
     * 01111100
     * 00000000
     * 00000000
     *
     * @param startx starting x coordinate
     * @param starty starting y coordinate
     * @param endx   ending x coordinate
     * @param endy   ending y coordinate
     */

    public static void drawHorizontalLine(int startx, int starty, int endx, int endy, int value) {

        //check whether the points entered are valid points
        if (!validCoordinate(startx, starty) || !validCoordinate(endx, endy)) {
            if (!validCoordinate(startx, starty) && !validCoordinate(endx, endy)) {
                throw new RuntimeException("Coordinate ( " + startx + " , " + starty + " ) is not in the map\n" +
                        "Coordinate ( " + endx + " , " + endy + " ) is not in the map");
            } else if (!validCoordinate(startx, starty)) {
                throw new RuntimeException("Coordinate ( " + startx + " , " + starty + " ) is not in the map");
            } else {
                throw new RuntimeException("Coordinate ( " + endx + " , " + endy + " ) is not in the map");
            }
        }


        if (startx != endx) {
            throw new RuntimeException("Two coordinate is not in a horizontal line");

        }
        for (int i = Math.min(starty, endy); i <= Math.max(starty, endy); i++) {
            setMapValue(startx, i, value);
        }
    }

    /**
     * method that draws a vertical line in the map
     * e.g: value 1
     * 00000000
     * 01000000
     * 01000000
     * 01000000
     * 01000000
     * 00000000
     *
     * @param startx starting x coordinate
     * @param starty starting y coordinate
     * @param endx   ending x coordinate
     * @param endy   endking y coordinate
     */

    public static void drawVerticalLine(int startx, int starty, int endx, int endy, int value) {

        //check whether the points entered are valid points
        if (!validCoordinate(startx, starty) || !validCoordinate(endx, endy)) {
            if (!validCoordinate(startx, starty) && !validCoordinate(endx, endy)) {
                throw new RuntimeException("Coordinate ( " + startx + " , " + starty + " ) is not in the map\n" +
                        "Coordinate ( " + endx + " , " + endy + " ) is not in the map");
            } else if (!validCoordinate(startx, starty)) {
                throw new RuntimeException("Coordinate ( " + startx + " , " + starty + " ) is not in the map");
            } else {
                throw new RuntimeException("Coordinate ( " + endx + " , " + endy + " ) is not in the map");
            }
        }
        if (starty != endy) {
            throw new RuntimeException("Two coordinate is not in a vertical line");

        }
        for (int i = Math.min(startx, endx); i <= Math.max(startx, endx); i++) {
            setMapValue(i, starty, value);
        }
    }

    /**
     * method that draws a diagonal line in the map
     * e.g: value 1
     * 00000000
     * 01000000
     * 00100000
     * 00010000
     * 00001000
     * 00000000
     *
     * @param startx starting x coordinate
     * @param starty starting y coordinate
     * @param endx   ending x coordinate
     * @param endy   endking y coordinate
     */

    public static void drawDiagonalUnclosedLine(int startx, int starty, int endx, int endy, int value) {

        //check whether the points entered are valid points
        if (!validCoordinate(startx, starty) || !validCoordinate(endx, endy)) {
            if (!validCoordinate(startx, starty) && !validCoordinate(endx, endy)) {
                throw new RuntimeException("Coordinate ( " + startx + " , " + starty + " ) is not in the map\n" +
                        "Coordinate ( " + endx + " , " + endy + " ) is not in the map");
            } else if (!validCoordinate(startx, starty)) {
                throw new RuntimeException("Coordinate ( " + startx + " , " + starty + " ) is not in the map");
            } else {
                throw new RuntimeException("Coordinate ( " + endx + " , " + endy + " ) is not in the map");
            }
        }
        //check whether if the slope of the two line is 1 or -1;
        if (Math.abs((float) (startx - endx) / (float) (starty - endy)) != 1) {
            throw new RuntimeException("Two coordinate is not in a diagonal line");

        }
        //slope is 1 (the value is -1 due to it is not the familiar coordinate system)
        if (((float) (startx - endx) / (float) (starty - endy)) == -1) {
            int bigx = Math.max(startx, endx);
            int smally = Math.min(starty, endy);
            int smallx = Math.min(startx, endx);
            int bigy = Math.max(starty, endy);
            while (true) {
                setMapValue(bigx, smally, value);
                bigx--;
                smally++;
                if (bigx == smallx && smally == bigy) {
                    setMapValue(bigx, smally, value);
                    break;
                }
            }
        }
        //slope is -1
        if (((float) (startx - endx) / (float) (starty - endy)) == 1) {
            int smallx = Math.min(startx, endx);
            int smally = Math.min(starty, endy);
            int bigx = Math.max(startx, endx);
            int bigy = Math.max(starty, endy);
            while (true) {
                setMapValue(smallx, smally, value);
                smallx++;
                smally++;
                if (smallx == bigx && smally == bigy) {
                    setMapValue(smallx, smally, value);
                    break;
                }
            }

        }
    }

    /**
     * method that draws closed stairs in the map
     * e.g: value 1
     * 00000000
     * 01100000
     * 00110000
     * 00011000
     * 00001000
     * 00000000
     *
     * @param startx starting x coordinate
     * @param starty starting y coordinate
     * @param endx   ending x coordinate
     * @param endy   endking y coordinate
     */

    public static void drawStairs(int startx, int starty, int endx, int endy, int value) {

        //check whether the points entered are valid points
        if (!validCoordinate(startx, starty) || !validCoordinate(endx, endy)) {
            if (!validCoordinate(startx, starty) && !validCoordinate(endx, endy)) {
                throw new RuntimeException("Coordinate ( " + startx + " , " + starty + " ) is not in the map\n" +
                        "Coordinate ( " + endx + " , " + endy + " ) is not in the map");
            } else if (!validCoordinate(startx, starty)) {
                throw new RuntimeException("Coordinate ( " + startx + " , " + starty + " ) is not in the map");
            } else {
                throw new RuntimeException("Coordinate ( " + endx + " , " + endy + " ) is not in the map");
            }
        }
        //check whether if the slope of the two line is 1 or -1;
        if (Math.abs((float) (startx - endx) / (float) (starty - endy)) != 1) {
            throw new RuntimeException("Two coordinate is not in a diagonal line, stairs cannot be formed");

        }
        //slope is 1 (the value is -1 due to it is not the familiar coordinate system)
        if (((float) (startx - endx) / (float) (starty - endy)) == -1) {
            int bigx = Math.max(startx, endx);
            int smally = Math.min(starty, endy);
            int smallx = Math.min(startx, endx);
            int bigy = Math.max(starty, endy);
            drawDiagonalUnclosedLine(bigx, smally, smallx, bigy, value);
            drawDiagonalUnclosedLine(bigx - 1, smally, smallx, bigy - 1, value);
        }
        //slope is -1
        if (((float) (startx - endx) / (float) (starty - endy)) == 1) {
            int smallx = Math.min(startx, endx);
            int smally = Math.min(starty, endy);
            int bigx = Math.max(startx, endx);
            int bigy = Math.max(starty, endy);
            drawDiagonalUnclosedLine(smallx, smally, bigx, bigy, value);
            drawDiagonalUnclosedLine(smallx, smally + 1, bigx - 1, bigy, value);

        }
    }

    /**
     * method that builds a rectangle with format of:
     * length
     * |
     * width-center-width
     * |
     * length
     * e.g: with length 3, width 2, value 1
     * 000000000
     * 001111100
     * 001000100
     * 001000100
     * 001000100
     * 001000100
     * 001000100
     * 001111100
     * 000000000
     *
     * @param x      the x coordinate of the centre of the rectangle
     * @param y      the y coordinate of the centre of the rectangle
     * @param length the length of the building
     * @param width  the width of the building
     */

    public static void drawRectangle(int x, int y, int length, int width, int value) {
        //check whether the building will be in the map, we check the marginal coordinate
        if (!validCoordinate(x - length, y - width) || !validCoordinate(x - length, y + width)
                || !validCoordinate(x + length, y - width) || !validCoordinate(x + length, y + width)) {

            throw new RuntimeException("The rectangle might not be in the map");

        }
        //check if the size of the rectangle is acceptable
        if (x < 1 || y < 1) {
            throw new RuntimeException("The size of the building is not acceptable");
        }

        //before the drawing we shall remove all the remaining obstacles in advance
        for (int i = x - length; i <= x + length; i++) {
            for (int j = y - width; j <= y + width; j++) {
                setMapValue(i, j, 0);
            }
        }

        //build the sides
        drawHorizontalLine(x - length, y - width, x - length, y + width, value);
        drawHorizontalLine(x + length, y - width, x + length, y + width, value);
        drawVerticalLine(x - length, y - width, x + length, y - width, value);
        drawVerticalLine(x - length, y + width, x + length, y + width, value);

    }

    /**
     * method that builds a rhombus with format of:
     * e.g. value 1
     * size
     * |
     * size-center-size
     * |
     * size
     * e.g: size 3 value 1
     * <p>
     * 000000000
     * 000010000
     * 000101000
     * 001000100
     * 000101000
     * 000010000
     * 000000000
     *
     * @param x    the x coordinate of the centre of the rhombus
     * @param y    the y coordinate of the centre of the rhombus
     * @param size the size of the rhombus
     */

    public static void drawRhombus(int x, int y, int size, int value) {
        //check whether the rhombus will be in the map, we check the marginal coordinate
        if (!validCoordinate(x, y - size) || !validCoordinate(x, y + size)
                || !validCoordinate(x - size, y) || !validCoordinate(x + size, y)) {

            throw new RuntimeException("The rhombus might not be in the map");

        }
        //check if the size of the rhombus is acceptable
        if (x < 1 || y < 1) {
            throw new RuntimeException("The size of the rhombus is not acceptable");
        }

        //build the rhombus
        drawDiagonalUnclosedLine(x - size, y, x, y + size, value);
        drawDiagonalUnclosedLine(x, y + size, x + size, y, value);
        drawDiagonalUnclosedLine(x + size, y, x, y - size, value);
        drawDiagonalUnclosedLine(x, y - size, x - size, y, value);

    }

    /**
     * method that builds a isosceles triangle, there is up and down two types
     * e.g.(up type, size 3, value 1)
     * 000000000
     * 000010000
     * 000111000
     * 001111100
     * 000000000
     * <p>
     * e.g.(down type, size 3, value 1)
     * 000000000
     * 001111100
     * 000111000
     * 000010000
     * 000000000
     *
     * @param x                   the x coordinate between two equal sides
     * @param y                   the y coordinate between two equal sides
     * @param sidelength          the size of the two equal sides
     * @param triangledescription "up" or "down" to determine how the triangle sits
     */

    public static void drawTriangle(int x, int y, int sidelength, int value, String triangledescription) {
        //check the size of the triangle
        if (sidelength < 1) {
            throw new RuntimeException("The size of the triangle is not permitted");
        }
        //check if the up down description of the triangle is invalid
        if (!triangledescription.toLowerCase().contains("up") && !triangledescription.toLowerCase().contains("down") ||
                triangledescription.toLowerCase().contains("up") && triangledescription.toLowerCase().contains("down")
        ) {
            throw new RuntimeException("The description of the triangle direction is invalid");
        }
        //judge if it is a up or down triangle
        if (triangledescription.toLowerCase().contains("up")) {
            //check whether the three sides is in the map, we check the marginal points
            if (!validCoordinate(x, y) || !validCoordinate(x + sidelength, y - sidelength) ||
                    !validCoordinate(x + sidelength, y + sidelength)) {
                throw new RuntimeException("The triangle is not in the map");
            }

            //connect the lines
            drawStairs(x, y, x + sidelength, y - sidelength, value);
            drawStairs(x, y, x + sidelength, y + sidelength, value);
            drawHorizontalLine(x + sidelength, y - sidelength, x + sidelength, y + sidelength, value);

        } else if (triangledescription.toLowerCase().contains("down")) {
            //check whether the three sides is in the map, we check the marginal points
            //check whether the three sides is in the map, we check the marginal points
            if (!validCoordinate(x, y) || !validCoordinate(x - sidelength, y - sidelength) ||
                    !validCoordinate(x - sidelength, y + sidelength)) {
                throw new RuntimeException("The triangle is not in the map");
            }

            //connect the lines
            drawStairs(x, y, x - sidelength, y - sidelength, value);
            drawStairs(x, y, x - sidelength, y + sidelength, value);
            drawHorizontalLine(x - sidelength, y - sidelength, x - sidelength, y + sidelength, value);
        }

    }

    /**
     * builds a block with format of:
     * length
     * |
     * width-center-width
     * |
     * length
     * <p>
     * e.g. :(length 3, width 2)
     * 0000000000000
     * 0000001111100
     * 0000001111100
     * 0000001111100
     * 0000001111100
     * 0000001111100
     * 0000001111100
     * 0000001111100
     * <p>
     *
     * @param x      the x coordinate  of the center of the building
     * @param y      the y coordinate  of the center of the building
     * @param length the length of the building
     * @param width  the width of the building
     */

    public void drawRectangleBlock(int x, int y, int length, int width) {
        //check whether the block will be in the map, we check the marginal coordinate
        if (!validCoordinate(x - length, y - width) || !validCoordinate(x - length, y + width)
                || !validCoordinate(x + length, y - width) || !validCoordinate(x + length, y + width)) {

            throw new RuntimeException("The rectangle block might not be in the map");

        }
        //check if the size of the building is acceptable
        if (length < 1 || width < 1) {
            throw new RuntimeException("The size of the building is not acceptable");
        }

        //build the wall
        drawRectangle(x, y, length, width, 1);

        //fill the block
        fill(x, y, 1);

    }

    /**
     * builds a block with format of:
     * size
     * |
     * size-center-size
     * |
     * size
     * e.g: (size 4)
     * 000000000000000000000000000000
     * 000000000000000100000000000000
     * 000000000000001110000000000000
     * 000000000000011111000000000000
     * 000000000000111111100000000000
     * 000000000001111111110000000000
     * 000000000000111111100000000000
     * 000000000000011111000000000000
     * 000000000000001110000000000000
     * 000000000000000100000000000000
     * 000000000000000000000000000000
     * <p>
     *
     * @param x    the x coordinate of the centre of the rhombus
     * @param y    tje y coordinate of the centre of the rhombus
     * @param size the size of the rhombus
     */

    public static void drawRhombusBlock(int x, int y, int size) {
        //check if the block is on the map
        if (!validCoordinate(x + size, y + size) || !validCoordinate(x + size, y - size)
                || !validCoordinate(x - size, y + size) || !validCoordinate(x - size, y - size)) {
            throw new RuntimeException("The rhombus block might not be in the map");
        }
        //check if the size of the building is acceptable
        if (size < 2) {
            throw new RuntimeException("The size of the building is not acceptable");
        }
        //build the wall
        drawRhombus(x, y, size, 1);
        drawRhombus(x, y, size - 1, 1);//this closes the wall

        //fill the rhombus
        fill(x, y, 1);

    }

    /**
     * draws a solid isosceles triangle triangle with tip at (x,y), the two equal sides are lengthen size
     * e.g:(size 4,triangledexcription up)
     * 000000000000000000000000000000
     * 000000000000001110000000000000
     * 000000000000011111000000000000
     * 000000000000111111100000000000
     * 000000000001111111110000000000
     * 000000000001111111110000000000
     * 000000000000000000000000000000
     *
     * @param x                   x coordinate of the tip of the triangle
     * @param y                   y coordinate of the tip of teh triangle
     * @param size                the length of the tow equal sides
     * @param triangledescription up or down
     */

    public static void drawTriangleBlock(int x, int y, int size, String triangledescription) {
        //we then check the validity of the triangledexcription
        if (!triangledescription.toLowerCase().contains("up") && !triangledescription.toLowerCase().contains("down")) {
            throw new RuntimeException("Triangle description error ,must contaion \"up\" or \"down\"");
        }
        //check whether the points description of the building is in the map
        if (triangledescription.toLowerCase().contains("up")) {
            //situation where it is a up triangle
            if (!validCoordinate(x, y) || !validCoordinate(x + size, y + size) || !validCoordinate(x + size, y - size)) {
                throw new RuntimeException("The up triangle contains invalid points");
            }
        } else if (triangledescription.toLowerCase().contains("down")) {
            //situation where it is a down triangle
            if (!validCoordinate(x, y) || !validCoordinate(x - size, y + size) || !validCoordinate(x - size, y - size)) {
                throw new RuntimeException("The down triangle contains invalid points");
            }
        }
        //we then check the size of the triangle
        if (size <= 2) {
            throw new RuntimeException("The size of the triangle is invalid, the size of triangle building must be greater than 2");
        }


        //we directly draw the triangle,
        drawTriangle(x, y, size, 1, triangledescription);


        if (triangledescription.toLowerCase().contains("up")) {

            //if it is an up triangle
            fill(x + 2, y, 1);

        } else if (triangledescription.toLowerCase().contains("down")) {
            //if it is a down triangle
            fill(x - 2, y, 1);
        }
    }

    public static void drawrandomblocks(int x, int y, int length, int width, int density) {
        //check whether the building will be in the map, we check the marginal coordinate
        if (!validCoordinate(x, y) || !validCoordinate(x + length, y + width)) {

            throw new RuntimeException("The obstacle might not be in the map");

        }
        //check if the size of the rectangle is acceptable
        if (x < 1 || y < 1) {
            throw new RuntimeException("The size of the block is not acceptable");
        }


        //start putting points on the map randomly, but if the block connects to anything, than give up
        for (int i = 0; i < density * 10; i++) {
            int xrandom = (int) (Math.random() * length) + x;
            int yrandom = (int) (Math.random() * width) + y;
            if (getMapValue(xrandom, yrandom) == 0 && getMapValue(xrandom + 1, yrandom + 1) == 0 &&
                    getMapValue(xrandom + 1, yrandom - 1) == 0 && getMapValue(xrandom - 1, yrandom + 1) == 0
                    && getMapValue(xrandom - 1, yrandom - 1) == 0) {

                setMapValue(xrandom, yrandom, 1);

            }
        }


    }

}
