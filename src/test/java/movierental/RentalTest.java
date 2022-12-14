package movierental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class RentalTest {
	Movie [] movies;
	
	@BeforeEach
	public void setUp() throws Exception {
		movies = new Movie[] {
				new Movie("CitizenFour", Movie.REGULAR),
				new Movie("Frozen", Movie.CHILDRENS),
				new Movie("Ex Machina", Movie.NEW_RELEASE),
				new Movie("Bridge of Spies", Movie.NEW_RELEASE)
		};
	}
	
	@Test
	public void testMovieAttributes() {
		// a trivial test. The main purpose is to catch refactoring errors or change in API of Movie.
		Movie m = movies[0];
		assertEquals("CitizenFour", m.getTitle());
		assertEquals(Movie.REGULAR, m.getPriceCode());
	}

	@Test
	public void testAttributes() {
		int days = 1;
		for(Movie m: movies) {
			Rental r = new Rental(m, days);
			assertEquals(r.getDaysRented(), days);
			assertSame(m, r.getMovie());
		}
	}
}
