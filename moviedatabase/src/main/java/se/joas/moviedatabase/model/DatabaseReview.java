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

    @Override
    public String toString() {
        return "Database review id: " + id + "\n" + "Movie id: " + movieId + "\nReview date: " + reviewDate
                + "\nReview text: " + reviewText + "\nReview user id: " + reviewUserId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DatabaseReview) {
            DatabaseReview otherReview = (DatabaseReview) obj;
            return id == otherReview.id && movieId == otherReview.movieId && reviewUserId == otherReview.reviewUserId
                    && reviewDate.equals(otherReview.reviewDate) && reviewText.equals(otherReview.reviewText);
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result += 31 * id;
        result += 31 * movieId;
        result += 31 * reviewUserId;
        result += 31 * reviewDate.hashCode();
        result += 31 * reviewText.hashCode();
        return result;
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