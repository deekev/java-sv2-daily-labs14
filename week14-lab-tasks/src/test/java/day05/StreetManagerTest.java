package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreetManagerTest {

    @Test
    void testReadLines() {
        StreetManager streetManager = new StreetManager();
        Path path = Path.of("src/main/resources/streets.txt");

        Map<String, List<Integer>> result = streetManager.readLines(path);

        assertEquals(2, result.size());
        assertEquals(Arrays.asList(2, 4, 1, 3, 5, 7), result.get("Kossuth"));
        assertEquals(Arrays.asList(1, 2, 4, 3, 6), result.get("Petofi"));
    }

}