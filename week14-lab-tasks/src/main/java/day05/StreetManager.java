package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StreetManager {

    public Map<String, List<Integer>> readLines(Path path) {
        Map<String, List<Integer>> result = new HashMap<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                fillMapFromLines(result, line);
            }
            transformValues(result);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file.");
        }
        return result;
    }

    private void fillMapFromLines(Map<String, List<Integer>> map, String line) {
        String[] temp = line.split(" ");
        String key = temp[0];
        int value = Integer.parseInt(temp[1]);
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }

    private void transformValues(Map<String, List<Integer>> map) {
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<Integer> value = entry.getValue();
            List<Integer> houseNumbers = getHouseNumbers(value);
            map.put(key, houseNumbers);
        }
    }

    private List<Integer> getHouseNumbers(List<Integer> numbers) {
        List<Integer> houseNumbers = new ArrayList<>();
        int maxEven = 2;
        int maxOdd = 1;
        for (int i = 0; i < numbers.size(); i++) {
            int houseNumber = numbers.get(i);
            if (houseNumber % 2 == 0 && houseNumber < maxEven) {
                houseNumbers.add(maxEven);
                maxEven += 2;
            } else {
                houseNumbers.add(maxOdd);
                maxOdd += 2;
            }
        }
        return houseNumbers;
    }
}