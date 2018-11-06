package item1;

import item.CustomDate;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class CustomDateTest {

    @Test
    public void todayTest() {
        LocalDate localDate = LocalDate.now ();
        CustomDate today = CustomDate.today ();
        Assert.assertEquals (today.day, Integer.toString (localDate.getDayOfMonth ()));
        Assert.assertEquals (today.month, Integer.toString (localDate.getMonthValue ()));
        Assert.assertEquals (today.year, Integer.toString (localDate.getYear ()));
    }

    @Test
    public void tomorrowTest() {
        LocalDate localDate = LocalDate.now ().plusDays (1);
        CustomDate today = CustomDate.tomorrow ();
        Assert.assertEquals (today.day, Integer.toString (localDate.getDayOfMonth ()));
        Assert.assertEquals (today.month, Integer.toString (localDate.getMonthValue ()));
        Assert.assertEquals (today.year, Integer.toString (localDate.getYear ()));
    }

    @Test
    public void yesterdayTest() {
        LocalDate localDate = LocalDate.now ().minusDays (1);
        CustomDate today = CustomDate.yesterday ();
        Assert.assertEquals (today.day, Integer.toString (localDate.getDayOfMonth ()));
        Assert.assertEquals (today.month, Integer.toString (localDate.getMonthValue ()));
        Assert.assertEquals (today.year, Integer.toString (localDate.getYear ()));
    }
}
