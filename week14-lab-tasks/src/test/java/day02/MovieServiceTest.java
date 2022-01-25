package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    MovieService movieService = new MovieService();

    @BeforeEach
    void init() {
        movieService.addMovie(new Movie("Mátrix", 97, Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss")));
        movieService.addMovie(new Movie("Forrest Gump", 113, Arrays.asList("Tom Hanks", "Robin Wright")));
        movieService.addMovie(new Movie("Hetedik", 102, Arrays.asList("Morgan Freeman", "Brad Pitt", "Kevin Spacey", "Gwyneth Paltrow")));
        movieService.addMovie(new Movie("Harcosok klubja", 105, Arrays.asList("Brad Pitt", "Edward Norton", "Helena Bonham Carter", "Jared Leto")));
        movieService.addMovie(new Movie("Amerikai história X", 115, Arrays.asList("Edward Norton", "Edward Furlong")));
    }

    @Test
    void testGetMoviesWithActor() {

        List<Movie> result = movieService.getMoviesWithActor("Edward Norton");

        assertEquals(2, result.size());
        assertEquals("Harcosok klubja", result.get(0).getTitle());
    }

    @Test
    void testGetLengthOfLongestMovie() {

        int result = movieService.getLengthOfLongestMovie();

        assertEquals(115, result);
    }
}