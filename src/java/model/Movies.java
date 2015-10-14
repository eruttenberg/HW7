
package model;

public class Movies {
    private int movieID;
    private String movieTitle;
    private int movieYear;
    private String movieGenre;
    private String director;

    public Movies() {
        this.movieID = 0;
        this.movieTitle = "";
        this.movieYear = 0;
        this.movieGenre = "";
        this.director = "";
    }
    
   public Movies(int movieID, String movieTitle, int movieYear, String movieGenre, String director) {
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
        this.movieGenre = movieGenre;
        this.director = director;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movies{" + "movieID=" + movieID + ", movieTitle=" + movieTitle + ", movieYear=" + movieYear + ", movieGenre=" + movieGenre + ", director=" + director + '}';
    }
   
   
}
