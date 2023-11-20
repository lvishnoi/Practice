package GS;

import java.util.*;
import java.util.stream.Collectors;

// Given an array of strings. Each string has an IP address and the user mentioned. Find out the maximum accessed IP address
public class MaxAccessedIP {
    public static void main(String[] args) {
        String[] ipAdd = new String[]{"10.1.1.1 - james" ,"10.1.1.1 - frank" ,"10.1.1.2 - sam"};
        Map<String, Integer> hm = new HashMap<>();

        for (String s : ipAdd) {
            String[] tokens = s.split("-");
            int count = 0;

            if (null == hm.get(tokens[0].trim())) {
                hm.put(tokens[0].trim(), 1);
            } else {
                count = hm.get(tokens[0].trim()) + 1;
                hm.put(tokens[0].trim(), count);
            }
        }

        HashMap<String, Integer> hmRevSorted = MaxAccessedIP.sortByValue(hm);

        for (Map.Entry<String, Integer> entry : hmRevSorted.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            break;
        }

    }

    // function to sort hashmap by values
    public static HashMap<String, Integer> sortByValue(Map<String, Integer> map) {

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}
