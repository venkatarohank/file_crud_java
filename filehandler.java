import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;
public class Main {

    // Creating a file
    public static void createFile(File file) throws IOException {
        if (file.createNewFile()) {

            System.out.println("File " + file.getName() + " is created successfully.");

        } else {
            System.out.println("File is already exists");
        }
    }

    // deleting a file
    public static void deleteFile(File file) {

        if (file.delete()) {

            System.out.println(file.getName() + " file is deleted successfully.");

        } else {

            System.out.println("Error Occurred");

        }
    }

    // updating a file
    public static void updateFile(String file,String updateText) throws IOException
    {
        try {

            FileWriter fwrite = new FileWriter(file,true);

            fwrite.write(updateText);

            fwrite.close();

            System.out.println("Content is successfully wrote to the file.");

        } catch (IOException e) {

            System.out.println("Exception Occurred");

        }
    }
    //replaces old line with new one
    //update a line
    public static void updateLineFile(String filename,int ind,String updateText) throws IOException {

        File file = new File("./sample.txt");

        Scanner dataReader = new Scanner(file);

        ArrayList<String> contents=new ArrayList<>();

        while (dataReader.hasNextLine()) {
            contents.add(dataReader.nextLine());
        }
        System.out.println(contents);
        if(ind<contents.size())
        {
            contents.set(ind,updateText);
            StringBuilder str=new StringBuilder();
            for(String i:contents)
            {
                str.append(i+"\n");
            }
            FileWriter fwrite = new FileWriter(filename);
            fwrite.write(String.valueOf(str));

            fwrite.close();
        }
        else{
            System.out.println("index out of range");
        }

    }

    //read the whole file
    public static Scanner readFile(File file) throws FileNotFoundException {
        Scanner dataReader = new Scanner(file);

        while (dataReader.hasNextLine()) {

            String fileData = dataReader.nextLine();

            System.out.println(fileData);

        }

        return dataReader;
    }

    public static void main(String[] args) {
        try {

                File file = new File("./sample.txt");

                //createFile(file);

                Scanner dataReader = readFile(file);
                dataReader.close();

               // updateFile("./sample.txt", "test");
                updateLineFile("./sample.txt",3,"");
                //deleteFile(file);


        } catch (IOException exception) {

            System.out.println("Exception Occurred");

        }
        System.out.println("Hello world!");
    }
}
