package csc8011;

// Exhibit class allows the program to objectify the CSV file.
public class Exhibit
{
//private variables allowing for security, less confusion and manipulation of the array via getters and setters
    private String exhibitID;
    private String description;
    private int year;
    private double value;

    public Exhibit (String exhibit, String description, int year, double value)
    {
        this.exhibitID = exhibit;
        this.description = description;
        this.year = year;
        this.value = value;
    }
    public String toString()
    {
        return "ExhibitID: " + getExhibitID() +" " + "Description: " + getDescription() +" " + "Year: " + getYear() +" " + "Value: £" + this.getValue() +"\n";
    }
    public String getExhibitID() {
        return exhibitID;
    }

    public void setExhibitID(String exhibitID) {
        this.exhibitID = exhibitID;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
