package mkozachuk.filmography.service;

import mkozachuk.filmography.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> allMovies(int page);
    void add(Movie movie);
    void edit(Movie movie);
    void delete(Movie movie);
    Movie getById(int id);
    int moviesCount();
}
