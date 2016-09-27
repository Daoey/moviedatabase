package se.joas.moviedatabase.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public final class ActorTest {

    private static Actor mattWilliamDamon;
    private static Actor mattWilliamDamonCopy;
    private static Actor mattPotatoeDamon;
    private static Actor mattWilliamDamonDifferentId;
    private static Actor susanDamon;

    /**
     * Setup before all tests are called.
     */
    @BeforeClass
    public static void setUpClass() {
        // System.out.println("@BeforeClass");
        mattWilliamDamon = Actor.builder("Matt", "Damon").setId(10).setMiddleName("William").build();
        mattWilliamDamonCopy = Actor.builder("Matt", "Damon").setId(10).setMiddleName("William").build();
        mattPotatoeDamon = Actor.builder("Matt", "Damon").setId(10).setMiddleName("Potatoe").build();
        mattWilliamDamonDifferentId = Actor.builder("Matt", "Damon").setId(5).setMiddleName("Potatoe").build();
        susanDamon = Actor.builder("Susan", "Damon").setId(10).setMiddleName("William").build();
    }

    @AfterClass
    public static void tearDownClass() {
        // System.out.println("@AfterClass");
    }

    /**
     * Sets up actors.
     */
    @Before
    public void setUp() {
        // System.out.println("@Before");
    }

    @After
    public void tearDown() {
        // System.out.println("@After");
    }

    @Test
    public void equalIfSameObject() {
        assertEquals(mattWilliamDamon, mattWilliamDamon);
    }

    @Test
    public void equalIfSameValues() {
        assertEquals(mattWilliamDamon, mattWilliamDamonCopy);
    }

    @Test
    public void equalIfSameFirstNameAndIdButDifferentMiddleName() {
        assertTrue(mattWilliamDamon.equals(mattPotatoeDamon));
    }

    @Test
    public void differentIfDifferentId() {
        assertNotEquals(mattWilliamDamon, mattWilliamDamonDifferentId);
    }

    @Test
    public void differentIfDifferentFirstName() {
        assertNotEquals(susanDamon, mattWilliamDamon);
    }

    @Test
    public void differentIfDifferentClass() {
        assertNotEquals(mattWilliamDamon, "mattWilliamDamon");
    }

    @Test
    public void sameHashCodeIfEquals() {
        assertEquals(mattWilliamDamon.hashCode(), mattWilliamDamonCopy.hashCode());
    }

    @Test
    public void gettersAndSetters() {
        assertEquals("Matt", mattWilliamDamon.getFirstName());
        assertEquals("Damon", mattWilliamDamon.getLastName());
        assertEquals("William", mattWilliamDamon.getMiddleName());
        assertEquals(10, mattWilliamDamon.getId());
    }

    @Test
    public void actorToStringAsExpected() {
        assertEquals("Actor id: 10\nFirst name: Matt\nMiddle name: William\nLast name: Damon",
                mattWilliamDamon.toString());
    }

    // @Test(expected = IllegalArgumentException.class)
    // public void shouldThrowExceptionIfIdContainsLetters() {
    // try {
    // new User("a1001", "master");
    // fail();
    // } catch (IllegalArgumentException e) {
    // throw e;
    // }
    // }

    // public void shouldThrowExceptionIfUsernameTooShort(){
    // new User("1001", "yoda");
    // }

}
