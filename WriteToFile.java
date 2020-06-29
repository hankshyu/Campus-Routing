import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void toFile(String filePath, int[][] arr,char obstacleRepresentation ,char emptySpaceRepresentation ,char pathRepresentation  ) {

        String writetofilestring = "";
        System.out.println("Writing procedure executing...");


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    writetofilestring += emptySpaceRepresentation;
                } else if (arr[i][j] == 1) {
                    writetofilestring+=obstacleRepresentation;
                } else if (arr[i][j] == 7) {
                    writetofilestring += pathRepresentation;
                } else {
                    writetofilestring += (arr[i][j]-10);
                }

            }
            writetofilestring += "\n";
            System.out.printf("Executing\t%.2f\tpercent\n", i * 100 / (float) arr.length);

        }
        File file = new File(filePath);
        try {
            file.createNewFile();
            // creates a FileWriter Object
            FileWriter writer = new FileWriter(file);
            // Writes the content to the file
            writer.write(writetofilestring);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Printing procedure finished, file at " + filePath);

    }
//
//    public static void main(String[] args) {
//        int[][] arr = new int[10][200];
//        toFile("C:\\TEMP\\Hank.txt", arr,' ',' ',' ');
//    }

}