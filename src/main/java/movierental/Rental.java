package movierental;

public class Rental {
	private final Movie movie;
	private final int daysRented;
	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(getDaysRented());
	}

	public double getCharge() {
		return movie.getCharge(getDaysRented());
	}

	public Movie getMovie() {
		return movie;
	}
	public int getDaysRented() {
		return daysRented;
	}
}
