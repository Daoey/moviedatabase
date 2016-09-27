package se.joas.moviedatabase.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ReviewUserTest {

    private final ReviewUser reviewUser = ReviewUser.builder("Kim Yong Un", "2005-11-11").setId(4).build();
    private final ReviewUser reviewUserCopy = ReviewUser.builder("Kim Yong Un", "2005-11-11").setId(4).build();
    private final ReviewUser reviewUserDifferentId = ReviewUser.builder("Kim Yong Un", "2005-11-11").setId(3).build();
    private final ReviewUser reviewUserDifferentUsername = ReviewUser.builder("Kim Yong Ill", "2005-11-11").setId(4)
            .build();
    private final ReviewUser reviewUserDifferentRegisterDate = ReviewUser.builder("Kim Yong Un", "2005-11-20").setId(4)
            .build();

    @Test
    public void toStringAsExpected() {
        assertEquals("Review user id: 4\nUsername: Kim Yong Un\nRegister date: 2005-11-11", reviewUser.toString());
    }

    @Test
    public void equalIfSame() {
        assertEquals(reviewUser, reviewUser);
    }

    @Test
    public void equalIfSameFieldValues() {
        assertEquals(reviewUser, reviewUserCopy);
    }

    @Test
    public void gettersAndSetters() {
        assertEquals(4, reviewUser.getId());
        assertEquals("Kim Yong Un", reviewUser.getUsername());
        assertEquals("2005-11-11", reviewUser.getRegisterDate());
    }

    @Test
    public void differentIfOneDifferentFieldValue() {
        assertNotEquals(reviewUser, reviewUserDifferentId);
        assertNotEquals(reviewUser, reviewUserDifferentRegisterDate);
        assertNotEquals(reviewUser, reviewUserDifferentUsername);
    }

    @Test
    public void differentIfOtherClass() {
        assertNotEquals(reviewUser, "reviewUser");
    }

    @Test
    public void sameHashIfEquals() {
        assertEquals(reviewUser.hashCode(), reviewUserCopy.hashCode());
    }

}
