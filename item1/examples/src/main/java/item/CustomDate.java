package item;

import java.time.LocalDate;

public class CustomDate {
    public String day;
    public String month;
    public String year;

    private CustomDate() {

    }

    public static CustomDate today() {
        LocalDate localDate = LocalDate.now ();
        return setDate(localDate);
    }

    public static CustomDate tomorrow() {
        LocalDate localDate = LocalDate.now ().plusDays (1);
        return setDate(localDate);
    }

    public static CustomDate yesterday() {
        LocalDate localDate = LocalDate.now ().minusDays (1);
        return setDate(localDate);
    }

    /*
     * Not validating the values for day, month, year over here
     *
     */
    public static CustomDate getInstance(String day, String month, String year) {
        CustomDate customDate = new CustomDate ();
        customDate.day = day;
        customDate.month = month;
        customDate.year = year;

        return customDate;
    }

    public static CustomDate setDate(LocalDate localDate) {
        CustomDate customDate = new CustomDate ();
        customDate.day = Integer.toString (localDate.getDayOfMonth ());
        customDate.month = Integer.toString (localDate.getMonth ().getValue ());
        customDate.year = Integer.toString (localDate.getYear ());
        return  customDate;
    }

    @Override
    public String toString() {
        return "CustomDate{" +
                "day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
