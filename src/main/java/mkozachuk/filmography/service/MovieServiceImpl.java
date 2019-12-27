package mkozachuk.filmography.service;

import mkozachuk.filmography.dao.MovieDAO;
import mkozachuk.filmography.dao.MovieDAOImpl;
import mkozachuk.filmography.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {


    private MovieDAO movieDAO;

    @Autowired
    public void setMovieDAO(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @Override
    @Transactional
    public List<Movie> allMovies() {
        return movieDAO.allMovies();
    }

    @Override
    @Transactional
    public void add(Movie movie) {
        movieDAO.add(movie);
    }

    @Override
    @Transactional
    public void edit(Movie movie) {
        movieDAO.edit(movie);
    }

    @Override
    @Transactional
    public void delete(Movie movie) {
        movieDAO.delete(movie);
    }

    @Override
    @Transactional
    public Movie getById(int id) {
        return movieDAO.getById(id);
    }

}
