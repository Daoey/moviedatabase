package se.joas.moviedatabase.model;

public final class Review {

    private final int id;
    private final Movie movie;
    private final String reviewDate;
    private final String reviewText;
    private final ReviewUser reviewUser;

    /**
     * Review constructor.
     * 
     * @param id    Review id
     * @param movie Movie
     * @param reviewDate Review date
     * @param reviewText Review text
     * @param reviewUser Review user
     */
    public Review(int id, Movie movie, String reviewDate, String reviewText, ReviewUser reviewUser) {
        this.id = id;
        this.movie = movie;
        this.reviewDate = reviewDate;
        this.reviewText = reviewText;
        this.reviewUser = reviewUser;
    }
        
    public int getId() {
        return id;
    }
    
    public Movie getMovie() {
        return movie;
    }
    
    public String getReviewDate() {
        return reviewDate;
    }
    
    public String getReviewText() {
        return reviewText;
    }
    
    public ReviewUser getReviewUser() {
        return reviewUser;
    }

}
