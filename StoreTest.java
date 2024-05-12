import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StoreTest {
    
    Store store;

    //We are doing this because each store test is going to depend on us initializing the store class and adding the movies.
    //So we must run the store object first so that we can get access to the methods inside of it. 
    @Before
    public void setup(){
        store = new Store();
        store.addMovie(new Movie("The Shawshank Redemption", "Blue-Ray", 9.2));
        store.addMovie(new Movie("The Godfather", "Blue-Ray", 9.1));
        store.rentMovie("The Godfather");
    }

    @Test
    public void movieAdded(){
        assertTrue(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test
    public void sellMovieTest(){
     store.sellMovie("The Shawshank Redemption");
     assertFalse(store.contains(new Movie("The Shawshank Redemption", "Blue-Ray", 9.2)));
    }

    @Test
    public void rentMovieTest(){
        store.rentMovie("The Godfather");
        assertEquals("Rented", store.getMovie("The Godfather").isIsAvailable());
    }
    @Test(expected = IllegalStateException.class)
    public void movieNotInStock(){
        store.rentMovie("The Godfather");
        store.sellMovie("The Godfather");
    }

    @Test
    public void returnedMovie(){
        store.returnMovie("The Godfather");
        assertEquals("In-stock", store.getMovie("The Godfather").isIsAvailable());
    }



}
