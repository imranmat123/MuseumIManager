package csc8011;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
public class MuseumIO {
    private static String CSVfilepath;
    private static Museum museum;
    private static String collum;
    private static Scanner options;
    private static boolean fileLoaded;


    public static void main(String[] args)
    {
        //Asking the user for the name of the Museum.
        System.out.print("Please name the Museum: ");
        Scanner nameOfMuseum = new Scanner(System.in);
        String name = nameOfMuseum.nextLine().trim();
        museum = new Museum(name);
        System.out.println();
        // CSVfilepath, is the location of the CSV file.
        CSVfilepath = "src/csc8011/exhibits.csv";
        fileLoaded = false;
        collum = "";
        userInterface();
    }
    private static void userInterface()
    {
        boolean b = false;
        //This while loop is the mainframe for the User Interface (IU)
        while (!b)
        {
            System.out.print("The name of the museum is: " + museum.getMuseumName() + "\n");
            System.out.println("\nPlease choose from the following options\n");
            System.out.println(" 1. Load a new CSV File \n 2. List of Exhibits from CSV File \n 3. Summary of the museum \n 4. Statistics of the museum \n 5. Change museum name \n 6. Log off");
            System.out.println();
            System.out.print("Please type a value of 1-6: ");
            options = new Scanner(System.in);
            String userOption = null;
            int userOptionInt = 0;
            //ensuring the user is putting in a valid value.
            while (true)
            {
                try
                {
                    userOption = options.nextLine();
                    userOptionInt = Integer.parseInt(userOption);
                    break;
                }
                //asking the user for a valid input
                catch (NumberFormatException e) {
                    System.out.println("Please Input a number between 1-6");
                }
            }
            //The if statement is for the program to only accept valid inputs within the UI.
            if (userOptionInt > 0 && userOptionInt <= 6)
            {
                //The switch is allowing the program to present options to the user, based upon inputs.
                switch (userOptionInt)
                {
                    // case 1 allows the user to load or reload a CSV file.
                    case 1 ->
                    {
                        System.out.println("\nLoading a new CSV File:\n");
                        museum.reset();
                        csvReader();
                        System.out.println("CSV file has been loaded\n");
                        fileLoaded = true;
                        break;
                    }
                    case 2 ->
                    {
                        if (fileLoaded == true)
                        {
                            //listing the Exhibits, the information and using the "Get" method to achieve the result.
                            System.out.println("\nList of Exhibits from CSV File: \n");
                            System.out.println("Exhibit information:");
                            System.out.println("ExhibitID: Description: Year: Value: ");
                            // The for loop is generating the list.
                            for (Exhibit exhibitInformation : museum.getListOfExhibits())
                            {
                                System.out.print("ExhibitID: " + exhibitInformation.getExhibitID());
                                System.out.print(" Description: " + exhibitInformation.getDescription());
                                System.out.print(" Year: " + exhibitInformation.getYear());
                                System.out.print(" Value: £" + exhibitInformation.getValue()+"\n");
                            }
                        }
                        else
                        {
                            System.out.println("Please load the CSVfile");
                        }
                        break;
                    }
                    case 3 ->
                    {
                        if (fileLoaded == true)
                        {
                        //case 3 allows the user to view a summary of the museum, for this to work, the CSV file must be loaded.
                        System.out.println("\nSummery of the museum: \n");
                        System.out.print("Museum name: " + museum.getMuseumName() + "\n");
                        museum.description();
                        System.out.print("Current Exhibits: ");
                        System.out.print("(ExhibitID: Description: Year: Value:)");
                        // The for loop is generating the list.
                            for (Exhibit m : museum.getListOfExhibits())
                            {
                                System.out.print("\n");
                                System.out.print("ExhibitID: " + m.getExhibitID() + " ");
                                System.out.print("Description: " + m.getDescription() + " ");
                                System.out.print("Year: " + m.getYear() + " ");
                                System.out.print("Value: £" + m.getValue() + " ");
                            }
                        }
                        else
                        {
                            System.out.println("Please load the CSVfile");
                        }
                        break;
                    }
                    case 4 ->
                    {
                        if (fileLoaded == true)
                        {
                            // Case 4 is allowing the program to display statistics about the museum using getters and setters.
                            System.out.println("The statistics on highest value, first exhibit acquired and average value of exhibits: \n");
                            System.out.println("Highest value exhibit: " + museum.max().getDescription() + ": £" + museum.max().getValue());
                            System.out.print("First exhibit acquired: " + museum.min().getDescription() + ": (acquired " + museum.min().getYear() + ") \n");
                            System.out.println("The average value of the Exhibits is: £" + museum.average());
                        }
                        else
                        {
                            System.out.println("Please load the CSVfile");
                        }
                        break;
                    }
                    case 5 ->
                    {
                        //case 5 will re-naming the Museum.
                        System.out.print("Please name the Museum: ");
                        Scanner reName = new Scanner(System.in);
                        String newName = reName.nextLine().trim();
                        museum.setMuseumName(newName);
                        break;
                    }
                    case 6 ->
                    {
                        // case 6 ends the loop and thus the program.
                        b = !b;
                        System.out.println("Good Bye!");
                        break;
                    }
                }
            }
            // End of the if statement asking the user to enter a valid input.
            else
            {
                System.out.println("Invalided number or character");
            }
        }
    }
    //this is the CSV reader, and this will take the information from the csv file and put it in to an arrayList via a buffered reader
    private static void csvReader ()
    {
        try
        {
            BufferedReader listOfInformation = new BufferedReader(new FileReader(CSVfilepath));
            listOfInformation.readLine();
            //this wile loop takes the information, splits it by comma and then gives values to the arrayList.
            while ((collum = listOfInformation.readLine()) != null) {
                String[] values = collum.split("");
                Exhibit exhibit1 = new Exhibit(values[0], values[1], parseInt(values[2]), parseDouble(values[3]));
                museum.addInToArrayList(exhibit1);
            }

        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}









