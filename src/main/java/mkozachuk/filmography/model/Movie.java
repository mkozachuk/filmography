package mkozachuk.filmography.model;

public class Movie {
    private int id;
    private String title;
    private int year;
    private String genre;
    private boolean watched;

    @Override
    public String toString() {
        return "Id: " + getId() + "\n" +
               "Title: " + getTitle() + "\n" +
               "Year: " + getYear() + "\n" +
               "Genre: " + getGenre() + "\n" +
               "Watched: " + watched;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}
