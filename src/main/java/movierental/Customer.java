package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private final String name;
	private final List<Rental> rentals;
	public Customer(String name) {
		this.name = name;
		this.rentals = new ArrayList<>();
	}
	public void addRental(Rental rental) {
		if (! rentals.contains(rental)) rentals.add(rental);
	}
	public String getName() {
		return name;
	}
	public String statement() {
		StringBuilder stmt = new StringBuilder("Rental Report for "+getName()).append("\n\n");
		// header for details section
		stmt.append(String.format("%-40.40s %4s %-8s\n", "Movie Title", "Days", "Price"));

		for(Rental rental: rentals) {
			stmt.append(String.format("%-40.40s %3d %8.2f\n", rental.getMovie().getTitle(), rental.getDaysRented(), rental.getCharge()));
		}
		// footer: summary of charges
		stmt.append( String.format("%-44.44s %8.2f\n", "Total Charges", getTotalAmount()));
		stmt.append( String.format("%-44.44s %5d\n","Frequent Renter Points earned", getTotalFrequentRenterPoints()) );
		
		return stmt.toString();
	}

	private double getTotalAmount() {
		return rentals.stream().map(r -> r.getCharge()).mapToDouble(d -> d).sum();
	}

	private int getTotalFrequentRenterPoints() {
		return rentals.stream().map(r -> r.getFrequentRenterPoints()).mapToInt(i -> i).sum();
	}
}
