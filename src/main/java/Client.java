import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Client {
    boolean logged;
    String user;
    Random r = new Random();
    String sesionId;
    int logsLeft;
    static ArrayList<String> actionList = new ArrayList<>();

    {
        for (int i = 0; i < 20; i++) {
            actionList.add("action № " + i);
        }
    }

    public Client(boolean logged, int logsLeft) {
        this.logged = logged;
        this.user = "name" + (int) (Math.random() * 1000);
        this.sesionId = "" + r.nextInt(1000);
        this.logsLeft = logsLeft;
    }

    private Map<String, String> login() {
        logged = true;
        Map<String, String> logData = new HashMap<>();
        logData.put("userId", user);
        logData.put("action", "login");
        logData.put("sesionID", sesionId);
        logsLeft--;
        return logData;
    }

    private Map<String, String> logout() {
        Map<String, String> logData = new HashMap<>();
        logData.put("userId", user);
        logData.put("action", "logout");
        logData.put("sesionID", sesionId);
        return logData;
    }

    public Map<String, String> doThmth() {
        if (!logged) {
            return login();
        }
        if (logsLeft == 1) {
            return logout();
        }
        Map<String, String> logData = new HashMap<>();
        logData.put("userId", user);
        logData.put("action", createAction());
        logData.put("sesionID", sesionId);
        logsLeft--;
        return logData;
    }

    public String createAction() {

        return actionList.get((int) (Math.random() * actionList.size()));
    }

    @Override
    public String toString() {
        return "Client{" +
                "logged=" + logged +
                ", user='" + user + '\'' +
                ", sesionId='" + sesionId + '\'' +
                ", logsLeft=" + logsLeft +
                '}';
    }
}


