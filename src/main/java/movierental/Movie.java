package movierental;

public class Movie {
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDRENS = 2;
	
	private int priceCode;
	private final String title;
	Price price;

	public Movie(String title, int priceCode) {
		this.title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
		switch (priceCode) {
			case REGULAR:
				price = new RegularPrice();
				break;
			case CHILDRENS:
				price = new ChildrensPrice();
				break;
			case NEW_RELEASE:
				price = new NewReleasesPrice();
				break;
			default:
				throw new IllegalArgumentException("Incorrect Price Code");
		}
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String toString() {
		return this.title;
	}

	double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}

	int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}
}
