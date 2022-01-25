package day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }

    public List<Movie> getMoviesWithActor(String actor) {
        return movies
                .stream()
                .filter(movie -> movie.getActors().contains(actor))
                .toList();
    }

    public int getLengthOfLongestMovie() {
        return movies
                .stream()
                .max(Comparator.comparingInt(o -> o.getLength()))
                .get().getLength();
    }
}