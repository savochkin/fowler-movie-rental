package movierental;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest {

	Customer c;
	Movie [] movies;
	
	@BeforeEach
	public void setUp() throws Exception {
		c = new Customer("Edward Snowden");
		movies = new Movie[] {
				new Movie("The Irishman", Movie.NEW_RELEASE),
				new Movie("CitizenFour", Movie.REGULAR),
				new Movie("Frozen", Movie.CHILDRENS),
				new Movie("El Camino", Movie.NEW_RELEASE),
				new Movie("Particle Fever", Movie.REGULAR)
		};
	}

	@Test
	public void testBilling() {
		// no convenient way to test billing since its buried in the statement() method.
	}
	
	@Test
	public void testExampleStatement() {
		int days = 1;
		for(Movie m: movies) {
			c.addRental(new Rental(m, days));
			days++;
		}

		String expected = "Rental Report for Edward Snowden\n" +
				"\n" +
				"Movie Title                              Days Price   \n" +
				"The Irishman                               1     3,00\n" +
				"CitizenFour                                2     2,00\n" +
				"Frozen                                     3     1,50\n" +
				"El Camino                                  4    12,00\n" +
				"Particle Fever                             5     6,50\n" +
				"Total Charges                                   25,00\n" +
				"Frequent Renter Points earned                    6\n";

		assertEquals(expected, c.statement());
	}

	@Test
	public void testEmptyStatement() {
		String expected = "Rental Report for Edward Snowden\n" +
				"\n" +
				"Movie Title                              Days Price   \n" +
				"Total Charges                                    0,00\n" +
				"Frequent Renter Points earned                    0\n";

		assertEquals(expected, c.statement());
	}
}
