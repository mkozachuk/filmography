package mkozachuk.filmography.controller;

import mkozachuk.filmography.model.Movie;
import mkozachuk.filmography.service.MovieService;
import mkozachuk.filmography.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieController {

    private static Movie movie;

    private MovieService movieService;

    private int page;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allMovies(@RequestParam(defaultValue = "1") int page) {
        List<Movie> films = movieService.allMovies(page);
        int filmsCount = movieService.moviesCount();
        int pagesCount = (filmsCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("movies");
        modelAndView.addObject("page", page);
        modelAndView.addObject("moviesList", films);
        modelAndView.addObject("moviesCount", filmsCount);
        modelAndView.addObject("pagesCount", pagesCount);
        this.page = page;
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Movie movie = movieService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("movie", movie);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editMovie(@ModelAttribute("movie") Movie movie) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        movieService.edit(movie);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addMovie(@ModelAttribute("movie") Movie movie) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        movieService.add(movie);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Movie movie = movieService.getById(id);
        movieService.delete(movie);
        return modelAndView;
    }

}
