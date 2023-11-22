package GS;

import java.util.HashMap;
import java.util.Map;

public class HighestAvgV1 {
    public static void main(String[] args) {
        String[] marks = new String[]{"Name1 , 90", "Name2 , 85","Name1 , 20"};
        HashMap<String, Double> hm = new HashMap<>();

        for (String s : marks) {
            String[] mark = s.split(" , ");
            if (null == hm.get(mark[0])) {
                hm.put(mark[0], Double.parseDouble(mark[1]));
            } else {
                double avg = (hm.get(mark[0]) + Double.parseDouble(mark[1])) / 2;
                hm.put(mark[0], avg);
            }
        }

        double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> entry : hm.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        System.out.println("Highest average is: " + max);
    }
}
