package mkozachuk.filmography.dao;

import mkozachuk.filmography.model.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MovieDAOImpl implements MovieDAO {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Movie> movies = new HashMap<>();

    static{
        Movie movie = new Movie();
        movie.setId(AUTO_ID.getAndIncrement());
        movie.setTitle("Movie_Title");
        movie.setYear(2010);
        movie.setGenre("sci-fi");
        movie.setWatched(true);
        movies.put(movie.getId(), movie);

        Movie movie1 = new Movie();
        movie1.setId(AUTO_ID.getAndIncrement());
        movie1.setTitle("Movie_Title1");
        movie1.setYear(2011);
        movie1.setGenre("sci-fi");
        movie1.setWatched(true);
        movies.put(movie1.getId(), movie1);

        Movie movie2 = new Movie();
        movie2.setId(AUTO_ID.getAndIncrement());
        movie2.setTitle("Movie_Title2");
        movie2.setYear(2012);
        movie2.setGenre("sci-fi");
        movie2.setWatched(true);
        movies.put(movie1.getId(), movie1);
    }

    @Override
    public List<Movie> allMovies() {
        return new ArrayList<>(movies.values());
    }

    @Override
    public void add(Movie movie) {
        movie.setId(AUTO_ID.getAndIncrement());
        movies.put(movie.getId(), movie);
    }

    @Override
    public void edit(Movie movie) {
        movies.put(movie.getId(), movie);
    }

    @Override
    public void delete(Movie movie) {
        movies.remove(movie.getId());
    }

    @Override
    public Movie getById(int id) {
        return movies.get(id);
    }
}
