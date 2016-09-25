package se.joas.moviedatabase.model;

public final class DatabaseReview {

    private final int id;
    private final int movieId;
    private final String reviewDate;
    private final String reviewText;
    private final int reviewUserId;

    /**
     * Constructor for DatabaseReview.
     * 
     * @param id
     *            id
     * @param movieId
     *            movie id
     * @param reviewDate
     *            review date
     * @param reviewText
     *            review text
     * @param reviewUserId
     *            review user id
     */
    public DatabaseReview(int id, int movieId, String reviewDate, String reviewText, int reviewUserId) {
        this.id = id;
        this.movieId = movieId;
        this.reviewDate = reviewDate;
        this.reviewText = reviewText;
        this.reviewUserId = reviewUserId;
    }

    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getReviewUserId() {
        return reviewUserId;
    }

}