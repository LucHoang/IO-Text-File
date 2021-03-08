import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void copyFileText(String sourceFile, String targetFile) {
        try {
            File file = new File(sourceFile);

            if(!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            FileWriter fileWriter = new FileWriter(targetFile);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                fileWriter.write(line+"\n");
            }
            bufferedReader.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhap duong dan source file: ");
        Scanner input = new Scanner(System.in);
        String sourcePath = input.nextLine();

        System.out.println("Nhap duong dan target file: ");
        String targetFile = input.nextLine();

        copyFileText(sourcePath, targetFile);
    }
}
