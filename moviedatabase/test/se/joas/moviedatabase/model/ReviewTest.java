package se.joas.moviedatabase.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ReviewTest {

    private final Review review = new Review(1, Movie.builder(1999, "James Bond").build(), "1999-12-24",
            "Fantastisk film!", ReviewUser.builder("Potatisbyxan", "1998-12-10").build());
    private final Review reviewCopy = new Review(1, Movie.builder(1999, "James Bond").build(), "1999-12-24",
            "Fantastisk film!", ReviewUser.builder("Potatisbyxan", "1998-12-10").build());
    private final Review reviewDifferentId = new Review(2, Movie.builder(1999, "James Bond").build(), "1999-12-24",
            "Fantastisk film!", ReviewUser.builder("Potatisbyxan", "1998-12-10").build());
    private final Review reviewDifferentMovie = new Review(1, Movie.builder(1999, "James Bond 2").build(), "1999-12-24",
            "Fantastisk film!", ReviewUser.builder("Potatisbyxan", "1998-12-10").build());
    private final Review reviewDifferentReviewUser = new Review(1, Movie.builder(1999, "James Bond").build(),
            "1999-12-24", "Fantastisk film!", ReviewUser.builder("Pottfrillan", "2000-12-10").build());
    private final Review reviewDifferentReviewDate = new Review(1, Movie.builder(1999, "James Bond").build(),
            "1999-12-26", "Fantastisk film!", ReviewUser.builder("Potatisbyxan", "1998-12-10").build());
    private final Review reviewDifferentReviewText = new Review(1, Movie.builder(1999, "James Bond").build(),
            "1999-12-24", "Stupid movie!", ReviewUser.builder("Potatisbyxan", "1998-12-10").build());

    @Test
    public void toStringAsExpected() {
        assertEquals("Review id: 1\nMovie title: James Bond\nReview date: 1999-12-24\nReview text: Fantastisk film!"
                + "\nReview user username: Potatisbyxan", review.toString());
    }

    @Test
    public void equalIfSame() {
        assertEquals(review, review);
    }

    @Test
    public void equalIfSameFieldValues() {
        assertEquals(review, reviewCopy);
    }

    @Test
    public void gettersAndSetters() {
        assertEquals(1, review.getId());
        assertEquals(Movie.builder(1999, "James Bond").build(), review.getMovie());
        assertEquals(ReviewUser.builder("Potatisbyxan", "1998-12-10").build(), review.getReviewUser());
        assertEquals("1999-12-24", review.getReviewDate());
        assertEquals("Fantastisk film!", review.getReviewText());
    }

    @Test
    public void differentIfOneDifferentFieldValue() {
        assertNotEquals(review, reviewDifferentId);
        assertNotEquals(review, reviewDifferentMovie);
        assertNotEquals(review, reviewDifferentReviewDate);
        assertNotEquals(review, reviewDifferentReviewText);
        assertNotEquals(review, reviewDifferentReviewUser);
    }

    @Test
    public void differentIfOtherClass() {
        assertNotEquals(review, "review");
    }

    @Test
    public void sameHashIfEquals() {
        assertEquals(review.hashCode(), reviewCopy.hashCode());
    }

}
