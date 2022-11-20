package movierental;

public class NewReleasesPrice extends Price {
    @Override
    double getCharge(int daysRented) {
        return 3 * daysRented;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1? 2 : 1;
    }
}
