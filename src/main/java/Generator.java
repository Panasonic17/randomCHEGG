import java.text.SimpleDateFormat;
import java.util.*;

public class Generator {
    int logCount;
    int maxClients = 15;
    long startTime;
    long endTime;
    String template;
    Random r = new Random();

    ArrayList<Long> times = new ArrayList<>();

    public Generator(int logCount, long startTime, long endTime, String template) {
        this.logCount = logCount;
        this.startTime = startTime;
        this.endTime = endTime;
        this.template = template;
        TimeGenerator timeGenerator = new TimeGenerator(startTime, endTime, logCount);
        times = timeGenerator.getTimes();

    }

    int logNumber = 0;
    int clientNumber = 0;
    ArrayList<Client> clients = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("[dd/MM/yyyy:HH:mm:ss Z]");

    public String generate() {
        if (clients.size() == 0) {
            for (int i = 0; i < 3; i++) {
                Client client = new Client(false, 10);
                clients.add(client);
                clientNumber++;
            }
        }
        if (clients.size() <maxClients)
            if (Math.random() > 0.9) {
                Client client = new Client(false, 10);
                clients.add(client);
                clientNumber++;
            }

        Client c = clients.get(r.nextInt(clients.size()));
        Map<String, String> logData = c.doThmth();

        if (logData.get("action").equals("logout")) {
            clients.remove(c);
        }
        logNumber++;
        String date = sdf.format(times.get(logNumber));
        logData.put("time", date + "");
        return logDataToLog(logData);
    }

    String logDataToLog(Map<String, String> data) {
        String ret = template;
        for (Map.Entry<String, String> entry : data.entrySet()) {
            ret = ret.replace(entry.getKey(), entry.getValue());
        }

        return ret;
    }

}
