package mkozachuk.filmography.controller;

import mkozachuk.filmography.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {

    private static Movie movie;

    static {
        movie = new Movie();
        movie.setTitle("Inception");
        movie.setYear(2010);
        movie.setGenre("sci-fi");
        movie.setWatched(true);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allMovies(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("movies");
        modelAndView.addObject("movie", movie);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }
}
