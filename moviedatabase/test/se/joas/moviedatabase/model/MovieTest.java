package se.joas.moviedatabase.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class MovieTest {

    private final Movie movie = Movie.builder(2000, "Year 1").setId(4).build();
    private final Movie movieCopy = Movie.builder(2000, "Year 1").setId(4).build();
    private final Movie movieDifferentProductionYear = Movie.builder(2001, "Year 1").setId(4).build();
    private final Movie movieDifferentTitle = Movie.builder(2000, "Year 2").setId(4).build();
    private final Movie movieDifferentId = Movie.builder(2000, "Year 1").setId(3).build();

    @Test
    public void toStringAsExpected() {
        assertEquals("Movie id: 4\nProduction year: 2000\nTitle: Year 1", movie.toString());
    }

    @Test
    public void equalsIfSame() {
        assertEquals(movie, movie);
    }

    @Test
    public void equalsIfSameFieldValues() {
        assertEquals(movie, movieCopy);
    }

    @Test
    public void differentIfOneFieldDifferent() {
        assertNotEquals(movie, movieDifferentId);
        assertNotEquals(movie, movieDifferentProductionYear);
        assertNotEquals(movie, movieDifferentTitle);

    }
    
    @Test
    public void differentIfDifferentObject() {
        assertNotEquals(movie, "movie");
    }

    @Test
    public void sameHashIfEquals() {
        assertEquals(movie.hashCode(), movieCopy.hashCode());
    }

    @Test
    public void gettersAndSetters() {
        Movie dodgeball = Movie.builder(1999, "Dodgeball").setId(1).build();
        assertEquals(1999, dodgeball.getProductionYear());
        assertEquals("Dodgeball", dodgeball.getTitle());
        assertEquals(1, dodgeball.getId());
    }

}
