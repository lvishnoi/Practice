package GS;

import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "god"};
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();

        for (String word : words) {
            char[] mWord = word.toCharArray();
            Arrays.sort(mWord);
            String wordSorted = String.valueOf(mWord);

            if (null == hm.get(wordSorted)) {
                hm.put(wordSorted, new ArrayList<>() {{
                    add(word);
                }});
            } else {
                List<String> tmp = hm.get(wordSorted);
                tmp.add(word);
                hm.put(wordSorted, tmp);
            }
        }

        for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
            list.add(entry.getValue());
        }

        System.out.println(list);
    }
}
