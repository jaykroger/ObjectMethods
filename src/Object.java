import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;

// Modify object attributes as needed in actual scenario
public class Object {
    private String ID;
    private String name;
    private String description;
    private String property;

    public Object(String ID, String name, String description, String property) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.property = property;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }


    public static void toCSVDataRecord(Object obj) {
        // Method that writes records from ArrayList to CSV file

        // Gets current working directory and specifies file to write to
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\TestData.txt");

        // Initializes ArrayList to temporarily store object data
        ArrayList<String>Array = new ArrayList<>();

        // Modify as needed to store object attributes as writeable string
        String record = (obj.getID() + ", " + obj.getName() + ", " + obj.getDescription() + ", " + obj.getProperty());
        Array.add(record);

        try
        {
            // Typical java pattern of inherited classes
            // Wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Writes the file for each line in the array
            for(String rec : Array)
            {
                writer.write(rec, 0, rec.length());  // syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds new line
            }

            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("\n" + "Data file written!");

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}



