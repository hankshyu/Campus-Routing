import java.util.TreeMap;

public class SchoolMap extends BasicDrawings {

    // a hashtable that stores object and their corresponding names
    final private static TreeMap<String, BasicDrawings> treeMap = new TreeMap<>();

    //a parameter to test whether the school is under a crowded mood
    public static boolean crowded=false;

    //getter of the map
    public int[][] getSchoolMap() {

        constructschool();
        return getMap();
    }

    //getter of the hashtable
    public TreeMap<String, BasicDrawings> getTreeMap() {

        return treeMap;
    }

//    //setter of the crowded parameter
//    public void setCrowded(boolean b) {
//
//        crowded = b;
//    }


    //the main function that constructs the map, and put correspond constructions with their names in the hashtable
    static void constructschool() {
        try {


            // start the building process by construct the fence of the school
            createMap(180, 210);
            drawStairs(70, 200, 30, 160, 1);
            drawHorizontalLine(30, 160, 30, 130, 1);
            drawStairs(30, 130, 10, 110, 1);
            drawHorizontalLine(10, 110, 10, 70, 1);
            drawStairs(10, 70, 60, 20, 1);
            drawVerticalLine(60, 20, 130, 20, 1);
            drawStairs(130, 20, 170, 60, 1);
            drawHorizontalLine(170, 60, 170, 160, 1);
            drawStairs(170, 160, 130, 200, 1);
            drawVerticalLine(130, 200, 70, 200, 1);

            //build the lake
            drawHorizontalLine(52, 157, 52, 168, 1);
            drawStairs(52, 168, 56, 172, 1);
            drawVerticalLine(56, 172, 62, 172, 1);
            drawHorizontalLine(62, 172, 62, 165, 1);
            drawVerticalLine(62, 165, 72, 165, 1);
            drawStairs(72, 165, 77, 160, 1);
            drawHorizontalLine(77, 160, 77, 148, 1);
            drawVerticalLine(77, 148, 65, 148, 1);
            drawStairs(65, 148, 56, 157, 1);
            drawVerticalLine(56, 157, 52, 157, 1);
            fill(65, 155, 1);


            //start building process


            CreateRectangularBuildings building1 = new CreateRectangularBuildings(78, 167, 1, 4, "south", crowded);
            building1.construct();
            treeMap.put("管理一館", building1);

            CreateRectangularBuildings building2 = new CreateRectangularBuildings(88, 155, 2, 4, "north", crowded);
            building2.construct();
            treeMap.put("人社二館", building2);

            CreateRectangularBuildings building3 = new CreateRectangularBuildings(76, 143, 1, 2, "north south west", crowded);
            building3.construct();
            treeMap.put("行政大樓", building3);

            CreateRectangularBuildings building4 = new CreateRectangularBuildings(65, 130, 5, 5, "north south east west", crowded);
            building4.construct();
            treeMap.put("中正堂", building4);

            CreateRectangularBuildings building5 = new CreateRectangularBuildings(84, 133, 2, 4, "north south west", crowded);
            building5.construct();
            treeMap.put("人社一館", building5);

            CreateRectangularBuildings building6 = new CreateRectangularBuildings(58, 117, 1, 4, "south", crowded);
            building6.construct();
            treeMap.put("工程一館", building6);

            CreateRectangularBuildings building7 = new CreateRectangularBuildings(53, 111, 3, 4, "north east west", crowded);
            building7.construct();
            treeMap.put("工程二館", building7);

            CreateRectangularBuildings building8 = new CreateRectangularBuildings(69, 94, 3, 6, "north south east west", crowded);
            building8.construct();
            treeMap.put("科學一館", building8);

            CreateRectangularBuildings building9 = new CreateRectangularBuildings(74, 115, 4, 6, "south west", crowded);
            building9.construct();
            treeMap.put("資訊館", building9);

            CreateRectangularBuildings building10 = new CreateRectangularBuildings(93, 105, 6, 4, " east west", crowded);
            building10.construct();
            treeMap.put("工程三館", building10);

            CreateRectangularBuildings building11and29 = new CreateRectangularBuildings(99, 151, 4, 9, "north south east west", crowded);
            building11and29.construct();
            treeMap.put("第一餐廳", building11and29);
            treeMap.put("學生活動中心", building11and29);

            CreateRectangularBuildings building12 = new CreateRectangularBuildings(45, 113, 3, 4, "north south west", crowded);
            building12.construct();
            treeMap.put("第二餐廳", building12);

            CreateRectangularBuildings building13 = new CreateRectangularBuildings(86, 180, 1, 3, "north west", crowded);
            building13.construct();
            treeMap.put("羽球場", building13);

            CreateRectangularBuildings TennisCourt1 = new CreateRectangularBuildings(65, 183, 2, 2, "west", crowded);
            TennisCourt1.construct();
            treeMap.put("網球場一", TennisCourt1);

            CreateRectangularBuildings TennisCourt2 = new CreateRectangularBuildings(78, 182, 3, 4, "north west", crowded);
            TennisCourt2.construct();
            treeMap.put("網球場二", TennisCourt2);

            CreateRectangularBuildings building14 = new CreateRectangularBuildings(56, 79, 5, 5, "north south", crowded);
            building14.construct();
            treeMap.put("體育館", building14);

            CreateRectangularBuildings SoftBallField = new CreateRectangularBuildings(70, 76, 5, 4, "north south", crowded);
            SoftBallField.construct();
            treeMap.put("壘球場", SoftBallField);

            CreateRectangularBuildings building15 = new CreateRectangularBuildings(32, 77, 4, 6, "south", crowded);
            building15.construct();
            treeMap.put("游泳池", building15);

            //田徑場 is always open space
            CreateRectangularBuildings trackField16 = new CreateRectangularBuildings(55, 55, 15, 12, "east south", false);
            trackField16.construct();
            treeMap.put("田徑場", trackField16);

            CreateBasketballField basketballField1 = new CreateBasketballField(76, 62, 1);
            basketballField1.construct();
            treeMap.put("籃球場一", basketballField1);

            CreateBasketballField basketballField2 = new CreateBasketballField(76, 48, 1);
            basketballField2.construct();
            treeMap.put("籃球場二", basketballField2);

            CreateBasketballField basketballField3 = new CreateBasketballField(84, 62, 1);
            basketballField3.construct();
            treeMap.put("籃球場三", basketballField3);

            CreateBasketballField basketballField4 = new CreateBasketballField(84, 48, 1);
            basketballField4.construct();
            treeMap.put("籃球場四", basketballField4);

            //dormitories cannot be passed
            CreateRectangularBuildings building17 = new CreateRectangularBuildings(114, 145, 6, 5, "west", true);
            building17.construct();
            treeMap.put("學生七舍", building17);

            // dormitories cannot be passed
            CreateRectangularBuildings building18 = new CreateRectangularBuildings(124, 150, 4, 7, "south", true);
            building18.construct();
            treeMap.put("學生八舍", building18);

            //dormitories cannot be passed
            CreateRhombusBuildings building19 = new CreateRhombusBuildings(39, 125, 4, "southeast southwest", true);
            //building19.construct();
            treeMap.put("竹軒", building19);

            //dormitories cannot be passed
            CreateRectangularBuildings building20and21 = new CreateRectangularBuildings(32, 95, 4, 6, "south", true);
            building20and21.construct();
            treeMap.put("學生九舍", building20and21);
            treeMap.put("學生十舍", building20and21);

            //dormitories cannot be passed
            CreateRectangularBuildings building22and23 = new CreateRectangularBuildings(31, 111, 3, 5, "south east ", true);
            building22and23.construct();
            treeMap.put("學生十一舍", building22and23);
            treeMap.put("研一舍", building22and23);

            CreateRectangularBuildings building24 = new CreateRectangularBuildings(93, 93, 6, 4, " east west", crowded);
            building24.construct();
            treeMap.put("工程四館", building24);

            CreateRectangularBuildings building25 = new CreateRectangularBuildings(123, 126, 5, 3, "east south", crowded);
            building25.construct();
            treeMap.put("管理二館", building25);

            CreateSlantBuildings building26 = new CreateSlantBuildings(100, 167, 4, 6, "northwest,northeast,southwest", crowded);
            building26.construct();
            treeMap.put("毫微米實驗研究室", building26);

            CreatePond pond = new CreatePond(102, 176, 8);
            pond.construct();
            treeMap.put("荷塘", pond);

            //dormitories cannot be passed
            CreateTriangularBuildings building27 = new CreateTriangularBuildings(142, 76, 6, "up", "north", true);
            building27.construct();
            treeMap.put("學生十二舍", building27);

            CreateRectangularBuildings building28 = new CreateRectangularBuildings(49, 91, 4, 5, "north west", crowded);
            building28.construct();
            treeMap.put("科學二館", building28);

            CreateRectangularBuildings building30 = new CreateRectangularBuildings(114, 105, 6, 7, "north south west east", crowded);
            building30.construct();
            treeMap.put("工程五館", building30);

            CreateRectangularBuildings building31 = new CreateRectangularBuildings(137, 109, 6, 8, "north south west east", crowded);
            building31.construct();
            treeMap.put("綜合一館", building31);

            CreateBaseballField baseballField = new CreateBaseballField(138, 85, 13);
            baseballField.construct();
            treeMap.put("棒壘球場", baseballField);

            //dormitories cannot be passed
            CreateRectangularBuildings building32 = new CreateRectangularBuildings(154, 88, 4, 6, "north east west", true);
            building32.construct();
            treeMap.put("學生十三舍", building32);

            //dormitories cannot be passed
            CreateRectangularBuildings building33 = new CreateRectangularBuildings(139, 69, 3, 2, "east", true);
            building33.construct();
            treeMap.put("研二舍", building33);

            CreateRectangularBuildings building34 = new CreateRectangularBuildings(102, 125, 8, 5, "east west", crowded);
            building34.construct();
            treeMap.put("浩然圖書館", building34);

            CreateSlantBuildings building35 = new CreateSlantBuildings(92, 192, 6, 3, "northwest", crowded);
            building35.construct();
            treeMap.put("電子資訊研究大樓", building35);

            CreateRectangularBuildings building36 = new CreateRectangularBuildings(158, 122, 2, 5, "north west", crowded);
            building36.construct();
            treeMap.put("土木結構實驗室", building36);

            //dormitories cannot be passed
            CreateRectangularBuildings building37 = new CreateRectangularBuildings(137, 133, 5, 6, "south west ", true);
            building37.construct();
            treeMap.put("女二舍", building37);

            CreateRectangularBuildings building38 = new CreateRectangularBuildings(165, 121, 3, 7, "north", crowded);
            building38.construct();
            treeMap.put("材料結構實驗室防災中心", building38);

            CreateRectangularBuildings building39 = new CreateRectangularBuildings(111, 79, 4, 7, "north west east ", crowded);
            building39.construct();
            treeMap.put("工程六館", building39);

            CreateSlantBuildings building40 = new CreateSlantBuildings(124, 167, 20, 4, "northwest northeast", crowded);
            building40.construct();
            treeMap.put("國家奈米實驗室", building40);

            CreateRectangularBuildings building42 = new CreateRectangularBuildings(31, 63, 2, 2, "south", crowded);
            building42.construct();
            treeMap.put("綜合球場", building42);

            CreateRectangularBuildings building43 = new CreateRectangularBuildings(24, 83, 2, 5, "west", crowded);
            building43.construct();
            treeMap.put("環保大樓", building43);

            //the sewage treatment plant is filled due to no one would like to pass it
            CreateRectangularBuildings sewageTreatmentPlant = new CreateRectangularBuildings(23, 94, 3, 2, "east", true);
            sewageTreatmentPlant.construct();
            treeMap.put("汙水處理廠", sewageTreatmentPlant);


            CreateRectangularBuildings building45 = new CreateRectangularBuildings(82, 77, 2, 5, "south east", crowded);
            building45.construct();
            treeMap.put("田家炳光電大樓", building45);

            CreateRectangularBuildings building46 = new CreateRectangularBuildings(95, 77, 3, 5, "east west", crowded);
            building46.construct();
            treeMap.put("華映大樓", building46);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

}
