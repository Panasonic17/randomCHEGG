package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sawa on 09.08.17.
 */
public class Verhina {
    String action;
    public ArrayList<Verhina> branches=new ArrayList<>();
    List<String> next=new ArrayList<>();

    public Verhina(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Verhina{" +
                "action='" + action + '\'' +
                '}';
    }
}
