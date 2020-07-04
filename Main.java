import java.util.*;


public class Main extends BasicMapManipulation {


    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("The file path is set as empty, please enter file path!");
        }
        SchoolMap schoolMap = new SchoolMap();

        TreeMap<String, BasicDrawings> treeMap = schoolMap.getTreeMap();


        Scanner scanner = new Scanner(System.in);
        // get the map and hashtable in school map


        //set the crowded parameter
        System.out.println("This is the School Road Guiding System!");
        System.out.println("Build by 徐子瀚");
        System.out.println();
        System.out.println("Your file path is set as: "+args[0]);
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println();
        System.out.println("STAGE 1 :Please set whether the school is crowded");
        System.out.println("A crowded school will imitate a crowded indoor, which encourages you to walk outdoor");
        System.out.println();
        System.out.println("Press (1) if is crowded, (2) if is not.");
        int crowdedornot = Integer.parseInt(scanner.nextLine());

        if (crowdedornot == 1) {
            System.out.println("Please enter the density of people in the campus (1-10)");
            SchoolMap.crowded=true;
            SchoolMap.constructschool();

            int densityindex = Integer.parseInt(scanner.nextLine());
            SchoolMap.drawrandomblocks(40, 50, 120, 120, densityindex * 10);
            System.out.println("Your setting is: " + "corwded" + " with the density of " + densityindex);
        } else {
            System.out.println("Your setting is: " + "not crowded");
            SchoolMap.crowded =false;
            SchoolMap.constructschool();
        }


        //adjust the map or look at it
        System.out.println("-------------------------------------------------");
        System.out.println();
        System.out.println("STAGE 2 :Make adjustments to the map");
        boolean adjustflag = true;
        String adjuststring = "";
        while (adjustflag) {

            System.out.println("Press (1) to look at the map");
            System.out.println("Press (2) to rotate the map to right");
            System.out.println("Press (3) to rotate the map to left");
            System.out.println("Press (4) to flip the map");
            System.out.println("Press (5) to exit adjusting stage");

            adjuststring = scanner.nextLine();

            switch (Integer.parseInt(adjuststring)) {
                case 1:
                    printMap();
                    break;
                case 2:
                    rotateMapRight();
                    break;
                case 3:
                    rotateMapLeft();
                    break;
                case 4:
                    flipMap();
                    break;
                case 5:
                    adjustflag = false;
                    System.out.println("You have left the adjusting stage");
                    ;
                    break;
                default:
                    throw new RuntimeException("Pleas enter a valid instruction");

            }
        }


        //set original position and destination
        System.out.println("-------------------------------------------------");
        System.out.println();
        System.out.println("STAGE 3 :Set Current Location and Destination");
        System.out.println();
        System.out.println("All constructions in NCTU are as above: ");
        System.out.println();
        int serialNumber = 0;
        for (String string : treeMap.keySet()) {
            System.out.printf("(%02d) %-30s\t", ++serialNumber, string);
            if (serialNumber % 4 == 0) {
                System.out.print("\n");
            }

        }

        int currentLocation = -1;
        int destination = -1;
        int[] relaypoints = new int[0];


        while (!treeMap.containsKey(stringconvertion(currentLocation))) {
            System.out.println();
            System.out.println("Please enter Your current Location (with number)");
            currentLocation = Integer.parseInt(scanner.nextLine());
            if (!treeMap.containsKey(stringconvertion(currentLocation))) {
                System.out.println("Please enter a valid Location in the Map to set up current location!");
            } else {
                System.out.println("You have set your current Location at: " + stringconvertion(currentLocation));
            }

        }

        while (!treeMap.containsKey(stringconvertion(destination))) {
            System.out.println();
            System.out.println("Please enter Your destination (with number)");

            destination = Integer.parseInt(scanner.nextLine());
            if (!treeMap.containsKey(stringconvertion(destination))) {
                System.out.println("Please enter a valid Location in the Map to set up destination!");
            } else if (currentLocation == (destination)) {
                System.out.println("You are already at the spot!! Enter another destination");
                destination = -1;
            } else {
                System.out.println("You have set your destination at:" + stringconvertion(destination));
            }
        }
        System.out.println("Current Location and Destination successfully set!");
        System.out.println("Press (1) to set relays     (2) to exit the stage");
        int relayans = Integer.parseInt(scanner.nextLine());
        if (relayans == 2) {
            relaypoints = new int[0];
            System.out.println("You did not set any relay and has exit the relay setting stage!");

        } else {
            boolean flag = true;
            while (flag) {
                System.out.println("Please enter relay points and with space between (e.g.) 2 45 33");
                String[] relaypointsstringarr = scanner.nextLine().split("\\s+");
                relaypoints = new int[relaypointsstringarr.length];
                for (int i = 0; i < relaypointsstringarr.length; i++) {
                    relaypoints[i] = Integer.parseInt(relaypointsstringarr[i]);
                }
                //check if there is repeated  or invalid points;
                boolean validpoints = true;
                HashSet<Integer> set = new HashSet<>();
                for (int integer : relaypoints) {
                    set.add(integer);
                    if (integer <= 0 || integer >= 55) {
                        validpoints = false;
                    }
                }
                set.add(currentLocation);
                set.add(destination);

                if (set.size() != relaypoints.length + 2 || !validpoints) {
                    System.out.println("You have set repeated or invalid points!");

                } else {
                    flag = false;
                }
            }
        }





        int[] routearray = routeplanner(currentLocation, destination, relaypoints, treeMap);

        //set up the A* algorithm
        AStarAlgorithm aStarAlgorithm = new AStarAlgorithm();
        for (int i = 0; i < routearray.length - 1; i++) {
            aStarAlgorithm.executesearch(getMap(), treeMap.get(stringconvertion(routearray[i])).x, treeMap.get(stringconvertion(routearray[i])).y
                    , treeMap.get(stringconvertion(routearray[i+1])).x, treeMap.get(stringconvertion(routearray[i+1])).y);
        }
        for (int i = 0; i < routearray.length ; i++) {
            setMapValue(treeMap.get(stringconvertion(routearray[i])).x, treeMap.get(stringconvertion(routearray[i])).y,10+i+1);

        }
        System.out.println();
        System.out.println("The route is successfully set as:");
        System.out.println();
        System.out.print("(start)=> ");

        for (int i = 0; i < routearray.length-1 ; i++) {

            System.out.print(stringconvertion(routearray[i])+"--");

        }
        System.out.print(stringconvertion(routearray[routearray.length-1]));
        System.out.print(" (ends))");

        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println();
        System.out.println("STAGE 4 :Output Stage");


        boolean outputflag = false;
        int outputDecision = -1;

        while (!outputflag) {
            System.out.println("Press (1) to look at the map");
            System.out.println("Press (2) to write the map to file");
            System.out.println("Press (3) to  do both");
            outputDecision = Integer.parseInt(scanner.nextLine());
            if (outputDecision == 1) {

                printMap();
                outputflag = true;

            } else if (outputDecision == 2) {
                WriteToFile writeToFile = new WriteToFile();
                writeToFile.toFile(args[0], getMap(), '#', ' ', '@');
                outputflag = true;
            } else if (outputDecision == 3) {
                WriteToFile writeToFile = new WriteToFile();
                writeToFile.toFile(args[0], getMap(), '#', ' ', '@');
                printMap();
                outputflag = true;
            } else {
                System.out.println("Please enter a valid instruction");
            }

        }

    }

    public static int[] routeplanner(int currentLocation, int destination, int[] arr, TreeMap<String, BasicDrawings> treeMap) {
        if (arr.length == 0) {
            int[] returnarray = new int[2];
            returnarray[0] = currentLocation;
            returnarray[1] = destination;

            return returnarray;
        }
        if (arr.length == 1) {
            int[] returnarray = new int[3];
            returnarray[0] = currentLocation;
            returnarray[1] = arr[0];
            returnarray[2] = destination;

            return returnarray;
        }
        int targerlocation = currentLocation;
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> orderedlist = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        while (arrayList.size() != 1) {
            int bestfit = arrayList.get(0);
            int bestfitx = Math.abs(treeMap.get(stringconvertion(targerlocation)).x - treeMap.get(stringconvertion(bestfit)).x);
            int bestfity = Math.abs(treeMap.get(stringconvertion(targerlocation)).y - treeMap.get(stringconvertion(bestfit)).y);
            for (int index=0;index<arrayList.size();index++) {
                int distancex = Math.abs(treeMap.get(stringconvertion(targerlocation)).x - treeMap.get(stringconvertion(arrayList.get(index))).x);
                int distancey = Math.abs(treeMap.get(stringconvertion(targerlocation)).y - treeMap.get(stringconvertion(arrayList.get(index))).y);
                if (bestfitx * bestfity > distancex * distancey) {
                    bestfit = arrayList.get(index);
                }
            }
            orderedlist.add(bestfit);
            arrayList.remove(arrayList.indexOf(bestfit));
            targerlocation = bestfit;

        }
        int[] returnarray = new int[arr.length + 2];
        returnarray[0] = currentLocation;
        returnarray[returnarray.length - 1] = destination;
        returnarray[returnarray.length - 2] = arrayList.get(0);
        for (int i = 0; i < orderedlist.size(); i++) {
            returnarray[1 + i] = orderedlist.get(i);
        }

        return returnarray;

    }

    public static String stringconvertion(int i) {

        switch (i) {
            case 1:
                return "中正堂";
            case 2:
                return "人社一館";
            case 3:
                return "人社二館";
            case 4:
                return "國家奈米實驗室";
            case 5:
                return "土木結構實驗室";
            case 6:
                return "壘球場";
            case 7:
                return "女二舍";
            case 8:
                return "學生七舍";
            case 9:
                return "學生九舍";
            case 10:
                return "學生八舍";
            case 11:
                return "學生十一舍";
            case 12:
                return "學生十三舍";
            case 13:
                return "學生十二舍";
            case 14:
                return "學生十舍";
            case 15:
                return "學生活動中心";
            case 16:
                return "工程一館";
            case 17:
                return "工程三館";
            case 18:
                return "工程二館";
            case 19:
                return "工程五館";
            case 20:
                return "工程六館";
            case 21:
                return "工程四館";
            case 22:
                return "材料結構實驗室防災中心";
            case 23:
                return "棒壘球場";
            case 24:
                return "毫微米實驗研究室";
            case 25:
                return "汙水處理廠";
            case 26:
                return "浩然圖書館";
            case 27:
                return "游泳池";
            case 28:
                return "環保大樓";
            case 29:
                return "田家炳光電大樓";
            case 30:
                return "田徑場";
            case 31:
                return "研一舍";
            case 32:
                return "研二舍";
            case 33:
                return "科學一館";
            case 34:
                return "科學二館";
            case 35:
                return "竹軒";
            case 36:
                return "第一餐廳";
            case 37:
                return "第二餐廳";
            case 38:
                return "管理一館";
            case 39:
                return "管理二館";
            case 40:
                return "籃球場一";
            case 41:
                return "籃球場三";
            case 42:
                return "籃球場二";
            case 43:
                return "籃球場四";
            case 44:
                return "綜合一館";
            case 45:
                return "綜合球場";
            case 46:
                return "網球場一";
            case 47:
                return "網球場二";
            case 48:
                return "羽球場";
            case 49:
                return "荷塘";
            case 50:
                return "華映大樓";
            case 51:
                return "行政大樓";
            case 52:
                return "資訊館";
            case 53:
                return "電子資訊研究大樓";
            case 54:
                return "體育館";
            default:
                return "";

        }
    }


}

