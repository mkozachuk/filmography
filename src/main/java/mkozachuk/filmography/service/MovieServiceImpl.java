package mkozachuk.filmography.service;

import mkozachuk.filmography.dao.MovieDAO;
import mkozachuk.filmography.dao.MovieDAOImpl;
import mkozachuk.filmography.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {


    private MovieDAO movieDAO;

    @Autowired
    public void setMovieDAO(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @Override
    public List<Movie> allFilms() {
        return movieDAO.allMovies();
    }

    @Override
    public void add(Movie movie) {
        movieDAO.add(movie);
    }

    @Override
    public void edit(Movie movie) {
        movieDAO.edit(movie);
    }

    @Override
    public void delete(Movie movie) {
        movieDAO.delete(movie);
    }

    @Override
    public Movie getById(int id) {
        return movieDAO.getById(id);
    }

}
