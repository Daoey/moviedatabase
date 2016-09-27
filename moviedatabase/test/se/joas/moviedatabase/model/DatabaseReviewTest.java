package se.joas.moviedatabase.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class DatabaseReviewTest {

    private final DatabaseReview databaseReview = new DatabaseReview(2, 4, "2016-6-5", "Good movie!", 5);
    private final DatabaseReview databaseReviewCopy = new DatabaseReview(2, 4, "2016-6-5", "Good movie!", 5);
    private final DatabaseReview databaseReviewDifferentId = new DatabaseReview(5, 4, "2016-6-5", "Good movie!", 5);
    private final DatabaseReview databaseReviewDifferentMovieId = new DatabaseReview(2, 6, "2016-6-5", "Good movie!",
            5);
    private final DatabaseReview databaseReviewDifferentDate = new DatabaseReview(2, 4, "2016-2-5", "Good movie!", 5);
    private final DatabaseReview databaseReviewDifferentText = new DatabaseReview(2, 4, "2016-6-5", "Bad movie!", 5);
    private final DatabaseReview databaseReviewDifferentReviewUserId = new DatabaseReview(2, 4, "2016-6-5",
            "Good movie!", 9);

    @Test
    public void testToString() {
        assertEquals("Database review id: 2\nMovie id: 4\nReview date: 2016-6-5\n"
                + "Review text: Good movie!\nReview user id: 5", databaseReview.toString());
    }

    @Test
    public void gettersAndSetters() {
        assertEquals(databaseReview.getId(), 2);
        assertEquals(databaseReview.getMovieId(), 4);
        assertEquals(databaseReview.getReviewDate(), "2016-6-5");
        assertEquals(databaseReview.getReviewText(), "Good movie!");
        assertEquals(databaseReview.getReviewUserId(), 5);
    }

    @Test
    public void equalIfSameObject() {
        assertEquals(databaseReview, databaseReview);
    }

    @Test
    public void equalIfSameFieldValues() {
        assertEquals(databaseReview, databaseReviewCopy);
    }

    @Test
    public void differentIfOneDifferentFieldValue() {
        assertNotEquals(databaseReview, databaseReviewDifferentDate);
        assertNotEquals(databaseReview, databaseReviewDifferentId);
        assertNotEquals(databaseReview, databaseReviewDifferentMovieId);
        assertNotEquals(databaseReview, databaseReviewDifferentReviewUserId);
        assertNotEquals(databaseReview, databaseReviewDifferentText);
    }
    
    @Test
    public void differentIfDifferentClass() {
        assertNotEquals(databaseReview, "databaseReview");
    }
    
    @Test
    public void sameHashIfEquals() {
        assertEquals(databaseReview.hashCode(), databaseReviewCopy.hashCode());
    }

}
