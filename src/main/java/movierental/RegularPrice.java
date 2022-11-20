package movierental;

public class RegularPrice extends Price {
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) result += 1.5*(daysRented -2);
        return result;
    }
}
