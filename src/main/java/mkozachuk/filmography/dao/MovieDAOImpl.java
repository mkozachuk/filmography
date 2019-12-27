package mkozachuk.filmography.dao;

import mkozachuk.filmography.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MovieDAOImpl implements MovieDAO {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Movie> movies = new HashMap<>();

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Movie> allMovies() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Movie").list();
    }

    @Override
    public void add(Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(movie);
    }

    @Override
    public void edit(Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.update(movie);
    }

    @Override
    public void delete(Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(movie);
    }

    @Override
    public Movie getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Movie.class, id);
    }
}
