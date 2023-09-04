public class Main {
    public static void main(String[] args) {

        // This is just a small test case I created to test that the object writing methods work

        // Variable initialization for testing, would likely be input-based in actual scenario
        String ID = "000001";
        String name = "Ryan Gosling";
        String description = "He is Kenough";
        String property = "10";

        // Creation of new object and writing to CSV file
        Object ryan = new Object(ID, name, description, property);
        Object.toCSVDataRecord(ryan);
    }
}