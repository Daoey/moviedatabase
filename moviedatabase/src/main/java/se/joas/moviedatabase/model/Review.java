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
     * @param id
     *            Review id
     * @param movie
     *            Movie
     * @param reviewDate
     *            Review date
     * @param reviewText
     *            Review text
     * @param reviewUser
     *            Review user
     */
    public Review(int id, Movie movie, String reviewDate, String reviewText, ReviewUser reviewUser) {
        this.id = id;
        this.movie = movie;
        this.reviewDate = reviewDate;
        this.reviewText = reviewText;
        this.reviewUser = reviewUser;
    }

    @Override
    public String toString() {
        return "Review id: " + id + "\nMovie title: " + movie.getTitle() + "\nReview date: " + reviewDate
                + "\nReview text: " + reviewText + "\nReview user username: " + reviewUser.getUsername();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Review) {
            Review otherReview = (Review) obj;
            return id == otherReview.id && movie.equals(otherReview.movie) && reviewDate.equals(otherReview.reviewDate)
                    && reviewText.equals(otherReview.reviewText) && reviewUser.equals(otherReview.reviewUser);
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result += 31 * id;
        result += 31 * movie.hashCode();
        result += 31 * reviewUser.hashCode();
        result += 31 * reviewDate.hashCode();
        result += 31 * reviewText.hashCode();
        return result;
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
