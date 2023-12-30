import java.time.*;
import java.util.*;
import java.util.regex.*;

public class Date212{
    private int year, month, day;

    public Date212(String dateString){
        String date212Pattern = "^\\d{8}$";
        Pattern p = Pattern.compile(date212Pattern);
        Matcher m = p.matcher(dateString);
        if(!m.matches()) throw new IllegalDate212Exception("Invalid date format: " + dateString);
        else{
            year = Integer.parseInt(dateString.substring(0, 4));
            month = Integer.parseInt(dateString.substring(4, 6));
            day = Integer.parseInt(dateString.substring(6, 8));
            //parses input string and initializes year, month, and day
        } //if-else block ensures that the IllegalDate212Exception is thrown if the date is invalid (i.e. not having 8 characters which are all digits) and otherwise constructs the date as normal
    } //constructor

    private boolean isValidDate(){
        if (this.month == 2){
            int tempFebDay = 28;
            if (Year.isLeap(this.year)) tempFebDay = 29;
            if (this.day < 1 || this.day > tempFebDay) return false;
        } //checks for leap years, and depending on results alters February's range of days

        if (this.month < 1 || this.month > 12) return false; //checks if the month is valid

        int tempDay = 30;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) tempDay = 31;
        if (this.day < 1 || this.day > tempDay) return false;
        //checks if the day is valid

        else return true;
    } //private method that checks if month and day are valid

    public boolean isValid(){
        return (this.isValidDate());
    } //public-facing method that allows the user to call the validity checking method indirectly

    public int compareTo(Date212 other){
        if (this.year > other.year) return 1;
        else if (this.year < other.year) return -1;
        //checks whether the "other" date's year or the year of the date calling this method is larger; if "other" is larger, returns -1 / if calling date is larger, returns 1 / else, enter The Nested If Statements (Hell)
        else{
            if (this.month > other.month) return 1;
            else if (this.month < other.month) return -1;
            //same as above except compares the month, if neither works then jump down to the Third Circle
            else{
                if (this.day > other.day) return 1;
                else if (this.day < other.day) return -1;
                //same as above except it compares the day, if neither works then ascend back to the surface
            }
        }
        return 0; //at this point, the dates MUST be equal and thus return 0
    } //method that implements compareTo method for sorting

    public String toString(){
        return (month + "/" + day + "/" + year);
    } //method that returns the date in the form mm/dd/yyyy

    public static Comparator<Date212> dateComparator = new Comparator<Date212>(){
        public int compare(Date212 d1, Date212 d2){
            return d1.compareTo(d2);
        }
    }; //static Comparator that implements compareTo method for sorting
} //class Date212