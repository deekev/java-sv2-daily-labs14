package day04;

import java.util.HashMap;
import java.util.Map;

public class PairFinder {

    public int findPairs(int[] arr) {
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int i: arr) {
            if (!pairs.containsKey(i)) {
                pairs.put(i, 1);
            } else {
                pairs.put(i, pairs.get(i) + 1);
            }
        }
        int count = 0;
        for (int j: pairs.values()) {
            count += j / 2;
        }
        return count;
    }
}
