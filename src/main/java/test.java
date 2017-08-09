import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sawa on 09.08.17.
 */
public class test {
    public static void main(String[] args) {
        String d="2017:03:07";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
        try {
            Date d1=sdf.parse(d);
            System.out.println(d1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
