package csc8011;
import java.util.ArrayList;
public class Museum
{
    private String museumName;
    private ArrayList<Exhibit> listOfExhibits = new ArrayList<>();

    //Creates a name for the museum, and allows that name to use used within different parts of the code.
    public Museum (String museumName)
    {
        this.museumName = museumName;
    }
    //description method, when called upon it will print the name of the museum along with a hardcoded description of the museum.
    public String description()
    {
        String description = ("The " + this.museumName + " Was");
        return description;
    }
    //adds input in to the arrayList.
    public void addInToArrayList (Exhibit exhibit1)
    {
        System.out.println(exhibit1);
        listOfExhibits.add(exhibit1);
    }
    //allows the user to view the averages of the exhibits via the arrayList (used for viewing the average value)
    public double average ()
    {
        double average = 0;
        for (Exhibit temp:listOfExhibits)
        {
            average = average + temp.getValue();
        }
        average = average / listOfExhibits.size();
        return average;
    }
    //Getting the minimum value of the arrayList (used for viewing the First exhibit acquired)
    public Exhibit min ()
    {
        Exhibit minExhibit = null;
        int min = Integer.MAX_VALUE;
        for (Exhibit temp:listOfExhibits)
        {
            if (temp.getYear() < min)
            {
                min = temp.getYear();
                minExhibit = temp;
            }
        }
        return minExhibit;
    }
    //allow for the max value of the arrayList (used for viewing the Highest value exhibit)
    public Exhibit max ()
    {
        Exhibit maxExhibit = null;
        double max = Integer.MIN_VALUE;
        for (Exhibit temp:listOfExhibits)
        {
            if (temp.getValue() > max)
            {
                max = temp.getValue();
                maxExhibit = temp;
            }
        }
        return maxExhibit;
    }
    // resets the ArrayList
    public void reset ()
    {
        listOfExhibits.removeAll(listOfExhibits);
    }
    //returns the name of the museum
    public String getMuseumName() {
        return museumName;
    }
    //sets the name of the museum
    public void setMuseumName(String museumName) {
        this.museumName = museumName;
    }
    //returns the value of the ArrayList
    public ArrayList<Exhibit> getListOfExhibits() {
        return listOfExhibits;
    }
    // Sets/adds values in the arrayList if needed
    public void setListOfExhibits(ArrayList<Exhibit> listOfExhibits) {
        this.listOfExhibits = listOfExhibits;
    }
}

