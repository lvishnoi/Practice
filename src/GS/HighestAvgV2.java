package GS;

import java.util.HashMap;
import java.util.Map;

public class HighestAvgV2 {
    public static void main(String[] args) {
        String[][] file= { {"Shrikanth", "20", "30" ,"10"}, {"Ram" ,"100", "50", "10"}};
        HashMap<String, Double> hm = new HashMap<>();

        for (String[] strings : file) {
            int length = strings.length - 1;
            int sum = 0;

            for (int j = 1; j <= length; j++) {
                sum += Integer.parseInt(strings[j]);
            }
            hm.put(strings[0], (double) (sum / length));
        }

        double maxAvg = Double.MIN_VALUE;
        String name  = "";

        for (Map.Entry<String, Double> entry : hm.entrySet()) {
            if (maxAvg < entry.getValue()) {
                maxAvg = entry.getValue();
                name = entry.getKey();
            }
        }

        System.out.println(name + " " + maxAvg);
    }
}
