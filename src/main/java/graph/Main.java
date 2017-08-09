package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by sawa on 09.08.17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> graf = new ArrayList<>();
        ArrayList<Verhina> normGraf = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("grafTest.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                graf.add(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        for (String s : graf) {
            System.out.println(s);
        }


        ArrayList<Integer> vershiny = new ArrayList<>();
        for (int i = 0; i < graf.size(); i++) {
            if (!graf.get(i).contains("*")) {
                System.out.println(i);
                vershiny.add(i);
            }
        }
        for (int i = 0; i < vershiny.size(); i++) {

            Verhina v = new Verhina(graf.get(vershiny.get(i)));
            System.out.println("Vershina "+v);
            int last;
            if (i + 1 < vershiny.size()) {
                last = vershiny.get(i + 1);
            } else {
                last = graf.size();
            }
//            System.out.println("last =" + last);

            v.next = graf.subList(vershiny.get(i)+1, last);
            for (String s : v.next) {
                System.out.println(s);
            }
            normGraf.add(new Verhina(graf.get(i).replaceFirst("-","")));
        }

    }
    public void genGraf
}
