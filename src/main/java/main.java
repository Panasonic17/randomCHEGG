import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class main {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (String s : args) {
            builder.append(s + " ");
        }
        String str = builder.toString();
        String inputParams[] = str.split("-");
        Map<String, String> params = new HashMap();
        for (int i = 0; i < inputParams.length; i++) {
            String keyValue[] = inputParams[i].split(" ");
            if (keyValue.length == 2)
                params.put(keyValue[0], keyValue[1]);
            else {
                if (keyValue.length == 1) continue;

                String value = "";
                for (int j = 1; j < keyValue.length; j++) {
                    value += keyValue[j] + " ";
                }
                params.put(keyValue[0], value);
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
        Date startDate = null;
        Date endDate = null;
        int n = 0;
        String template = null;
        String path = null;
        try {
            startDate = sdf.parse(params.get("s"));
            endDate = sdf.parse(params.get("f"));
            n = Integer.parseInt(params.get("n"));
            template = params.get("t");
            path = params.get("p");
        } catch (NullPointerException e) {
            System.err.println("missing input parameter should be [-t \"time  action  qweuserID [sesionID]\" -n 1000  -s 2014:11:11  -f 2014:11:12 -p \"text.txt\" ] ");
        } catch (ParseException e) {
            System.err.println("wrong data format  example[ -s 2014:11:11  -f 2014:11:12] s-start time f-end time");
        }

        Generator g = new Generator(n, startDate.getTime(), endDate.getTime(), template);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i = 1; i < n; i++) {

                bw.write(g.generate() + "\n");
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
