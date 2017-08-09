import java.util.*;


public class TimeGenerator {
    long startMs;
    long endMs;
    int count;
    Random r = new Random();

    public TimeGenerator(long startMs, long endMs, int count) {
        this.startMs = startMs;
        this.endMs = endMs;
        this.count = count;
    }

    public ArrayList<Long> getTimes() {
        ArrayList<Long> longs = new ArrayList<>();
        LinkedList<Long> newTimes = new LinkedList();
        for (int i = 0; i < count * 10; i++) {
            longs.add(randomBetween());
        }
        int i = 0;
        int size = count * 10;
        int all = 0;
        double dilnyk = 10 * 60 * 1000 * 60;
        while (true) {
            if (all == count) break;
            if (i >= size) {
                i = 0;
            }
            Double test = r.nextDouble() + 0.2;
            Long minest = longs.get(i) % (1000 * 60 * 24 * 60);
            Double q1 = Double.valueOf((Math.abs(minest - dilnyk)) / (dilnyk)); //posible to do les math (почленно розділити)
            if (test > q1) {
                newTimes.add(longs.get(i));
                all++;
            }
            i++;
        }
        Collections.sort(newTimes);
        return new ArrayList<>(newTimes);
    }

    private long randomBetween() {
        long resvult = (endMs - (long) (Math.random() * (endMs - startMs)));

        return resvult;
    }
}
