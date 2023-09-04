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


    public static void toCSVDataRecord(Path filePath, ArrayList<String> records) {
        // Method that writes records from ArrayList to CSV file

        // IMPORTANT: Gets current working directory and specifies file to write to
        // Best to put outside this method
        /*
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\TestData.txt");
       */

        // IMPORTANT: 'StringBuilder'; modify as needed to store object records in Array as CSV writeable string
        /*
        for (Object obj : records) {
        String record = String.format("%s, %s, %s, %s", obj.getID(), obj.getName(), obj.getDescription(), obj.getProperty());
        records.add(record);
        */

        try
        {
            // Typical java pattern of inherited classes
            // Wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(filePath, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Writes the file for each line in the array
            for(String rec : records)
            {
                // Syntax for write rec:
                // 0 is where to start write (1st char)
                // rec. length() is how many chars to write (all)
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }

            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("\n" + "Data file written!");

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}



